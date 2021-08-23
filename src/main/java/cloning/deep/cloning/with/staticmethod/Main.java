package cloning.deep.cloning.with.staticmethod;

/**
 * Created by Yevhenii Tykhonov.
 */
public class Main {
    public static void main(String[] args) {
        // 1st example
        Human cloneHuman = Human.getHumanInstanceWithAgeAndString(20, "Robert");

        System.out.println(cloneHuman);

        // 2nd example
        Car car = new Car(2500, "BMW");
        System.out.println("Original car = " + car);

        Car copiedCar = Car.deepCopyCar(car);
        System.out.println("Copied car = " + copiedCar);
    }
}
