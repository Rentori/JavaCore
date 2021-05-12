package chapter11;

class NewThread4 implements Runnable {
    String name;
    Thread t;

    NewThread4(String threadName) {
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

public class DemoJoin {
    public static void main(String[] args) {
        NewThread4 ob1 = new NewThread4("One");
        NewThread4 ob2 = new NewThread4("Two");
        NewThread4 ob3 = new NewThread4("Three");

        System.out.println("First thread running: " + ob1.t.isAlive());
        System.out.println("Second thread running: " + ob2.t.isAlive());
        System.out.println("Third thread running: " + ob3.t.isAlive());

        try {
            System.out.println("Waiting for thread finish");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Maint thread was inturrepted");
        }

        System.out.println("First thread running: " + ob1.t.isAlive());
        System.out.println("Second thread running: " + ob2.t.isAlive());
        System.out.println("Third thread running: " + ob3.t.isAlive());
        System.out.println("Main thread finished!");
    }
}
