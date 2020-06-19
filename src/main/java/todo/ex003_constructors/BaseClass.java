package todo.ex003_constructors;

/**
 * Наследование.
 */
public class BaseClass {
    public int baseNumber;

    // Конструктор по умолчанию.
    public BaseClass() {
        System.out.println("empty parent");
    }

    // Пользовательский конструктор.
    public BaseClass(int baseNumber) {
        this.baseNumber = baseNumber;
    }
}
