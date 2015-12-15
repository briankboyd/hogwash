package howwash.auth;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import hogwash.auth.AuthContstant;
import hogwash.auth.AuthProviderType;
import hogwash.auth.AuthUser;

public class TestAuthUserType
{

  @Test
  public void testGoogleAuthUserType()
  {
    AuthProviderType authUserType = AuthProviderType.provider( AuthContstant.GOOGLE );
    AuthUser authUser = authUserType.getAuthUser();
    System.out.println( authUser.getClass().getName() );
    System.out.println( authUserType.toString() );
    assertTrue( true );
  }

}
