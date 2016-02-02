package hogwash.user;

import java.util.List;

public interface IUserDao
{
  public List< IUserSocial > getAllUsers();

  public IUserSocial createUser(IUserSocial user);

  public void updateUser(int id);

  public void deleteUser(int id);
}
