package chapter22;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class NIOStreamWrite {
    public static void main(String[] args) {
        try (OutputStream os = Files.newOutputStream(Paths.get("src/chapter22/test.txt"))) {
            for (int i = 0; i < 26; i++) {
                os.write((byte)'B' + i);
            }

        } catch (InvalidPathException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
