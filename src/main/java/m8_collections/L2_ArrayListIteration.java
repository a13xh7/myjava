package m8_collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class L2_ArrayListIteration {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(7);

        // с помощью итератора можем бегать по нашему списку
        Iterator<Integer> iterator = arrayList.iterator();

        // спрашиваем есть ли следующий элемент в списке, если true, то будет реализовано тело while
        while (iterator.hasNext()) {
            // переходим к следующему элементу в списке и его выводим
            Integer integer = iterator.next();
            System.out.println(integer);
        }
        // то же самое действие, но через оптимизированный итератор под cписки
        // предыдущий, следующий элемент
        ListIterator<Integer> listIterator = arrayList.listIterator();

        while (listIterator.hasNext()) {
            Integer integer = listIterator.next();
            //listIterator.previous();
            System.out.println(integer);
        }
    }
}
