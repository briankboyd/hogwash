package hogwash.auth;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Token;

@Path("/auth")
public class AuthService
{
  @Context
  private HttpServletResponse response;

  @Path("/provider")
  @GET
  public void redirect(@QueryParam(AuthContstant.PROVIDER) String provider)
  {
    AuthUser authUser = AuthProviderType.provider( provider ).getAuthUser();
    String redirectUrl = authUser.serviceRedirect();
    try
    {
      response.sendRedirect( redirectUrl );
    }
    catch ( IOException e )
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Path("/callback")
  @GET
  public void authCallback(@QueryParam(AuthContstant.STATE) String state,
                           @QueryParam(AuthContstant.CODE) String code,
                           @QueryParam(AuthContstant.ERROR) String error,
                           @QueryParam(AuthContstant.PROVIDER) String provider)
  {
    // how to check if user has already has authenticated
    AuthUser authUser = AuthProviderType.provider( provider ).getAuthUser();
    if ( error != null && error.length() > 0 )
    {
      System.out.println( "error authenticating" );
    }
    else if ( code != null && code.length() > 0 )
    {
      Token accessToken = authUser.buildAccessToken( code );
      System.out.println( accessToken.getRawResponse() );

      Response profileResponse = authUser.getResponseForProfile();
      System.out.println( profileResponse.getBody() );
    }
  }

}
