package countries;

/**
 * Se requiere un programa que lea y guarde países, y para evitar que se ingresen repetidos
 * usaremos un conjunto. El programa pedirá un país en un bucle, se guardará el país en el
 * conjunto y después se le preguntará al usuario si quiere guardar otro país o si quiere salir,
 * si decide salir, se mostrará todos los países guardados en el conjunto. (Recordemos hacer
 * los servicios en la clase correspondiente)
 * Después deberemos mostrar el conjunto ordenado alfabéticamente: para esto recordar
 * cómo se ordena un conjunto.
 * Por último, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator, se
 * buscará el país en el conjunto y si está en el conjunto se eliminará el país que ingresó el
 * usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto se le informará
 * al usuario.
 */

import java.util.HashSet;

import static countries.CountryService.scanner;

public class Runnable {
    public static void main(String [] arg){
        int option;
        boolean cancel = false;
        CountryService cs = new CountryService();
        HashSet<Country> countriesList = cs.listOfCountries();

        while(!cancel){
            do{
                System.out.print("""
                Choose an option:
                
                    1. Add more countries to the set.
                    2. Show all countries.
                    3. Eliminate a country on the set.
                
                """);
                option = scanner.nextInt();
                if(option<1 || option>3){
                    System.out.println("Option invalid. Try again.");
                }
            } while(option<1 || option>3);
            cs.menu(countriesList,option);
            System.out.println("Do you want to close the program? Write true or false.");
            cancel = scanner.nextBoolean();
        }
        scanner.close();
    }
}
