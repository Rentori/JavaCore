package chapter28;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class FJExperiment {
    public static void main(String[] args) {
        int pLevel;
        int threshold;

        pLevel = 4;
        threshold = 10000;
        long beginT, endT;

        ForkJoinPool forkJoinPool = new ForkJoinPool(pLevel);
        double[] numbs = new double[1000000];
        for (int i = 0; i < numbs.length; i++) {
            numbs[i] = i;
        }
        Transform task = new Transform(threshold, numbs, 0, numbs.length);
        beginT = System.nanoTime();
        forkJoinPool.invoke(task);
        endT = System.nanoTime();
        System.out.println("Parallel level: " + pLevel);
        System.out.println("Threshold: " + threshold);
        System.out.println("Time: " + (endT - beginT) + "ns");
    }
}

class Transform extends RecursiveAction {
    int seqThreshold;
    double[] data;
    int start, end;

    public Transform(int seqThreshold, double[] data, int start, int end) {
        this.seqThreshold = seqThreshold;
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        } else {
            int middle = (start + end) / 2;
            invokeAll(new SqrtTransform(data, start, middle), new SqrtTransform(data, middle, end));
        }
    }
}
