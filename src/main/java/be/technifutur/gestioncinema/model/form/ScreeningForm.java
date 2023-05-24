package be.technifutur.gestioncinema.model.form;

import be.technifutur.gestioncinema.model.entity.Movie;
import be.technifutur.gestioncinema.model.entity.Room;
import be.technifutur.gestioncinema.model.entity.Screening;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ScreeningForm {

    @NotNull
    @Positive
    private Long id;

    private LocalDate date;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @NotNull
    @Positive
    private Long roomId;

    @NotNull
    @Positive
    private Long movieId;

    public Screening toEntity(Room room, Movie movie) {
        Screening screening = new Screening();
        screening.setId(this.id);
        screening.setDate(this.date);
        screening.setStartTime(this.startTime);
        screening.setEndTime(this.endTime);
        screening.setRoom(room);
        screening.setMovie(movie);
        return screening;
    }

}
