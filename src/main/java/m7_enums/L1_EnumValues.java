package m7_enums;

enum Type
{
    SCIENCE,
    BELLETRE,
    PHANTASY,
    SCIENCE_FICTION
}

public class L1_EnumValues {

    // Каждое перечисление имеет статический метод values(). Он возвращает массив всех констант перечисления:

    public static void main(String[] args) {

        Type[] types = Type.values();

        for (Type s : types) {
            System.out.println(s);
        }
    }

}
