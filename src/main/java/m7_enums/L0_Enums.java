package m7_enums;

/**
 * Перечисляемые типы (enum). Перечисления представляют набор логически связанных констант.
 * Костанты перечисляемых типов по-умолчанию являются static final.
 */
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class L0_Enums {

    public static void main(String[] args) {

        // Объект со ссылкой на экземпляр перечисляемого типа Day.
        Day today = Day.SATURDAY;
        System.out.println("Today is " + today);

        // Нельзя переопределить єкземпляр перечисляемого типа.
        // Day.MONDAY = Day.FRIDAY;

        switch (today) {
            case SATURDAY:
                System.out.println("First day of the weekend - Saturday.");
                break;
            case SUNDAY:
                System.out.println("The last day of the weekend - Sunday.");
                break;
            default:
                System.out.println("The weekday - " + today);
        }

        // Также, можно сравнивать экземпляры перечисляеміх типов, используя операцию ==
        if (today == Day.SATURDAY) {
            System.out.println("Finally, weekend!");
        }
    }


}
