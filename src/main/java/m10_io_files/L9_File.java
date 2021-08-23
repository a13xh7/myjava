package m10_io_files;

import java.io.File;

/*
Класс File, определенный в пакете java.io, не работает напрямую с потоками. Его задачей является управление информацией
о файлах и каталогах. Хотя на уровне операционной системы файлы и каталоги отличаются, но в Java они описываются одним классом File.
 */
public class L9_File {

    public static void main(String[] args) {

        // определяем объект для каталога
        File dir = new File(System.getProperty("user.dir") );
        // если объект представляет каталог
        if(dir.isDirectory())
        {
            // получаем все вложенные объекты в каталоге
            for(File item : dir.listFiles()){

                if(item.isDirectory()){

                    System.out.println(item.getName() + "  \t folder");
                }
                else{

                    System.out.println(item.getName() + "\t file");
                }
            }
        }
    }

}
