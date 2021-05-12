package chapter15;

interface MyFunc {
    int func(int n);
}

public class VarCapture {
    public static void run() {
        int num = 10;

        MyFunc myLambda = n -> {
            int v = num + n;
            return v;
        };
    }
}
