package com.tvion.third;

public class SixthTask {
    enum Fingers {THUMB, INDEX, MIDDLE, RING, LITTLE}


    public static void main(String[] args) {
        Fingers finger = Fingers.RING;
        long startTime;
        long estimatedTime;
        startTime = System.nanoTime();
        if (finger == Fingers.THUMB) {
            System.out.println("THUMB");
        } else if (finger == Fingers.INDEX) {
            System.out.println("INDEX");
        } else if (finger == Fingers.MIDDLE) {
            System.out.println("MIDDLE");
        } else if (finger == Fingers.RING) {
            System.out.println("RING");
        } else if (finger == Fingers.LITTLE) {
            System.out.println("LITTLE");
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("If time=" + estimatedTime);
        startTime = System.nanoTime();
        switch (finger) {
            case THUMB:
                System.out.println("THUMB");
                break;
            case INDEX:
                System.out.println("INDEX");
                break;
            case MIDDLE:
                System.out.println("MIDDLE");
                break;
            case RING:
                System.out.println("RING");
                break;
            case LITTLE:
                System.out.println("LITTLE");
                break;
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Case time=" + estimatedTime);


        int[] testArray = new int[50];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = (int) (Math.random() * 11);
        }
        int[] caseCounter = new int[11];
        int[] ifCounter = new int[11];
        startTime = System.nanoTime();
        for (int i = 0; i < testArray.length; i++) {
            if (testArray[i] == 0) {
                System.out.print(0 + " ");
                ifCounter[0]++;
            } else if (testArray[i] == 1) {
                System.out.print(1 + " ");
                ifCounter[1]++;
            } else if (testArray[i] == 2) {
                System.out.print(2 + " ");
                ifCounter[2]++;
            } else if (testArray[i] == 3) {
                System.out.print(3 + " ");
                ifCounter[3]++;
            } else if (testArray[i] == 4) {
                System.out.print(4 + " ");
                ifCounter[4]++;
            } else if (testArray[i] == 5) {
                System.out.print(5 + " ");
                ifCounter[5]++;
            } else if (testArray[i] == 6) {
                System.out.print(6 + " ");
                ifCounter[6]++;
            } else if (testArray[i] == 7) {
                System.out.print(7 + " ");
                ifCounter[7]++;
            } else if (testArray[i] == 8) {
                System.out.print(8 + " ");
                ifCounter[8]++;
            } else if (testArray[i] == 9) {
                System.out.print(9 + " ");
                ifCounter[9]++;
            } else if (testArray[i] == 10) {
                System.out.print(10 + " ");
                ifCounter[10]++;
            }
        }

        estimatedTime = System.nanoTime() - startTime;
        System.out.println();
        System.out.println("Array if time=" + estimatedTime);
        startTime = System.nanoTime();
        for (int i = 0; i < testArray.length; i++) {
            switch (testArray[i]) {
                case 0:
                    System.out.print(0 + " ");
                    caseCounter[0]++;
                    break;
                case 1:
                    System.out.print(1 + " ");
                    caseCounter[1]++;
                    break;
                case 2:
                    System.out.print(2 + " ");
                    caseCounter[2]++;
                    break;
                case 3:
                    System.out.print(3 + " ");
                    caseCounter[3]++;
                    break;
                case 4:
                    System.out.print(4 + " ");
                    caseCounter[4]++;
                    break;
                case 5:
                    System.out.print(5 + " ");
                    caseCounter[5]++;
                    break;
                case 6:
                    System.out.print(6 + " ");
                    caseCounter[6]++;
                    break;
                case 7:
                    System.out.print(7 + " ");
                    caseCounter[7]++;
                    break;
                case 8:
                    System.out.print(8 + " ");
                    caseCounter[8]++;
                    break;
                case 9:
                    System.out.print(9 + " ");
                    caseCounter[9]++;
                    break;
                case 10:
                    System.out.print(10 + " ");
                    caseCounter[10]++;
                    break;
            }
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println();
        System.out.println("Array case time=" + estimatedTime);
        for (int i = 0; i < ifCounter.length; i++) {
            System.out.println("In " + i + "row is " + ifCounter[i] + " nubmers");
        }
/*        for (int i=0;i<caseCounter.length;i++){
            System.out.println("In "+i+"row is "+caseCounter[i]+" nubmers");
        }*/
    }


}
