package com.example.shineshoes.core.Builders.UserBuilder.Login;

import com.example.shineshoes.core.DTO.UserDTO;
import com.example.shineshoes.core.Exceptions.ErrorCode;
import com.example.shineshoes.core.Exceptions.ShopException;
import com.example.shineshoes.core.Model.User;
import com.example.shineshoes.core.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LoginBuilder implements LoginBuilderInterface
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void build(UserDTO query)
    {
        User user = userRepository.findByEmail(query.getEmail())
                .orElseThrow(() -> new ShopException(ErrorCode.USER_NOT_FOUND));
        if(!passwordEncoder.matches(query.getPassword(), user.getPassword()))
        {
            throw new ShopException(ErrorCode.INVALID_CREDENTIALS);
        }
        query.setName(user.getName());
    }
}
