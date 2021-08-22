package m3_oop;

/**
 * Абстрактный класс.
 */
abstract class L1_AbstractClass {

    // можно создавать поля
    private String name;

    // Конструктор (отрабатывает первым).
    public L1_AbstractClass() {
        System.out.println("1 AbstractClass()");

        // Вызывается реализация метода из производного класса - ConcreteClass.
        this.abstractMethod();

        System.out.println("2 AbstractClass()");
    }

    // Абстрактный метод, Производный класс обязан переопределить и реализовать все абстрактные методы
    public abstract void abstractMethod();

    // метод с реализацией
    public void simpleMethod() {
        System.out.println("AbstractBaseClass.simpleMethod");
    }

}

class Parent extends L1_AbstractClass{

    public void superMethod() {
        System.out.println(111);
    }

    @Override
    public void abstractMethod() {

    }

}


class DerivedClass extends Parent {
    // Переопределение метода базового класса.

    @Override
    public void superMethod() {
        // Вызов метода базового класса.
         super.superMethod();
    }

}