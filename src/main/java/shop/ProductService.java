package shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductService {
    static Scanner scanner = new Scanner(System.in);


    public void menu(HashMap<String, Double> map, int option){
        switch (option){
            case 1 -> addProductOnTheMap(map);
            case 2 -> modifyPrice(map);
            case 3 -> eliminateProduct(map);
            default -> printMap(map);
        }
    }


    private void addProductOnTheMap(HashMap<String, Double> map ){
        boolean flag = true;
        while(flag){
            Product product = createProduct();
            map.put(product.getName(), product.getPrice());
            System.out.println("Do you want to add another product? Write true or false");
            flag = scanner.nextBoolean();
        }

    }
    private Product createProduct(){
        double price;
        Product product = new Product();

        System.out.println("Enter name of the product.");
        product.setName(scanner.next());
        System.out.println("Enter the price of the product.");
        price = Math.floor(scanner.nextDouble() * 100)/100;
        product.setPrice(price);
        return product;
    }
    private void modifyPrice(HashMap<String, Double> map){
        System.out.println("Enter the name of the product to change the price.");
        String name = scanner.next();
        boolean isPresent = map.containsKey(name);
        if(isPresent){
            System.out.println("Enter the new price of the product.");
            double price = Math.floor(scanner.nextDouble() * 100)/100;
            map.replace(name, price);
            System.out.println("The price was changed.");
        } else {
            System.out.println("The product is not in the map.");
        }
    }
    private void printMap(HashMap<String, Double> map){
        for(Map.Entry<String, Double> aux: map.entrySet()) {
            System.out.println(aux.getKey() + ": $" + aux.getValue());
        }
    }
    private void eliminateProduct(HashMap<String, Double> map){
        System.out.println("Enter the name of the product to eliminate from the map.");
        String name = scanner.next();
        boolean isPresent = map.containsKey(name);
        if(isPresent){
            map.remove(name);
            System.out.println("The product was eliminated.");
        } else {
            System.out.println("The product is not in the map.");
        }
    }
}
