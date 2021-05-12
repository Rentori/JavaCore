package chapter15;

import java.util.Locale;

interface StringFunc {
    String func(String n);
}

public class BlockLambdaDemo2 {
    public static void run() {
        StringFunc reverse = str -> {
            String result = "";
            int i;

            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result.toLowerCase(Locale.ROOT);
        };

        System.out.println("Лямбда обращается на " + reverse.func("Лямбда"));
        System.out.println("Выражение обращается на " + reverse.func("Выражение"));
    }
}
