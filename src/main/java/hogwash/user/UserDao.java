package hogwash.user;

import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao
{
  public static List< IUser > users = new ArrayList< IUser >();
  public static int           count = 0;

  @Override
  public List< IUser > getAllUsers()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IUser createUser(IUser user)
  {
    user.setUserId( UserDao.count );
    UserDao.users.add( user );
    UserDao.count++;
    return user;
  }

  @Override
  public void updateUser(int id)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteUser(int id)
  {
    // TODO Auto-generated method stub

  }

}
