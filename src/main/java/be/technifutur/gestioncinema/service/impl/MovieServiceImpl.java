package be.technifutur.gestioncinema.service.impl;

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
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println(movieForm.getClassifications());

        Movie movie = new Movie();

        movie.setTitle(movieForm.getTitle());
        movie.setDuration(movieForm.getDuration());
        movie.setReleaseDate(movieForm.getReleaseDate());
        movie.setDirector(movieForm.getDirector());
        movie.setClassifications(movieForm.getClassifications());
        movie.setDescription(movieForm.getDescription());
        movie.setEndDate(movieForm.getEndDate());
        movie.setGenres(movieForm.getGenres());
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
        movie.setClassifications(movieForm.getClassifications());
        movie.setDescription(movieForm.getDescription());
        movie.setEndDate(movieForm.getEndDate());
        movie.setGenres(movieForm.getGenres());
        movie.setPoster(movieForm.getPoster());

        movieRepository.save(movie);
    }
}
