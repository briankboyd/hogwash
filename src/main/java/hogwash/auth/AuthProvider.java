package hogwash.auth;

import java.util.Properties;
import java.util.Random;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.builder.api.Api;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.model.Verifier;
import com.github.scribejava.core.oauth.OAuthService;

public abstract class AuthProvider implements IAuthProvider
{

  public AuthProvider( String provider ) {
    this.provider = provider.toUpperCase();
    authProps = AuthProperties.getInstance();
    userInfoUrl = authProps.getProperty( this.provider + AuthContstant.USER_INFO_URL );
    apiKey = authProps.getProperty( this.provider + AuthContstant.CLIENT_ID );
    apiSecret = authProps.getProperty( this.provider + AuthContstant.CLIENT_SECRET );
    scope = authProps.getProperty( this.provider + AuthContstant.CLIENT_SCOPE );
    callback = authProps.getProperty( this.provider + AuthContstant.CALLBACK_URI );
    state = "superSecret" + new Random().nextInt( 999_999 );
  }

  private String       provider;
  private String       userInfoUrl;
  private Properties   authProps;
  private String       apiKey;
  private String       apiSecret;
  private String       scope;
  private String       callback;
  private String       state;
  private Token        token;
  private OAuthService service;

  @Override
  public OAuthService buildService(Class< ? extends Api > apiClass)
  {
    service = new ServiceBuilder().grantType( AuthContstant.AUTHORIZATION_CODE )
                                  .provider( apiClass )
                                  .apiKey( apiKey )
                                  .apiSecret( apiSecret )
                                  .scope( scope )
                                  .callback( callback )
                                  .state( state )
                                  .build();
    return service;
  }

  @Override
  public Response getResponseForProfile()
  {
    OAuthRequest oauthRequest = new OAuthRequest( Verb.GET, getUserInfoUrl(), getService() );
    getService().signRequest( getAccessToken(), oauthRequest );
    return oauthRequest.send();
  }

  @Override
  public String serviceRedirect()
  {
    return getService().getAuthorizationUrl( Token.empty() );
  }

  @Override
  public Token buildAccessToken(String code)
  {
    Token token = getService().getAccessToken( Token.empty(), new Verifier( code ) );
    setToken( token );
    return token;
  }

  public String getApiKey()
  {
    return apiKey;
  }

  public String getApiSecret()
  {
    return apiSecret;
  }

  public String getScope()
  {
    return scope;
  }

  public String getCallback()
  {
    return callback;
  }

  public String getState()
  {
    return state;
  }

  public String getUserInfoUrl()
  {
    return userInfoUrl;
  }

  public Properties getAuthProps()
  {
    return authProps;
  }

  public String getProvider()
  {
    return provider;
  }

  public Token getAccessToken()
  {
    return token;
  }

  public OAuthService getService()
  {
    return service;
  }

  public void setToken(Token token)
  {
    this.token = token;
  }
}
