package chapter28;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        es.execute(new AtomThread("A"));
        es.execute(new AtomThread("B"));
        es.execute(new AtomThread("C"));
        es.shutdown();
    }
}

class Shared3 {
    static AtomicInteger ai = new AtomicInteger(0);
}

class AtomThread implements Runnable {
    String name;

    @Override
    public void run() {
        System.out.println("Start thread " + name);
        for (int i = 1; i <= 3; i++) {
            System.out.println("Recive from thread " + name + ": " + Shared3.ai.getAndSet(i));
        }
    }

    public AtomThread(String name) {
        this.name = name;
        new Thread(this).start();
    }
}
