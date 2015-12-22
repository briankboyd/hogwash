package hogwash.auth;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.model.Verb;

import hogwash.user.GoogleUser;

public class AuthGoogleProvider extends AuthProvider
{
  private final static String ACCESS_TYPE  = "&access_type=offline";
  private final static String FORCE_PROMPT = "&approval_prompt=force";

  public AuthGoogleProvider( String provider ) {
    super( provider );
    buildService( GoogleApi20.class );
  }

  @Override
  public String serviceRedirect()
  {
    return getService().getAuthorizationUrl( Token.empty() ) + ACCESS_TYPE;
  }

  @Override
  public String getClassName()
  {
    return GoogleUser.class.getName();
  }

  @Override
  public IAuthUser createAuthUser(String authResponse)
  {
    ObjectMapper mapper = new ObjectMapper();
    AuthGoogleUser authGoogleUser = null;
    try
    {
      authGoogleUser = mapper.readValue( authResponse, AuthGoogleUser.class );
    }
    catch ( IOException e )
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return authGoogleUser;
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

}
