package be.technifutur.gestioncinema.service;

import be.technifutur.gestioncinema.model.dto.ScreeningDTO;
import be.technifutur.gestioncinema.model.form.ScreeningForm;

import java.util.List;

public interface ScreeningService{

    List<ScreeningDTO> getAll();

    ScreeningDTO getOne(Long id);

    void create(ScreeningForm screeningForm);

    void update(ScreeningForm screeningForm, Long id);

    void delete(Long id);

}
