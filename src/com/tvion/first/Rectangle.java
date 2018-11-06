package com.tvion.first;

public class Rectangle {

    private float length = 1.0f;
    private float width = 1.0f;

    public Rectangle() {
    }

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Rectangle[length=" + length + ",width=" + width;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (!(otherObject instanceof Rectangle)) return false;
        Rectangle other = (Rectangle) otherObject;
        return width == other.width && length == other.length;
    }

    @Override
    public int hashCode() {
        int result = 23;
        result = 31 * result + Float.floatToIntBits(width);
        result = 31 * result + Float.floatToIntBits(length);
        return result;
    }
}
