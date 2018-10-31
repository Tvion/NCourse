package com.tvion.first;

import java.util.Arrays;

public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.v1 = new MyPoint(x1, y1);
        this.v2 = new MyPoint(x2, y2);
        this.v3 = new MyPoint(x3, y3);
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public String toString() {
        return "MyTriangle[" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", v3=" + v3 +
                ']';
    }

    public double getPerimeter() {
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }

    public String getType() {
        double firstSide = v1.distance(v2);
        double secondSide = v2.distance(v3);
        double thirdSide = v3.distance(v1);
        if (firstSide == secondSide && secondSide == thirdSide) return "Equilateral";
        if (firstSide == secondSide || firstSide == thirdSide || secondSide == thirdSide) return "Isosceles";
        return "Scalene";
    }

    private boolean compareTriangles(MyTriangle other) {
        double[] firstTriangleSides = this.getSides();
        double[] secondTriangleSides = other.getSides();
        Arrays.sort(firstTriangleSides);
        Arrays.sort(secondTriangleSides);
        return Arrays.equals(firstTriangleSides, secondTriangleSides);


    }

    // Возвращает массив длин сторон

    public double[] getSides() {
        double[] triangleSides = new double[3];
        triangleSides[0] = v1.distance(v2);
        triangleSides[1] = v2.distance(v3);
        triangleSides[2] = v3.distance(v1);
        return triangleSides;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (!(otherObject instanceof MyTriangle)) return false;
        MyTriangle other = (MyTriangle) otherObject;
        if (!this.getType().equals(other.getType())) return false;
        return compareTriangles(other);
    }


    @Override
    public int hashCode() {
        int result = 23;
        double[] sides = this.getSides();
        Arrays.sort(sides);
        result = 31 * Arrays.hashCode(sides);
        return result;
    }
}
