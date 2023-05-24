package be.technifutur.gestioncinema.utils;

import be.technifutur.gestioncinema.model.Classification;
import be.technifutur.gestioncinema.model.Genre;
import be.technifutur.gestioncinema.model.entity.*;
import be.technifutur.gestioncinema.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;

@Component
public class DataInit implements InitializingBean {

    private final MovieRepository movieRepository;
    private final CinemaRepository cinemaRepository;

    private final RoomRepository roomRepository;
    private final ScreeningRepository screeningRepository;

    public DataInit(MovieRepository movieRepository, CinemaRepository cinemaRepository, RoomRepository roomRepository,
                    ScreeningRepository screeningRepository) {
        this.movieRepository = movieRepository;
        this.cinemaRepository = cinemaRepository;
        this.roomRepository = roomRepository;
        this.screeningRepository = screeningRepository;
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

        Cinema cinema1 = new Cinema();

        cinema1.setName("Kinepolis");
        cinema1.setCity("Bruxelles");
        cinema1.setAddress("Boulevard du Centenaire 20");
        cinema1.setPhoneNumber("02 474 26 26");
        cinema1.setEmail("bruxelles@kinepolis.be");
        cinema1.setPostalCode("1020");

        Cinema cinema2 = new Cinema();

        cinema2.setName("UGC");
        cinema2.setCity("Bruxelles");
        cinema2.setAddress("Boulevard Anspach 85");
        cinema2.setPhoneNumber("02 474 26 26");
        cinema2.setEmail("bruxelles@ugc.be");
        cinema2.setPostalCode("1000");

        Room room1 = new Room();

        room1.setNumber(1L);
        room1.setCapacity(100);
        room1.setCinema(cinema1);

        Screening screening1 = new Screening();

        screening1.setMovie(lgdlg3);
        screening1.setDate(LocalDate.of(2023, 5, 3));
        screening1.setRoom(room1);
        screening1.setStartTime(LocalDateTime.of(2023, 5, 3, 10, 0));
        screening1.setEndTime(LocalDateTime.of(2023, 5, 3, 12, 30));

        room1.setScreenings(Set.of(screening1));

        movieRepository.save(lgdlg3);
        cinemaRepository.save(cinema1);
        cinemaRepository.save(cinema2);
        roomRepository.save(room1);
        screeningRepository.save(screening1);


    }
}
