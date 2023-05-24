package be.technifutur.gestioncinema.service.impl;

import be.technifutur.gestioncinema.model.Classification;
import be.technifutur.gestioncinema.model.Genre;
import be.technifutur.gestioncinema.model.dto.MovieDTO;
import be.technifutur.gestioncinema.model.entity.Movie;
import be.technifutur.gestioncinema.model.form.MovieForm;
import be.technifutur.gestioncinema.repository.MovieRepository;
import be.technifutur.gestioncinema.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieDTO getOne(Long id) {
        return movieRepository.findById(id).map(MovieDTO::from).orElseThrow();
    }

    @Override
    public List<MovieDTO> getAll() {
        return movieRepository.findAll().stream().map(MovieDTO::from).toList();
    }

    @Override
    public void create(MovieForm movieForm) {

        Movie movie = new Movie();

        movie.setTitle(movieForm.getTitle());
        movie.setDuration(movieForm.getDuration());
        movie.setReleaseDate(movieForm.getReleaseDate());
        movie.setDirector(movieForm.getDirector());
        movie.setClassifications(movieForm.getClassifications().stream().map(Classification::valueOf).toList());
        movie.setGenres(movieForm.getGenres().stream().map(Genre::valueOf).toList());
        movie.setDescription(movieForm.getDescription());
        movie.setEndDate(movieForm.getEndDate());
        movie.setPoster(movieForm.getPoster());

        movieRepository.save(movie);
    }

    @Override
    public void update(Long id, MovieForm movieForm) {
        Movie movie = movieRepository.findById(id).orElseThrow();

        movie.setTitle(movieForm.getTitle());
        movie.setDuration(movieForm.getDuration());
        movie.setReleaseDate(movieForm.getReleaseDate());
        movie.setDirector(movieForm.getDirector());
        movie.setClassifications(movieForm.getClassifications().stream().map(Classification::valueOf).toList());
        movie.setGenres(movieForm.getGenres().stream().map(Genre::valueOf).toList());
        movie.setDescription(movieForm.getDescription());
        movie.setEndDate(movieForm.getEndDate());
        movie.setPoster(movieForm.getPoster());

        movieRepository.save(movie);
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

}
