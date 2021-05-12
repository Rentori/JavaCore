package chapter13;

import java.io.PrintWriter;

public class PrintWriterDemo {
    public static void run() {
        PrintWriter pw = new PrintWriter(System.out, true);

        pw.println("Это строка");
        int n = -7;
        pw.println(n);
        double d = 4.5e-7;
        pw.println(d);
    }
}
