package m13_lambda;

/*
Также метод в Java может возвращать лямбда-выражение.
 */
public class L7_ReturnLambda {
    public static void main(String[] args) {

        Operation3 func = action(1);
        int a = func.execute(6, 5);
        System.out.println(a);          // 11

        int b = action(2).execute(8, 2);
        System.out.println(b);          // 6
    }

    private static Operation3 action(int number){
        switch(number){
            case 1: return (x, y) -> x + y;
            case 2: return (x, y) -> x - y;
            case 3: return (x, y) -> x * y;
            default: return (x,y) -> 0;
        }
    }
}

interface Operation3{
    int execute(int x, int y);
}
