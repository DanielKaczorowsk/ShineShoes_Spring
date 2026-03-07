package Factory;

import Builders.UserBuilderInterface;
import Builders.UserDirector;
import Cache.UserCache.UserCacheInterface;
import DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserFactory
{
    @Autowired
    private ApplicationContext context;


    public void execute(UserDTO query, UserCacheInterface strategy)
    {
        List<UserBuilderInterface> builders = strategy.getCache().stream()
                .map(clazz -> (UserBuilderInterface) context.getBean(clazz))
                .toList();
        UserDirector director = new UserDirector();
        director.setClass(builders);
        director.build(query);
    }
}
