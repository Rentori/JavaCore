package chapter15;

interface MyFunction<T> {
    boolean func(T v1, T v2);
}

class HighTemp {
    private int hTepm;

    HighTemp(int ht) {
        hTepm = ht;
    }

    boolean sameTemp(HighTemp ht2) {
        return hTepm == ht2.hTepm;
    }

    boolean lessThanTemp(HighTemp ht2) {
        return hTepm < ht2.hTepm;
    }
}

public class InstanceMethWithObjectRefDemo {
    static <T> int counter(T[] vals, MyFunction<T> f, T v) {
        int count = 0;

        for(int i = 0; i < vals.length; i++) {
            if (f.func(vals[i], v)) count++;
        }
        return count;
    }

    public static void run() {
        int count;

        HighTemp[] weekDayHighs = {
                new HighTemp(89), new HighTemp(82),
                new HighTemp(90), new HighTemp(89),
                new HighTemp(89), new HighTemp(91),
                new HighTemp(84), new HighTemp(83)
        };
        count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(89));

        System.out.println("Дней, когда максимальная температура была 89: " + count);

        HighTemp[] weekDayHighs2 = {
                new HighTemp(32), new HighTemp(12),
                new HighTemp(24), new HighTemp(19),
                new HighTemp(18), new HighTemp(12),
                new HighTemp(-1), new HighTemp(13)
        };
        count = counter(weekDayHighs2, HighTemp::sameTemp, new HighTemp(12));
        System.out.println("Дней, когда максимальная температура была 12: " + count);

        count = counter(weekDayHighs, HighTemp::lessThanTemp, new HighTemp(89));
        System.out.println("Дней, когда температура была меньше чем 89: " + count);

        count = counter(weekDayHighs2, HighTemp::lessThanTemp, new HighTemp(19));
        System.out.println("Дней, когда температура была меньше чем 19: " + count);
    }
}
