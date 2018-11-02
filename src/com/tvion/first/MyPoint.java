package com.tvion.first;

public class MyPoint {
    private double x = 0;
    private double y = 0;

    public MyPoint() {
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double[] getXY() {
        return new double[]{x, y};
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public double distance(double x, double y) {
        return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
    }

    public double distance(MyPoint another) {
        return distance(another.getX(), another.getY());
    }

    public double distance() {
        return distance(0, 0);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (!(otherObject instanceof MyPoint)) return false;
        MyPoint other = (MyPoint) otherObject;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        int result = 23;
        long xLong = Double.doubleToLongBits(x);
        long yLong = Double.doubleToLongBits(y);
        result = 31 * result + (int) (xLong ^ (xLong >>> 32));
        result = 31 * result + (int) (yLong ^ (yLong >>> 32));
        return result;
    }


}
