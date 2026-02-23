package Factory;

import Builders.UserDirector;
import DTO.RegisterDTO;
import Exceptions.ErrorCode;
import Exceptions.ShopException;
import Model.User;
import Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterFactory
{
    private final PasswordEncoder passwordEncoder;
    private RegisterDTO query;
    private final UserRepository userRepository;

    public RegisterFactory(PasswordEncoder passwordEncoder, UserRepository userRepository)
    {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    public RegisterDTO setQuery(RegisterDTO query)
    {
        this.query = query;
        return this.query;
    }
    public void execute()
    {
        UserDirector director = new UserDirector();
    }
}
