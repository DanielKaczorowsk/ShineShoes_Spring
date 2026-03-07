package Cache.UserCache;

import Builders.UserBuilder.Register.CheckRegisterBuilder;
import Builders.UserBuilder.Register.RegisterBuilder;
import Builders.UserBuilderInterface;

import java.util.ArrayList;
import java.util.List;

public class UserRegisterCache implements UserCacheInterface
{
    private final List<Class<? extends UserBuilderInterface>> cacheRegister = new ArrayList<>();;
    public UserRegisterCache()
    {
        this.cacheRegister.add(CheckRegisterBuilder.class);
        this.cacheRegister.add(RegisterBuilder.class);
    }
    @Override
    public List<Class<? extends UserBuilderInterface>> getCache()
    {
        return this.cacheRegister;
    }
}
