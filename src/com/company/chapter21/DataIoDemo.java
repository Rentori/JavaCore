package chapter21;

import java.io.*;

public class DataIoDemo {
    static final String path = "/home/viktor/java-projects/JavaCore/src/chapter21/chapter21.txt";
    
    public static void main(String[] args) throws Exception {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(path))) {
            dos.writeDouble(98.6);
            dos.writeInt(1000);
            dos.writeBoolean(true);
        } catch (FileNotFoundException e) {
            System.out.println("File cannot find");
            return;
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(path))) {
            double d = dis.readDouble();
            int i = dis.readInt();
            boolean b = dis.readBoolean();

            System.out.printf("Получаемые значения: %.1f, %d, %b\n", d, i, b);
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }
    }
}

