package chapter21.filewriterdemo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileWriterDemo {
    static final String path1 = "/home/viktor/java-projects/JavaCore/src/chapter21/filewriterdemo/test1.txt.txt";
    static final String path2 = "/home/viktor/java-projects/JavaCore/src/chapter21/filewriterdemo/test2.txt.txt";
    static final String path3 = "/home/viktor/java-projects/JavaCore/src/chapter21/filewriterdemo/test3.txt";

    public static void main(String[] args) throws IOException {
        String source = """
                Now is the time for all good man
                to come to the aid of their country
                and pay their due taxes.""";
        char[] buffer = source.toCharArray();

        try (FileWriter f0 = new FileWriter(path1);
             FileWriter f1 = new FileWriter(path2);
             FileWriter f2 = new FileWriter(path3)) {
            for (int i = 0; i < buffer.length; i += 2) {
                f0.write(buffer[i]);
            }

            f1.write(buffer);

            f2.write(buffer, buffer.length - buffer.length / 4, buffer.length / 4);

        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
