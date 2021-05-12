package chapter20;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AvgFile {
    static final String path = "/home/viktor/java-projects/JavaCore/src/chapter20/test.txt";

    public static void main(String[] args) throws IOException {
        int count = 0;
        double sum = 0;
        String num;
        for (int i = 0; i < 100; i++) {
            FileWriter fout = new FileWriter(path, true);
            fout.write("2 3.4 5 6 7.4 9.1 10.5\n");
            fout.close();

            FileReader fr = new FileReader(path);
            Scanner src = new Scanner(fr);

            while (src.hasNext()) {
                num = src.next();
                try {
                    sum += Double.parseDouble(num);
                    count++;
                }
                catch (Exception e) {
                    if (num.equals("ready")) {
                        break;
                    }
                    else {
                        throw e;
                    }
                }

            }
            src.close();
            System.out.println("Avg = " + (sum/count));
        }

    }
}
