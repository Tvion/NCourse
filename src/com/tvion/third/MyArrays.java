package com.tvion.third;

public class MyArrays {
    private String[][] incArray;

    public MyArrays(int size) {
        this.incArray = new String[size][size];
        initArray(size, size);
    }

/*    public MyArrays(int rows, int cols) {
        this.incArray = new String[rows][cols];
        initArray(rows, cols);
    }*/

    private void initArray(int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                incArray[row][col] = "#";
            }
        }
    }


    public void showArray() {
        for (int i = 0; i < incArray.length; i++) {
            for (int j = 0; j < incArray[i].length; j++) {
                System.out.print(incArray[i][j]);
            }
            System.out.println();
        }
    }

    private void showArray(String[][] sourceArray) {
        System.out.println();
        for (int i = 0; i < sourceArray.length; i++) {
            for (int j = 0; j < sourceArray[i].length; j++) {
                System.out.print(sourceArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    public void firstArrayFigure() {
        String[][] newIncArray = incArray.clone();
        for (int i = 0; i < newIncArray.length; i++) {
            for (int j = 0; j < newIncArray[i].length; j++) {
                if (i < j) newIncArray[i][j] = " ";
                else newIncArray[i][j] = "#";
            }
        }
        showArray(newIncArray);
    }

    public void secondArrayFigure() {
        String[][] newIncArray = incArray.clone();
        for (int i = 0; i < newIncArray.length; i++) {
            for (int j = 0; j < newIncArray[i].length; j++) {
                if (i != 0 && i != (newIncArray.length-1) && j != (newIncArray[i].length-1) && j != 0 && i != j && i != (newIncArray[i].length-j-1))
                    newIncArray[i][j] = " ";
                else incArray[i][j] = "#";
            }
        }
        showArray(newIncArray);
    }

    public void thirdArrayFigure() {
        String[][] newIncArray = incArray.clone();
        for (int i = 0; i < newIncArray.length; i++) {
            for (int j = 0; j < newIncArray[i].length; j++) {
                if (i != 0 && i != (newIncArray.length-1) && i!=j)
                    newIncArray[i][j] = " ";
                else incArray[i][j] = "#";
            }
        }
        showArray(newIncArray);
    }

    public void forthArrayFigure() {
        String[][] newIncArray = incArray.clone();
        for (int i = 0; i < newIncArray.length; i++) {
            for (int j = 0; j < newIncArray[i].length; j++) {
                if (i != 0 && i != (newIncArray.length-1) && i!=newIncArray.length-1-j)
                    newIncArray[i][j] = " ";
                else incArray[i][j] = "#";
            }
        }
        showArray(newIncArray);
    }
}
