package chapter10;

public class FinallyDemo {
    public static void procA() {
        try {
            System.out.println("В теле метода procA()");
            throw new RuntimeException("демонстрация");
        }
        finally {
            System.out.println("блок оператора finally в методе procA()");
        }
    }

    public static void procB() {
        try {
            System.out.println("В теле метода procB()");
            return;
        }
        finally {
            System.out.println("блок оператора finally в методе procB()");
        }
    }

    public static void procC() {
        try {
            System.out.println("В теле метода procC");
        }
        finally {
            System.out.println("В блоке оператора finally в методе procC");
        }
    }

    public static void run() {
        try {
            procA();
        }
        catch (Exception e) {
            System.out.println("Исключение перехвачено");
        }
    }
}
