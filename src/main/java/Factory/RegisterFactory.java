package Factory;

import Builders.UserDirector;
import DTO.UserDTO;
import Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterFactory
{
    private final PasswordEncoder passwordEncoder;
    private UserDTO query;
    private final UserRepository userRepository;

    public RegisterFactory(PasswordEncoder passwordEncoder, UserRepository userRepository)
    {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    public UserDTO setQuery(UserDTO query)
    {
        this.query = query;
        return this.query;
    }
    public void execute()
    {
        UserDirector director = new UserDirector();
        director.build(this.query);
    }
}
