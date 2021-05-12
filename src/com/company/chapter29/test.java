package chapter29;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Original list: ");
        for (int i = 0; i < 15; i++) {
            list.add(random.nextInt(20));
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        System.out.print("Enter a num: ");
        int num = in.nextInt();
        System.out.println();

        System.out.print("Sorted list: ");
        Stream<Integer> sortedStream = list.stream().sorted().filter((n) -> n < num);
        sortedStream.forEach((n) -> System.out.print(n + " "));

        long count = list.stream().count();
        System.out.println(count);
    }
}
