package hogwash.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import hogwash.auth.AuthContstant;
import hogwash.auth.IAuthUser;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FacebookUser implements IUser
{
  private int       userId;
  @JsonProperty("id")
  private String    providerId;
  @JsonProperty("email")
  private String    email;
  @JsonProperty("first_name")
  private String    firstName;
  @JsonProperty("last_name")
  private String    lastName;
  @JsonProperty("gender")
  private String    gender;
  @JsonProperty("locale")
  private String    locale;
  private String    provider = AuthContstant.FACEBOOK;
  private IAuthUser authUser;

  @Override
  public String getProviderId()
  {
    return providerId;
  }

  @Override
  public void setProviderId(String userId)
  {
    this.providerId = userId;
  }

  @Override
  public String getEmail()
  {
    return email;
  }

  @Override
  public void setEmail(String email)
  {
    this.email = email;
  }

  @Override
  public String getFirstName()
  {
    return firstName;
  }

  @Override
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  @Override
  public String getLastName()
  {
    return lastName;
  }

  @Override
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  @Override
  public String getGender()
  {
    return gender;
  }

  @Override
  public void setGender(String gender)
  {
    this.gender = gender;
  }

  @Override
  public String getLocale()
  {
    return locale;
  }

  @Override
  public void setLocale(String locale)
  {
    this.locale = locale;
  }

  @Override
  public String getProvider()
  {
    return provider;
  }

  @Override
  public void setProvider(String provider)
  {
    this.provider = provider;
  }

  @Override
  public IAuthUser getAuthUser()
  {
    return authUser;
  }

  @Override
  public void setAuthUser(IAuthUser authUser)
  {
    this.authUser = authUser;
  }

  @Override
  public int getUserId()
  {
    return userId;
  }

  @Override
  public void setUserId(int id)
  {
    this.userId = id;
  }
}
