package be.technifutur.gestioncinema.repository;

import be.technifutur.gestioncinema.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface RoomRepository extends JpaRepository<Room, Long> {
}
