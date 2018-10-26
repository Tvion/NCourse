package com.tvion.first;

public class Circle {

    private double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color){
        this.radius=radius;
        this.color=color;
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
    public String toString(){
        return "Circle[radius="+radius+",color="+color;
    }

    public double getArea(){
        return Math.PI*Math.pow(radius,2);
    }


    public static void main(String[] args) {
        Circle circle=new Circle(30);
        System.out.printf("%.2f",circle.getArea());
    }
}
