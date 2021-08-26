package m13_lambda;

/*
Функциональный интерфейс может быть обобщенным, однако в лямбда-выражении использование обобщений не допускается.
В этом случае нам надо типизировать объект интерфейса определенным типом, который потом будет применяться в лямбда-выражении.

Таким образом, при объявлении лямбда-выражения ему уже известно, какой тип параметры будут представлять и какой тип они будут возвращать.
*/
public class L3_Generics {

    public static void main(String[] args) {

        Operationable2<Integer> operation1 = (x, y)-> x + y;

        Operationable2<String> operation2 = (x, y) -> {
            System.out.println(x);
            return y;
        };

        System.out.println(operation1.calculate(20, 10)); //30
        System.out.println(operation2.calculate("20", "10")); //2010
    }
}

interface Operationable2<T>{
    T calculate(T x, T y);
}
