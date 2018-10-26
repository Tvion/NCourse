package com.tvion.second;

public class BallTest {

    public static void main(String[] args) {
        Container container = new Container(3, 2, 10, 9);
        Ball ball = new Ball(2.5f, 3f, 1, 6, 5);
        System.out.println(container.toString() + " width=" + container.getWidth() + " height=" + container.getHeight());
        System.out.println(ball);
        System.out.println(container.collides(ball));
        System.out.println("Move");
        ball.move();
        System.out.println(ball);
        System.out.println(container.collides(ball));
        System.out.println("ReflectHorizontal and move");
        ball.reflectHorizontal();
        ball.move();
        System.out.println(ball);
        System.out.println(container.collides(ball));
        System.out.println();

        System.out.println("*****MyComplex*****");
        MyComplex myComplex = new MyComplex(2, 2);
        MyComplex myComplex1 = new MyComplex(10, 3);
        System.out.println(myComplex);
        System.out.println(myComplex1);
        System.out.println(myComplex.multiply(myComplex1));
        System.out.println(myComplex.add(myComplex1));
        System.out.println(myComplex.conjugate());
        System.out.println();


        System.out.println("*****MyPolinomial*****");
        MyPolynomial polina = new MyPolynomial(new double[]{1, 2, 3, 4});
        MyPolynomial polinochka = new MyPolynomial(new double[]{2, 3, 1});
        System.out.println(polina);
        System.out.println(polinochka);
        System.out.println(polina.add(polinochka));
        System.out.println(polinochka.multiply(polina));
    }

}
