package m10_io_files;

import java.io.*;

/*
Класс BufferedWriter записывает текст в поток, предварительно буферизируя записываемые символы,
тем самым снижая количество обращений к физическому носителю для записи данных.
 */
public class L7_BufferedReaderWriter {

    public static void main(String[] args) {

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("notes4.txt")))
        {
            String text = "Hello  World!\nHey! Teachers! Leave them kids alone.";
            bw.write(text);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        /*
        Класс BufferedReader считывает текст из символьного потока ввода, буферизируя прочитанные символы.
        Использование буфера призвано увеличить производительность чтения данных из потока.
         */
        try(BufferedReader br = new BufferedReader (new FileReader("notes4.txt")))
        {
            // чтение посимвольно
            int c;
            while((c=br.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }

}
