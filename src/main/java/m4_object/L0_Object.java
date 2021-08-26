package m4_object;

import java.util.Objects;

/*
Переопределяя equals нужно переопределять и hashCode
Objects.hashCode(1); - преобразование любого объекта в int

В hashMap например нсачал идет сравнение по hashCode
 */
class Car {
    // создаем поля
    private int speed;
    private String color;

    // конструктор
    public Car(int speed, String color) {
        this.speed = speed;
        this.color = color;
    }

    // методы доступа
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }



    // Метод toString служит для получения представления данного объекта в виде строки.
    // При попытке вывести строковое представления какого-нибудь объекта, как правило, будет выводиться полное имя класса.

    @Override
    public String toString() {
        return String.format("Speed is: %s\nColor is: %s", speed, color);
    }

    //Метод hashCode позволяет задать некоторое числовое значение, которое будет соответствовать данному объекту или его хэш-код.
    // По данному числу, например, можно сравнивать объекты.
    // мы можем задать свой алгоритм определения хэш-кода объекта:
    @Override
    public int hashCode(){
        //Objects.hashCode(1);
        return 10 * color.hashCode() + 20456;
    }

    /* Метод equals сравнивает два объекта на равенство
    Реализация по умолчанию метода equals() в классе java.lang.Object сравнивает ссылки на адреса в памяти, которые
    хранят переменные, и возвращает true только в том случае, если адреса совпадают, другими словами переменные ссылаются на один и тот же объект.
     */
    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Car)) return false;
        Car p = (Car)obj;
        return this.color.equals(p.color);
    }

    @Override
    protected Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }
}

class L0_Object {
    public static void main(String[] args) {
        Car car = new Car(1212, "red");

        System.out.println(car);

        Object ject = new Object().toString();
        System.out.println(car.hashCode());

        //Метод getClass позволяет получить тип данного объекта
        System.out.println(car.getClass());

        try {
            Car newCar = car.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}