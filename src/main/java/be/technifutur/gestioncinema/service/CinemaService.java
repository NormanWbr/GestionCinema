package be.technifutur.gestioncinema.service;

import be.technifutur.gestioncinema.model.dto.CinemaDTO;
import be.technifutur.gestioncinema.model.dto.ScreeningDTO;
import be.technifutur.gestioncinema.model.entity.Screening;
import be.technifutur.gestioncinema.model.form.CinemaForm;
import be.technifutur.gestioncinema.model.form.MovieForm;

import java.util.List;

public interface CinemaService {

    CinemaDTO getOne(Long id);

    List<CinemaDTO> getAll();

    void create(CinemaForm cinemaForm);

    void update(Long id, CinemaForm cinemaForm);

    List<ScreeningDTO> getAllCinemaScreening(Long id);

    void delete(Long id);

}
