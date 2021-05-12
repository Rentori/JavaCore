package chapter28;

import java.util.concurrent.CountDownLatch;

public class CDLDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        System.out.println("Start");

        new Thread(new MyThread(latch)).start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        System.out.println("Finish thread");
    }
}

class MyThread implements Runnable {
    CountDownLatch latch;

    MyThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            latch.countDown();
        }
    }
}
