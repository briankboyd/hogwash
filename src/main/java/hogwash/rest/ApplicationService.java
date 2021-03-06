package hogwash.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import hogwash.auth.AuthService;
import hogwash.user.UserService;

@ApplicationPath("/rest/v1")
public class ApplicationService extends Application
{
  @Override
  public Set< Class< ? > > getClasses()
  {
    Set< Class< ? > > restClass = new HashSet< Class< ? > >();
    restClass.add( AuthService.class );
    restClass.add( UserService.class );
    return restClass;
  }
}
