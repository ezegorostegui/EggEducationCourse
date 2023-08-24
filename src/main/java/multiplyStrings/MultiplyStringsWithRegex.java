package multiplyStrings;

/* # Q1
## input => "3[asdf]"
## output => "asdfasdfasdf"
# Q2
## input => "3[a]4[b]"
## output => "aaabbbb"
# Q3
## input => "3[a2[b]]"
## interim output => "3[abb]"
## output => "abbabbabb" */

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MultiplyStringsWithRegex {
    public static void main(String[] args){
            String word = "3[a2[b]]";
            String solution = "";
            String regex = "\\[(.*?)]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(word);

            List<String> wordsBetweenBrackets = new ArrayList<>();

            String numberRegex = "\\d";
            Pattern pattern1 = Pattern.compile(numberRegex);
            Matcher matcher1 = pattern1.matcher(word);

            List<String> numbersList = new ArrayList<>();
            while (matcher.find() && matcher1.find()) {
                wordsBetweenBrackets.add( matcher.group(1));
                numbersList.add( matcher1.group(0));
            }
            for (int i = 0; i < wordsBetweenBrackets.size(); i++) {
                for (int j = 0; j < Integer.parseInt(numbersList.get(i)); j++ ) {
                    solution = solution.concat(wordsBetweenBrackets.get(i));
                }
            }
            System.out.println(solution);
    }
}