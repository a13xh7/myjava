package m7_enums;

// Перечисления, как и обычные классы, могут определять конструкторы, поля и методы.

/*
Перечисление Color определяет приватное поле code для хранения кода цвета, а с помощью метода getCode оно возвращается.
Через конструктор передается для него значение. Следует отметить, что конструктор по умолчанию приватный, то есть имеет
модификатор private. Любой другой модификатор будет считаться ошибкой. Поэтому создать константы перечисления с помощью
конструктора мы можем только внутри перечисления.
 */

enum Color{

    RED("#FF0000"), BLUE("#0000FF"), GREEN("#00FF00");

    private String code;

    Color(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }
}

// Также можно определять методы для отдельных констант
// Только сначала определить абстрактный метод

enum Operation{
    SUM{
        // Абстрактные методы обязятельно должны быть переопределены в экземплярах перечисляемых типов.
        @Override
        public int action(int x, int y){ return x + y;}
    },
    SUBTRACT{
        public int action(int x, int y){ return x - y;}
    },
    MULTIPLY{
        public int action(int x, int y){ return x * y;}
    };

    public abstract int action(int x, int y);

    // Можно переопределять методы "для всех" экземпляров перечисляемого типа.
    @Override
    public String toString() {
        return "overriden all";
    }
}

public class L2_Constructors_Methods {

    public static void main(String[] args) {

        System.out.println(Color.RED);

        System.out.println(Color.RED.getCode());        // #FF0000
        System.out.println(Color.GREEN.getCode());      // #00FF00

        ///

        Operation op = Operation.SUM;
        System.out.println(op.action(10, 4));   // 14

        op = Operation.MULTIPLY;
        System.out.println(op.action(6, 4));    // 24

        System.out.println(Operation.MULTIPLY);

    }

}
