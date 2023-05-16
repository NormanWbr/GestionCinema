package be.technifutur.gestioncinema.service.impl;

import be.technifutur.gestioncinema.model.dto.CinemaDTO;
import be.technifutur.gestioncinema.model.entity.Cinema;
import be.technifutur.gestioncinema.model.form.CinemaForm;
import be.technifutur.gestioncinema.repository.CinemaRepository;
import be.technifutur.gestioncinema.service.CinemaService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Cinema cinema = new Cinema();

        cinema.setName(cinemaForm.getName());
        cinema.setAddress(cinemaForm.getAddress());
        cinema.setCity(cinemaForm.getCity());
        cinema.setPostalCode(cinemaForm.getPostalCode());
        cinema.setEmail(cinemaForm.getEmail());
        cinema.setPhoneNumber(cinemaForm.getPhoneNumber());

        cinemaRepository.save(cinema);
    }

    @Override
    public void update(Long id, CinemaForm cinemaForm) {
        Cinema cinema = cinemaRepository.findById(id).orElseThrow();
        cinema.setName(cinemaForm.getName());
        cinema.setAddress(cinemaForm.getAddress());
        cinema.setCity(cinemaForm.getCity());
        cinema.setPostalCode(cinemaForm.getPostalCode());
        cinema.setEmail(cinemaForm.getEmail());
        cinema.setPhoneNumber(cinemaForm.getPhoneNumber());
        cinemaRepository.save(cinema);
    }
}