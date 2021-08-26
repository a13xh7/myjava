package m14_stream_api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/*
Коллекции, на основе которых нередко создаются потоки, уже имеют специальные методы для сортировки содержимого.
Однако класс Stream также включает возможность сортировки. Такую сортировку мы можем задействовать, когда у нас идет
набор промежуточных операций с потоком, которые создают новые наборы данных, и нам надо эти наборы отсортировать.
 */
public class L3_Sorting {

    public static void main(String[] args) {
        List<String> phones = new ArrayList<>();
        Collections.addAll(phones, "iPhone X", "Nokia 9", "Huawei Nexus 6P",
                "Samsung Galaxy S8", "LG G6", "Xiaomi MI6",
                "ASUS Zenfone 3", "Sony Xperia Z5", "Meizu Pro 6",
                "Pixel 2");

        phones.stream()
                .filter(p->p.length()<12)
                .sorted() // Для простой сортировки по возрастанию применяется метод sorted()
                .forEach(s->System.out.println(s));

        /*
        Однако данный метод не всегда подходит. Уже по консольному выводу мы видим, что метод сортирует объекты по возрастанию,
        но при этом заглавные и строчные буквы рассматриваются отдельно.

        Кроме того, данный метод подходит только для сортировки тех объектов, которые реализуют интерфейс Comparable.

        Если же у нас классы объектов не реализуют этот интерфейс или мы хотим создать какую-то свою логику сортировки,
        то мы можем использовать другую версию метода sorted(), которая в качестве параметра принимает компаратор.
         */
        Stream<Phone> phoneStream = Stream.of(
                new Phone("iPhone X",  600),
                new Phone("Pixel 2", 500),
                new Phone("iPhone 8", 450),
                new Phone("Nokia 9", 150),
                new Phone("Galaxy S9",  300)
        );

        phoneStream.sorted(new PhoneComparator())
                .forEach(p->System.out.printf("%s - %d \n",
                        p.getName(), p.getPrice()));
    }
}


class PhoneComparator implements Comparator<Phone> {
    public int compare(Phone a, Phone b){
        return a.getName().toUpperCase().compareTo(b.getName().toUpperCase());
    }
}