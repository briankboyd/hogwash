package hogwash.auth;

public interface IAuthUser
{
  // private String accessToken;
  // private String refeshToken;
  // private String expiresIn;
  // private String tokenId;

  public String getAccessToken();

  public void setAccessToken(String token);

  public int getExpiresIn();

  public void setExpiresIn(int expiresIn);
}
