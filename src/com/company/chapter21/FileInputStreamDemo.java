package chapter21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
    static final String path = "/home/viktor/java-projects/JavaCore/src/chapter21/chapter21.txt";

    public static void main(String[] args) {
        int size;

        try (FileInputStream fis = new FileInputStream(path)) {
            System.out.println("Общее количество доступных байтов: " + (size = fis.available()));

            int n  = size/40;
            System.out.println("Первые " + n + " байтов, прочитанные методом read()");
            for (int i = 0; i < n; i++) {
                System.out.print((char) fis.read());
            }

            System.out.println("\n Все ещё доступно: " + fis.available());
            System.out.println("Чтение следующих " + n + " байтов методом read(b[])");
            byte[] b = new byte[n];
            if (fis.read(b) != n) {
                System.err.println("Нельзя прочитать " + n + " байтов");
            }
            System.out.println(new String(b, 0, n));
            System.out.println("\n Все еще доступно " + (size = fis.available()));
            System.out.println("Пропустить половину оставщихся байтов методом skip()");
            fis.skip(size/2);
            System.out.println("Все еще доступно: " + fis.available());
            System.out.println("Чтение " + n/2 + " байтов, размещенных в конце массива");
            if (fis.read(b, n/2, n/2) != n/2) {
                System.err.println("Нельзя прочитать " + n/2 + " байтов");
            }

            System.out.println(new String(b, 0, b.length));
            System.out.println("Все еще доступно: " + fis.available());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
