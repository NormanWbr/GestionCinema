package be.technifutur.gestioncinema.service.impl;

import be.technifutur.gestioncinema.model.dto.ScreeningDTO;
import be.technifutur.gestioncinema.model.entity.Screening;
import be.technifutur.gestioncinema.model.form.ScreeningForm;
import be.technifutur.gestioncinema.repository.ScreeningRepository;
import be.technifutur.gestioncinema.service.ScreeningService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    private final ScreeningRepository screeningRepository;

    public ScreeningServiceImpl(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    @Override
    public List<ScreeningDTO> getAll() {
        return screeningRepository.findAll().stream().map(ScreeningDTO::from).toList();
    }

    @Override
    public ScreeningDTO getOne(Long id) {
        return screeningRepository.findById(id).map(ScreeningDTO::from).orElseThrow();
    }

    @Override
    public void create(ScreeningForm screeningForm) {
        Screening screening = new Screening();

        screening.setDate(screeningForm.getDate());
        screening.setStartTime(screeningForm.getStartTime());
        screening.setEndTime(screeningForm.getEndTime());
//        screening.setRoom(screeningForm.getRoom());
//        screening.setMovie(screeningForm.getMovie());

        screeningRepository.save(screening);
    }

    @Override
    public void update(ScreeningForm screeningForm, Long id) {
        Screening screening = screeningRepository.findById(id).orElseThrow();

        screening.setDate(screeningForm.getDate());
        screening.setStartTime(screeningForm.getStartTime());
        screening.setEndTime(screeningForm.getEndTime());
//        screening.setRoom(screeningForm.getRoom());
//        screening.setMovie(screeningForm.getMovie());

        screeningRepository.save(screening);
    }

    @Override
    public void delete(Long id) {
        screeningRepository.deleteById(id);
    }
}
