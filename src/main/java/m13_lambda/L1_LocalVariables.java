package m13_lambda;

public class L1_LocalVariables {

    static int x = 10;
    static int y = 20;

    public static void main(String[] args) {

        /*
        Лямбда-выражение может использовать переменные, которые объявлены во вне в более общей области видимости -
        на уровне класса или метода, в котором лямбда-выражение определено. Однако в зависимости от того, как и где
        определены переменные, могут различаться способы их использования в лямбдах.
        Рассмотрим первый пример - использования переменных уровня класса:
         */
        Operation op = ()->{
            x=30;
            return x+y;
        };

        System.out.println(op.calculate()); // 50
        System.out.println(x); // 30 - значение x изменилось

        methodVariables();
    }

    /*
    Локальные переменные уровня метода мы также можем использовать в лямбдах, но изменять их значение нельзя.
     */
    public static void methodVariables() {
        int n=70;
        int m=30;
        Operation op = ()->{
            //n=100; - так нельзя сделать
            return m+n;
        };
        // n=100;  - так тоже нельзя
        System.out.println(op.calculate()); // 100
    }
}

interface Operation{
    int calculate();
}
