package Cache.UserCache;

import Builders.UserBuilderInterface;

import java.util.List;

public interface UserCacheInterface {
    public List<Class<? extends UserBuilderInterface>> getCache();
}
