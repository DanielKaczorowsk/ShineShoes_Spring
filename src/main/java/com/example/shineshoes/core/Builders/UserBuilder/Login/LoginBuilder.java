package Builders.UserBuilder.Login;

import DTO.UserDTO;
import Exceptions.ErrorCode;
import Exceptions.ShopException;
import Model.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoginBuilder implements LoginBuilderInterface
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginBuilder(UserDTO userDTO) {}

    public void build(UserDTO query)
    {
        User user = userRepository.findByEmail(query.getEmail())
                .orElseThrow(() -> new ShopException(ErrorCode.Email_Used));
        if(!passwordEncoder.matches(query.getPassword(), user.getPassword()))
        {
            throw new ShopException(ErrorCode.Email_Used);
        }
        query.setName(user.getName());
    }
}
