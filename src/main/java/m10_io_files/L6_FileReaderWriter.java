package m10_io_files;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
Запись файлов. Класс FileWriter
Класс FileWriter является производным от класса Writer. Он используется для записи текстовых файлов.
 */
public class L6_FileReaderWriter {

    public static void main(String[] args) {

        try(FileWriter writer = new FileWriter("notes3.txt", false))
        {
            // запись всей строки
            String text = "Hello Gold!";
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append('E');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        // read file

        try( FileReader reader = new FileReader("notes3.txt")) {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }

}
