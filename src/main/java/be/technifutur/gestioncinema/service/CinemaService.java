package be.technifutur.gestioncinema.service;

import be.technifutur.gestioncinema.model.dto.CinemaDTO;
import be.technifutur.gestioncinema.model.form.CinemaForm;
import be.technifutur.gestioncinema.model.form.MovieForm;

import java.util.List;

public interface CinemaService {

    CinemaDTO getOne(Long id);

    List<CinemaDTO> getAll();

    void create(CinemaForm cinemaForm);

    void update(Long id, CinemaForm cinemaForm);

}
