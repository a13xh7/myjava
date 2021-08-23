package m10_io_files;

import java.io.*;

/*
Для оптимизации операций ввода-вывода используются буферизуемые потоки. Эти потоки добавляют к стандартным специальный
буфер в памяти, с помощью которого повышается производительность при чтении и записи потоков.
 */
public class L3_BufferedStream {

    // Класс BufferedInputStream накапливает вводимые данные в специальном буфере без постоянного обращения к устройству ввода.
    public static void main(String[] args) {

        String text = "Hello world!";
        byte[] buffer = text.getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(buffer);

        try(BufferedInputStream bis = new BufferedInputStream(in)) {
            int c;
            while((c=bis.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println();
    }
/*
Класс BufferedOutputStream аналогично создает буфер для потоков вывода. Этот буфер накапливает выводимые байты без
постоянного обращения к устройству. И когда буфер заполнен, производится запись данных.
 */
    public static void main2(String[] args) {

        String text = "Hello world!"; // строка для записи
        try(FileOutputStream out=new FileOutputStream("notes.txt");
            BufferedOutputStream bos = new BufferedOutputStream(out))
        {
            // перевод строки в байты
            byte[] buffer = text.getBytes();
            bos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
