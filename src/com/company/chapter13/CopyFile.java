package chapter13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    private static final String inPath = "/home/viktor/java-projects/JavaCore/src/chapter13/test.txt";
    private static final String outPath = "/home/viktor/java-projects/JavaCore/src/chapter13/copyTest.txt";

    public static void run() {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        try {
            fin = new FileInputStream(inPath);
            fout = new FileOutputStream(outPath);

            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода вывода: " + e);
        } finally {
            try {
                if (fin != null) fin.close();
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файла ввода");
            }
            try {
                if (fout != null) fout.close();
            } catch (IOException e2) {
                System.out.println("Ошибка закрытия файла вывода");
            }
        }
    }
}
