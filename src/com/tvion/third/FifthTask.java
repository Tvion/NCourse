package com.tvion.third;

import java.util.Arrays;
import java.util.Comparator;

public class FifthTask {
    public static void main(String[] args) {
        int glSum=0;
        int pobSum=0;
        long glPr=1L;
        long pobPr=1L;
        int[][] firstArray = new int[8][8];
        for (int i = 0; i < firstArray.length; i++) {
            for (int j = 0; j < firstArray.length; j++) {
                firstArray[i][j]=(int)(Math.random()*99)+1;
                if(i==j){
                    glSum+=firstArray[i][j];
                    glPr*=firstArray[i][j];
                }
                if(i==firstArray.length-1-j){
                    pobSum+=firstArray[i][j];
                    pobPr*=firstArray[i][j];
                }
            }
        }
        showArray(firstArray);
        System.out.println("Diag: Sum="+glSum+" Multiple="+glPr);
        System.out.println("DiagPob: Sum="+pobSum+" Multiple="+pobPr);

        int[][] secondArray=new int[8][5];
        int max=Integer.MIN_VALUE;
        int[] maxIndex=new int[2];
        for (int i = 0; i < secondArray.length; i++) {
            for (int j = 0; j < secondArray[i].length; j++) {
                secondArray[i][j]=(int)(Math.random()*199)-99;
                if(secondArray[i][j]>max){
                    max=secondArray[i][j];
                    maxIndex[0]=i;
                    maxIndex[1]=j;
                }
            }
        }
        showArray(secondArray);
        System.out.println(max);
        System.out.println("Max element's row index is "+maxIndex[0]+" and col index is "+maxIndex[1]);

        int[][] third=new int[8][5];
        int maxMult=1;
        int maxMultIndex=0;
        for(int i=0;i<third.length;i++){
            int rowMult=1;
            for (int j=0;j<third[i].length;j++){
            third[i][j]=(int)(Math.random()*21)-10;
            rowMult*=Math.abs(third[i][j]);
            }
            if(rowMult>maxMult){
                maxMult=rowMult;
                maxMultIndex=i;
            }
        }
        showArray(third);
        System.out.println(maxMult);
        System.out.println(maxMultIndex);


        Integer[][] forth=new Integer[10][7];
        for(int i=0;i<forth.length;i++){
            for(int j=0;j<forth[i].length;j++){
                forth[i][j]=(int)(Math.random()*101);
            }
        }
        showArray(forth);
        for(int i=0;i<forth.length;i++){
            Arrays.sort(forth[i],(a,b)->b.intValue()-a.intValue());
        }
        showArray(forth);


    }



    public static void showArray(int[][] sourceArray) {
        System.out.println();
        for (int i = 0; i < sourceArray.length; i++) {
            for (int j = 0; j < sourceArray[i].length; j++) {
                System.out.print(sourceArray[i][j]+"    ");

            }
            System.out.println();
        }
        System.out.println();
    }
    public static void showArray(Integer[][] sourceArray) {
        System.out.println();
        for (int i = 0; i < sourceArray.length; i++) {
            for (int j = 0; j < sourceArray[i].length; j++) {
                System.out.print(sourceArray[i][j]+"    ");

            }
            System.out.println();
        }
        System.out.println();
    }
}