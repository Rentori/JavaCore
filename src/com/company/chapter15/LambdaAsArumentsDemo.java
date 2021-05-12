package chapter15;

interface StringFunct {
    String func(String n);
}

public class LambdaAsArumentsDemo {
    static String stringOp(StringFunct sf, String s) {
        return sf.func(s);
    }

    public static void run() {
        String inStr = "Лямбда-выражения повышают эффективность Java";
        String outStr;

        System.out.println("Исходная строка: " + inStr);

        outStr = stringOp(str -> str.toUpperCase(), inStr);
        System.out.println("Строка прописными буквами: " + outStr);

        outStr = stringOp(str -> {
            String result = "";
            int i;

            for (i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ') {
                    result += str.charAt(i);
                }
            }
            return result;
        }, inStr);

        System.out.println("Строка с удалёнными пробелами: " + outStr);

        StringFunct reverse = str -> {
            String result = "";
            int i;

            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };
        System.out.println("Обращенная строка: " + stringOp(reverse, inStr));
    }
}
