    package Builders.UserBuilder.Register;

    import DTO.UserDTO;
    import Model.User;
    import Repository.UserRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Component;

    @Component
    public class RegisterBuilder implements RegisterBuilderInterface
    {
        @Autowired
        private PasswordEncoder passwordEncoder;
        @Autowired
        private UserRepository userRepository;

        public RegisterBuilder(UserDTO userDTO) {
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
