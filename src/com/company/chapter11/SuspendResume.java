package chapter11;

class NewThread5 implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    NewThread5(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        suspendFlag = false;
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                System.out.println(t.getState());
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        System.out.println(name + " finished");
    }

    synchronized void mySuspend() {
        suspendFlag = true;
    }
    synchronized void meResume() {
        suspendFlag = false;
        notify();
    }
}

public class SuspendResume {
    public static void main(String[] args) {
        NewThread5 ob1 = new NewThread5("One");
        NewThread5 ob2 = new NewThread5("Two");

        try {
            Thread.sleep(1000);
            ob1.mySuspend();
            System.out.println("Suspend of the thread one");
            Thread.sleep(1000);
            ob1.meResume();
            System.out.println("Resume of the thread one");
            ob2.mySuspend();
            System.out.println("Suspend of the thread two");
            Thread.sleep(1000);
            ob2.meResume();
            System.out.println("Resume of the thread two");
        } catch (InterruptedException e) {
            e.getStackTrace();
        }

        try {
            System.out.println("Waiting");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        System.out.println("Main thread finished!");
    }
}
