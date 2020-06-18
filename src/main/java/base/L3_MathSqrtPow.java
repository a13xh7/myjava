package base;

import static java.lang.Math.pow;

public class L3_MathSqrtPow {

    /* Math.pow() - возведение числа в степень
     * 1-ый аргумент - число, которое возводим в степень,
     * 2-ой – показатель степени, в которую возводим число.
     */
    public static void main(String[] args) {
        double x = 2, y = 8;

        double result = pow(x, y);

        System.out.println(result);
    }

    // Math.sqrt() - математическая функция, которая извлекает квадратный корень
    public static void sqrt() {
        double x = 256;

        double result = Math.sqrt(x);

        System.out.println("Квадратный корень: " + result);
    }
}
