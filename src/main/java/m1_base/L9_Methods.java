package m1_base;

public class L9_Methods {

    public static void main(String[] args) {
        function("Stringgg");
    }

    // Обычный метод

    static String function(String name) {
        String sentence = "Hello " + name + "!";
        return sentence;
    }

    // Пример правильного множественного возврата из метода.

    static String compare(int value1, int value2) {
        if (value1 < value2) {
            return "Comparison Less Than";
        } else if (value1 > value2) {
            return "Comparison Greater Than";
        }
        return "Comparison Equal";
    }

    // Перегруженные методы могут отличаться типом и количеством аргументов.

    static void function() {                 // 1-я перегрузка.
        System.out.println("Hello!");
    }

    static void function(String s, int i) { // 5-я перегрузка.
        System.out.println(s + i);
    }

    static void function(int i, String s) { // 6-я перегрузка.
        System.out.println(i + s);
    }

//    Перегруженные методы не могут отличаться возвращаемыми значениями!
//    static String function(String s) {   // 7-я перегрузка.
//
//        return s;
//    }

    // Нахождение факториала числа.

    static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }
}
