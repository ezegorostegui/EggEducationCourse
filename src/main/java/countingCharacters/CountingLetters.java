package countingCharacters;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class CountingLetters {
    public static void main(String[] args){
        String phrase = enterData();
        HashMap<Character, Integer> map = countingCharacters(phrase);
        showCount(map);
    }
    public static String enterData(){
        return JOptionPane.showInputDialog("Enter a phrase");
    }
    public static HashMap<Character, Integer> countingCharacters(String string){
        char[] chars = string.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c)+1);
            }
        }
        return map;
    }
    public static void showCount(HashMap<Character, Integer> map){
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.println("Letter " + entry.getKey() + " appear " + entry.getValue() + " times in the phrase.");
        }
    }
}
