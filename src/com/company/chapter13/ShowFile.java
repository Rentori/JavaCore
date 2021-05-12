package chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ShowFile {
    private static final String path = "/home/viktor/java-projects/JavaCore/src/chapter13/test.txt";

    public static void run() {
        int i;
        FileInputStream fin;

        try {
            fin = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно открыть файл");
            return;
        }

        try {
            do {
                i = fin.read();
                if (i != -1) System.out.println((char) i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }

        try {
            fin.close();
        } catch (IOException e) {
            System.out.println("Ошибка закрытия файла");
        }
    }
}
