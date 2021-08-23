package m10_io_files;

import java.io.FileInputStream;
import java.io.IOException;

/*
При завершении работы с потоком его надо закрыть с помощью метода close()
При закрытии потока освобождаются все выделенные для него ресурсы, например, файл.
В случае, если поток окажется не закрыт, может происходить утечка памяти.
 */
public class L1_CloseStreams {

    public static void main(String[] args) {

        FileInputStream fin=null;
        try
        {
            fin = new FileInputStream(System.getProperty("user.dir") + "/test_file.txt");

            int i=-1;
            while((i=fin.read())!=-1){

                System.out.print((char)i);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        finally{

            try{

                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }
    }

    /*
    Начиная с Java 7 можно использовать еще один способ, который автоматически вызывает метод close.
    Этот способ заключается в использовании конструкции try-with-resources (try-с-ресурсами).
     Данная конструкция работает с объектами, которые реализуют интерфейс AutiCloseable.
     Так как все классы потоков реализуют интерфейс Closeable, который в свою очередь наследуется от AutoCloseable,
     то их также можно использовать в данной конструкции
     */

    public static void ex2() {

        try( FileInputStream fin=new FileInputStream(System.getProperty("user.dir") + "/test_file.txt") )
        {
            int i=-1;
            while((i=fin.read())!=-1){

                System.out.print((char)i);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
