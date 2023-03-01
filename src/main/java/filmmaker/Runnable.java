package filmmaker;

import java.util.List;

import static filmmaker.FilmService.scanner;

/**
 * Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto,
 * tendremos una clase Pelicula con el título, director y duración de la película (en horas).
 * Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo
 * que se pide a continuación:
 * En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
 * todos sus datos y guardándolos en el objeto Pelicula.
 * Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
 * crear otra Pelicula o no.
 * Después de ese bucle realizaremos las siguientes acciones:
 * • Mostrar en pantalla todas las películas.
 * • Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
 * • Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en
 * pantalla.
 * • Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en
 * pantalla.
 * • Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.
 * • Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
 */
public class Runnable {
    public static void main(String [] args){
        int option;
        FilmService fs = new FilmService();
        List<Film> listOfFilms = fs.createFilmList();
        do{
            System.out.print("""
                    Choose an option:

                    1. Show all films.
                    2. Show all film longer than an hour.
                    3. Sort films by length from longest to shortest.
                    4. Sort films by length from shortest to longest.
                    5. Sort films by title.
                    6. Sort films by director."""
            );
            option = scanner.nextInt();
            if(option < 1 || option > 6){
                System.out.println("Option invalid.");
            }
        } while(option < 1 || option > 6);
        scanner.close();
        fs.sortList(listOfFilms, option);
    }
}
