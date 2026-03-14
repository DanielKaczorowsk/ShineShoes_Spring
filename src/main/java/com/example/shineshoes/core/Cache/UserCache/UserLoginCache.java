package com.example.shineshoes.core.Cache.UserCache;

import com.example.shineshoes.core.Builders.UserBuilder.Login.GenerateToken;
import com.example.shineshoes.core.Builders.UserBuilder.Login.LoginBuilder;
import com.example.shineshoes.core.Builders.UserBuilderInterface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserLoginCache implements UserCacheInterface
{
    private final List<Class<? extends UserBuilderInterface>> cacheLogin = new ArrayList<>();;

    public UserLoginCache()
    {
        this.cacheLogin.add(LoginBuilder.class);
        this.cacheLogin.add(GenerateToken.class);
    }
    @Override
    public List<Class<? extends UserBuilderInterface>>getCache()
    {
        return this.cacheLogin;
    }
}
