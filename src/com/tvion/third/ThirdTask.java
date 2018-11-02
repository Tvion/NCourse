package com.tvion.third;

public class ThirdTask {
    public static void main(String[] args) {
        int size = 8;
        char[][] sArray = new char[size][size];
        initialArray(sArray);
        showArray(sArray);
        firstArrayFigure(sArray);
        secondArrayFigure(sArray);
        thirdArrayFigure(sArray);
        forthArrayFigure(sArray);
    }

    public static void initialArray(char[][] incArray) {
        int size = incArray.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                incArray[row][col] = '#';
            }
        }

    }

    public static void showArray(char[][] sourceArray) {
        System.out.println();
        for (char[] aSourceArray : sourceArray) {
            for (int j = 0; j < aSourceArray.length; j++) {
                System.out.print(aSourceArray[j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void firstArrayFigure(char[][] incArray) {
        char[][] newIncArray = incArray.clone();
        for (int i = 0; i < newIncArray.length; i++) {
            for (int j = 0; j < newIncArray[i].length; j++) {
                if (i < j) newIncArray[i][j] = '#';
                else newIncArray[i][j] = ' ';
            }
        }
        showArray(newIncArray);
    }

    public static void secondArrayFigure(char[][] incArray) {
        char[][] newIncArray = incArray.clone();
        for (int i = 0; i < newIncArray.length; i++) {
            for (int j = 0; j < newIncArray[i].length; j++) {
                if (i != 0 && i != (newIncArray.length - 1) && j != (newIncArray[i].length - 1) && j != 0 && i != j && i != (newIncArray[i].length - j - 1))
                    newIncArray[i][j] = ' ';
                else incArray[i][j] = '#';
            }
        }
        showArray(newIncArray);
    }

    public static void thirdArrayFigure(char[][] incArray) {
        char[][] newIncArray = incArray.clone();
        for (int i = 0; i < newIncArray.length; i++) {
            for (int j = 0; j < newIncArray[i].length; j++) {
                if (i != 0 && i != (newIncArray.length - 1) && i != j)
                    newIncArray[i][j] = ' ';
                else incArray[i][j] = '#';
            }
        }
        showArray(newIncArray);
    }

    public static void forthArrayFigure(char[][] incArray) {
        char[][] newIncArray = incArray.clone();
        for (int i = 0; i < newIncArray.length; i++) {
            for (int j = 0; j < newIncArray[i].length; j++) {
                if (i != 0 && i != (newIncArray.length - 1) && i != newIncArray.length - 1 - j)
                    newIncArray[i][j] = ' ';
                else incArray[i][j] = '#';
            }
        }
        showArray(newIncArray);
    }
}
