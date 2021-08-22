package m2_arrays;

public class L0_ArraysFill {

    // Массив представляет набор однотипных значений.
    // тип_данных название_массива[];
    // либо
    // тип_данных[] название_массива;

    public static void main(String[] args) {

        // объявление массива
        int[] arr1;
        int arr2[]; // не рекоммендуется
        arr1 = new int[5]; // объявили размерность в 5 элементов
        int[] arr3 = new int[100];

        int[] arr4 = {12, 25, 33, 41, 13, 98}; // размер массива 6

        System.out.println(arr4.length); //  длинна массива

        // эти два способа равноценны
        int[] nums = new int[] { 1, 2, 3, 5 };
        int[] nums2 = { 1, 2, 3, 5 };

       // Нередко бывает неизвестным последний индекс, и чтобы получить последний элемент массива, мы можем использовать это свойство:
        int[] nums3 = {1, 2, 3, 4, 5};
        int length = nums.length;   // 5
        int last = nums[nums.length-1];


        int[] array = new int[5];

        // Заполнение массива.
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
        }

        // Вывод на экран значений элементов массива.
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        // Специальная запись цикла for для прохождения элементов массива (Java 8)
        // Аналогична конструкции foreach, используемой в других языках программирования (например C#, PHP)
        // for (int ключ, массив)
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
    }

    public static void fill() {
        // На 10 строке создаем массив целочисленных элементов с именем array
        // и заполняем его значениями 1,2,3,4,5

        int[] array = new int[]{1, 2, 3, 4, 5};

        // Вывод на экран значений элементов массива.
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void emptyArray() {
        int[] array = new int[5];

        // Вывод на экран значений элементов массива.
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


}
