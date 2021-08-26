package m8_collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
Интерфейс Map<K, V> представляет отображение или иначе говоря словарь, где каждый элемент представляет пару "ключ-значение".
При этом все ключи уникальные в рамках объекта Map. Такие коллекции облегчают поиск элемента, если нам известен ключ - уникальный идентификатор объекта.

Не запоминает порядок добавления элементов.

Если добавить 2 элемента с одним ключем, значение перезапишется.
Ключ и значение можгут быть null
 */
public class L6_Map {

    public static void main(String[] args) {

        Map<Integer, String> states = new HashMap<>();
        states.put(1, "Germany");
        states.put(2, "Spain");
        states.put(4, "France");
        states.put(3, "Italy");

        // получим объект по ключу 2
        String first = states.get(2);
        System.out.println(first);

        // получим весь набор ключей
        Set<Integer> keys = states.keySet();

        // получить набор всех значений
        Collection<String> values = states.values();

        //заменить элемент
        states.replace(1, "Poland");

        // удаление элемента по ключу 2
        states.remove(2);

        // перебор элементов
        for(Map.Entry<Integer, String> item : states.entrySet()){
            System.out.printf("Key: %d  Value: %s \n", item.getKey(), item.getValue());
        }

        Map<String, Person> people = new HashMap<String, Person>();
        people.put("1240i54", new Person("Tom"));
        people.put("1564i55", new Person("Bill"));
        people.put("4540i56", new Person("Nick"));

        for(Map.Entry<String, Person> item : people.entrySet()){

            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue().getName());
        }
    }

}
