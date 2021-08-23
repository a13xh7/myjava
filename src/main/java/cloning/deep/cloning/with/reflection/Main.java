package cloning.deep.cloning.with.reflection;

import java.lang.reflect.Field;

/**
 * Created by Yevhenii Tykhonov.
 */
public class Main {
    public static void main(String[] args) {
        Cow originalCow = new Cow("Milka", 5, 1);
        System.out.println("Original cow = " + originalCow);
        
        Cow copiedCow = reflectionCloning(originalCow);
        System.out.println(copiedCow);
    }

    private static Cow reflectionCloning(Cow originalCow) {
        Cow copiedCow = originalCow;

        try {
            Field name = Cow.class.getDeclaredField("name");
            Field head = Cow.class.getDeclaredField("head");

            name.setAccessible(true);
            head.setAccessible(true);

            name.set(copiedCow, "Byrenka");
            head.set(copiedCow, 2);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return copiedCow;
    }
}
