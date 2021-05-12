package chapter10;

public class ThrowDemo {
    public static void run() {
        try {
            demoProc();
        }
        catch (NullPointerException e) {
            System.out.println("Повторный перехват: " + e);
        }
    }

    public static void demoProc() {
        try {
            throw new NullPointerException("демонстрация");
        }
        catch (NullPointerException e) {
            System.out.println("Исключение перехвачено в теле метода demoProc");
            throw e;
        }
    }
}


