package chapter10;

public class ZeroExeption {
    static int d, a;
    public static void getZeroEx() {
        int a = 0;
        int d = 12 /0 ;
    }

    public static void getCheckedZeroEx() {
        try {
            a = 0;
            d = 12 / 0;
            System.out.println("Это не будет выведено");
        }
        catch (ArithmeticException e) {
            System.out.println("Деление на 0");
        }
        System.out.println("После оператора catch");
    }
}
