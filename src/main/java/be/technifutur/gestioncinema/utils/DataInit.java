package be.technifutur.gestioncinema.utils;

import be.technifutur.gestioncinema.model.Classification;
import be.technifutur.gestioncinema.model.Genre;
import be.technifutur.gestioncinema.model.entity.Movie;
import be.technifutur.gestioncinema.model.entity.User;
import be.technifutur.gestioncinema.repository.CinemaRepository;
import be.technifutur.gestioncinema.repository.MovieRepository;
import be.technifutur.gestioncinema.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;

@Component
public class DataInit implements InitializingBean {

    private final MovieRepository movieRepository;
    private final CinemaRepository cinemaRepository;
    private final UserRepository userRepository;

    public DataInit(MovieRepository movieRepository, CinemaRepository cinemaRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.cinemaRepository = cinemaRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Movie lgdlg3 = new Movie();

        lgdlg3.setTitle("Les Gardiens de la Galaxie 3");
        lgdlg3.setDescription("""
                Les Gardiens de la Galaxie vont devoir combattre à nouveau Ayesha, 
                la prêtresse des Souverains, 
                faire face au créateur de Rocket qui veut le récupérer à tout prix 
                et défier Adam Warlock prêt à tout pour les tuer.
                """);
        lgdlg3.setGenres(List.of(Genre.ACTION, Genre.ADVENTURE, Genre.COMEDY));
        lgdlg3.setClassifications(List.of(Classification.AL));
        lgdlg3.setReleaseDate(LocalDate.of(2023, 5, 3));
        lgdlg3.setPoster("https://xl.movieposterdb.com/23_02/2021/6791350/xl_guardians-of-the-galaxy-vol-3-movie-poster_1aa9e0b7.jpg");
        lgdlg3.setDirector(Set.of("James Gunn"));
        lgdlg3.setDuration(150);
        lgdlg3.setEndDate(lgdlg3.getReleaseDate().plus(3, ChronoUnit.MONTHS));

        movieRepository.save(lgdlg3);

        User user = new User();

        user.setUsername("user");
        user.setPassword("pass");
        user.setEnabled(true);
        user.setRoles(Set.of("USER"));

        userRepository.save(user);

        User admin = new User();

        admin.setUsername("admin");
        admin.setPassword("pass");
        admin.setEnabled(true);
        admin.setRoles(Set.of("USER","ADMIN"));

        userRepository.save(admin);

    }
}
