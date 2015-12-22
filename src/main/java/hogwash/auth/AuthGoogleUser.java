package hogwash.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthGoogleUser implements IAuthUser
{
  @JsonProperty("access_token")
  private String accessToken;
  @JsonProperty("expires_in")
  private int    expiresIn;
  @JsonProperty("refresh_token")
  private String refreshToken;
  @JsonProperty("id_token")
  private String tokenId;

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

  public String getRefreshToken()
  {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken)
  {
    this.refreshToken = refreshToken;
  }

  public String getTokenId()
  {
    return tokenId;
  }

  public void setTokenId(String tokenId)
  {
    this.tokenId = tokenId;
  }

}
