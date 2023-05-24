package be.technifutur.gestioncinema.controller;

import be.technifutur.gestioncinema.model.dto.CinemaDTO;
import be.technifutur.gestioncinema.model.dto.ScreeningDTO;
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

    @GetMapping("/{id}")
    public CinemaDTO getById(@PathVariable Long id) {
        return cinemaService.getOne(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody @Valid CinemaForm cinemaForm) {
        cinemaService.create(cinemaForm);
    }

    @PatchMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid CinemaForm cinemaForm) {
        cinemaService.update(id, cinemaForm);
    }

    @GetMapping("/{id}/movie")
    public List<ScreeningDTO> getAllByMovie(@PathVariable Long id) {
        return cinemaService.getAllCinemaScreening(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        cinemaService.delete(id);
    }


}
