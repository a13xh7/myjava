package m5_generics;

/*
При реализации подобного интерфейса есть две стратегии. В данном случае реализована первая стратегия, когда при
реализации для универсального параметра интерфейса задается конкретный тип, как например, в данном случае это тип String.
Тогда класс, реализующий интерфейс, жестко привязан к этому типу.
 */
public class L1_GenericInterface{

    public static void main(String[] args) {

        Accountable<String> acc1 = new Account("1235rwr", 5000);
        Account acc2 = new Account("2373", 4300);
        System.out.println(acc1.getId());
        System.out.println(acc2.getId());
    }
}
interface Accountable<T>{
    T getId();
    int getSum();
    void setSum(int sum);
}

class Account implements Accountable<String>{

    private String id;
    private int sum;

    Account(String id, int sum){
        this.id = id;
        this.sum = sum;
    }

    public String getId() { return id; }
    public int getSum() { return sum; }
    public void setSum(int sum) { this.sum = sum; }
}

/*
Вторая стратегия представляет определение обобщенного класса, который также использует тот же универсальный параметр:
 */

class Account2<T> implements Accountable<T>{

    private T id;
    private int sum;

    Account2(T id, int sum){
        this.id = id;
        this.sum = sum;
    }

    public T getId() { return id; }
    public int getSum() { return sum; }
    public void setSum(int sum) { this.sum = sum; }
}