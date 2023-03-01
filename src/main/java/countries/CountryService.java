package countries;

import java.util.*;

public class CountryService {
    static Scanner scanner = new Scanner(System.in);


    public HashSet<Country> listOfCountries(){
        HashSet<Country> countriesList = new HashSet<>();
        addCountries(countriesList);
        return countriesList;
    }
    public void menu(HashSet<Country> set, int option){
        switch (option) {
            case 1 -> {
                if(checkCountry(set)){
                    addCountries(set);
                }
            }
            case 2 -> sortSetByName(set);
            case 3 -> {
                if(checkCountry(set)){
                    System.out.println("The country is not on the set.");
                } else {
                    System.out.println("It will be removed. Please, write it again.");
                    String name = giveCountryName();
                    set.removeIf(country -> country.getName().equals(name));
                    sortSetByName(set);
                }
            }
        }
    }



    private void addCountries(HashSet<Country> set){
        boolean flag;

        set.add(createCountry());
        do{
            System.out.println("Do you want to add another country? Write true or false.");
            flag = scanner.nextBoolean();
            if(flag){
                set.add(createCountry());
            }
        } while(flag);
    }
    private Country createCountry(){
        Country country = new Country();
        country.setName(giveCountryName());
        return country;
    }
    private Boolean checkCountry(HashSet<Country> set){
        boolean isPresent;
        String name = giveCountryName();

        isPresent = set.stream().anyMatch(country -> country.getName().equals(name));
        if (isPresent){
            System.out.println("The country has already been on the set.");
            return false;
        } else {
            return true;
        }
//            Optional<Country> result = set.stream()
//                    .filter(country -> country.getName().equals(name))
//                    .findFirst();
//            return result.get();
    }
    private String giveCountryName(){
        System.out.println("Enter a country.");
        return scanner.next();
    }
    private void sortSetByName(HashSet<Country> set){
        set.stream()
                .sorted(Comparator.comparing(Country::getName))
                .forEach(System.out::println);
    }

}
