package chapter22;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class NIOCopy {
    public static void main(String[] args) {
        try {
            Path source = Paths.get("src/chapter22/test.txt");
            Path target = Paths.get("src/chapter22/test.txt2");

            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути: " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода вывода: " + e);
        }
    }
}
