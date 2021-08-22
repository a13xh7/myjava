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

    /*
    Метод может принимать параметры переменной длины одного типа. Например, нам надо передать в метод набор числел и
    вычислить их сумму, но мы точно не знаем, сколько именно чисел будет передано - 3, 4, 5 или больше.
    Параметры переменной длины позволяют решить эту задачу:

    Троеточие перед названием параметра int ...nums указывает на то, что он будет необязательным и будет представлять массив.
    Мы можем передать в метод sum одно число, несколько чисел, а можем вообще не передавать никаких параметров.
    Причем, если мы хотим передать несколько параметров, то необязательный параметр должен указываться в конце:
     */
    static void sum(int ...nums){

        int result =0;
        for(int n: nums)
            result += n;
        System.out.println(result);
    }

}
