package com.tvion.third;


import java.util.Arrays;

public class Common {
    public static void main(String[] args) {
        int[] ints = new int[100];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * 1000);
        }
        System.out.println(Arrays.toString(ints));
        bubbleSorts(ints);
        selectSort(ints);
        libSort(ints);

        System.out.println("***************Second***************");

        long startTime;
        long estimatedTime;
        startTime = System.nanoTime();
        int factorial1 = factCycle(1000);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Factorial was calculated by cycle in " + estimatedTime);
        startTime = System.nanoTime();
        int factorial2 = factRecursive(1000);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Factorial was calculated by recursion in " + estimatedTime);

        System.out.println("***************Third***************");

        int size = 8;
        MyArrays array1 = new MyArrays(size);
        array1.showArray();
        array1.firstArrayFigure();
        array1.secondArrayFigure();
        array1.thirdArrayFigure();
        array1.forthArrayFigure();

        System.out.println("***************Forth***************");

        int[] nech = new int[50];
        int firstNumb = 1;
        for (int i = 0; i < nech.length; i++) {
            nech[i] = firstNumb;
            firstNumb += 2;
        }
        System.out.print("[");
        for (int num : nech) {
            System.out.print(" " + num + ",");
        }
        System.out.println("]");
        System.out.print("[");
        for (int i = nech.length - 1; i > 0; i--) {
            System.out.print(" " + nech[i] + ",");
        }
        System.out.println("]");

        int[] randNum = new int[20];
        int evenNum = 0;
        int oddNum = 0;
        for (int i = 0; i < randNum.length; i++) {
            randNum[i] = (int) (Math.random() * 11);
            if (randNum[i] % 2 == 0) {
                evenNum++;
            } else {
                oddNum++;
            }
        }
        System.out.println(Arrays.toString(randNum));
        System.out.println("even= " + evenNum);
        System.out.println("odd= " + oddNum);

        int[] tenNumb = new int[10];
        for (int i = 0; i < tenNumb.length; i++) {
            tenNumb[i] = (int) (Math.random() * 101);
        }
        System.out.println(Arrays.toString(tenNumb));
        for (int i = 0; i < tenNumb.length; i++) {
            if (i % 2 != 0) tenNumb[i] = 0;
        }
        System.out.println(Arrays.toString(tenNumb));

        int[] fifteenNumb = new int[15];
        for (int i = 0; i < fifteenNumb.length; i++) {
            fifteenNumb[i] = (int) (Math.random() * 101) - 50;
        }
        int max = fifteenNumb[0];
        int min = fifteenNumb[0];
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 0; i < fifteenNumb.length; i++) {
            if (fifteenNumb[i] >= max) {
                max = fifteenNumb[i];
                maxIndex = i;
            }
            if (fifteenNumb[i] <= min) {
                min = fifteenNumb[i];
                minIndex = i;
            }
        }
        System.out.println(Arrays.toString(fifteenNumb));
        System.out.println("Max=" + max + " with Index=" + maxIndex);
        System.out.println("Min=" + min + " with Index=" + minIndex);

        int[] firstRandArray = new int[10];
        int[] secondRandArray = new int[10];
        double avrFirst = 0.0;
        double avrSecond = 0.0;
        for (int i = 0; i < firstRandArray.length; i++) {
            firstRandArray[i] = (int) (Math.random() * 11);
            secondRandArray[i] = (int) (Math.random() * 11);
            avrFirst += firstRandArray[i];
            avrSecond += secondRandArray[i];
        }
        avrFirst /= 10.0;
        avrSecond /= 10.0;
        System.out.println(Arrays.toString(firstRandArray));
        System.out.println(Arrays.toString(secondRandArray));
        if (avrFirst > avrSecond) {
            System.out.println("FirstArray's average is more than SecondArray's");
        } else if (avrSecond > avrFirst) {
            System.out.println("SecondArray's average is more than FirstArray's");
        } else {
            System.out.println("Averages are equal");
        }

        int[] twentyRandomNumb = new int[20];
        int[] points=new int[3];
        for (int i = 0; i < twentyRandomNumb.length; i++) {
            twentyRandomNumb[i] = (int) (Math.random() * 3) - 1;
            if (twentyRandomNumb[i] == 0) {
                points[0]++;
            } else if (twentyRandomNumb[i]==1){
                points[1]++;
            }
            else {
                points[2]++;
            }
        }
        System.out.println(Arrays.toString(twentyRandomNumb));
        int maxPoints=0;
        int maxPointsIndex=0;
        for(int i=0;i<3;i++){
            if(points[i]>maxPoints){
                maxPoints=points[i];
                maxPointsIndex=i;
            }
        }
        switch(maxPointsIndex){
            case 0:
                System.out.println("More points has "+0);
                break;
            case 1:
                System.out.println("More points has "+1);
                break;
            case 2:
                System.out.println("More points has "+(-1));
                break;
        }
        if(points[0]==points[1]){
            System.out.println(0+" and "+1+" met the same number of times");
        }
        if (points[0]==points[2]){
            System.out.println(0+" and "+-1+" met the same number of times");
        }
        if (points[1]==points[2]){
            System.out.println(1+" and "+-1+" met the same number of times");
        }



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
        int minIndex = 0;
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

    public static int[] libSort(int[] sourceArray) {
        int[] intArray = sourceArray.clone();
        long startTime = System.nanoTime();
        Arrays.sort(intArray);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Arrays sort Time =" + estimatedTime);
        return intArray;
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
