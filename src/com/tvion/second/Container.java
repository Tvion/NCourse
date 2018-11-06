package com.tvion.second;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width;
        this.y2 = y + height;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return x2 - x1;
    }

    public int getHeight() {
        return y2 - y1;
    }

    //При пересечение границы какой-либо частью мяча возвращает false
    public boolean collides(Ball ball) {
        int radius = ball.getRadius();
        if ((ball.getX() - radius < x1) || (ball.getX() + radius > x2)) return false;
        if ((ball.getY() - radius < y1) || (ball.getY() + radius > y2)) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Container[(" + x1 + "," + y1 + "),(" + x2 + "," + y2 + ")]";
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (!(otherObject instanceof Container)) return false;
        Container other = (Container) otherObject;
        return this.getHeight() == other.getHeight() && this.getWidth() == other.getWidth();
    }

    @Override
    public int hashCode() {
        int result = 23;
        result = 31 * result + getWidth();
        result = 31 * result + getHeight();
        return result;
    }

}

