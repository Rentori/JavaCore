package chapter11;

public class CurrentThreadDemo {
    public static void main(String[] args) {

        Thread t = Thread.currentThread();
        System.out.println("Current thread: " + t);

        t.setName("My thread");
        System.out.println("After set name:" + t);

        try {
            for (int n = 0; n < 50; n--) {
                for (int i = 0; i < 50; i++) {
                    System.out.print("*");
                    Thread.sleep(1000);
                }
                System.out.println();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupted");
        }
    }
}
