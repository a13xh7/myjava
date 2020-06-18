package java_essential.lesson_1.ex_005_constructors.private_constructor;

public class Animal {
    private int age;

    // объявленный конструктор является приватным. Может быть использован только в рамках данного класса
    private Animal(int age) {
        this.age = age;
    }
}