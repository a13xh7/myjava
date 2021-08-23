package m11_string_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L4_regex {

    public static void main(String[] args) {

        // split

        String text = "FIFA will never regret it";
        String[] words = text.split("\\s*(\\s|,|!|\\.)\\s*");

        for(String word : words){
            System.out.println(word);
        }

        // matches

        String input = "+12343454556";
        boolean result = input.matches("(\\+*)\\d{11}");

        if(result) {
            System.out.println("It is a phone number");
        } else {
            System.out.println("It is not a phone number!");
        }

        // replace

        String input2 = "Hello Java! Hello JavaScript! JavaSE 8.";
        Pattern pattern = Pattern.compile("Java(\\w*)");
        Matcher matcher = pattern.matcher(input2);
        String newStr = matcher.replaceAll("HTML");
        System.out.println(newStr); // Hello HTML! Hello HTML! HTML 8.
    }
}
