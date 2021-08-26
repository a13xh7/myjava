package m13_lambda;

public class L4_lambdaAsMethodParam {

    /*
    Одним из преимуществ лямбд в java является то, что их можно передавать в качестве параметров в методы. Рассмотрим пример:
     */
    public static void main(String[] args) {

        Expression func = (n)-> n%2==0;

        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        System.out.println( sum(nums, func)  ); // 20
    }

    private static int sum (int[] numbers, Expression func) {
        int result = 0;

        for(int i : numbers) {
            if (func.isEqual(i))
                result += i;
        }
        return result;
    }
}

interface Expression{
    boolean isEqual(int n);
}
