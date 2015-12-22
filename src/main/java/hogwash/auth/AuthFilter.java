package hogwash.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter
{

  @Override
  public void init(FilterConfig filterConfig) throws ServletException
  {}

  @Override
  public void doFilter(ServletRequest req,
                       ServletResponse res,
                       FilterChain chain) throws IOException, ServletException
  {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    HttpSession session = request.getSession( false );
    String requestUri = request.getRequestURI();

    if ( ( session != null && session.getAttribute( AuthContstant.USER ) != null )
        || requestUri.contains( "rest/v1/auth" ) || requestUri.equals( request.getContextPath() + "/" ) )
    {
      chain.doFilter( req, res );
    }
    else
    {
      response.sendRedirect( request.getContextPath() );
    }
  }

  @Override
  public void destroy()
  {}
}
