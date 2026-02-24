package Builders;

import DTO.UserDTO;

import java.util.List;

public class UserDirector
{
    private List<UserBuilderInterface> list;
    public List<UserBuilderInterface> setClass(List<UserBuilderInterface> list)
    {
        this.list = list;
        return this.list;
    }
    public void build(UserDTO query)
    {
        list.forEach(b->{
            b.build(query);
        });
    }
}
