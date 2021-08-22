package m3_oop;

/**
 * Анонимные классы.
 */
interface Interface {
    void method();

    int getValue();
}

class ConcreteClass implements Interface {
    protected int protectedField = 10;

    public void method() {
        System.out.println("ConcreteClass: method()");
    }

    public int getValue() {
        return protectedField;
    }
}

public class L5_AnonymousClasses {

    public static void main(String[] args) {

        // Объявление анонимного (внутреннего) класса
        /*
        Создается безымянный Java-класс, реализующий интерфейс MonitoringSystem.
        Компилятор, увидев такой класс, требует от тебя реализовать все методы интерфейса MonitoringSystem (мы это и сделали 3 раза).
        Создается один объект этого класса. Обрати внимание на код:
         */
        ConcreteClass instance1 = new ConcreteClass() {
            @Override
            public void method() {
                System.out.println("instance1: method()");
            }

        };

        // Объявление анонимного (внутреннего) класса
        Interface instance2 = new ConcreteClass() {
            int protectedField = 3;

            @Override
            public void method() {
                System.out.println("instance2: method()");
            }

            @Override
            public int getValue() {
                return this.protectedField + super.getValue();
            }
        };

        instance1.method();
        instance2.method();

        System.out.println("instance1: publicField = " + instance1.getValue() + "    instance2: publicField = " + instance2.getValue());
    }
}