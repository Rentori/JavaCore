package chapter10;

import java.util.Random;

public class MultipleCatches {
    static Random random = new Random();
    public static void run() {
        try {
            int a = random.nextInt(2);
            System.out.println("a = " + a);
            int b = 42/a;
            int[] c = {1};
            c[42] = 99;
        }
        catch (ArithmeticException e) {
            System.out.println("Деление на 0");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка индексации за пределами массива " + e);
        }
        System.out.println("После операторов try/catch.");
    }
}
