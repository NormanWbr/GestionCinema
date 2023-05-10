package be.technifutur.gestioncinema.model.entity;

import be.technifutur.gestioncinema.model.Price;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_id")
    private Long id;

    private String name;

    private String address;

    private String city;

    private String postalCode;

    private String phoneNumber;

    private String email;

    @OneToMany(mappedBy = "cinema")
    private Set<Room> rooms = new LinkedHashSet<>();

}
