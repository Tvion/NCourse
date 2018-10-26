package com.tvion.second;

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
        double[] degrees = new double[maxDegree + 1];
        for (int i = 0; i < this.getDegree() + 1; i++) {
            for (int j = 0; j < right.getDegree() + 1; j++) {
                degrees[i + j] += this.coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolynomial(degrees);

    }

    public static void main(String[] args) {
        MyPolynomial polina = new MyPolynomial(new double[]{2, 4, 6, 3, 2, 6, 8, 6});
        MyPolynomial polinochka = new MyPolynomial(new double[]{2, 2, 7, 9, 6, 4, 3, 2, 9});
        MyPolynomial polinochka2 = new MyPolynomial(new double[]{1, 2, 3});
        MyPolynomial polinochka3 = new MyPolynomial(new double[]{2, 3, 1});
        System.out.println(polina);
        System.out.println(polinochka2);
        System.out.println(polinochka3);
        System.out.println(polinochka2.multiply(polinochka3));
        System.out.println(polinochka3.multiply(polinochka2));
    }
}
