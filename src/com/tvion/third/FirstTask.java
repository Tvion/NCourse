package com.tvion.third;

import java.util.Arrays;

public class FirstTask {
    public static void main(String[] args) {
        int[] ints = new int[1000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * 1000);
        }
        System.out.println(Arrays.toString(ints));
        bubbleSorts(ints);
        selectSort(ints);
        libSort(ints);
    }

    //Пузырек
    public static int[] bubbleSorts(int[] sourceArray) {
        int[] intArray = sourceArray.clone();
        long startTime = System.nanoTime();
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i; j < intArray.length; j++) {
                if (intArray[j] < intArray[i]) {
                    int c = intArray[i];
                    intArray[i] = intArray[j];
                    intArray[j] = c;
                }
            }
        }
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Bubble Time =" + estimatedTime);
        return intArray;
    }

    //    Выбор
    public static int[] selectSort(int[] sourceArray) {
        int[] intArray = sourceArray.clone();
        long startTime = System.nanoTime();
        int minIndex;
        for (int i = 0; i < intArray.length; i++) {
            int min = intArray[i];
            minIndex = i;
            for (int j = i; j < intArray.length; j++) {
                if (intArray[j] < min) {
                    min = intArray[j];
                    minIndex = j;
                }
            }
            int c = intArray[i];
            intArray[i] = min;
            intArray[minIndex] = c;


        }

        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Select Time =" + estimatedTime);
        return intArray;
    }

    // Библиотечная QuickSort
    public static int[] libSort(int[] sourceArray) {
        int[] intArray = sourceArray.clone();
        long startTime = System.nanoTime();
        Arrays.sort(intArray);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Arrays sort Time =" + estimatedTime);
        return intArray;
    }
}
