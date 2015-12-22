package hogwash.user;

import java.util.List;

public interface IUserDao
{
  public List< IUser > getAllUsers();

  public IUser createUser(IUser user);

  public void updateUser(int id);

  public void deleteUser(int id);
}
