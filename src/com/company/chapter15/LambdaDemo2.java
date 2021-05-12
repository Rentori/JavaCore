package chapter15;

interface NumericTest {
    boolean test(int n);
}

public class LambdaDemo2 {
    public static void run() {
        NumericTest isEven = (n) -> (n % 2) == 0;

        if (isEven.test(10)) {
            System.out.println("Число 10 четное");
        }
        if (!isEven.test(9)) {
            System.out.println("ЧИсло 9 не чётное");
        }

        NumericTest isNonNeg = (n) -> n >= 0;

        if (isNonNeg.test(1)) {
            System.out.println("Число 1 не отрицательное");
        }
        if (!isNonNeg.test(-1)) {
            System.out.println("Число -1 отрицательное");
        }
    }
}
