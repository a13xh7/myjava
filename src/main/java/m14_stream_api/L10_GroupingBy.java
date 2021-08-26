package m14_stream_api;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Чтобы сгруппировать данные по какому-нибудь признаку, нам надо использовать в связке метод collect() объекта Stream и метод Collectors.groupingBy().
 */
public class L10_GroupingBy {

    public static void main(String[] args) {

        Stream<Phone2> phoneStream = Stream.of(
                new Phone2("iPhone X", "Apple", 600),
                new Phone2("Pixel 2", "Google", 500),
                new Phone2("iPhone 8", "Apple",450),
                new Phone2("Galaxy S9", "Samsung", 440),
                new Phone2("Galaxy S8", "Samsung", 340)
        );

        Map<String, List<Phone2>> phonesByCompany = phoneStream.collect(
                Collectors.groupingBy(Phone2::getCompany));

        for(Map.Entry<String, List<Phone2>> item : phonesByCompany.entrySet()){
            System.out.println(item.getKey());

            for(Phone2 phone : item.getValue()){

                System.out.println(phone.getName());
            }

            System.out.println();
        }
    }
}

class Phone2 {
    private String name;
    private String company;
    private int price;

    public Phone2(String name, String comp, int price) {
        this.name = name;
        this.company = comp;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCompany() {
        return company;
    }
}