package m5_generics;

/**
 * Ограничения параметров типа
 * Когда мы указываем универсальный параметр у обобщений, то по умолчанию он может представлять любой тип.
 * Однако иногда необходимо, чтобы параметр соответствовал только некоторому ограниченному набору типов.
 * В этом случае применяются ограничения, которые позволяют указать базовый класс, которому должен соответствовать параметр.
 *
 * В качестве ограничений могут выступать также интерфейсы
 */

public class L2_Generics_Limitations {

    public static void main(String[] args) {

        MyClass<Base> mc1 = new MyClass<>();

        MyClass<Derived> mc2 = new MyClass<>();

        //MyClass<String> mc3 = new MyClass<>(); // Ошибка.
    }
}

class Base {
}

class Derived extends Base {
}

/**
 * T extends Base -  аргумент типа должен являться или быть производным от указанного базового класса.
 */
class MyClass<T extends Base> {
}

/*
Также можно установить сразу несколько ограничений. Например, пусть класс Transaction может работать только с объектами,
 которые одновременно реализуют интерфейс Accountable и являются наследниками класса Person:
 */

class Person{}

interface Accountable2{}

class Transaction<T extends Person & Accountable2>{}