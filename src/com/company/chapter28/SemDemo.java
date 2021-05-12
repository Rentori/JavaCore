package chapter28;

import java.util.concurrent.Semaphore;

public class SemDemo {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        new Thread(new IncThread(sem, "A")).start();
        new Thread(new DecThread(sem, "B")).start();
    }
}

class Shared {
    static int count = 0;
}

class IncThread implements Runnable {
    String name;
    Semaphore sem;

    IncThread(Semaphore sem, String name) {
        this.name = name;
        this.sem = sem;
    }

    @Override
    public void run() {
        System.out.println("Start " + name + " thread");
        try {
            System.out.println(name + " thread waiting for accept");
            sem.acquire();
            System.out.println(name + " thread recive accept");

            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        System.out.println(name + " thread free accept");
        sem.release();
    }
}

class DecThread implements Runnable {
    String name;
    Semaphore sem;

    DecThread(Semaphore sem, String name) {
        this.name = name;
        this.sem = sem;
    }

    @Override
    public void run() {
        System.out.println("Start " + name + " thread");
        try {
            System.out.println(name + " thread waiting for accept");
            sem.acquire();
            System.out.println(name + " thread recive accept");

            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        System.out.println(name + " thread free accept");
        sem.release();
    }
}
