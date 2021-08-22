package m8_collections.lesson_1_iterator_comparator.ex_004_comparable.interface_comparable;

import java.util.Arrays;

public class Main {
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
