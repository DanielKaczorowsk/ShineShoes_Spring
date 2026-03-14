package com.example.shineshoes.core.Services;

import com.example.shineshoes.core.Cache.UserCache.UserLoginCache;
import com.example.shineshoes.core.Cache.UserCache.UserRegisterCache;
import com.example.shineshoes.core.DTO.UserDTO;
import com.example.shineshoes.core.Factory.UserFactory;
import com.example.shineshoes.core.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService
{
    private final UserFactory userFactory;
    private final UserRegisterCache register;
    private final UserLoginCache login;
    @Transactional

    public void register(UserDTO query)
    {
        this.userFactory.execute(query,register);
    }
    public void login(UserDTO query){this.userFactory.execute(query,login);}
}
