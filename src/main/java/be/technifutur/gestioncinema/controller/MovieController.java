package be.technifutur.gestioncinema.controller;

import be.technifutur.gestioncinema.model.dto.MovieDTO;
import be.technifutur.gestioncinema.model.form.MovieForm;
import be.technifutur.gestioncinema.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
    public void add(@RequestBody @Valid MovieForm movieForm) {
        movieService.create(movieForm);
    }

    @PatchMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid MovieForm movieForm) {
        movieService.update(id, movieForm);
    }

}
