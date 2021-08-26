package m14_stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
Метод skip(long n) используется для пропуска n элементов. Этот метод возвращает новый поток, в котором пропущены первые n элементов.

Метод limit(long n) применяется для выборки первых n элементов потоков. Этот метод также возвращает модифицированный поток, в котором не более n элементов.

Зачастую эта пара методов используется вместе для создания эффекта постраничной навигации.
*/
public class L5_Skip_Limit {
    public static void main(String[] args) {
        List<String> phones = new ArrayList<>();

        phones.addAll(
                Arrays.asList(new String[]
                {
                        "iPhone 6 S", "Lumia 950", "Huawei Nexus 6P",
                        "Samsung Galaxy S 6", "LG G 4", "Xiaomi MI 5",
                        "ASUS Zenfone 2", "Sony Xperia Z5", "Meizu Pro 5",
                        "Lenovo S 850"
                })
        );

        int pageSize = 3; // количество элементов на страницу
        Scanner scanner = new Scanner(System.in);
        while(true){

            System.out.println("Введите номер страницы: ");
            int page = scanner.nextInt();

            if(page<1) break; // если число меньше 1, выходим из цикла

            phones.stream()
                    .skip((page-1) * pageSize) // пропустить страницу
                    .limit(pageSize) // выбрать указанный лимит со следующей "страницы"
                    .forEach(s->System.out.println(s));
        }
    }
}
