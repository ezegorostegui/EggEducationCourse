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
public class CoinsWithMap {
    public static void main(String[] args){
        Integer coins = 400;
        HashMap<String, Integer> menu = new HashMap<>();
        menu.put("coffee", 100);
        menu.put("cake", 200);
        menu.put("popcorn", 225);
//        menu.put("tea", 150);
        Set<String> result = new HashSet<>();

        for(Map.Entry<String, Integer> aux1: menu.entrySet()){
            if(aux1.getValue() <= coins){
                for(Map.Entry<String, Integer> aux2: menu.entrySet()){
                    if(aux1.getKey().equals(aux2.getKey())){
                        combinationsWithSameProduct(aux1, aux2, coins, result);
                    } else {
                        combinationsWithDifferentProduct(aux1, aux2, coins, result);
                    }
                }
            }
        }
        System.out.print("There are " + result.size() + " combinations:" + "\n" + result);
    }

    public static void combinationsWithSameProduct(Map.Entry<String, Integer> aux1, Map.Entry<String, Integer> aux2,
                                                   Integer coins, Set<String> result){
        StringBuilder combination = new StringBuilder();

        while((coins - aux2.getValue()) >= 0){
            coins = coins - aux2.getValue();
            combination.append(aux1.getKey());
            result.add(combination.toString());
            combination.append(" + ");
        }
    }
    public static void combinationsWithDifferentProduct(Map.Entry<String, Integer> aux1, Map.Entry<String, Integer> aux2,
                                                        Integer coins, Set<String> result){
        StringBuilder combination = new StringBuilder();
        List<String> toSort = new ArrayList<>();

        coins = coins - aux1.getValue();
        toSort.add(aux1.getKey());
        while((coins - aux2.getValue()) >= 0) {
            coins = coins - aux2.getValue();
            toSort.add(aux2.getKey());
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