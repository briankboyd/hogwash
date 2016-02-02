package hogwash.auth;

public interface IAuthUser
{
  public String getAccessToken();

  public void setAccessToken(String token);

  public int getExpiresIn();

  public void setExpiresIn(int expiresIn);
}
