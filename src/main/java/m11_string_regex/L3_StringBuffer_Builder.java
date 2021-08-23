package m11_string_regex;

/*
Объекты String являются неизменяемыми, поэтому все операции, которые изменяют строки, фактически приводят к созданию
новой строки, что сказывается на производительности приложения. Для решения этой проблемы, чтобы работа со строками
проходила с меньшими издержками в Java были добавлены классы StringBuffer и StringBuilder. По сути они напоминает
расширяемую строку, которую можно изменять без ущерба для производительности.

Эти классы похожи, практически двойники, они имеют одинаковые конструкторы, одни и те же методы, которые одинаково
используются. Единственное их различие состоит в том, что класс StringBuffer синхронизированный и потокобезопасный.
То есть класс StringBuffer удобнее использовать в многопоточных приложениях, где объект данного класса может меняться
в различных потоках. Если же речь о многопоточных приложениях не идет, то лучше использовать класс StringBuilder,
который не потокобезопасный, но при этом работает быстрее, чем StringBuffer в однопоточных приложениях.

 */
public class L3_StringBuffer_Builder {

    public static void main(String[] args) {

        String str = "Java";
        StringBuffer strBuffer = new StringBuffer(str);

        System.out.println("Емкость: " + strBuffer.capacity()); // 20
        strBuffer.ensureCapacity(32);
        System.out.println("Емкость: " + strBuffer.capacity()); // 42
        System.out.println("Длина: " + strBuffer.length()); // 4

        System.out.println(strBuffer.toString()); // Java

        // Получение и установка символов

        char c = strBuffer.charAt(0); // J
        System.out.println(c);
        strBuffer.setCharAt(0, 'c');
        System.out.println(strBuffer.toString()); // cava

        // append

        strBuffer.append(" world");
        System.out.println(strBuffer.toString()); // hello world

        // delete

        strBuffer.delete(0,2);
        System.out.println(strBuffer.toString()); //sembler

        strBuffer.deleteCharAt(2);
        System.out.println(strBuffer.toString()); //semble

        // Обрезка строки

        StringBuffer strBuffer2 = new StringBuffer("hello java!");
        String str1 = strBuffer2.substring(6); // обрезка строки с 6 символа до конца
        System.out.println(str1); //java!

        /*
        Для изменения длины StringBuffer (не емкости буфера символов) применяется метод setLength().
        Если StringBuffer увеличивается, то его строка просто дополняется в конце пустыми символами, если уменьшается - то строка по сути обрезается:
         */
        StringBuffer strBuffer3 = new StringBuffer("hello");
        strBuffer3.setLength(10);
        System.out.println(strBuffer3.toString()); //"hello     "

        // Обратный порядок в строке
        strBuffer.reverse();

        // Замена в строке
        strBuffer.replace(6,11,"java");
        System.out.println(strBuffer.toString()); //hello java!
    }
}
