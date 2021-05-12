package chapter15;

interface MyNumber {
    double getValue();
}

public class LambdaDemo {
    public static void run() {
        MyNumber num;

        num = () -> 123.45;
        System.out.println("Фиксированное значение: " + num.getValue());

        num = () -> Math.random() * 100;
        System.out.println("Случайное значение: " + num.getValue());
        System.out.println("Случайное значение: " + num.getValue());

    }
}
