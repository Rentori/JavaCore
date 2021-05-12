package chapter20;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScanMixed {
    static final String path = "/home/viktor/java-projects/JavaCore/src/chapter20/test.txt";

    public static void main(String[] args) throws IOException {
        int i;
        double d;
        boolean b;
        String s;

        FileWriter fr = new FileWriter(path);
        fr.write("Тестирование Scanner 10 12.2 один true два false");
        fr.close();

        Scanner scr = new Scanner(new FileReader(path));

        while (scr.hasNext()) {
            if (scr.hasNextInt()) {
                i = scr.nextInt();
                System.out.println("int: " + i);
            }
            else if (scr.hasNextDouble()) {
                d = scr.nextDouble();
                System.out.println("double: " + d);
            }
            else if (scr.hasNextBoolean()) {
                b = scr.nextBoolean();
                System.out.println("boolean: " + b);
            }
            else {
                s = scr.next();
                System.out.println("String: " + s);
            }
        }
        scr.close();
    }
}
