package m14_stream_api;

import java.util.Optional;
import java.util.stream.Stream;

/*
Метод reduce выполняет терминальные операции сведения, возвращая одно значение - результат операции. Он имеет следующие формы:

Optional<T> reduce(BinaryOperator<T> accumulator)
T reduce(T identity, BinaryOperator<T> accumulator)
U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
 */
public class L7_Reduce {

    public static void main(String[] args) {
        // Первая форма возвращает результат в виде объекта Optional<T>. Например, вычислим произведение набора чисел:
        // Объект BinaryOperator<T> представляет функцию, которая принимает два элемента и выполняет над ними некоторую операцию,
        // возвращая результат. При этом метод reduce сохраняет результат и затем опять же применяет к этому результату и следующему элементу в наборе бинарную операцию.
        Stream<Integer> numbersStream = Stream.of(1,2,3,4,5,6);
        Optional<Integer> result = numbersStream.reduce((x, y)->x*y);
        System.out.println(result.get()); // 720

        /*
        Вторая версия метода reduce() принимает два параметра:
        T reduce(T identity, BinaryOperator<T> accumulator)

        Первый параметр - T identity - элемент, который предоставляет начальное значение для функции из второго параметра,
        а также предоставляет значение по умолчанию, если поток не имеет элементов.
        Второй параметр - BinaryOperator<T> accumulator, как и первая форма метода reduce

        То есть при первом вызове функция accumulator в качестве первого параметра принимает значение identity,
        а в качестве второго параметра - первый элемент потока. При втором вызове первым параметром служит результат
        первого вызова функции accumulator, а вторым параметром - второй элемент в потоке и так далее. Например:
         */
        Stream<Integer> numberStream = Stream.of(-4, 3, -2, 1);
        int identity = 1;
        int result2 = numberStream.reduce(identity, (x,y)->x * y);
        System.out.println(result2);  // 24

        // мы хотим найти сумму цен тех телефонов, у которых цена меньше определенного значения. Для этого используем третью версию метода reduce:

        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone 6 S", 54000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 6", 40000),
                new Phone("LG G 4", 32000));

        int sum = phoneStream.reduce(0,
                (x,y)-> {
                    if(y.getPrice()<50000)
                        return x + y.getPrice();
                    else
                        return x + 0;
                },
                (x, y)->x+y);

        System.out.println(sum); // 117000
    }
}
