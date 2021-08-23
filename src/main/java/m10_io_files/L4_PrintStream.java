package m10_io_files;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*
Класс PrintStream - это именно тот класс, который используется для вывода на консоль. Когда мы выводим на консоль
некоторую информацию с помощью вызова System.out.println(), то тем самым мы задействует PrintStream, так как переменная
out в классе System как раз и представляет объект класса PrintStream, а метод println() - это метод класса PrintStream.
Но PrintStream полезен не только для вывода на консоль. Мы можем использовать данный класс для записи информации в поток вывода.
 */

public class L4_PrintStream {

    public static void main(String[] args) {

        String text = "Привет мир!"; // строка для записи
        try(FileOutputStream fos=new FileOutputStream(System.getProperty("user.dir") + "/test_file.txt");
            PrintStream printStream = new PrintStream(fos))
        {
            printStream.println(text);
            System.out.println("Запись в файл произведена");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        /*
        В данном случае применяется форма конструктора PrintStream, которая в качестве параметра принимает поток вывода:
        PrintStream (OutputStream out). Кроме того, мы могли бы использовать ряд других форм конструктора, например,
        указывая названия файла для записи: PrintStream (string filename)

        В качестве потока вывода используется объект FileOutputStream. С помощью метода println() производится запись информации
        в выходной поток - то есть в объект FileOutputStream. (В случае с выводом на консоль с помощью System.out.println() в
        качестве потока вывода выступает консоль)
         */

        try(PrintStream printStream = new PrintStream(System.getProperty("user.dir") + "/test_file.txt"))
        {
            printStream.print("Hello World!");
            printStream.println("Welcome to Java!");

            printStream.printf("Name: %s Age: %d \n", "Tom", 34);

            String message = "PrintStream";
            byte[] message_toBytes = message.getBytes();
            printStream.write(message_toBytes);

            System.out.println("The file has been written");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
