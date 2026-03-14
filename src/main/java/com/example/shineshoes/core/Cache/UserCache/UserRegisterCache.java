package com.example.shineshoes.core.Cache.UserCache;

import com.example.shineshoes.core.Builders.UserBuilder.Register.CheckRegisterBuilder;
import com.example.shineshoes.core.Builders.UserBuilder.Register.RegisterBuilder;
import com.example.shineshoes.core.Builders.UserBuilder.Register.VerifyRegisterBuilder;
import com.example.shineshoes.core.Builders.UserBuilderInterface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserRegisterCache implements UserCacheInterface
{
    private final List<Class<? extends UserBuilderInterface>> cacheRegister = new ArrayList<>();;
    public UserRegisterCache()
    {
        this.cacheRegister.add(CheckRegisterBuilder.class);
        this.cacheRegister.add(RegisterBuilder.class);
        this.cacheRegister.add(VerifyRegisterBuilder.class);
    }
    @Override
    public List<Class<? extends UserBuilderInterface>> getCache()
    {
        return this.cacheRegister;
    }
}
