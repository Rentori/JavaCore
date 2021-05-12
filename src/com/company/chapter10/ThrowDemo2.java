package chapter10;

public class ThrowDemo2 {
    public static void throwOne() throws IllegalAccessException {
        System.out.println("В теле метода throwOne");
        throw new IllegalAccessException("Демонстрация");
    }

    public static void run() {
        try {
            throwOne();
        } catch (IllegalAccessException e) {
            System.out.println("Перехвачено исключение " + e);
        }
    }
}

