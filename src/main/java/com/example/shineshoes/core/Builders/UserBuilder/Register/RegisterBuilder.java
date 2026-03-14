    package com.example.shineshoes.core.Builders.UserBuilder.Register;

    import com.example.shineshoes.core.DTO.UserDTO;
    import com.example.shineshoes.core.Model.User;
    import com.example.shineshoes.core.Repository.UserRepository;
    import lombok.RequiredArgsConstructor;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.stereotype.Component;

    @Component
    @RequiredArgsConstructor
    public class RegisterBuilder implements RegisterBuilderInterface
    {
        private final PasswordEncoder passwordEncoder;
        private final UserRepository userRepository;

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
