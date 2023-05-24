package be.technifutur.gestioncinema.model.dto;

import be.technifutur.gestioncinema.model.entity.Room;
import lombok.Data;

@Data
public class RoomDTO {

    private Long id;

    private Long number;

    private Integer capacity;

    public static RoomDTO from(Room entity){
        if(entity == null){
            return null;
        }
        RoomDTO dto = new RoomDTO();
        dto.setId(entity.getId());
        dto.setNumber(entity.getNumber());
        dto.setCapacity(entity.getCapacity());
        return dto;
    }

}
