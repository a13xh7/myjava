package m1_base;

import java.util.Scanner;

public class L4_ConsoleInput {
    // Объект класса Scanner позволяет обрабатывать ввод данных с консоли

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите целое число: ");
        int a = input.nextInt();       //считываем целое число

        System.out.println("Введите дробное число: ");
        float b = input.nextFloat();   //считываем дробное число


        System.out.println("Введите строку с пробелами: ");
        String c = input.next();       //считываем строку до первого пробела

        input = new Scanner(System.in);

        System.out.println("Введите строку: ");
        String d = input.nextLine();   //считываем целую строку

        System.out.println(a + "\n" + b + "\n" + c + "\n" + d);
    }

    public static void colorGame() {
        System.out.println("Угадайте задуманный цвет с пяти попыток.");
        System.out.println("Для выхода из программы введите - exit.");

        final int MAX_ATTEMPT = 5; // Допустимое количество попыток.
        int attempt = 0;           // Счетчик попыток.
        String color = "red";      // Задуманный цвет.
        Scanner in = new Scanner(System.in);

        while (attempt < MAX_ATTEMPT) {
            attempt++;
            System.out.println("Попытка " + attempt + ":");
            String value = in.next();

            if (value.equals("exit")) {
                break;
            }

            if (!value.equals(color)) {
                continue;
            }

            System.out.println("Поздравляем, Вы угадали с " + attempt + " попытки!");
            break;
        }

        System.out.println("Конец игры!");
    }
}
