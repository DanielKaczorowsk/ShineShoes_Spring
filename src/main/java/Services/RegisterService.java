package Services;

import DTO.UserDTO;
import Factory.RegisterFactory;
import Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterService
{
    private RegisterFactory registerFactory;
    private final UserRepository userRepository;
    @Transactional

    public void register(UserDTO query)
    {
        this.registerFactory.setQuery(query);
        this.registerFactory.execute();
    }
}
