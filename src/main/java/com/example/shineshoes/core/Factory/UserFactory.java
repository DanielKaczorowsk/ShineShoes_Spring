package com.example.shineshoes.core.Factory;

import com.example.shineshoes.core.Builders.UserBuilderInterface;
import com.example.shineshoes.core.Builders.UserDirector;
import com.example.shineshoes.core.Cache.UserCache.UserCacheInterface;
import com.example.shineshoes.core.DTO.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class UserFactory
{
    private final ApplicationContext context;
    private final UserDirector director;

    public void execute(UserDTO query, UserCacheInterface strategy)
    {
        List<UserBuilderInterface> builders = strategy.getCache().stream()
                .map(clazz -> (UserBuilderInterface) context.getBean(clazz))
                .toList();
        director.build(query,builders);
    }
}
