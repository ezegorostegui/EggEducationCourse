package filmmaker;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilmService {
    static Scanner scanner = new Scanner(System.in);
    private final static Logger LOGGER = Logger.getLogger("film.FilmService");


    public List<Film> createFilmList(){
        boolean flag = true;
        List<Film> listOfFilms = new ArrayList<>();

        listOfFilms.add(createFilm());
        do{
            try{
                LOGGER.info("Do you want to add another film? Write true or false.");
                flag = scanner.nextBoolean();
                if(flag){
                    listOfFilms.add(createFilm());
                }
            } catch (Exception e){
                LOGGER.log(Level.WARNING,"Have to write true or false.");
            }
        } while(flag);
        return listOfFilms;
    }
    public void sortList(List<Film> list, int option){
            switch (option) {
                case 1 -> list.forEach(System.out::println);
                case 2 -> list.stream()
                        .sorted(Comparator.comparing(Film::getDuration))
                        .filter(film -> film.getDuration() > 60)
                        .forEach(System.out::println);
                case 3 -> list.stream()
                        .sorted(Comparator.comparing(Film::getDuration).reversed())
                        .forEach(System.out::println);
                case 4 -> list.stream()
                        .sorted(Comparator.comparingInt(Film::getDuration))
                        .forEach(System.out::println);
                case 5 -> list.stream()
                        .sorted(Comparator.comparing(Film::getTitle))
                        .forEach(System.out::println);
                default -> {
                    list.stream()
                            .sorted(Comparator.comparing(Film::getDirector))
                            .forEach(System.out::println);
                }
            }
    }


    private Film createFilm(){
        Film film = new Film();
        LOGGER.info("Enter the title of the film.");
        film.setTitle(scanner.next());
        LOGGER.info("Enter the director's name of the film.");
        film.setDirector(scanner.next());
        LOGGER.info("Enter the duration of the film in minutes.");
        film.setDuration(scanner.nextInt());
        return film;
    }
}
