package com.tvion.first;

public class Common {
    public static void main(String[] args) {
        System.out.println("*****Book*****");
        Author[] authors = new Author[5];
        authors[0] = new Author("Sasha", "snak", 'm');
        authors[1] = new Author("Masha", "sdf", 'f');
        Book book = new Book("nazv", authors, 10);
        System.out.println(book);
        System.out.println();


        System.out.println("*****Circle*****");
        Circle circle = new Circle(30);
        System.out.printf("%.2f", circle.getArea());
        System.out.println();


        System.out.println("*****Employee*****");
        Employee employee = new Employee(1, "s", "d", 100000);
        System.out.println(employee.getSalary());
        System.out.println(employee.raiseSalary(10));
        System.out.println(employee);
        System.out.println();


        System.out.println("*****MyPoint*****");
        MyPoint first = new MyPoint(5, 2);
        MyPoint third = new MyPoint(3, 10);
        System.out.printf("%4.2f\n", first.distance(third));
        System.out.printf("%4.2f\n", first.distance());
        System.out.printf("%4.2f\n", first.distance(10, 40));
        System.out.println();

        System.out.println("*****MyTriangle*****");
        MyTriangle triangle = new MyTriangle(0, 0, 1, 1, 2, 0);
        System.out.println(triangle.getType());
        System.out.println(triangle.getPerimeter());
        System.out.println();

        System.out.println("*****MyRectangle*****");
        Rectangle rectangle = new Rectangle(10, 30);
        System.out.println(rectangle.getPerimeter());

    }
}
