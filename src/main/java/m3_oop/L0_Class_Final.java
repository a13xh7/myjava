package m3_oop;

public class L0_Class_Final {

    // константа
    public static final String CONSTANT = "test";

    private int age;
    private int height;

    // если конструктор мы не создавали, JVM создаст его сама.
    // или можем создать его руками, как указано ниже

    // public Animal() {}  // Конструктор по умолчанию.

    // объявление конструктора
    // создали конструктор с параметрами
    // пустой конструктор по умолчанию создан не будет, пока Вы это не сделаете руками
    // Пользовательский конструктор.

    //    public Animal(int age) {
    //        this.age = age;
    //    }

    // перегруженые конструкторы

    public L0_Class_Final() {
        // задаем начальные параметры полей. Обычно в таких ситуациях параметры задаются по умолчанию
        this.age = 14;
        this.height = 60;
    }

    public L0_Class_Final(int age) {
        // задаем один начальный параметр, второй указываем при создании объекта
        this.age = age;
        this.height = 66;
    }

    public L0_Class_Final(int age, int height) {
        // оба параметра задаем при создании объекта
        this.age = age;
        this.height = height;
    }

    /*
    Существует всего два типа блоков инициализации:
    нестатический (instance initializer)
    статический (class initializer)

    статический блок используется для инициализации статических переменных, а "обычный"  - для всех остальных.
     */

    // Статический блок.
    // Статический блок вызывается в любом случае,
    static {
        int X = 10;
        System.out.println("Static block  X = " + X);
    }

    // Нестатический блок.
    {
        System.out.println("Это нестатический блок!");
    }

    /**
     * Статические блоки.
     * Статических блоков может быть сколько угодно и вызываться они будут в том же порядке, в котором написаны.
     */

    static int x;

    static {
        x = 1;
        System.out.println("Static block  x = " + x);
    }

    static {
        x = 23;
        System.out.println("Static block  x = " + x);
    }

}

// Попытка наследования от FinalClass приводит к ошибке компилятора.
//  класс не сможет иметь подклассов, т.е. запрещено наследование. Это полезно при создании immutable (неизменяемых) объектов

final class FinalClass {
    public int x;
    public int y;
}

