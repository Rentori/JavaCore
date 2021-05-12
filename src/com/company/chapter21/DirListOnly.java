package chapter21;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

class OnlyExt implements FilenameFilter {
    String ext;
    public OnlyExt(String ext) {
        this.ext = "." + ext;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(ext);
    }
}
public class DirListOnly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dirname = "/home/viktor/java-projects/JavaCore/src/chapter13";
        File f1 = new File(dirname);
        String filter = scanner.next();
        FilenameFilter only = new OnlyExt(filter);
        String[] s = f1.list(only);

        if (s.length != 0) {
            for (int i = 0; i < s.length; i++) {
                System.out.println(s[i]);
            }
        } else {
            System.out.printf("Файл %s не найден", "html");
        }

    }
}
