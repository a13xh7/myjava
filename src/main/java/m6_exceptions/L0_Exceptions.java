package m6_exceptions;

/*
Базовым классом для всех исключений является класс Throwable. От него уже наследуются два класса: Error и Exception.
Все остальные классы являются производными от этих двух классов.

Класс Error описывает внутренние ошибки в исполняющей среде Java. Программист имеет очень ограниченные возможности для обработки подобных ошибок.

Собственно исключения наследуются от класса Exception
 */
public class L0_Exceptions {

    public static void main(String[] args) {
        int a = 1, n = 2;


         /*
        Конструкция try..catch также может иметь блок finally. Однако этот блок необязательный, и его можно при
        обработке исключений опускать. Блок finally выполняется в любом случае, возникло ли исключение в блоке try или нет:
         */
        try {
            // Попытка деления на ноль.
            a = a / (2 - n);
            System.out.println("a = " + a);
        } catch (Exception e) {
            System.out.println("Обработка исключения.");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Блок finally.");
        }


    }

    public static void ex2() {
        Exception ex = new Exception("Мое исключение");

        try {
            throw ex;
        } catch (Exception e) {
            System.out.println("Обработка исключения.");
            System.out.println(e.getMessage());
        }
    }

    /*
     Иногда метод, в котором может генерироваться исключение, сам не обрабатывает это исключение.
     В этом случае в объявлении метода используется оператор throws, который надо обработать при вызове этого метода.
     */
    public void myMethod() throws Exception {
        Exception exception = new Exception("Мое исключение");
        throw exception;
    }
}
