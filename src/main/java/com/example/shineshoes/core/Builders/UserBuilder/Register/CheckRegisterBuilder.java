package com.example.shineshoes.core.Builders.UserBuilder.Register;

import com.example.shineshoes.core.DTO.UserDTO;
import com.example.shineshoes.core.Exceptions.ErrorCode;
import com.example.shineshoes.core.Exceptions.ShopException;
import com.example.shineshoes.core.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckRegisterBuilder implements  RegisterBuilderInterface
{
    private final UserRepository userRepository;

    public void build(UserDTO query)
    {
        if(userRepository.existsByEmail(query.getEmail()))
        {
            throw new ShopException(ErrorCode.Email_Used);
        }
        if(userRepository.existsByName(query.getName()))
        {
            throw new ShopException(ErrorCode.Name_User);
        }
    }
}
