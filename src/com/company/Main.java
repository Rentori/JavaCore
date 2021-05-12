package com.company;

abstract class Test {
    private int count;

    public Test (int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

class MainTest extends Test {
    public MainTest(int count) {
        super(count);
    }

}
public class Main {
    public static void main(String[] args) throws Exception {
        Test test = new MainTest(12);
        System.out.println(test.getCount());
        test.setCount(52);
        System.out.println(test.getCount());
    }
}







