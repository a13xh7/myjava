package base;

import java.util.Arrays;
import java.util.List;

public class L8_Loops {

    // break
    // continue

    // while
    public static void main(String[] args) {
        int counter = 0;

        while (counter < 3) {
            counter++;
            System.out.println("Counter " + counter);
        }
        System.out.println("Произведено " + counter + " итераций.");
    }

    // do while
    public static void doWhile() {
        int counter = 0;

        do {
            counter++;
            System.out.println("Counter " + counter);
        }
        while (counter < 3);

        System.out.println("Произведено " + counter + " итераций.");
    }

    // Циклическая конструкция - for (цикл со счетчиком).
    public static void forLoop() {
        // for ( Инициализация счетчика итераций; Условие; Изменение счетчика ) { Тело цикла }

        for (int counter = 0; counter < 3; counter++) {
            System.out.println("Counter = " + counter);
        }

        //counter = 0; //  counter - недоступен за пределами цикла for.
    }

    // FOREACH
    public static void foreach() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        for (Integer element : numbers) {
            System.out.println(element);
        }
    }

    // endless loops
    public static void endlessLoop(String[] args) {
        // 1.
        while (true) {

        }

        // 2.
        /*
        do {

        }
        while (true);

        // 3.
        for ( ; ; ) {

        }
        */
    }
}
