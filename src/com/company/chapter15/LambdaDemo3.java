package chapter15;

interface NumericTest2 {
    boolean test(int a, int b);

}

public class LambdaDemo3 {
    public static void run() {
        NumericTest2 isFactor = (a, b) -> (a % b) == 0;

        if (isFactor.test(10, 2)) System.out.println("Число 2 является множителем числа 10");
        if (!isFactor.test(10, 3)) System.out.println("Число 3 не является множителем числа 10");
    }
}
