package m5_generics;

/**
 * Универсальные шаблоны.
 *
 */
class MyGenerics<TYPE1, TYPE2> {
    // Поля
    public TYPE1 variable1;
    public TYPE2 variable2;

    // Конструктор.
    public MyGenerics(TYPE1 argument1, TYPE2 argument2) {
        this.variable1 = argument1;
        this.variable2 = argument2;
    }

    // Универсальный метод
    public <T> void method(T argument) {
        T variable = argument;

        System.out.println(variable);
    }
}

public class L0_Generics {
    public static void main(String[] args) {
        MyGenerics<Integer, Integer> instance1 = new MyGenerics<Integer, Integer>(1, 2);
        System.out.println(instance1.variable1 + instance1.variable2);

        MyGenerics<String, Integer> instance2 = new MyGenerics<>("Number ", 1);
        System.out.println(instance2.variable1 + instance2.variable2);

        MyGenerics<String, String> instance3 = new MyGenerics<>("Hello ", "World");
        System.out.println(instance3.variable1 + instance3.variable2);

        //
        MyGenerics<Integer, Integer> instance = new MyGenerics<>(1, 2);
        instance.method("Hello world!");
    }
}
