package m8_collections;

import java.util.Arrays;
import java.util.Comparator;

public class L8_ComparatorInterface {
    public static void main(String[] args) {
        Animal3 cat = new Animal3("Oriental", 7, 25, 5000);
        Animal3 dog = new Animal3("Labrador", 30, 20, 4000);
        Animal3 bird = new Animal3("King Penguin", 15, 8, 50000);

        Animal3[] c = {cat, dog, bird};

        Arrays.sort(c, new ComparatorByPrice());

        for (Animal3 tmp : c) {
            System.out.println(tmp);
        }
        System.out.println();

        Arrays.sort(c, new ComparatorBySpeed());
        for (Animal3 tmp : c) {
            System.out.println(tmp);
        }
        System.out.println();

        Arrays.sort(c, new ComparatorByBreed());

        for (Animal3 tmp : c) {
            System.out.println(tmp);
        }
    }
}

class Animal3 {
    String breed;
    int weight;
    int speed;
    int price;

    Animal3(String breed, int weight, int speed, int price) {
        this.breed = breed;
        this.weight = weight;
        this.speed = speed;
        this.price = price;
    }

    @Override
    public String toString() {
        return this.breed + " " + this.weight + " " + this.speed + " " + this.price;
    }
}

class ComparatorByPrice implements Comparator {
    public int compare(Object o1, Object o2) {
        return ((Animal3) o1).price - ((Animal3) o2).price;
    }
}

class ComparatorBySpeed implements Comparator {
    public int compare(Object o1, Object o2) {
        return ((Animal3) o1).speed - ((Animal3) o2).speed;
    }
}

class ComparatorByBreed implements Comparator {
    public int compare(Object o1, Object o2) {
        return ((Animal3) o1).breed.compareTo(((Animal3) o2).breed);
    }
}