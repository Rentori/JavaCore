package chapter10;

public class ChainExcDemo {
    public static void demoproc() {
        NullPointerException e = new NullPointerException("Верхний уровень");

        e.initCause(new ArithmeticException("Причина"));

        throw e;
    }

    public static void run() {
        try {
            demoproc();
        }
        catch (NullPointerException e) {
            System.out.println("Перехвачено исключение : " + e);
            System.out.println("Первопричина: " + e.getCause());
        }
    }

}
