package m10_io_files;

import java.io.*;

/*
Сериализация представляет процесс записи состояния объекта в поток, соответственно процесс извлечения или восстановления
состояния объекта из потока называется десериализацией. Сериализация очень удобна, когда идет работа со сложными объектами.

сериализовать можно только те объекты, которые реализуют интерфейс Serializable. Этот интерфейс не определяет никаких
методов, просто он служит указателем системе, что объект, реализующий его, может быть сериализован.
 */
public class L8_Serialization {
    public static void main(String[] args) {

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat")))
        {
            Person2 p = new Person2("Sam", 33, 178, true);
            oos.writeObject(p);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

        // Десериализация

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat")))
        {
            Person2 p = (Person2)ois.readObject();
            System.out.printf("Name: %s \t Age: %d \n", p.getName(), p.getAge());
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}

/*
Исключение данных из сериализации
По умолчанию сериализуются все переменные объекта. Однако, возможно, мы хотим, чтобы некоторые поля были исключены из сериализации.

Для этого они должны быть объявлены с модификатором transient. Например, исключим из сериализации объекта Person переменные height и married:
 */

class Person2 implements Serializable {

    private String name;
    private int age;
    private double height;
    private transient boolean married;

    Person2(String n, int a, double h, boolean m){

        name=n;
        age=a;
        height=h;
        married=m;
    }
    String getName() {return name;}
    int getAge(){ return age;}
    double getHeight(){return height;}
    boolean getMarried(){return married;}
}
