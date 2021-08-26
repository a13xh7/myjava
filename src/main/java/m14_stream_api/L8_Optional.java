package m14_stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class L8_Optional {
    /*
    Ряд операций сведения, такие как min, max, reduce, возвращают объект Optional<T>. Этот объект фактически обертывает
     результат операции. После выполнения операции с помощью метода get() объекта Optional мы можем получить его значение:
     */
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9}));

        Optional<Integer> min = numbers.stream().min(Integer::compare);
        System.out.println(min.get());  // 1

        // Но что, если поток не содержит вообще никаких данных:
        // список numbers пустой
        ArrayList<Integer> numbers2 = new ArrayList<Integer>();
        Optional<Integer> min2 = numbers2.stream().min(Integer::compare);
        //System.out.println(min2.get());  // java.util.NoSuchElementException

        /* isPresent()
        Что мы можем сделать, чтобы избежать выброса исключения? Для этого класс Optional предоставляет ряд методов.
        Самой простой способ избежать подобной ситуации - это предварительная проверка наличия значения в Optional с помощью метода isPresent().
        Он возврашает true, если значение присутствует в Optional, и false, если значение отсутствует:
         */

        if(min2.isPresent()){
            System.out.println(min2.get());
        }

        // Метод orElse() позволяет определить альтернативное значение, которое будет возвращаться, если Optional не получит из потока какого-нибудь значения:

        // пустой список
        ArrayList<Integer> numbers3 = new ArrayList<Integer>();
        Optional<Integer> min3 = numbers3.stream().min(Integer::compare);
        System.out.println(min3.orElse(-1)); // -1

        // непустой список
        numbers3.addAll(Arrays.asList(new Integer[]{4,5,6,7,8,9}));
        min3 = numbers.stream().min(Integer::compare);
        System.out.println(min3.orElse(-1)); // 4

        // Метод orElseGet() позволяет задать функцию, которая будет возвращать значение по умолчанию:
        ArrayList<Integer> numbers4 = new ArrayList<Integer>();
        Optional<Integer> min4 = numbers4.stream().min(Integer::compare);
        Random rnd = new Random();
        System.out.println(min.orElseGet( () -> rnd.nextInt(100) ) );

        // Еще один метод - orElseThrow позволяет сгенерировать исключение, если Optional не содержит значения:
        ArrayList<Integer> numbers5 = new ArrayList<Integer>();
        Optional<Integer> min5 = numbers5.stream().min(Integer::compare);
        // генеррация исключения IllegalStateException
        System.out.println(min5.orElseThrow(IllegalStateException::new));

        // Метод ifPresent() определяет действия со значением в Optional, если значение имеется:
        ArrayList<Integer> numbers6 = new ArrayList<Integer>();
        numbers6.addAll(Arrays.asList(new Integer[]{4,5,6,7,8,9}));
        Optional<Integer> min6 = numbers6.stream().min(Integer::compare);
        min6.ifPresent(v->System.out.println(v)); // 4

        // Метод ifPresentOrElse() позволяет определить альтернативную логику на случай, если значение в Optional отсутствует
        ArrayList<Integer> numbers7 = new ArrayList<Integer>();
        Optional<Integer> min7 = numbers7.stream().min(Integer::compare);
        min7.ifPresentOrElse(
                v -> System.out.println(v),
                () -> System.out.println("Value not found")
        );
    }
}
