package be.technifutur.gestioncinema.controller;

import be.technifutur.gestioncinema.model.dto.ScreeningDTO;
import be.technifutur.gestioncinema.service.ScreeningService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/screening")
public class ScreeningController {

    private final ScreeningService screeningService;

    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @GetMapping("/all")
    public List<ScreeningDTO> getAllScreenings() {
        return screeningService.getAll();
    }

}
