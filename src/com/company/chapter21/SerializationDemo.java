package chapter21;

import java.io.*;

public class SerializationDemo {
    static final String path = "/home/viktor/java-projects/JavaCore/src/chapter21/chapter21.txt";

    public static void main(String[] args) {
        try (ObjectOutputStream objOStrim = new ObjectOutputStream(new FileOutputStream(path))) {
            MyClass object1 = new MyClass("Hello", 15, 12.124);
            System.out.println("object1: " + object1);
            objOStrim.writeObject(object1);
        } catch (IOException e) {
            System.out.println(e);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            MyClass object2 = (MyClass) ois.readObject();
            System.out.println("object2: " + object2);
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}

class MyClass implements Serializable {
    String s;
    int i;
    double d;

    public MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "s='" + s + '\'' +
                ", i=" + i +
                ", d=" + d +
                '}';
    }
}
