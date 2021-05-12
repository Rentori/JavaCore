package chapter10;

class MyException extends Exception {
    private final int detail;

    public MyException(int detail) {
        this.detail = detail;
    }

    public String toString() {
        return "MyException[" + detail + "]";
    }
}

public class ExceptionDemo {
    public static void compute(int a) throws Exception {
        System.out.println("Вызван метод compute(" + a + ")");
        if (a > 10) {
            throw new MyException(a);
        }
        System.out.println("Нормальное завершение");
    }

    public static void run() throws Exception {
        try {
            compute(1);
            compute(20);
        } catch (MyException e) {
            System.out.println("Перехвачено исключение " + e);
        }
    }
}
