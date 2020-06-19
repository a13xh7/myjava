package oop;

// Попытка наследования от L2_FinalClassesAndMethods приводит к ошибке компилятора.

public final class L2_FinalClassesAndMethods {

        public int x;
        public int y;

        // Финальыне методы нельзя переопределять / override
        public final void method1(){
            System.out.println(777);
        }

}

