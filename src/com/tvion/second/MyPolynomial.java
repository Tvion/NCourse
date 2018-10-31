package com.tvion.second;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double[] coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    @Override
    public String toString() {
        String answer = "";
        for (int i = coeffs.length - 1; i > 0; i--) {
            answer += coeffs[i] + "x^" + i + "+";
        }
        answer += coeffs[0];
        return answer;
    }

    public double evaluate(double x) {
        double answer = 0.0;
        for (int i = 0; i < coeffs.length; i++) {
            answer += coeffs[i] * Math.pow(x, i);
        }
        return answer;
    }

    public MyPolynomial add(MyPolynomial right) {
        MyPolynomial high;
        MyPolynomial low;
        int maxDegree = Math.max(right.getDegree(), this.getDegree());
        if (this.getDegree() == maxDegree) {
            high = this;
            low = right;
        } else {
            high = right;
            low = this;
        }
        double[] newCoeffs = new double[maxDegree + 1];
        for (int i = 0; i < high.getDegree() + 1; i++) {
            if (i > low.getDegree()) {
                newCoeffs[i] += high.coeffs[i];
            } else {
                newCoeffs[i] = right.coeffs[i] + this.coeffs[i];
            }
        }
        return new MyPolynomial(newCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial right) {
        int maxDegree = this.getDegree() + right.getDegree();
        double[] newCoeffs = new double[maxDegree + 1];
        for (int i = 0; i < this.getDegree() + 1; i++) {
            for (int j = 0; j < right.getDegree() + 1; j++) {
                newCoeffs[i + j] += this.coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolynomial(newCoeffs);

    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (!(otherObject instanceof MyPolynomial)) return false;
        MyPolynomial other = (MyPolynomial) otherObject;
        if (this.getDegree() != other.getDegree()) return false;
        double[] sortCoeffs = coeffs.clone();
        double[] otherSortCoeffs = other.coeffs.clone();
        Arrays.sort(sortCoeffs);
        Arrays.sort(otherSortCoeffs);
        return Arrays.equals(sortCoeffs, otherSortCoeffs);
    }

    @Override
    public int hashCode() {
        int result = 23;
        result = 31 * result + Arrays.hashCode(coeffs);
        return result;
    }
}
