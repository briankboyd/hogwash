package hogwash.auth;
public class AuthFacebookUser implements IAuthUser
{
  private String accessToken;
  private int    expiresIn;

  @Override
  public String getAccessToken()
  {
    return accessToken;
  }

  @Override
  public void setAccessToken(String token)
  {
    this.accessToken = token;

  }

  @Override
  public int getExpiresIn()
  {
    return expiresIn;
  }

  @Override
  public void setExpiresIn(int expiresIn)
  {
    this.expiresIn = expiresIn;

  }

}
