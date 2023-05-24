package be.technifutur.gestioncinema.repository;

import be.technifutur.gestioncinema.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //    @Query("SELECT user FROM User user WHERE user.username = :username")
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

}
