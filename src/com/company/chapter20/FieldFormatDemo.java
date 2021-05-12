package chapter20;

import java.util.Formatter;

public class FieldFormatDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Formatter fmt = new Formatter();
            fmt.format("%5d %5d %5d", i, i*i, i*i*i);
            System.out.println(fmt);
            fmt.close();
        }
    }
}
