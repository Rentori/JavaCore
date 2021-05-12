package chapter21;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamDemo {
    public static void main(String[] args) throws Exception{
        String tmp = "abc";
        byte[] b = tmp.getBytes();
        ByteArrayInputStream input1 = new ByteArrayInputStream(b);

        for (int i = 0; i < 2; i++) {
            int c;
            while ((c=input1.read()) != -1) {
                if ( i == 0) {
                    System.out.println((char) c);
                } else {
                    System.out.println(Character.toUpperCase((char) c));
                }
            }
            System.out.println();
            input1.reset();
        }

    }
}
