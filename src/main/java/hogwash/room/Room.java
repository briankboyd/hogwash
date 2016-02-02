package hogwash.room;

import java.util.List;

import hogwash.user.User;

public class Room
{

  private int roomId;
  private String roomName;
  private int ownerId;
  private List< User > users;

  public int getRoomId()
  {
    return roomId;
  }

  public void setRoomId(int roomId)
  {
    this.roomId = roomId;
  }

  public String getRoomName()
  {
    return roomName;
  }

  public void setRoomName(String roomName)
  {
    this.roomName = roomName;
  }

  public int getOwnerId()
  {
    return ownerId;
  }

  public void setOwnerId(int ownerId)
  {
    this.ownerId = ownerId;
  }

  public List< User > getUsers()
  {
    return users;
  }

  public void setUsers(List< User > users)
  {
    this.users = users;
  }

}
