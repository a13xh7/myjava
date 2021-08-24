package m8_collections;

import java.util.ArrayList;
import java.util.Objects;

/*
Для создания простых списков применяется интерфейс List.

Упорядоченная последовательность элементов. Допустимы дуликаты и null. У каждого элемента есть индекс.
ArrayList представляет простой список, аналогичный массиву, за тем исключением, что количество элементов в нем не фиксировано.

ArrayList(): создает пустой список
ArrayList(Collection <? extends E> col): создает список, в который добавляются все элементы коллекции col.
ArrayList (int capacity): создает список, который имеет начальную емкость capacity
 */
public class L1_ArrayList {

    public static void main(String[] args) {

//        removeByEquals();
//        addGetSetRemove();
        addAll();
    }

    public static void addGetSetRemove() {

        ArrayList<String> people = new ArrayList<String>();

        // добавим в список ряд элементов
        people.add("Tom");
        people.add("Alice");
        people.add("Kate");
        people.add("Sam");

        // добавляем элемент по индексу 0. Остальные элементы смещаются вперед
        people.add(0, "Bob");

        // people.add(99, "Bob"); // index out of bound exception

        // получаем 2-й объект
        System.out.println(people.get(1));

        // установка нового значения для 2-го объекта/ set == replace
        people.set(1, "Robert");

        // размер списка
        System.out.printf("ArrayList has %d elements \n", people.size());

        // for each
        for(String person : people){
            System.out.println(person);
        }

        // проверяем наличие элемента
        if(people.contains("Tom")){
            System.out.println("ArrayList contains Tom");
        }

        // удаление конкретного элемента
        people.remove("Robert"); // returns bool
        // удаление по индексу
        people.remove(0);

        // to array
        Object[] peopleArray = people.toArray();
        for(Object person : peopleArray){
            System.out.println(person);
        }
    }

    // Удаление объектов.
    // Удаляются все объекты которые равны переданному в метод
    // Объекты сравниваются через медот equals
    public static void removeByEquals() {
        ArrayList<Student> students = new ArrayList<Student>();

        // добавим в список ряд элементов
        Student s = new Student("Tom");
        students.add(s);
        students.add(new Student("Alex"));

        students.remove(s);

        for(Student student : students){
            System.out.println(student.name);
        }
    }

    public static void addAll() {
        ArrayList<String> people = new ArrayList<String>();

        // добавим в список ряд элементов
        people.add("Tom");
        people.add("Alice");

        ArrayList<String> people2 = new ArrayList<String>();
        people2.add("Kate");
        people2.add("Sam");

        people.addAll(people2);
        people.addAll(0,people2);

        for(String person : people){
            System.out.println(person);
        }
    }

    // List.of()  - создать неизменяемый list
    // List.copyOf()
}


class Student {
    public String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

}