package Builders.UserBuilder.Login;

import DTO.UserDTO;
import Exceptions.ErrorCode;
import Exceptions.ShopException;
import Model.User;
import Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class LoginBuilder
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public LoginBuilder(UserRepository userRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void build(UserDTO query)
    {
        User user = new User();
        if(!userRepository.existsByEmail(query.getEmail()))
        {
            throw new ShopException(ErrorCode.Email_Used);
        }
        if(!passwordEncoder.matches(query.getPassword(), user.getPassword()))
        {
            throw new ShopException(ErrorCode.Email_Used);
        }
    }
}
