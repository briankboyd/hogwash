package hogwash.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import hogwash.auth.AuthContstant;
import hogwash.auth.IAuthUser;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFacebook implements IUser
{
  private int       userId;
  private String    providerId;
  private String    email;
  @JsonProperty("first_name")
  private String    firstName;
  private String    lastName;
  private String    gender;
  private String    locale;
  private String    provider = AuthContstant.FACEBOOK;
  private IAuthUser authUser;

  @JsonIgnore
  @Override
  public String getProviderId()
  {
    return providerId;
  }

  @JsonProperty("id")
  @Override
  public void setProviderId(String userId)
  {
    this.providerId = userId;
  }

  @JsonIgnore
  @Override
  public String getEmail()
  {
    return email;
  }

  @JsonProperty("email")
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

  @JsonIgnore
  @Override
  public String getLastName()
  {
    return lastName;
  }

  @JsonProperty("last_name")
  @Override
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  @JsonIgnore
  @Override
  public String getGender()
  {
    return gender;
  }

  @JsonProperty("gender")
  @Override
  public void setGender(String gender)
  {
    this.gender = gender;
  }

  @JsonIgnore
  @Override
  public String getLocale()
  {
    return locale;
  }

  @JsonProperty("locale")
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

  @JsonIgnore
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
