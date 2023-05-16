package be.technifutur.gestioncinema.model.form;

import be.technifutur.gestioncinema.model.entity.Cinema;
import be.technifutur.gestioncinema.model.entity.Room;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class CinemaForm {

    @NotNull
    @Positive
    private Long id;

    private String name;

    private String address;

    private String city;

    private String postalCode;

    private String phoneNumber;

    private String email;

    public Cinema toEntity() {
        Cinema cinema = new Cinema();
        cinema.setId(this.id);
        cinema.setName(this.name);
        cinema.setAddress(this.address);
        cinema.setCity(this.city);
        cinema.setPostalCode(this.postalCode);
        cinema.setPhoneNumber(this.phoneNumber);
        cinema.setEmail(this.email);
        return cinema;
    }

}
