package chapter28;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int curPhase;

        System.out.println("Threads start");

        new Thread(new MyThread2(phaser, "A")).start();
        new Thread(new MyThread2(phaser, "B")).start();
        new Thread(new MyThread2(phaser, "C")).start();

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " finished");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " finished");

        curPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " finished");


        phaser.arriveAndDeregister();
        if(phaser.isTerminated()) {
            System.out.println("Phaser sincronized finished!");
        }
    }
}

class MyThread2 implements Runnable {
    Phaser phaser;
    String name;

    MyThread2(Phaser p, String n) {
        phaser = p;
        name = n;
        phaser.register();
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + " starting first phase");
        phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }

        System.out.println("Thread " + name + " starting second phase");
        phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }

        System.out.println("Thread " + name + " starting third phase");
        phaser.arriveAndAwaitAdvance();
    }
}
