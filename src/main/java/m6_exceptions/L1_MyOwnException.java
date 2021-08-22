package m6_exceptions;

class UserException extends Exception {
    public void method() {
        System.out.println("Мое исключение!");
    }
}


public class L1_MyOwnException {

    public static void main(String[] args) {
        try {
            throw new UserException();
        } catch (UserException e) {
            System.out.println("Обработка исключения.");
            e.method();
        }
    }

}
