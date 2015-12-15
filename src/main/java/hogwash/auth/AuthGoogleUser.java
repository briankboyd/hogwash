package hogwash.auth;

import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.model.Verifier;

public class AuthGoogleUser extends AuthUser
{
  private final static String ACCESS_TYPE  = "&access_type=offline";
  private final static String FORCE_PROMPT = "&approval_prompt=force";

  public AuthGoogleUser( String provider ) {
    super( provider );
    buildService( GoogleApi20.class );
  }

  @Override
  public String serviceRedirect()
  {
    return getService().getAuthorizationUrl( Token.empty() ) + ACCESS_TYPE;
  }

  @Override
  public Response getResponseForProfile()
  {
    OAuthRequest oauthRequest = new OAuthRequest( Verb.GET, getUserInfoUrl(), getService() );
    getService().signRequest( getAccessToken(), oauthRequest );
    return oauthRequest.send();
  }

  @Override
  public Response getRefreshToken(String code)
  {
    OAuthRequest request = new OAuthRequest( Verb.POST, "https://www.googleapis.com/oauth2/v4/token", getService() );
    // request.addBodyParameter( "grant_type", "refresh_token" );
    // request.addBodyParameter( "refresh_token", getAccessToken().getToken() );
    // request.addBodyParameter( "client_id", getApiKey() );
    // request.addBodyParameter( "client_secret", getApiSecret() );

    request.addBodyParameter( "code", code );
    request.addBodyParameter( "client_id", getApiKey() );
    request.addBodyParameter( "client_secret", getApiSecret() );
    request.addBodyParameter( "redirect_uri", getCallback() );
    request.addBodyParameter( "grant_type", "authorization_code" );
    return request.send();
  }

  @Override
  public Token buildAccessToken(String code)
  {
    Token token = getService().getAccessToken( Token.empty(), new Verifier( code ) );
    setToken( token );
    return token;
  }

}
