package be.technifutur.gestioncinema.controller;

import be.technifutur.gestioncinema.model.dto.MovieDTO;
import be.technifutur.gestioncinema.model.form.MovieForm;
import be.technifutur.gestioncinema.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public List<MovieDTO> getAll() {
        return movieService.getAll();
    }

    @PostMapping("/add")
    public void add(MovieForm movieForm) {
        movieService.create(movieForm);
    }

}
