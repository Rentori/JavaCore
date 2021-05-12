package chapter20;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SetDelimiters {
    static final String path = "/home/viktor/java-projects/JavaCore/src/chapter20/test.txt";

    public static void main(String[] args) throws IOException {
        int count = 0;
        double sum = 0.0;

        FileWriter fr = new FileWriter(path);
        fr.write("2, 3, 5, 7, 9, 10, ready");
        fr.close();

        Scanner src = new Scanner(new FileReader(path));
        src.useDelimiter(", *");

        while (src.hasNext()) {
            if (src.hasNextDouble()) {
                sum += src.nextDouble();
                count++;
            }
            else {
                String str = src.next();
                if (str.equals("ready")) break;
                else {
                    System.out.println("Format error");
                    return;
                }
            }
        }
        src.close();
        System.out.println("Avg " + sum/count);
    }
}
