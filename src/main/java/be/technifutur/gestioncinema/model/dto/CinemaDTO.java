package be.technifutur.gestioncinema.model.dto;

import be.technifutur.gestioncinema.model.entity.Cinema;
import be.technifutur.gestioncinema.model.entity.Room;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class CinemaDTO {

    private Long id;

    private String name;

    private String address;

    private String city;

    private String postalCode;

    private String phoneNumber;

    private String email;

    public static CinemaDTO from(Cinema entity){
        if(entity == null){
            return null;
        }
        CinemaDTO dto = new CinemaDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());
        dto.setPostalCode(entity.getPostalCode());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmail(entity.getEmail());
        return dto;
    }

}
