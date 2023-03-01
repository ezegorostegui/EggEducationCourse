package pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/*
1.Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide salir, se mostrará todos los perros guardados en el ArrayList.

2. Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro
está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará
la lista ordenada.*/
public class ArraysExercise {
    static ArrayList<String> breeds = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        boolean flag;
        addBreed();
        do{
            System.out.println("Do you want to add another breed? Write true or false.");
            flag = scanner.nextBoolean();
            if(flag){
                addBreed();
            } else {
                printBreedList();
                System.out.println("Select a breed to remove from the list.");
                removeBreed(scanner.next());
                printBreedList();
            }
        } while (flag);
    }

    public static void addBreed() {
        System.out.println("Enter a breed.");
        breeds.add(scanner.next());
    }
    public static void printBreedList(){
        Collections.sort(breeds);
        for (String aux: breeds) {
            System.out.println(aux);
        }
    }
    public static void removeBreed(String breed){
        if(breeds.contains(breed)){
            //Collection's method option: breeds.removeIf(s -> s.equals(breed));
            //Iterator option
            Iterator<String> it = breeds.iterator();
            while(it.hasNext()){
                if(it.next().equals(breed)){
                    it.remove();
                }
            }
        } else {
            System.out.println("That breed is not on the list");
        }
    }
}