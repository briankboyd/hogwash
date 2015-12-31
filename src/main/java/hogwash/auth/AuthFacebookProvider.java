package hogwash.auth;

import com.github.scribejava.apis.FacebookApi;
import com.github.scribejava.core.model.Response;

import hogwash.user.UserFacebook;

public class AuthFacebookProvider extends AuthProvider
{
  // https://graph.facebook.com/v2.3/oauth/access_token?
  public AuthFacebookProvider( String provider ) {
    super( provider );
    buildService( FacebookApi.class );
  }

  @Override
  public String getClassName()
  {
    return UserFacebook.class.getName();
  }

  @Override
  public IAuthUser createAuthUser(String authResponse)
  {
    String[] auths = authResponse.split( "&" );
    String[] tokens = auths[0].split( "=" );
    String[] expiresIns = auths[1].split( "=" );
    AuthFacebookUser authFacebookUser = new AuthFacebookUser();
    authFacebookUser.setAccessToken( tokens[1] );
    authFacebookUser.setExpiresIn( Integer.valueOf( expiresIns[1] ) );
    return authFacebookUser;
  }

  @Override
  public Response getRefreshToken(String code)
  {
    // TODO Auto-generated method stub
    return null;
  }

}
