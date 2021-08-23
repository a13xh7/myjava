package m10_io_files;

import java.io.Console;

/*
Специально для работы с консолью в Java определен класс Console, который хранится в пакете java.io.
Он не получает консольный ввод-вывод сам по себе, а использует уже имеющиеся потоки System.in и System.out.
 Но в то же время Console значительно упрощает ряд операций, связанных с консолью.
 */
public class L10_Console {

    public static void main(String[] args) {

        // получаем консоль
        Console console = System.console();
        if(console!=null){
            // считываем данные с консоли
            String login = console.readLine("Введите логин:");
            char[] password = console.readPassword("Введите пароль:");

            console.printf("Введенный логин: %s \n", login);
            console.printf("Введенный пароль: %s \n", new String(password));
        }
    }

}
