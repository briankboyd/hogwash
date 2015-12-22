package hogwash.auth;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

import hogwash.auth.AuthContstant;
import hogwash.auth.AuthProperties;

public class TestAuthProperties
{

  @Test
  public void loadPropsFile() throws Exception
  {
    Properties authProps = AuthProperties.getInstance();

    System.out.println( authProps.getProperty( "GOOGLE" + AuthContstant.CLIENT_ID ) );
    Assert.assertTrue( true );
  }

}
