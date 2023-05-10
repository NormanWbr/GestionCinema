package be.technifutur.gestioncinema.repository;

import be.technifutur.gestioncinema.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
