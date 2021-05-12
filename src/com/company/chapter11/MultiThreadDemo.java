package chapter11;

class NewThread3 implements Runnable {
    String name;
    Thread t;

    NewThread3(String threadName) {
        name = threadName;
        t = new Thread(this, threadName);
        System.out.println("New thread: " + t);
        t.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted");
        }
        System.out.println(name + " finished!");
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        new NewThread3("One");
        new NewThread3("Two");
        new NewThread3("Three");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted");
        }
        System.out.println("Main thread finished!");
    }
}
