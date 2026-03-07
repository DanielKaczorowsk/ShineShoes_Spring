package Repository;

import Model.User;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByName(String name);
    Optional<User> findByEmail(String email);

    <S extends User> List<S> findAll(@NonNull Example<S> example);

    <S extends User> S save(S entity);

    void delete(User entity);
}
