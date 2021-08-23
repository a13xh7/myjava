package m11_string_regex;

public class L1_Operations {

    public static void main(String[] args) {

        // Соединение строк

        String str1 = "Java";
        String str2 = "Hello";
        String str3 = str1 + " " + str2;

        System.out.println(str3); // Hello Java

        String str11 = "Java";
        String str22 = "Hello";
        str22 = str22.concat(str11); // HelloJava

        // Извлечение символов и подстрок

        String str = "Java";
        char c = str.charAt(2);
        System.out.println(c); // v

        /*
        Для сравнения строк используются методы equals() (с учетом регистра) и equalsIgnoreCase() (без учета регистра).
        Оба метода в качестве параметра принимают строку, с которой надо сравнить:
         */

        str1 = "Hello";
        str2 = "hello";

        System.out.println(str1.equals(str2)); // false
        System.out.println(str1.equalsIgnoreCase(str2)); // true

        //        System.out.println(str1.replace("l", "T"));
//        System.out.println(str1.toLowerCase());
//        System.out.println(str1.toUpperCase());



//        System.out.println(str1.equals("Hello"));
//        System.out.println(str1.equalsIgnoreCase("HELLO"));
//        System.out.println(str1.startsWith("H"));
//        System.out.println(str1.endsWith("o"));
//        System.out.println(str1.regionMatches());

//        System.out.println(str1.substring(0, 2));
//        System.out.println(str1.substring(2));
//        System.out.println(str1.length());
//        System.out.println(str1.indexOf("e"));

//        Integer i1 = 55;
//        System.out.println(i1.toString());
//        System.out.println(Integer.toString(i1));
//        Integer i2 = null;

//        System.out.println(String.valueOf(i1) instanceof String);
//        System.out.println(String.valueOf(i2));
//        System.out.println(String.valueOf(null));
    }
}
