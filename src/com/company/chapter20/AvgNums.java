package chapter20;

import java.util.Scanner;

public class AvgNums {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = 0;
        double sum = 0.0;

        System.out.println("Enter a nums for counting: ");

        while (in.hasNext()) {
            if (in.hasNextDouble()) {
                sum += in.nextDouble();
                count++;
            } else {
                String str = in.next();
                if (str.equals("ready")) {
                    break;
                } else {
                    System.out.println("Input of type error.");
                    return;
                }

            }
            in.close();
            System.out.println("Avg = " + (sum / count));
        }
    }
}
