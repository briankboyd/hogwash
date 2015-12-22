package hogwash.auth;

import com.github.scribejava.core.builder.api.Api;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.oauth.OAuthService;

public interface IAuthProvider
{
  public OAuthService buildService(Class< ? extends Api > apiClass);

  public String serviceRedirect();

  public Response getResponseForProfile();

  public Token buildAccessToken(String code);

  public Response getRefreshToken(String code);

  public String getClassName();

  public IAuthUser createAuthUser(String authResponse);

}
