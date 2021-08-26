package m14_stream_api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Большинство операций класса Stream, которые модифицируют набор данных, возвращают этот набор в виде потока.
Однако бывают ситуации, когда хотелось бы получить данные не в виде потока, а в виде обычной коллекции, например, ArrayList или HashSet.
И для этого у класса Stream определен метод collect.

Java уже предоставляет ряд встроенных функций, определенных в классе Collectors:

toList(): преобразование к типу List
toSet(): преобразование к типу Set
toMap(): преобразование к типу Map
 */
public class L9_Collect_StreamToCollections {

    public static void main(String[] args) {

        List<String> phones = new ArrayList<>();
        Collections.addAll(phones, "iPhone 8", "HTC U12", "Huawei Nexus 6P",
                "Samsung Galaxy S9", "LG G6", "Xiaomi MI6", "ASUS Zenfone 2",
                "Sony Xperia Z5", "Meizu Pro 6", "Lenovo S850");

        List<String> filteredPhones = phones.stream()
                .filter(s->s.length()<10)
                .collect(Collectors.toList());

        for(String s : filteredPhones){
            System.out.println(s);
        }

        // Для применения метода toMap() надо задать ключ и значение. Например, пусть у нас есть следующая модель:

        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 8", 54000),
                new Phone("Nokia 9", 45000),
                new Phone("Samsung Galaxy S9", 40000),
                new Phone("LG G6", 32000));


        Map<String, Integer> phones2 = phoneStream
                .collect(Collectors.toMap(p->p.getName(), t->t.getPrice())); // Collectors.toCollection(HashSet::new)

        phones2.forEach((k,v)->System.out.println(k + " " + v));
    }

}
