package chapter20;

import java.util.Formatter;

public class FormatDemo {
    public static void main(String[] args) {

        try (Formatter fmt = new Formatter()) {
            fmt.format("Форматировать %s просто: %d %f", "Средствами Java", 10, 98.3);
            System.out.println(fmt);
        }
    }
}
