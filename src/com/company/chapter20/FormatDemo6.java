package chapter20;

import java.util.Calendar;
import java.util.Formatter;

public class FormatDemo6 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        Formatter fmt = new Formatter();

        fmt.format("Today is day %te of %<tB, %<tY", cal);
        System.out.println(fmt);
        fmt.close();
    }
}
