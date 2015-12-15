package hogwash.auth;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AuthProperties
{

  public static final Properties getInstance()
  {
    Properties authProps = new Properties();
    InputStream input = null;

    try
    {
      input = AuthProperties.class.getClassLoader().getResourceAsStream( AuthContstant.AUTH_FILE );
      authProps.load( input );
    }
    catch ( IOException e )
    {
      // TODO: Add logging
      e.printStackTrace();
    }
    return authProps;
  }

}
