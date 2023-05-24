package be.technifutur.gestioncinema.repository;

import be.technifutur.gestioncinema.model.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}
