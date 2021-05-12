package chapter11;

class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " enter to method A.foo()");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.getStackTrace();
        }
        System.out.println(name + " try to call method B.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("In method A.last()");
    }
}

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " enter to method B.bar()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        System.out.println(name + " try to call method A.last()");
        a.last();
    }

    synchronized void last() {
        System.out.println("In method B.last()");
    }
}

public class DeadLock implements Runnable{
    A a = new A();
    B b = new B();

    DeadLock() {
        Thread.currentThread().setName("Main thread");
        Thread t = new Thread(this, "rival thread");
        t.start();

        a.foo(b);
        System.out.println("Back to other thread");
    }

    public void run() {
        b.bar(a);
        System.out.println("Back to other thread");
    }

    public static void main(String[] args) {
        new DeadLock();
    }
}
