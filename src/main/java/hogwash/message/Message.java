package hogwash.message;

public class Message
{
  private int    roomId;
  private int    userId;
  private String message;

  public int getRoomId()
  {
    return roomId;
  }

  public void setRoomId(int roomId)
  {
    this.roomId = roomId;
  }

  public int getUserId()
  {
    return userId;
  }

  public void setUserId(int userId)
  {
    this.userId = userId;
  }

  public String getMessage()
  {
    return message;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }

  public static class Fields
  {
    public final static String ROOM_ID = "roomId";
    public final static String USER_ID = "userId";
    public final static String MSG     = "message";

  }

}
