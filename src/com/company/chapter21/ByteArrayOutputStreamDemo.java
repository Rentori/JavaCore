package chapter21;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamDemo {
    static final String path = "/home/viktor/java-projects/JavaCore/src/chapter21/chapter21.txt";
    public static void main(String[] args) {
        ByteArrayOutputStream f = new ByteArrayOutputStream();
        String s = "Эти данные должны быть введены в массив";
        byte[] buf = s.getBytes();

        try {

            f.write(buf);
        } catch (IOException e) {
            System.out.println("Buffer write exception");
            return;
        }

        System.out.println("Буффер в виде символьной строки");
        System.out.println(f.toString());
        System.out.println("В массив");
        byte[] b = f.toByteArray();
        for (int i = 0; i < b.length; i++) {
            System.out.println((char) b[i]);
        }
        System.out.println("\n Поток вывода типа OutputStream()");
        try (FileOutputStream f2 = new FileOutputStream(path)) {
            f.writeTo(f2);
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
            return;
        }

        System.out.println("Установка в исходное состояние");
        f.reset();

        for (int i = 0; i < 3; i++) f.write('X');

        System.out.println(f.toString());

        }
    }

