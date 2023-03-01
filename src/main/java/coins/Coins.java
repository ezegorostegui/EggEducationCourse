package coins;

import java.util.*;

/**
 * Coins = 400;
 * Menu = { "coffee" : 100
 * "cake" : 200
 * "popcorn" : 225
 * }
 * Write a method that will show all possible combinations
 * that can be bought for coins
 */
public class Coins {
    public static void main(String [] args) {
        Set<String[]> products = new HashSet<>();
        products.add(new String[]{"coffee", "100"});
        products.add(new String[]{"cake","200"});
        products.add(new String[]{"popcorn","225"});
//        products.add(new String[]{"tea","100"});
        Set<String> result = new HashSet<>();

        for (String[] aux: products) {
            if(Integer.parseInt(aux[1]) <= 400){
                for (String[] aux2: products) {
                    if(aux[0].equals(aux2[0])){
                        combinationWithTheSameProduct(aux, aux2, result);
                    } else {
                        combinationWithDifferentProducts(aux, aux2, result);
                    }
                }
            }
        }
        System.out.print("There are " + result.size() + " combinations:" + "\n" + result);
    }
    public static void combinationWithTheSameProduct(String[] aux, String[] aux2, Set<String> result) {
        int coins = 400;
        StringBuilder combination = new StringBuilder();

        while((coins - Integer.parseInt(aux2[1])) >= 0){
            coins = coins - Integer.parseInt(aux2[1]);
            combination.append(aux[0]);
            result.add(combination.toString());
            combination.append(" + ");
        }
    }
    public static void combinationWithDifferentProducts(String[] aux, String[] aux2, Set<String> result) {
        int coins = 400;
        StringBuilder combination = new StringBuilder();
        List<String> toSort = new ArrayList<>();

        coins = coins - Integer.parseInt(aux[1]);
        toSort.add(aux[0]);
        while((coins - Integer.parseInt(aux2[1])) >= 0) {
            coins = coins - Integer.parseInt(aux2[1]);
            toSort.add(aux2[0]);
        }
        Collections.sort(toSort);
        for (int j = 0; j < toSort.size(); j++) {
            combination.append(toSort.get(j));
            if(!(j == toSort.size()-1)){
                combination.append(" + ");
            }
        }
        result.add(combination.toString());
    }
}