package m1_base;

import java.util.Scanner;

public class L7_If_Switch {

    public static void main(String[] args) {
        int a = 1, b = 2;

        // IF / IF ELSE

        if (a < b) { // Если условие удовлетворяет истинности, выполняем тело блока if.
            System.out.println("a < b");               // Ветвь 1
        } else if(a > b) {       // Иначе, выполняем тело блока else.
            System.out.println("a больше b");       // Ветвь 2
        } else  {       // Иначе, выполняем тело блока else.
            System.out.println("a не меньше b");       // Ветвь 2
        }

        // IF SHORT
        // Если тело блока if или else состоит из одного выражения, то операторные скобки можно опустить

        if (a < b)
            System.out.println("a меньше b");      // Ветвь 1
        else
            System.out.println("a не меньше b");   // Ветвь 2


        // Тернарный (троичный) оператор [?:] .
        // Тернарный оператор [?:], является сокращенной формой конструкции if ... else.
        // [?:] - включает в себя три операнда - ( условие ? Если условие ИСТИННО : Если условие ЛОЖНО )

        // Алгоритм работы тернарной операции: (логическое выражение) ? выражение 1 : выражение 2
        //    1. Вычисляется логическое выражение (условие).
        //    2. Если логическое выражение истинно, то вычисляется значение выражения выражение 1, в противном случае — значение выражения выражение 2.
        //    3. Вычисленное значение возвращается.
        // тернарные операторы могут быть вложенными

        int max = (a > b) ? a : b;   // ЕСЛИ:  (a > b)  ТО:  вернуть a  ИНАЧЕ: вернуть b;

        // SWITCH CASE

        String number = "2";
        switch (number) { // (number) — выражение-селектор.

            // В теле переключателя switch-case, на 27 и 32 строках,
            // создаем два оператора case, c постоянными выражениями равными "1" и "2" соответственно.

            // Если значение выражения-селектора совпадет с одним из значений постоянных выражений,
            // то выполняется тело оператора case, постоянное выражение которого, совпало с выражением-селектора.

            case "1": {   // "1" — постоянное выражение.
                System.out.println("Один");                                       // Ветвь 1
                // Выход из переключателя.
                break;
            }
            case "2": {
                System.out.println("Два");                                        // Ветвь 2
                break;
            }

            // На 40 строке создаем (необязательный) оператор default, тело которого выполняется в случае,
            // если значение выражения-селектора не совпадет ни с одним из значений постоянных выражений.

            default: {
                System.out.println("Вы ввели значение отличное от 1 и 2.");       // Ветвь 3
                break;
            }

            // Если в переключателе отсутствует оператор default, то управление передается за пределы переключателя switch.
        }


        switch ("5") {
            // Для пустых операторов case разрешено "проваливание" от одного оператора к другому.
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
                System.out.println("Этот день недели - Рабочий.");
                break;
            case "6":
            case "7":
                System.out.println("Этот день недели - Выходной.");
                break;

            default:
                System.out.println("Вы ввели несуществующий день недели.");
                break;
        }
    }

    public static void coffee() {
        // Предлагаем пользователю выбрать напиток.
        System.out.println("Размеры стаканчиков кофе: 1 = Маленький, 2 = Средний, 3 = Большой");
        System.out.print("Пожалуйста, сделайте свой выбор: ");

        // Принимаем ввод от пользователя.
        Scanner in = new Scanner(System.in);
        String coffeeSize = in.next();

        int cost = 0;

        switch (coffeeSize) {
            case "3":
                cost += 50;
            case "2":
                cost += 25;
            case "1":
                cost += 25;
                break;
            default:
                System.out.println("Неверный выбор. Пожалуста выберите 1, 2, или 3.");
                break;
        }

        if (cost != 0) {
            System.out.println("Внесите " + cost + " копеек.");
            System.out.println("Спасибо!");
        } else {
            System.out.print("Пожалуйста, повторите выбор.");
        }
    }


}
