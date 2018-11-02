package com.tvion.first;

public class Common {
    public static void main(String[] args) {

        // Проверка классов

        System.out.println("*****Book*****");

        Author[] authors = new Author[5];
        authors[0] = new Author("Sasha", "snak", 'm');
        authors[1] = new Author("Masha", "sdf", 'f');
        authors[3] = new Author("Masha", "sdf", 'm');
        Author[] authors2 = new Author[4];
        authors2[1] = new Author("Sasha", "snak", 'm');
        authors2[3] = new Author("Masha", "sdf", 'f');
        authors2[2] = new Author("Masha", "sdf", 'm');
        Book book = new Book("nazv", authors, 10);
        Book book1 = new Book("nazv", authors2, 10);
        System.out.println("First book's Hash = " + book.hashCode());
        System.out.println("Second book's Hash = " + book1.hashCode());
        System.out.println("First book equals second book =" + book.equals(book1));
        System.out.println(book);
        System.out.println(book1);
        System.out.println();


        System.out.println("*****Circle*****");

        Circle circle = new Circle(30);
        System.out.printf("Circle area = %.2f\n", circle.getArea());
        System.out.println();


        System.out.println("*****Employee*****");

        Employee employee = new Employee(1, "s", "d", 100000);
        System.out.println("Employee's salary = " + employee.getSalary());
        System.out.println("Emlployee's salary after raising = " + employee.raiseSalary(10));
        System.out.println(employee);
        System.out.println();


        System.out.println("*****MyPoint*****");

        MyPoint first = new MyPoint(5, 2);
        MyPoint third = new MyPoint(3, 10);

        System.out.printf("Distance from first to second point = %4.2f\n", first.distance(third));
        System.out.printf("Distance from zero to first point = %4.2f\n", first.distance());
        System.out.printf("Distance from first to that point = %4.2f\n", first.distance(10, 40));
        System.out.println();


        System.out.println("*****MyTriangle*****");

        MyTriangle triangle = new MyTriangle(0, 0, 1, 2, 2, 0);
        MyTriangle triangle1 = new MyTriangle(0, 0, 1, 1, 2, 0);
        MyTriangle triangle2 = new MyTriangle(1, 1, 2, 0, 3, 1);

        System.out.println("First triangle Hash = " + triangle.hashCode());
        System.out.println("Second triangle Hash = " + triangle1.hashCode());
        System.out.println("Third triangle Hash = " + triangle2.hashCode());

        System.out.println("First equals second = " + triangle.equals(triangle1));
        System.out.println("Third equals second = " + triangle1.equals(triangle2));
        System.out.println("First triangle type is " + triangle.getType());
        System.out.println("First triangle perimeter = " + triangle.getPerimeter());
        System.out.println();


        System.out.println("*****MyRectangle*****");

        Rectangle rectangle = new Rectangle(10, 30);
        System.out.println("Rectangle perimeter = " + rectangle.getPerimeter());

    }
}
