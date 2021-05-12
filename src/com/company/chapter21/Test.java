package chapter21;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        String path = "/home/viktor/java-projects/JavaCore/src/chapter21/chapter21.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int c = 0;
            while ((c = br.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

}
