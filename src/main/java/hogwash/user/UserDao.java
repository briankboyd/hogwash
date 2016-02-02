package hogwash.user;

import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao
{
  public static List< IUserSocial > users = new ArrayList< IUserSocial >();
  public static int           count = 0;

  @Override
  public List< IUserSocial > getAllUsers()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IUserSocial createUser(IUserSocial user)
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
