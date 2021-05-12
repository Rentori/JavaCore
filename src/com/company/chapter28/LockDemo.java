package chapter28;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new LockThread("A", lock);
        new LockThread("B", lock);
    }
}

class Shared1 {
    static int count = 0;
}

class LockThread implements Runnable {
    String name;
    ReentrantLock lock;

    public LockThread(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Thread " + name);
        try {
            System.out.println("Thread " + name + " waiting for count block");
            lock.lock();
            System.out.println("THread " + name + " blocking count");
            Shared1.count++;
            System.out.println("Thread " + name + ": " + Shared1.count);
            System.out.println("THread " + name + " waiting");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.getStackTrace();
        } finally {
            System.out.println("Thread " + name +  " unblock count");
            lock.unlock();
        }
    }
}
