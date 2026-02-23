package Builders;

import Builders.UserBuilder.LoginBuilderInterface;
import Builders.UserBuilder.RegisterBuilder;

import java.util.List;

public class UserDirector
{
    private List<LoginBuilderInterface<?>> list;
    public List<LoginBuilderInterface<?>> setClass(List<LoginBuilderInterface<?>> list)
    {
        this.list = list;
        return this.list;
    }
    public void build()
    {
        list.forEach(LoginBuilderInterface::build);
    }
}
