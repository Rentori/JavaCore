package chapter22;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DIrList {
    public static void main(String[] args) {
        String dirName = "src/chapter21";

        try (DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Paths.get(dirName))) {
            System.out.println("Directory: " + dirName);

            for (Path entry: dirstrm) {
                BasicFileAttributes attribs = Files.readAttributes(entry, BasicFileAttributes.class);
                if (attribs.isDirectory()) {
                    System.out.print("<DIR> ");
                } else {
                    System.out.print("      ");
                }
                System.out.println(entry.getName(2));
            }
        } catch (InvalidPathException e) {
            System.out.println(e);
        } catch (NotDirectoryException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
