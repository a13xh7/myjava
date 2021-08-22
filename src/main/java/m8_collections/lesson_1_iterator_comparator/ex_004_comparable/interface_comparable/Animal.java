package m8_collections.lesson_1_iterator_comparator.ex_004_comparable.interface_comparable;

public class Animal implements Comparable { // <Animal>{
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