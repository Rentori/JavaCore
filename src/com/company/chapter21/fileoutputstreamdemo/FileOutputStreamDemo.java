package chapter21.fileoutputstreamdemo;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        String source = "Now is the time for all good man\n"
                + " to come to the aid of theif county\n"
                + " and pay their due taxes";
        byte[] buf = source.getBytes();
        FileOutputStream fos1 = null;
        FileOutputStream fos2 = null;
        FileOutputStream fos3 = null;

        try {
            fos1 = new FileOutputStream("/home/viktor/java-projects/JavaCore/src/chapter21/fileoutputstreamdemo/test1.txt.txt");
            fos2 = new FileOutputStream("/home/viktor/java-projects/JavaCore/src/chapter21/fileoutputstreamdemo/test2.txt.txt");
            fos3 = new FileOutputStream("/home/viktor/java-projects/JavaCore/src/chapter21/fileoutputstreamdemo/test3.txt");

            for (int i = 0; i < buf.length; i += 2) {
                fos1.write(buf[i]);
            }

            fos2.write(buf);

            fos3.write(buf, buf.length-buf.length/4, buf.length/4);
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
        finally {
            try {
                if (fos1 != null) fos1.close();
            } catch (IOException e) {
                System.out.println("IO Exception of test1.txt");
            }
            try {
                if (fos2 != null) fos2.close();
            } catch (IOException e) {
                System.out.println("IO Exception of test2.txt");
            }
            try {
                if (fos3 != null) fos3.close();
            } catch (IOException e) {
                System.out.println("IO Exception of test3");
            }
        }
    }
}
