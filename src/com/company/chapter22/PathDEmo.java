package chapter22;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class PathDEmo {
    public static void main(String[] args) {
        Path filepath = Paths.get("/bin/X11");

        System.out.println("File name: " + filepath.getName(1));
        System.out.println("File path: " + filepath);
        System.out.println("Absolute file path: " + filepath.toAbsolutePath());
        System.out.println("Parent directory: " + filepath.getParent());

        if (Files.exists(filepath)) {
            System.out.println("File exists");
        } else {
            System.out.println("File not found");
        }

        try {
            if (Files.isHidden(filepath)) {
                System.out.println("File is hiden");
            } else {
                System.out.println("File is't hiden");
            }
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }

        if (Files.isWritable(filepath)) {
            System.out.println("File is ready for write");
        } else {
            System.out.println("File is close for write");
        }

        if (Files.isReadable(filepath)) {
            System.out.println("File is ready for read");
        } else {
            System.out.println("File is close for read");
        }

        try {
            BasicFileAttributes attribs = Files.readAttributes(filepath, BasicFileAttributes.class);

            if (attribs.isDirectory()) {
                System.out.println("It's a directory");
            } else {
                System.out.println("It's not a directory");
            }

            if (attribs.isRegularFile()) {
                System.out.println("It's a regular file");
            } else {
                System.out.println("It's not a regular file");
            }

            if (attribs.isSymbolicLink()) {
                System.out.println("It's a symbolic link");
            } else {
                System.out.println("It's not a symbolic link");
            }

            System.out.println("Last modified time: " + attribs.lastModifiedTime());
            System.out.println("File size: " + attribs.size());
        } catch (IOException e) {
            System.out.println("Attributes reading exception: " + e);
        }
    }
}
