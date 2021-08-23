package m11_string_regex;

/*
Строка представляет собой последовательность символов. Для работы со строками в Java определен класс String, который
предоставляет ряд методов для манипуляции строками. Физически объект String представляет собой ссылку на область в памяти,
в которой размещены символы.
 */
public class L0_String {

    public static void main(String[] args) {

        String str1 = "Java";
        String str2 = new String(); // пустая строка
        String str3 = new String(new char[] {'h', 'e', 'l', 'l', 'o'});
        String str4 = new String(new char[]{'w', 'e', 'l', 'c', 'o', 'm', 'e'}, 3, 4);//3 -начальный индекс, 4 -кол-во символов

        System.out.println(str1); // Java
        System.out.println(str2); //
        System.out.println(str3); // hello
        System.out.println(str4); // come

        System.out.println(str1.length()); // 4

        if(str2.isEmpty()) System.out.println("String is empty");

        String s = null;   // строка не указывает на объект
        if(s!=null && s.length()==0) System.out.println("String is empty");
    }

}
