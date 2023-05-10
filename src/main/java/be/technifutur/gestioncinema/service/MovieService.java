package be.technifutur.gestioncinema.service;

import be.technifutur.gestioncinema.model.dto.MovieDTO;
import be.technifutur.gestioncinema.model.form.MovieForm;

import java.util.List;

public interface MovieService {

    MovieDTO getOne(Long id);

    List<MovieDTO> getAll();

    void create(MovieForm movieForm);

    void update(Long id, MovieForm movieForm);
}
