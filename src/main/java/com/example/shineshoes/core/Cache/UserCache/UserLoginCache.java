package Cache.UserCache;

import Builders.UserBuilder.Login.GenerateToken;
import Builders.UserBuilder.Login.LoginBuilder;
import Builders.UserBuilderInterface;

import java.util.ArrayList;
import java.util.List;

public class UserLoginCache implements UserCacheInterface
{
    private final List<Class<? extends UserBuilderInterface>> loginDate = new ArrayList<>();;

    public UserLoginCache()
    {
        this.loginDate.add(LoginBuilder.class);
        this.loginDate.add(GenerateToken.class);
    }
    @Override
    public List<Class<? extends UserBuilderInterface>>getCache()
    {
        return this.loginDate;
    }
}
