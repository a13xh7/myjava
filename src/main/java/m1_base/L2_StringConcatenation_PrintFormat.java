package m1_base;

public class L2_StringConcatenation_PrintFormat {

    public static void concatenation() {
        // 1 вариант.
        String word1 = "Привет ";
        String word2 = "Мир!";
        String phrase = word1 + word2;
        System.out.println(phrase);

        // 2 вариант.
        System.out.println("Hello " + "World!");
    }

    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;

        //%x: для вывода шестнадцатеричных чисел
        //%f: для вывода чисел с плавающей точкой
        //%e: для вывода чисел в экспоненциальной форме, например, 1.3e+01
        //%c: для вывода одиночного символа
        //%s: для вывода строковых значений

        // Форматирование строк с помощью метода format класса String
        System.out.println(String.format("Это число %s", a));

        // Метод printf() принадлежит классу PrintStream, который отвечает за вывод информации
        // и возвращает строку, отформатированую по заданным условиям
        System.out.printf("Это число %s \n", a);
        System.out.printf("Это числа %s и %s \n", b, c);
        System.out.printf("Это числа наоборот %s и %s", b, c);
        // Форматирование вывода числа Пи
        System.out.printf("\n%1$+022.10f", Math.PI);
    }


}
