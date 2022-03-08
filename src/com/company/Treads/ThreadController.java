package com.company.Treads;

import com.company.Generation.Generator;
import com.company.Solving.Calculator;

public class ThreadController {
    private static final Generator generator = new Generator();
    private static final Calculator calculator = new Calculator();

    public static Thread createCalculationThread() {
        Runnable calculationTask = () -> {
            String str;
            while (!generator.values.isEmpty()) {
                synchronized (generator) {
                    str = generator.values.pollFirst();
                }
                if (str == null)
                    return;
                System.out.println(calculator.calculateString(str));
            }
        };
        return new Thread(calculationTask);
    }

    public static void workWithThreads(int amountThreads, int amountExpressions) {
        if (amountThreads < 1)
            return;

        long startTime = System.nanoTime();

        generator.generate( amountExpressions );
        Thread[] threads = new Thread[amountThreads];
        for (int i = 0; i < amountThreads; i++) {
            threads[i] = createCalculationThread();
            threads[i].start();
        }
        for (Thread thread :
                threads) {
            try {
                if (thread.isAlive())
                    thread.join();
            } catch (InterruptedException e) {
                System.out.println("Вычисления проводились " + (System.nanoTime() - startTime) + " нс");
                return;
            }
        }
        System.out.println("Вычисления проводились " + (System.nanoTime() - startTime) + " нс");
    }
}
