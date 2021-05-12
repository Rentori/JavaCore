package chapter20;

import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {
        String months[] = {
                "Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec" };

        Calendar calendar = Calendar.getInstance();

        System.out.println("Date: " + months[calendar.get(Calendar.MONTH)] + " " +
                calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR));
        System.out.println("\nTime: " + calendar.get(Calendar.HOUR) + " " +
                calendar.get(Calendar.MINUTE) + " " + calendar.get(Calendar.SECOND));

        calendar.set(Calendar.HOUR, 10);
        calendar.set(Calendar.MINUTE, 29);
        calendar.set(Calendar.SECOND, 22);

        System.out.println("Changed time: " + calendar.get(Calendar.HOUR) + " " +
                calendar.get(Calendar.MINUTE) + " " + calendar.get(Calendar.SECOND));
        }
    }

