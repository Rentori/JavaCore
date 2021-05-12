package chapter28;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpExec {
    public static void main(String[] args) {
        CountDownLatch cd1 = new CountDownLatch(5);
        CountDownLatch cd2 = new CountDownLatch(5);
        CountDownLatch cd3 = new CountDownLatch(5);
        CountDownLatch cd4 = new CountDownLatch(5);
        ExecutorService ex = Executors.newFixedThreadPool(1);

        System.out.println("Threads start.");
        ex.execute(new MyThread3(cd1, "A"));
        ex.execute(new MyThread3(cd2, "B"));
        ex.execute(new MyThread3(cd3, "C"));
        ex.execute(new MyThread3(cd4, "D"));

        try {
            cd1.await();
            cd2.await();
            cd3.await();
            cd4.await();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        ex.shutdown();
        System.out.println("Threads finished!");
    }
}

class MyThread3 implements Runnable {
    String name;
    CountDownLatch latch;

    public MyThread3(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
        new Thread(this);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }
}
