package m13_lambda;

/*
Существуют два типа лямбда-выражений: однострочное выражение и блок кода.
Блочные выражения обрамляются фигурными скобками. В блочных лямбда-выражениях можно использовать внутренние вложенные
блоки, циклы, конструкции if, switch, создавать переменные и т.д.
Если блочное лямбда-выражение должно возвращать значение, то явным образом применяется оператор return:
 */
public class L2_MultiLine {

    public static void main(String[] args) {

        Operationable operation = (int x, int y) -> {
            if(y==0)
                return 0;
            else
                return x/y;
        };

        System.out.println(operation.calculate(20, 10)); //2
        System.out.println(operation.calculate(20, 0)); //0
    }
}

interface Operationable{
    int calculate(int x, int y);
}