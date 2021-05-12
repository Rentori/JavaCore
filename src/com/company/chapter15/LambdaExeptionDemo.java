package chapter15;

interface DoubleNumericArrayFunc {
    double func(double[] n) throws EmptyArrayExeption;
}

class EmptyArrayExeption extends Exception {
    EmptyArrayExeption() {
        super("Массив пуст");
    }
}

public class LambdaExeptionDemo {
    public static void run() throws EmptyArrayExeption{
        double[] values = {1.0, 2.0, 3.0, 4.0};

        DoubleNumericArrayFunc average = n -> {
            double sum = 0;

            if (n.length == 0) throw new EmptyArrayExeption();

            for (int i = 0; i < n.length; i++) {
                sum += n[i];
            }
            return sum / n.length;
        };

        System.out.println("Среднее равно: " + average.func(values));
        System.out.println("Среднне равно: " + average.func(new double[0]));
    }
}
