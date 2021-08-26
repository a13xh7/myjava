package m14_stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/*
Операции сведения представляют терминальные операции, которые возвращают некоторое значение - результат операции.
В Stream API есть ряд операций сведения.
 */
public class L6_Count_Find_Match_MinMax {

    public static void main(String[] args) {

        // Метод count() возвращает количество элементов в потоке данных:
        ArrayList<String> names = new ArrayList<String>();
        names.addAll(Arrays.asList(new String[]{"Tom", "Sam", "Bob", "Alice"}));
        System.out.println(names.stream().count());  // 4

        // количество элементов с длиной не больше 3 символов
        System.out.println(names.stream().filter(n->n.length()<=3).count());  // 3

        // Метод findFirst() извлекает из потока первый элемент, а findAny() извлекает случайный объект из потока (нередко так же первый):
        Optional<String> first = names.stream().findFirst();
        System.out.println(first.get());    // Tom

        Optional<String> any = names.stream().findAny();
        System.out.println(first.get());    // Tom

        /*
        allMatch, anyMatch, noneMatch
        Еще одна группа операций сведения возвращает логическое значение true или false:

        boolean allMatch(Predicate<? super T> predicate): возвращает true, если все элементы потока удовлетворяют условию в предикате
        boolean anyMatch(Predicate<? super T> predicate): возвращает true, если хоть один элемент потока удовлетворяют условию в предикате
        boolean noneMatch(Predicate<? super T> predicate): возвращает true, если ни один из элементов в потоке не удовлетворяет условию в предикате
         */

        // есть ли в потоке строка, длина которой больше 3
        boolean any2 = names.stream().anyMatch(s->s.length()>3);
        System.out.println(any2);    // true

        // все ли строки имеют длину в 3 символа
        boolean all = names.stream().allMatch(s->s.length()==3);
        System.out.println(all);    // false

        // НЕТ ЛИ в потоке строки "Bill". Если нет, то true, если есть, то false
        boolean none = names.stream().noneMatch(s->s=="Bill");
        System.out.println(none);   // true

        /*
        Методы min() и max() возвращают соответственно минимальное и максимальное значение.
        Поскольку данные в потоке могут представлять различные типы, в том числе сложные классы, то в качестве параметра в
        эти методы передается объект интерфейса Comparator, который указывает, как сравнивать объекты:
         */

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9}));

        Optional<Integer> min = numbers.stream().min(Integer::compare);
        Optional<Integer> max = numbers.stream().max(Integer::compare);
        System.out.println(min.get());  // 1
        System.out.println(max.get());  // 9

    }
}
