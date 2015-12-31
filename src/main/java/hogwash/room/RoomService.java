package hogwash.room;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/rooms")
public class RoomService
{

  @POST
  @Path("/user/{userId}")
  public int createRoom(@PathParam("userId") int userId)
  {
    RoomDao roomDao = new RoomDao();

    return roomDao.createRoom( userId );

  }

}
