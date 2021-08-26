package m14_stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/*
Фактически жизненный цикл потока проходит следующие три стадии:

Создание потока
Применение к потоку ряда промежуточных операций
Применение к потоку терминальной операции и получение результата
 */
public class L1_CreateStream {

    public static void main(String[] args) {

        ArrayList<String> cities = new ArrayList<String>();
        Collections.addAll(cities, "Париж", "Лондон", "Мадрид");

        cities.stream() // получаем поток
                .filter(s->s.length()==6) // применяем фильтрацию по длине строки
                .forEach(s->System.out.println(s)); // выводим отфильтрованные строки на консоль

        // Аналогичный вариант
        Stream<String> citiesStream = cities.stream(); // получаем поток
        citiesStream = citiesStream.filter(s->s.length()==6); // применяем фильтрацию по длине строки
        citiesStream.forEach(s->System.out.println(s)); // выводим отфильтрованные строки на консоль

        // Еще вариант создания потока
        citiesStream = Arrays.stream(new String[]{"Париж", "Лондон", "Мадрид"}) ;
        citiesStream.forEach(s->System.out.println(s)); // выводим все элементы массива

        // Для создания потоков IntStream, DoubleStream, LongStream можно использовать соответствующие перегруженные версии метода Arrays.stream():
        IntStream intStream = Arrays.stream(new int[]{1,2,4,5,7});
        intStream.forEach(i->System.out.println(i));

        LongStream longStream = Arrays.stream(new long[]{100,250,400,5843787,237});
        longStream.forEach(l->System.out.println(l));

        DoubleStream doubleStream = Arrays.stream(new double[] {3.4, 6.7, 9.5, 8.2345, 121});
        doubleStream.forEach(d->System.out.println(d));

        // И еще один способ создания потока представляет статический метод of(T..values) класса Stream:

        Stream<String> citiesStream2 =Stream.of("Париж", "Лондон", "Мадрид");
        citiesStream2.forEach(s->System.out.println(s));

        // можно передать массив
        String[] cities2 = {"Париж", "Лондон", "Мадрид"};
        Stream<String> citiesStream3 =Stream.of(cities2);

        IntStream intStream2 = IntStream.of(1,2,4,5,7);
        intStream2.forEach(i->System.out.println(i));

        LongStream longStream2 = LongStream.of(100,250,400,5843787,237);
        longStream2.forEach(l->System.out.println(l));

        DoubleStream doubleStream2 = DoubleStream.of(3.4, 6.7, 9.5, 8.2345, 121);
        doubleStream2.forEach(d->System.out.println(d));
    }
}

