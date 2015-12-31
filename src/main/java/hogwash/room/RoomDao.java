package hogwash.room;

public class RoomDao implements IRoomDao
{
  public static int count = 0;

  @Override
  public int createRoom(int userId)
  {
    int roomId = count;
    count++;
    return roomId;
  }

}
