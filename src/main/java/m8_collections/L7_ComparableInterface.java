package m8_collections;

import java.util.Arrays;

public class L7_ComparableInterface {

    public static void main(String[] args) {
        Animal cat = new Animal("Oriental", 7, 25, 5000);
        Animal cat1 = new Animal("Orien", 7, 25, 5000);
        Animal dog = new Animal("Labrador", 30, 17, 4000);
        Animal dog1 = new Animal("Labra", 30, 13, 4000);
        Animal bird = new Animal("King", 15, 8, 50000);
        Animal bird1 = new Animal("King Penguin", 15, 8, 50000);

        Animal[] c = {cat, cat1, dog, dog1, bird, bird1};

        Arrays.sort(c);   // ClassCastException w/o Comparable

        for (Animal tmp : c) {
            System.out.println(tmp);
        }
    }
}

/*
Интерфейс Comparable содержит один единственный метод int compareTo(E item), который сравнивает текущий объект с объектом,
переданным в качестве параметра. Если этот метод возвращает отрицательное число, то текущий объект будет располагаться перед тем,
который передается через параметр. Если метод вернет положительное число, то, наоборот, после второго объекта.
Если метод возвратит ноль, значит, оба объекта равны.
 */

class Animal implements Comparable { // <Animal>{
    String breed;
    int weight;
    int speed;
    int price;

    Animal(String breed, int weight, int speed, int price) {
        this.breed = breed;
        this.weight = weight;
        this.speed = speed;
        this.price = price;
    }

    public String toString() {
        return this.breed + " " + this.weight + " " + this.speed + " " + this.price;
    }

//    public int compare(Person a, Person b){
//
//        if(a.getAge()> b.getAge())
//            return 1;
//        else if(a.getAge()< b.getAge())
//            return -1;
//        else
//            return 0;
//    }

    // Сортируем по скорости/цене
    public int compareTo(Object o) {              //    public int compareTo(Animal o) {
        int tmp = this.speed - ((Animal)o).speed; //    int tmp = this.speed - o.speed;

        if (tmp == 0) {
            int tmp1 = this.price - ((Animal)o).price;
            if (tmp1 == 0) {
                int tmp2 = this.weight - ((Animal)o).weight;
                if (tmp2 == 0){
                    return this.breed.compareTo(((Animal)o).breed);
                } else return tmp2;
            } else return tmp1;
        } else {
            return tmp;
        }
    }

    // Сравнение 2-х строковых значений
    // return this.breed.compareTo(((Animal)o).breed);
}