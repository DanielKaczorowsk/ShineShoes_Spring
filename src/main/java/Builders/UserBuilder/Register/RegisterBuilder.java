package Builders.UserBuilder.Register;

import DTO.UserDTO;
import Model.User;
import Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterBuilder implements RegisterBuilderInterface
{
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public RegisterBuilder(PasswordEncoder passwordEncoder, UserRepository userRepository)
    {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    @Override
    public void build(UserDTO query)
    {
        User user = new User();
        user.setEmail(query.getEmail());
        user.setName(query.getName());
        user.setPassword(this.passwordEncoder.encode(query.getPassword()));
        userRepository.save(user);
    }
}
