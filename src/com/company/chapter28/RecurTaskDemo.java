package com.company.chapter28;

import java.util.concurrent.*;

public class RecurTaskDemo {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        double[] data = new double[5000];

        for (int i = 0; i < data.length; i++)
            data[i] = (((i%2) == 0) ? i : -i);

        Sum task = new Sum(data, 0, data.length);
        double summation = forkJoinPool.invoke(task);
        System.out.println(summation);
    }
}

class Sum extends RecursiveTask<Double> {
    final int seqThreshold = 500;
    double[] data;
    int start, end;

    public Sum(double[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {
        double sum = 0;

        if((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) sum += data[i];
        }
        else {
            int middle = (start + end) / 2;
            Sum taskA = new Sum(data, start, middle);
            Sum taskB = new Sum(data, middle, end);

            taskA.fork();
            taskB.fork();
            sum = taskA.join() + taskB.join();
        }
        return sum;
    }
}
