package com.tvion.third;

public class SecondTask {
    public static void main(String[] args) {
        long startTime;
        long estimatedTime;
        int factorial1;
        int factorial2;
        startTime = System.nanoTime();
        factorial1 = factCycle(1000);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Factorial 1000 = " + factorial1);
        System.out.println("Factorial was calculated by cycle in " + estimatedTime);

        startTime = System.nanoTime();
        factorial2 = factRecursive(1000);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Factorial 1000 = " + factorial2);
        System.out.println("Factorial was calculated by recursion in " + estimatedTime);
    }

    public static int factCycle(int n) {
        int result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    public static int factRecursive(int n) {
        if (n == 0) return 1;
        return n * factRecursive(n - 1);
    }
}
