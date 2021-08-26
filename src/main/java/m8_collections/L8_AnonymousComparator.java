package m8_collections;

import java.util.Arrays;
import java.util.Comparator;

public class L8_AnonymousComparator {
    
    public static void main(String[] args) {

        Animal2 cat = new Animal2("Oriental", 7, 25, 5000);
        Animal2 dog = new Animal2("Labrador", 30, 20, 4000);
        Animal2 bird = new Animal2("King Penguin", 15, 8, 50000);

        Animal2[] c = {cat, dog, bird};

        // Сортировка по цене
        Arrays.sort(c, new Comparator<Animal2>() {
            @Override
            public int compare(Animal2 o1, Animal2 o2) {
                return o1.price - o2.price;
            }
        });

        for (Animal2 tmp : c) {
            System.out.println(tmp);
        }
        System.out.println();

        // Сортировка по скорости
        Arrays.sort(c, new Comparator<Animal2>() {
            public int compare(Animal2 o1, Animal2 o2) {
                return o1.speed - o2.speed;
            }
        });

        for (Animal2 tmp : c) {
            System.out.println(tmp);
        }
        System.out.println();

        // Сортировка по названию
        Arrays.sort(c, new Comparator<Animal2>() {
            public int compare(Animal2 o1, Animal2 o2) {
                return o1.breed.compareTo(o2.breed);
            }
        });

        for (Animal2 tmp : c) {
            System.out.println(tmp);
        }
    }
}

class Animal2 {
    String breed;
    int weight;
    int speed;
    int price;

    Animal2(String breed, int weight, int speed, int price) {
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