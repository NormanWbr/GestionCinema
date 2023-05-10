package be.technifutur.gestioncinema.model.entity;

import be.technifutur.gestioncinema.model.BookingStatus;
import be.technifutur.gestioncinema.model.Classification;
import be.technifutur.gestioncinema.model.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;

    @Column(unique = true)
    private String title;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> director = new LinkedHashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private List<Genre> genres;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private List<Classification> classifications;

    private String description;

    private Integer duration;

    private LocalDate releaseDate;

    private LocalDate endDate;

    private String poster;

    @OneToMany(mappedBy = "movie")
    private Set<Screening> screenings = new LinkedHashSet<>();

}
