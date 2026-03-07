package com.example.shineshoes.core.Services;

import com.example.shineshoes.core.Cache.UserCache.UserRegisterCache;
import com.example.shineshoes.core.DTO.UserDTO;
import com.example.shineshoes.core.Factory.UserFactory;
import com.example.shineshoes.core.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterService
{
    private UserFactory userFactory;
    private final UserRepository userRepository;
    @Transactional

    public void register(UserDTO query)
    {
        UserRegisterCache register = new UserRegisterCache();
        this.userFactory.execute(query,register);
    }
}
