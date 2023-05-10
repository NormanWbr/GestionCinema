package be.technifutur.gestioncinema.model.dto;

import be.technifutur.gestioncinema.model.Classification;
import be.technifutur.gestioncinema.model.Genre;
import be.technifutur.gestioncinema.model.entity.Booking;
import be.technifutur.gestioncinema.model.entity.Movie;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class MovieDTO {

    private Long id;

    private String title;

    private Set<String> director;

    private List<Genre> genres;

    private List<Classification> classifications;

    private String description;

    private Integer duration;

    private LocalDate releaseDate;

    private LocalDate endDate;

    private String poster;

    public static MovieDTO from(Movie entity){
        if(entity == null){
            return null;
        }
        MovieDTO dto = new MovieDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDirector(entity.getDirector());
        dto.setGenres(entity.getGenres());
        dto.setClassifications(entity.getClassifications());
        dto.setDescription(entity.getDescription());
        dto.setDuration(entity.getDuration());
        dto.setReleaseDate(entity.getReleaseDate());
        dto.setEndDate(entity.getEndDate());
        dto.setPoster(entity.getPoster());
        return dto;
    }

}
