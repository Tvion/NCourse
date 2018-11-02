package com.tvion.third;

import java.util.Arrays;

public class ForthTask {
    public static void main(String[] args) {

        System.out.println("******ODD_ARRAY******");

        int[] nech = new int[50];
        int firstNumb = 1;
        for (int i = 0; i < nech.length; i++) {
            nech[i] = firstNumb;
            firstNumb += 2;
        }
        System.out.print("[");
        for (int num : nech) {
            System.out.print(num + ", ");
        }
        System.out.println("]");
        System.out.print("[");
        for (int i = nech.length - 1; i > 0; i--) {
            System.out.print(nech[i] + ", ");
        }
        System.out.println("]");
        System.out.println();


        System.out.println("******TWENTY_RANDOM_ARRAY******");

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
        System.out.println();


        System.out.println("******ODD_TO_ZERO******");

        int[] tenNumb = new int[10];
        for (int i = 0; i < tenNumb.length; i++) {
            tenNumb[i] = (int) (Math.random() * 101);
        }
        System.out.println(Arrays.toString(tenNumb));
        for (int i = 0; i < tenNumb.length; i++) {
            if (i % 2 != 0) tenNumb[i] = 0;
        }
        System.out.println(Arrays.toString(tenNumb));
        System.out.println();


        System.out.println("******MIN_AND_MAX******");

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
        System.out.println();


        System.out.println("******AVERAGE******");

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
        System.out.println();


        System.out.println("******OFTEN_THAN_OTHERS******");

        int[] twentyRandomNumb = new int[20];
        int[] points = new int[3];
        for (int i = 0; i < twentyRandomNumb.length; i++) {
            twentyRandomNumb[i] = (int) (Math.random() * 3) - 1;
            if (twentyRandomNumb[i] == 0) {
                points[0]++;
            } else if (twentyRandomNumb[i] == 1) {
                points[1]++;
            } else {
                points[2]++;
            }
        }
        System.out.println(Arrays.toString(twentyRandomNumb));
        int maxPoints = 0;
        int maxPointsIndex = 0;
        for (int i = 0; i < 3; i++) {
            if (points[i] > maxPoints) {
                maxPoints = points[i];
                maxPointsIndex = i;
            }
        }
        switch (maxPointsIndex) {
            case 0:
                System.out.println("More points has " + 0);
                break;
            case 1:
                System.out.println("More points has " + 1);
                break;
            case 2:
                System.out.println("More points has " + (-1));
                break;
        }
        if (points[0] == points[1]) {
            System.out.println(0 + " and " + 1 + " met the same number of times");
        }
        if (points[0] == points[2]) {
            System.out.println(0 + " and " + -1 + " met the same number of times");
        }
        if (points[1] == points[2]) {
            System.out.println(1 + " and " + -1 + " met the same number of times");
        }
    }
}
