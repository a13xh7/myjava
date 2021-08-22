package m5_generics;

/*
Обобщенные классы могут участвовать в иерархии наследования: могут наследоваться от других, либо выполнять роль базовых классов.
 */
public class L3_GenericsInheritance {
    public static void main(String[] args) {

        DepositAccount<Integer, String> dAccount1 = new DepositAccount<>(20, "Tom");
        System.out.println(dAccount1.getId() + " : " + dAccount1.getName());

        DepositAccount<String, Integer> dAccount2 = new DepositAccount<>("12345", 23456);
        System.out.println(dAccount2.getId() + " : " + dAccount2.getName());
    }
}


class Account3<T>
{
    private T _id;
    T getId(){return _id;}
    Account3(T id)
    {
        _id = id;
    }
}

/*
При наследовании от обобщенного класса класс-наследник должен передавать данные о типе в конструкции базового класса:
При этом класс-наследник может добавлять и использовать какие-то свои параметры типов:
 */
class DepositAccount<T, S> extends Account3<T>{

    private S _name;
    S getName(){return _name;}
    DepositAccount(T id, S name){
        super(id);
        this._name=name;
    }
}