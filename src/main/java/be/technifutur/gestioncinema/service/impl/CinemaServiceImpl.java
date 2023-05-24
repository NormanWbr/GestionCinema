package be.technifutur.gestioncinema.service.impl;

import be.technifutur.gestioncinema.model.dto.CinemaDTO;
import be.technifutur.gestioncinema.model.dto.ScreeningDTO;
import be.technifutur.gestioncinema.model.entity.Cinema;
import be.technifutur.gestioncinema.model.entity.Room;
import be.technifutur.gestioncinema.model.entity.Screening;
import be.technifutur.gestioncinema.model.form.CinemaForm;
import be.technifutur.gestioncinema.repository.CinemaRepository;
import be.technifutur.gestioncinema.service.CinemaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;

    public CinemaServiceImpl(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public CinemaDTO getOne(Long id) {
        return cinemaRepository.findById(id).map(CinemaDTO::from).orElseThrow();
    }

    @Override
    public List<CinemaDTO> getAll() {
        return cinemaRepository.findAll().stream().map(CinemaDTO::from).toList();
    }

    @Override
    public void create(CinemaForm cinemaForm) {
        Cinema cinema = cinemaForm.toEntity();

        cinemaRepository.save(cinema);
    }

    @Override
    public void update(Long id, CinemaForm cinemaForm) {
        Cinema cinema = cinemaRepository.findById(id).orElseThrow();

        cinema = cinemaForm.toEntity();

        cinemaRepository.save(cinema);
    }

    @Override
    public List<ScreeningDTO> getAllCinemaScreening(Long id) {
        Cinema cinema = cinemaRepository.findById(id).orElseThrow();
        Set<Room> rooms = cinema.getRooms();
        Set<Screening> screenings = rooms.stream().flatMap(room -> room.getScreenings().stream()).collect(Collectors.toSet());
        return screenings.stream().map(ScreeningDTO::from).toList();
    }

    @Override
    public void delete(Long id) {
        cinemaRepository.deleteById(id);
    }

}
