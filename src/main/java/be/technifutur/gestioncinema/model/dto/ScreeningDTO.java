package be.technifutur.gestioncinema.model.dto;

import be.technifutur.gestioncinema.model.entity.Room;
import be.technifutur.gestioncinema.model.entity.Screening;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ScreeningDTO {

    private Long id;

    private LocalDate date;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private RoomDTO room;

    private MovieDTO movie;

    public static ScreeningDTO from(Screening entity) {
        if (entity == null) {
            return null;
        }
        ScreeningDTO dto = new ScreeningDTO();
        dto.setId(entity.getId());
        dto.setDate(entity.getDate());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        dto.setRoom(RoomDTO.from(entity.getRoom()));
        dto.setMovie(MovieDTO.from(entity.getMovie()));
        return dto;
    }

}
