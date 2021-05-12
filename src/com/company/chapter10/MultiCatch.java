package chapter10;

public class MultiCatch {
    public static void run() {
        int a = 10, b = 0;
        int vals[] = {1, 2, 3};

        try {
            int result = a / b;

            vals[10] = 19;
        }
        catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.out.println("Перехвачено исключение: " + e);
        }
        System.out.println("После многократного прехвата");
    }
}
