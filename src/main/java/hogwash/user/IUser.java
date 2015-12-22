package hogwash.user;

import hogwash.auth.IAuthUser;

public interface IUser
{
  public int getUserId();

  public void setUserId(int id);

  public String getProviderId();

  public void setProviderId(String userId);

  public String getEmail();

  public void setEmail(String email);

  public String getFirstName();

  public void setFirstName(String firstName);

  public String getLastName();

  public void setLastName(String lastName);

  public String getProvider();

  public void setProvider(String provider);

  public String getGender();

  public void setGender(String gender);

  public String getLocale();

  public void setLocale(String locale);

  public IAuthUser getAuthUser();

  public void setAuthUser(IAuthUser authUser);
}
