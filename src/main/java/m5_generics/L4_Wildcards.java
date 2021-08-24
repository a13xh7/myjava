package m5_generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class L4_Wildcards {

    public static void main(String[] args) {

        // List<Cat> cats = new ArrayList<>();
        // cats.add(new Cat());
        // iterateAnimals(cats);  //ошибка компилятора! в случае Collection<Animal>

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());

        iterateAnimals(cats);
    }


    /*
    Collection<? extends Animal> - значит, что метод принимает на вход коллекцию объектов класса
    Animal либо объектов любого класса-наследника Animal (? extends Animal).
    Это и есть wildcard. Точнее, это первый из нескольких типов wildcard — “extends” (другое название — Upper Bounded Wildcards).
     */
    public static void iterateAnimals(Collection<? extends Animal> animals) {
        for(Animal animal: animals) {
            System.out.println("Еще один шаг в цикле пройден!");
        }
    }

    /*
    Теперь тебе нужно переписать метод iretateAnimals() таким образом, чтобы он мог работать с любым типом животных, кроме собак.
    То есть он должен принимать на вход Collection<Animal>, Collection<Pet> или Collection<Cat>, но не должен работать с Collection<Dog>.
     Здесь нам снова придут на помощь wildcards. Но на этот раз мы воспользуемся другим типом — “super” (другое название — Lower Bounded Wildcards).

    Конструкция <? super Cat> говорит компилятору, что метод iterateAnimals() может принимать на вход коллекцию объектов класса
     Cat либо любого другого класса-предка Cat.
    Под это описание в нашем случае подходят сам класс Cat, его предок — Pets, и предок предка — Animal.
    Класс Dog не вписывается в это ограничение, и поэтому попытка использовать метод со списком List<Dog> приведет к ошибке компиляции:
     */
    public static void iterateAnimals2(Collection<? super Cat> animals) {
        for(int i = 0; i < animals.size(); i++) {
            System.out.println("Еще один шаг в цикле пройден!");
        }
    }

}



class Animal {

    public void feed() {

        System.out.println("Animal.feed()");
    }
}

class Pet extends Animal {

    public void call() {

        System.out.println("Pet.call()");
    }
}

class Cat extends Pet {

    public void meow() {

        System.out.println("Cat.meow()");
    }
}

class Dog extends Pet {

    public void woof() {

        System.out.println("Dog.woof()");
    }
}