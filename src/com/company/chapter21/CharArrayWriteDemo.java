package chapter21;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CharArrayWriteDemo {
    public static void main(String[] args) throws IOException {
        CharArrayWriter f = new CharArrayWriter();
        String s = " Эти данные должны быть внесены в массив";
        char buf[] = s.toCharArray();

        try {
            f.write(buf);
        } catch (IOException e) {
            System.out.println(e);
            return;
        }
        System.out.println("Буфер в виде символьной строки: ");
        System.out.println(f.toString());
        System.out.println("В массив");

        char[] c = f.toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }

        System.out.println("\nВ поток вывода типа FileWriter()");

        try {
            FileWriter f2 = new FileWriter("/home/viktor/java-projects/JavaCore/src/chapter21/chapter21.txt");
            f.writeTo(f2);
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("Установка в исходное состояние");
        f.reset();

        for (int i = 0; i < 3; i++) {
            f.write('X');
        }
        System.out.println(f.toString());
    }
}
