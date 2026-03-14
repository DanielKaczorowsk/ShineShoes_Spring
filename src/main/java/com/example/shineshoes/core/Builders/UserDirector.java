package com.example.shineshoes.core.Builders;

import com.example.shineshoes.core.DTO.UserDTO;
import com.example.shineshoes.core.Exceptions.ErrorCode;
import com.example.shineshoes.core.Exceptions.ShopException;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserDirector
{
    public void build(UserDTO query,List<UserBuilderInterface> list)
    {
        if (list == null || list.isEmpty()) {
            throw new ShopException(ErrorCode.Empty_Class);
        }
        list.forEach(b->{
            b.build(query);
        });
    }
}
