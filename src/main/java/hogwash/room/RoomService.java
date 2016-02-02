package hogwash.room;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import hogwash.rest.RestConstant;

@Path(RestConstant.ROOM)
public class RoomService
{

  @POST
  @Path(RestConstant.ROOM_USER)
  public int createRoom(@PathParam("userId") int userId)
  {
    RoomDao roomDao = new RoomDao();

    return roomDao.createRoom( userId );

  }

}
