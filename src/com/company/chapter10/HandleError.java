package chapter10;

import java.util.Random;

public class HandleError {
    static int a=0, b=0, c=0;
    static Random rnd = new Random();

    public static void run() {
        for (int i = 0; i < 32000; i++) {
            try {
                b = rnd.nextInt();
                c = rnd.nextInt();
                a = 12345 / (b/c);
            }
            catch (ArithmeticException e) {
                System.out.println(e);
                a = 0;
            }
            System.out.printf("a: %d \n", a);
        }
    }
}
