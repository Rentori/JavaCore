package chapter28;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
        System.out.println("Threads starting");
        new Thread(new MyThread1(cb, "A")).start();
        new Thread(new MyThread1(cb, "B")).start();
        new Thread(new MyThread1(cb, "C")).start();
        new Thread(new MyThread1(cb, "A")).start();
        new Thread(new MyThread1(cb, "B")).start();
        new Thread(new MyThread1(cb, "C")).start();
    }
}

class MyThread1 implements Runnable {
    CyclicBarrier cbar;
    String name;

    public MyThread1(CyclicBarrier cbar, String name) {
        this.cbar = cbar;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);

        try {
            cbar.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            e.getStackTrace();
        }
    }
}

class BarAction implements Runnable {
    @Override
    public void run() {
        System.out.println("Barrier achieved");
    }
}
