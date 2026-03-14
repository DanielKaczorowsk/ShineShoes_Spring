package com.example.shineshoes.core.Cache.UserCache;

import com.example.shineshoes.core.Builders.UserBuilderInterface;

import java.util.List;

public interface UserCacheInterface {
    public List<Class<? extends UserBuilderInterface>> getCache();
}
