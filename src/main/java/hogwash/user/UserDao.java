package hogwash.user;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import hogwash.auth.AuthService;

public class UserDao implements IUserDao
{

  @Override
  public List< IUser > getAllUsers()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IUser createUser(IUser user)
  {
    int id = ThreadLocalRandom.current().nextInt( 0, 100 + 1 );
    user.setUserId( id );
    AuthService.users.add( user );
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
