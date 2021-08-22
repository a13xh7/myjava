package m10_io_files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Объект, из которого можно считать данные, называется потоком ввода, а объект, в который можно записывать данные, - потоком вывода.
Например, если надо считать содержание файла, то применяется поток ввода, а если надо записать в файл - то поток вывода.
 */
public class L0_File_Input_Output {

    public static void main(String[] args) {

        String text = "Hello world!"; // строка для записи

        try {
            FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "/test_file.txt");

            // перевод строки в байты
            byte[] buffer = text.getBytes();

            // fos.write(buffer[0]); // запись первого байта
            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("The file has been written");

        try {
            FileInputStream fin=new FileInputStream(System.getProperty("user.dir") + "/test_file.txt");

            System.out.printf("File size: %d bytes \n", fin.available());

            int i=-1;
            while((i=fin.read()) != -1) { // Когда в потоке больше нет данных для чтения, метод возвращает число -1.

                System.out.print((char)i);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
}
