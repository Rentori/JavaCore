package chapter28;

import java.util.concurrent.Semaphore;

public class ProdCon {
    public static void main(String[] args) {
        Q q = new Q();
        new Thread(new Consumer(q), "Consumer").start();
        new Thread(new Producer(q), "Producer").start();
    }
}

class Q {
    int n;

    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get() {
        try {
            semCon.acquire();

        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        System.out.println("Recive: " + n);
        semProd.release();
    }

    void put(int i) {
        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        this.n = i;
        System.out.println("Send: " + n);
        semCon.release();
    }
}

class Producer implements Runnable {
    Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) { q.put(i); }
    }
}

class Consumer implements Runnable {
    Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) { q.get(); }
    }
}
