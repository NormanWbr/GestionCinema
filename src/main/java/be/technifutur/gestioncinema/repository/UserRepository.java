package be.technifutur.gestioncinema.repository;

import be.technifutur.gestioncinema.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //    @Query("SELECT u from User u WHERE u.username = :username")
    Optional<User> findByUsername(String username);

}