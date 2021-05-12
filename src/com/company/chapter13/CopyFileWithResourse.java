package chapter13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileWithResourse {
    private static final String inPath = "/home/viktor/java-projects/JavaCore/src/chapter13/test.txt";
    private static final String outPath = "/home/viktor/java-projects/JavaCore/src/chapter13/copyTest.txt";

    public static void run() {
        int i;

        try(FileInputStream fin = new FileInputStream(inPath);
            FileOutputStream fout = new FileOutputStream(outPath)) {
            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
