package chapter10;

public class SuperSubCatch {
    static int a, b;

    public static void run() {
        try {
            a = 0;
            b = 42 / a;
        }
        catch (ArithmeticException e) {
            System.out.println("Код достежим.");
        }
        catch (Exception e) {
            System.out.println("Перехват исключений общего класса Exeption");
        }

    }
}
