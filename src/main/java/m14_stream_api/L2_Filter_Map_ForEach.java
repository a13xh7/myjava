package m14_stream_api;

import java.util.stream.Stream;

public class L2_Filter_Map_ForEach {

    public static void main(String[] args) {

        /*
        Для перебора элементов потока применяется метод forEach(), который представляет терминальную операцию.
        В качестве параметра он принимает объект Consumer<? super String>, который представляет действие, выполняемое для каждого элемента набора.
         */
        Stream<String> citiesStream = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель");
        citiesStream.forEach(s->System.out.println(s));
        // citiesStream.forEach(System.out::println);

        /*
        Для фильтрации элементов в потоке применяется метод filter(), который представляет промежуточную операцию.
        Он принимает в качестве параметра некоторое условие в виде объекта Predicate<T> и возвращает новый поток из элементов, которые удовлетворяют этому условию:
         */
        Stream<String> citiesStream2 = Stream.of("Париж", "Лондон", "Мадрид","Берлин", "Брюссель");
        citiesStream2.filter(s->s.length()==6).forEach(s->System.out.println(s));

        /*
        Map
        Отображение или маппинг позволяет задать функцию преобразования одного объекта в другой, то есть получить из элемента одного типа элемент другого типа.

        Для преобразования объектов в типы Integer, Long, Double определены специальные методы mapToInt(), mapToLong() и mapToDouble() соответственно.
         */
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 6 S", 54000), new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000));

        phoneStream
                .map(p-> p.getName()) // помещаем в поток только названия телефонов.  результирующий поток содержит только строки
                .forEach(s->System.out.println(s));

        /*
        Метод flatMap
        Плоское отображение выполняется тогда, когда из одного элемента нужно получить несколько. Данную операцию выполняет метод flatMap:
         */
        Stream<Phone> phoneStream2 = Stream.of(new Phone("iPhone 6 S", 54000), new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000));

        phoneStream2
                .flatMap(p -> Stream.of(
                        String.format("название: %s  цена без скидки: %d", p.getName(), p.getPrice()),
                        String.format("название: %s  цена со скидкой: %d", p.getName(), p.getPrice() - (int)(p.getPrice()*0.1))
                ))
                .forEach(s->System.out.println(s));
    }
}


class Phone{

    private String name;
    private int price;
    public Phone(String name, int price){
        this.name=name;
        this.price=price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}