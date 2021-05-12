package chapter21.SISD;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

class InputStreamEnumerator implements Enumeration<FileInputStream> {
    private final Enumeration<String> files;

    public InputStreamEnumerator(Vector<String> files){
        this.files = files.elements();
    }

    @Override
    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    @Override
    public FileInputStream nextElement() {
        try {
            return new FileInputStream(files.nextElement());
        } catch (IOException e) {
            return null;
        }
    }
}
public class SequenceInputStreamDemo {
    public static void main(String[] args) {
        int c;
        Vector<String> files = new Vector<>();

        files.addElement("/home/viktor/java-projects/JavaCore/src/chapter21/SISD/text1.txt");
        files.addElement("/home/viktor/java-projects/JavaCore/src/chapter21/SISD/text2.txt");
        files.addElement("/home/viktor/java-projects/JavaCore/src/chapter21/SISD/text3.txt");
        InputStreamEnumerator ise = new InputStreamEnumerator(files);
        InputStream input = new SequenceInputStream(ise);

        try {
            while ((c = input.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (NullPointerException e) {
            System.out.println("Open file exception");
        } catch (IOException e) {
            System.out.println("IO ecxeption: " + e);
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                System.out.println("SequenceInput close exception");
            }
        }
    }
}
