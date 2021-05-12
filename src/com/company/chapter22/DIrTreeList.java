package chapter22;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class MyFileVisitor extends SimpleFileVisitor<Path> {
    public FileVisitResult visitFile(Path path, BasicFileAttributes attribs) throws IOException {
        System.out.println(path);
        return FileVisitResult.CONTINUE;
    }
}

public class DIrTreeList {
    public static void main(String[] args) {
        String dirname = "/home/viktor/java-projects";

        System.out.println("Дерево каталогов, начиная с католога " + dirname + "n");

        try {
            Files.walkFileTree(Paths.get(dirname), new MyFileVisitor());
        } catch (IOException exc) {
            System.out.println(exc);
        }
    }
}
