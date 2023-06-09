package be.technifutur.gestioncinema.model.form;

import be.technifutur.gestioncinema.model.Classification;
import be.technifutur.gestioncinema.model.Genre;
import be.technifutur.gestioncinema.model.entity.Movie;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class MovieForm {

    @NotNull
    @Positive
    private Long id;

    @NotNull
    private String title;

    private Set<String> director;

    private List<String> genres;

    private List<String> classifications;

    private String description;

    @Positive
    private Integer duration;

    private LocalDate releaseDate;

    private LocalDate endDate;

    private String poster;

    public Movie toEntity() {

        Movie movie = new Movie();

        movie.setId(this.id);
        movie.setTitle(this.title);
        movie.setDirector(this.director);
        movie.setGenres(this.genres.stream().map(Genre::valueOf).toList());
        movie.setClassifications(this.classifications.stream().map(Classification::valueOf).toList());
        movie.setDescription(this.description);
        movie.setDuration(this.duration);
        movie.setReleaseDate(this.releaseDate);
        movie.setEndDate(this.endDate);
        movie.setPoster(this.poster);

        return movie;

    }

}
