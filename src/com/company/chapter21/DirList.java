package chapter21;

import java.io.File;
import java.io.InputStream;

public class DirList {
    static final String dirname = "/home/viktor/java-projects/JavaCore/src/chapter13";

    public static void main(String[] args) {
        File f1 = new File(dirname);

        if(f1.isDirectory()) {
            System.out.println("Directory: " + dirname);
            String s[] = f1.list();

            for (int i = 0; i < s.length; i++) {
                File f = new File(dirname + "/" + s[i]);
                if (f.isDirectory()) {
                    System.out.println(s[i] + " is a directory");
                }else {
                    System.out.println(s[i] + " is a file");
                }
            }
        } else {
            System.out.println(dirname + " is not a directory");
        }
    }
}
