package com.tvion.second;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "(" + real +
                ((imag >= 0) ? "+" : "") + imag +
                "i)";
    }

    public boolean isReal() {
        if (real != 0.0) return true;
        return false;
    }

    public boolean isImaginary() {
        if (imag != 0.0) return true;
        return false;
    }

    public boolean equals(double real, double imag) {
        if (this.real == real && this.imag == imag) return true;
        return false;
    }

    public boolean equals(MyComplex another) {
        return equals(another.getReal(), another.getImag());
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2));
    }

    public double argument() {
        return Math.atan(imag / real);
    }

    public MyComplex add(MyComplex right) {
        this.real += right.getReal();
        this.imag += right.getImag();
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(this.real + right.getReal(), this.imag + right.getImag());
    }

    public MyComplex subtract(MyComplex right) {
        this.real -= right.getReal();
        this.imag -= right.getImag();
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        return new MyComplex(this.real - right.getReal(), this.imag - right.getImag());
    }

    public MyComplex multiply(MyComplex right) {
        double oldReal = this.real;
        double oldImag = this.imag;
        this.real = oldReal * right.getReal() - oldImag * right.getImag();
        this.imag = oldImag * right.getReal() + oldReal * right.getImag();
        return this;
    }

    public MyComplex divide(MyComplex right) {
        double oldReal = this.real;
        double oldImag = this.imag;
        double denominator = Math.pow(right.getReal(), 2) + Math.pow(right.getImag(), 2);
        this.real = (oldReal * right.getReal() + oldImag * right.getImag()) / denominator;
        this.imag = (oldImag * right.getReal() - oldReal * right.getImag()) / denominator;
        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(this.real, this.imag * (-1));
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (!(otherObject instanceof MyComplex)) return false;
        MyComplex other = (MyComplex) otherObject;
        return real == other.real && imag == other.imag;
    }

    @Override
    public int hashCode() {
        int result = 23;
        Long realLong = Double.doubleToLongBits(real);
        Long imagLong = Double.doubleToLongBits(imag);
        result = 31 * result + (int) (realLong ^ (realLong >>> 32));
        result = 31 * result + (int) (imagLong ^ (imagLong >>> 32));
        return result;
    }
}
