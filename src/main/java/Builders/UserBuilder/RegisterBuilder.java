package Builders.UserBuilder;

import DTO.RegisterDTO;
import Exceptions.ErrorCode;
import Exceptions.ShopException;
import Model.User;
import Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterBuilder
{
    private final PasswordEncoder passwordEncoder;
    private RegisterDTO query;
    private final UserRepository userRepository;
    public RegisterBuilder(PasswordEncoder passwordEncoder, UserRepository userRepository)
    {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    private void checkEmail()
    {
        if(!userRepository.existsByEmail(this.query.getEmail()))
        {
            throw new ShopException(ErrorCode.Email_Used);
        }
        if(!userRepository.existsByName(this.query.getName()))
        {
            throw new ShopException(ErrorCode.Name_User);
        }
    }
    public void build()
    {
        User user = new User();
        user.setEmail(this.query.getEmail());
        user.setName(this.query.getName());
        user.setPassword(this.passwordEncoder.encode(this.query.getPassword()));
        userRepository.save(user);
    }
}
