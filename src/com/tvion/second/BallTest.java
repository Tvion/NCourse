package com.tvion.second;

public class BallTest {

    public static void main(String[] args) {
        Container container=new Container(3,2,10,9);
        Ball ball=new Ball(4f,3f,1,5,6);
        System.out.println(container.collides(ball));
        System.out.println(ball);
        ball.move();
        System.out.println(ball);
        System.out.println(container.collides(ball));
        ball.reflectHorizontal();
        ball.move();
        System.out.println(ball);
        System.out.println(container.collides(ball));
    }

}
