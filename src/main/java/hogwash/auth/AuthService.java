package hogwash.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Token;

import hogwash.user.IUser;
import hogwash.user.UserDao;

@Path("/auth")
public class AuthService
{
  @Context
  private HttpServletResponse response;
  @Context
  private HttpServletRequest  request;

  private HttpSession         session;
  public static List< IUser > users = new ArrayList< IUser >();

  @Path("/provider")
  @GET
  public void redirect(@QueryParam(AuthContstant.PROVIDER) String provider)
  {
    session = request.getSession();
    IUser user = (IUser) session.getAttribute( AuthContstant.USER );
    if ( user == null )
    {
      AuthProvider authProvider = AuthProviderType.provider( provider ).getAuthUser();
      String redirectUrl = authProvider.serviceRedirect();
      session.setAttribute( AuthContstant.STATE, authProvider.getState() );
      sendRedirect( redirectUrl );
    }
    else
    {
      sendRedirect( request.getContextPath() + "/chat.html" );
    }
  }

  @Path("/callback")
  @GET
  public void authCallback(@QueryParam(AuthContstant.STATE) String state,
                           @QueryParam(AuthContstant.CODE) String code,
                           @QueryParam(AuthContstant.ERROR) String error,
                           @QueryParam(AuthContstant.PROVIDER) String provider)
  {
    session = request.getSession();
    IUser user = (IUser) session.getAttribute( AuthContstant.USER );
    if ( user == null )
    {
      // how to check if user has already has authenticated
      AuthProvider authProvider = AuthProviderType.provider( provider ).getAuthUser();
      if ( error != null && error.length() > 0 )
      {
        System.out.println( "error authenticating" );
        sendRedirect( request.getContextPath() );
      } // TODO haven't validated what a face book error response looks like
      else if ( code != null && code.length() > 0 )
      {
        Token accessToken = authProvider.buildAccessToken( code );
        String authResponse = accessToken.getRawResponse();
        IAuthUser authUser = authProvider.createAuthUser( authResponse );
        Response profileResponse = authProvider.getResponseForProfile();
        ObjectMapper mapper = new ObjectMapper();
        try
        {
          user = (IUser) mapper.readValue( profileResponse.getBody(), Class.forName( authProvider.getClassName() ) );
          user.setAuthUser( authUser );
          session.setAttribute( "user", user );
          UserDao userDao = new UserDao();
          userDao.createUser( user );
          sendRedirect( request.getContextPath() + "/chat.html" );
        }
        catch ( IOException | ClassNotFoundException e )
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
          sendRedirect( request.getContextPath() );
        }
      }
    }
    else
    {
      sendRedirect( request.getContextPath() + "/chat.html" );
    }
  }

  private void sendRedirect(String fullpath)
  {
    try
    {
      response.sendRedirect( fullpath );
    }
    catch ( IOException e )
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
