package chapter22;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.sql.SQLOutput;

public class ShowFIle {
    public static void main(String[] args) {
        int i;

        try (InputStream in = Files.newInputStream(Paths.get("src/chapter22/test.txt"))) {
            do {
                i = in.read();
                if ( i != -1 ) System.out.print((char) i);
            } while (i != -1);
        } catch (InvalidPathException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

