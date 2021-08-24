package m8_collections;

import java.util.ArrayDeque;

/*
Очереди представляют структуру данных, работающую по принципу FIFO (first in - first out).
То есть чем раньше был добавлен элемент в коллекцию, тем раньше он из нее удаляется.
Это стандартная модель однонаправленной очереди. Однако бывают и двунаправленные - то есть такие, в которых мы можем
добавить элемент не только в начала, но и в конец. И соответственно удалить элемент не только из конца, но и из начала.

Особенностью классов очередей является то, что они реализуют специальные интерфейсы Queue или Deque.
 */
public class L3_ArrayDeque {

    public static void main(String[] args) {

        ArrayDeque<String> states = new ArrayDeque<String>();
        // стандартное добавление

        states.add("Germany");
        states.addFirst("France"); // добавляем элемент в самое начало
        states.push("Great Britain"); // добавляем элемент в самое начало
        states.addLast("Spain"); // добавляем элемент в конец коллекции
        states.add("Italy");

        // получаем первый элемент без удаления
        String sFirst = states.getFirst();
        System.out.println(sFirst);     // Great Britain

        // получаем последний элемент без удаления
        String sLast = states.getLast();
        System.out.println(sLast);      // Italy

        System.out.printf("Queue size: %d \n", states.size());  // 5

        // перебор коллекции
        while(states.peek()!=null){
            // извлечение c начала
            System.out.println(states.pop());
        }

        // очередь из объектов Person
        ArrayDeque<Person> people = new ArrayDeque<Person>();
        people.addFirst(new Person("Tom"));
        people.addLast(new Person("Nick"));

        // перебор без извлечения
        for(Person p : people){
            System.out.println(p.getName());
        }
    }
}


