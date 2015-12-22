package hogwash.auth;

public enum AuthProviderType
{

  GOOGLE(AuthContstant.GOOGLE)
  {
    @Override
    public AuthProvider getAuthUser()
    {
      return new AuthGoogleProvider( provider );
    }
  },
  FACEBOOK(AuthContstant.FACEBOOK)
  {
    @Override
    public AuthProvider getAuthUser()
    {
      return new AuthFacebookProvider( provider );
    }
  };

  private AuthProviderType( String name ) {
    this.name = name;
  }

  @Override
  public String toString()
  {
    return provider;
  }

  private String getName()
  {
    return name;
  }

  public abstract AuthProvider getAuthUser();

  public static AuthProviderType provider(String value)
  {
    for ( AuthProviderType v : values() )
      if ( v.getName().equalsIgnoreCase( value ) )
      {
        provider = value;
        return v;
      }

    throw new IllegalArgumentException();
  }

  private static String provider;
  private String        name;
}
