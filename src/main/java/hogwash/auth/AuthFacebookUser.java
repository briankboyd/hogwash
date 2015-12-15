package hogwash.auth;

import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Token;

public class AuthFacebookUser extends AuthUser
{

  public AuthFacebookUser( String provider ) {
    super( provider );
  }

  @Override
  public Response getResponseForProfile()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String serviceRedirect()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Token buildAccessToken(String code)
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Response getRefreshToken(String code)
  {
    // TODO Auto-generated method stub
    return null;
  }

}
