package hogwash.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hogwash.auth.AuthContstant;

@Path("/users")
public class UserService
{

  @Context
  private HttpServletResponse response;
  @Context
  private HttpServletRequest  request;

  private HttpSession         session;

  @Produces(MediaType.APPLICATION_JSON)
  @Path("/user")
  @GET
  public Response getCurrentUser() throws JsonProcessingException
  {
    session = request.getSession();
    IUserSocial user = (IUserSocial) session.getAttribute( AuthContstant.USER );
    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writer().withDefaultPrettyPrinter().writeValueAsString( user );
    return Response.ok( json ).build();
  }

}
