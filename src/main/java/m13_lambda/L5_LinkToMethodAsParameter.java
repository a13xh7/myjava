package m13_lambda;

/*
Ссылки на метод как параметры методов
Начиная с JDK 8 в Java можно в качестве параметра в метод передавать ссылку на другой метод.
В принципе данный способ аналогичен передаче в метод лямбда-выражения.

Ссылка на метод передается в виде имя_класса::имя_статического_метода (если метод статический)
или объект_класса::имя_метода (если метод нестатический). Рассмотрим на примере:
 */
public class L5_LinkToMethodAsParameter {

    public static void main(String[] args) {
        int[] nums = { -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        System.out.println(sum(nums, ExpressionHelper::isEven));

        Expression2 expr = ExpressionHelper::isPositive;
        System.out.println(sum(nums, expr));

        // Если нам надо вызвать нестатические методы, то в ссылке вместо имени класса применяется имя объекта этого класса:
        int[] nums2 = { -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        ExpressionHelper exprHelper = new ExpressionHelper();
        System.out.println(sum(nums, exprHelper::isEvenForObject)); // 0
    }

    private static int sum (int[] numbers, Expression2 func) {
        int result = 0;
        for(int i : numbers) {
            if (func.isEqual(i))
                result += i;
        }
        return result;
    }
}

// функциональный интерфейс
interface Expression2{
    boolean isEqual(int n);
}

// класс, в котором определены методы
//  При этом методы, на которые идет ссылка, должны совпадать по параметрам и результату с методом функционального интерфейса.
class ExpressionHelper{

    static boolean isEven(int n) {
        return n%2 == 0;
    }

    boolean isEvenForObject(int n) {
        return n%2 == 0;
    }

    static boolean isPositive(int n) {
        return n > 0;
    }
}