package com.tvion.second;

public class BallTest {

    public static void main(String[] args) {

        System.out.println("*****BallTest*****");

        Container container = new Container(3, 2, 10, 9);
        Ball ball = new Ball(2.5f, 3f, 1, 6, 5);
        System.out.println(container.toString() + " has width=" + container.getWidth() + " height=" + container.getHeight());
        System.out.println(ball);
        System.out.println("Is ball in container =" + container.collides(ball));
        System.out.println("Move");
        ball.move();

        System.out.println(ball);
        System.out.println("Is ball in container now =" + container.collides(ball));
        System.out.println("ReflectHorizontal and move");
        ball.reflectHorizontal();
        ball.move();

        System.out.println(ball);
        System.out.println("Is ball in container now =" + container.collides(ball));
        System.out.println();


        System.out.println("*****MyComplex*****");

        MyComplex myComplex = new MyComplex(2, 2);
        MyComplex myComplex1 = new MyComplex(10, 3);
        System.out.println("First complex = " + myComplex);
        System.out.println("Second complex = " + myComplex1);

        System.out.println("First multiply with second = " + myComplex.multiply(myComplex1));
        System.out.println("Second complex add to multiplied first complex = " + myComplex.add(myComplex1));
        System.out.println("Conjugate new first = " + myComplex.conjugate());
        System.out.println();


        System.out.println("*****MyPolynomial*****");

        MyPolynomial polina = new MyPolynomial(new double[]{1, 2, 3, 4});
        MyPolynomial polinochka = new MyPolynomial(new double[]{2, 3, 1});
        MyPolynomial polinochka1 = new MyPolynomial(new double[]{2, 3, 1});
        System.out.println("First polynomial = " + polina);
        System.out.println("Second polynomial = " + polinochka);
        System.out.println("Third polynomial = " + polinochka1);
        System.out.println("Second polynomial evaluated at x=3 is " + polinochka.evaluate(3.0));

        System.out.println("Second polynomial equals third  = " + polinochka.equals(polinochka1));
        System.out.println("Second polynomial add to first = " + polina.add(polinochka));
        System.out.println("Second polynomial multiply to first = " + polinochka.multiply(polina));
    }


}
