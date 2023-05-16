package be.technifutur.gestioncinema.repository;

import be.technifutur.gestioncinema.model.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
