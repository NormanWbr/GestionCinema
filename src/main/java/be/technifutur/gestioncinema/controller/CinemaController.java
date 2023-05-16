package be.technifutur.gestioncinema.controller;

import be.technifutur.gestioncinema.model.dto.CinemaDTO;
import be.technifutur.gestioncinema.model.form.CinemaForm;
import be.technifutur.gestioncinema.service.CinemaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class CinemaController {
    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/all")
    public List<CinemaDTO> getAll() {
        return cinemaService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody @Valid CinemaForm cinemaForm) {
        cinemaService.create(cinemaForm);
    }

    @PatchMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid CinemaForm cinemaForm) {
        cinemaService.update(id, cinemaForm);
    }

}
