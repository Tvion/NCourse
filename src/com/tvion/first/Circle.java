package com.tvion.first;

public class Circle {

    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle[radius=" + radius + ",color=" + color;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (!(otherObject instanceof Circle)) return false;
        Circle other = (Circle) otherObject;
        return radius == other.radius && color.equals(other.color);
    }

    @Override
    public int hashCode() {
        int result = 23;
        long radiusLong = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (radiusLong ^ (radiusLong >>> 32));
        result = 31 * result + color.hashCode();
        return result;
    }

}
