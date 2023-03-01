package multiplyStrings;

import java.util.*;

/**
 * # Q1
 * input => "3[asdf]"
 * output => "asdfasdfasdf"
 * # Q2
 * input => "3[a]4[b]"
 * output => "aaabbbb"
 * # Q3
 * input => "3[a2[b]]"
 * interim output => "3[abb]"
 * output => "abbabbabb" (edited)
 *
 * write a solution for each case
 */
public class MultiplyStringInBrackets {
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter data:");
//        String input = sc.next();
        String input = "2[as2[we]d]";
        HashMap<String, List<Integer>> positions = new HashMap<>(positionOfBrackets(input));

        multiply(input, positions);
    }
    public static HashMap<String, List<Integer>> positionOfBrackets(String input){
        List<Integer> leftBracket = new ArrayList<>();
        List<Integer> rightBracket = new ArrayList<>();
        HashMap<String, List<Integer>> positions = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '['){
                leftBracket.add(i);
            }
            if (input.charAt(i) == ']'){
                rightBracket.add(i);
            }
        }
        System.out.println(leftBracket);
        System.out.println(rightBracket);
        positions.put("leftBracket", leftBracket);
        positions.put("rightBracket", rightBracket);
        return positions;
    }
    public static void multiply(String input, HashMap<String, List<Integer>> positions){
        int numOfBrackets = positions.get("leftBracket").size();
        int repetitionsNum;
        String repetedString;
        StringBuilder combination = new StringBuilder();

        for (int i = numOfBrackets-1; i >= 0; i--) {
            repetitionsNum = Character.getNumericValue(input.charAt
                    (positions.get("leftBracket").get(i) - 1));
            repetedString = input.substring(positions.get("leftBracket").get(i) + 1,
                    positions.get("rightBracket").get(i)-2);

            repetedString = repetedString.repeat(repetitionsNum);
            combination.append(repetedString);
        }
        
        System.out.println(combination);
    }
}
