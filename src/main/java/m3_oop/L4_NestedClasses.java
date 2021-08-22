package m3_oop;


/**
 * Вложенные классы.
 */
class MyClass {

    // Класс
    public class Nested {
        public void method() {
            System.out.println("Метод из Nested класса");
        }
    }


    public void test() {
        MyClass.Nested instance = new MyClass.Nested();
        instance.method();
    }

    /*
     * Вложенные классы.
     * Классы могут в себе содержать статические Nested классы.
     * Статическим классом в java может быть только вложенный класс
     */

    public static class Nested2 {
        public static void staticMethodFromNested() {
            System.out.println("Статический метод Nested класса.");
        }
    }

}

public class L4_NestedClasses {

    public static void main(String[] args) {
        MyClass parent = new MyClass();
        MyClass.Nested nested = parent.new Nested();

        nested.method();

        MyClass.Nested2.staticMethodFromNested();
    }


}
