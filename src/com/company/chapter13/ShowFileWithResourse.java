package chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ShowFileWithResourse {
    private static final String path = "/home/viktor/java-projects/JavaCore/src/chapter13/test.txt";

    public static void run() {
        int i;

        try (FileInputStream fin = new FileInputStream(path)) {
            do {
                i = fin.read();
                if (i != -1) System.out.println((char) i);
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
