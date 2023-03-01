package shop;

import java.util.HashMap;

import static shop.ProductService.scanner;

/**
 * Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos
 * productos que venderemos y el precio que tendrán. Además, se necesita que la
 * aplicación cuente con las funciones básicas.

 * Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio,
 * eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
 * Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
 * Realizar un menú para lograr todas las acciones previamente mencionadas.
 */

public class Runnable {
    public static void main(String [] args){
        ProductService ps = new ProductService();
        HashMap<String, Double> mapOfProducts = new HashMap<>();
        int option;
        boolean cancel = false;

        while(!cancel){
            do{
                System.out.println("""
                Choose an option:
                    1. Add a product to the map.1
                    2. Modify the price of a product.
                    3. Eliminate a product to the map.
                    4. Show all products.
                """);
                option = scanner.nextInt();
                if(option < 1 || option > 4){
                    System.out.println("Invalid option. Try again.");
                }
            } while (option < 1 || option > 4);
            ps.menu(mapOfProducts, option);
            System.out.println("Do you want to close the program? Write true or false.");
            cancel = scanner.nextBoolean();
        }
    }
}
