package com.tvion.first;

public class Common {
    public static void main(String[] args) {
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
        System.out.println(book.hashCode());
        System.out.println(book1.hashCode());
        System.out.println(book.equals(book1));
        System.out.println(book);
        System.out.println(book1);
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
        MyTriangle triangle = new MyTriangle(0, 0, 1, 2, 2, 0);
        MyTriangle triangle1 = new MyTriangle(0, 0, 1, 1, 2, 0);
        MyTriangle triangle2 = new MyTriangle(1, 1, 2, 0, 3, 1);
        System.out.println(triangle.hashCode());
        System.out.println(triangle1.hashCode());
        System.out.println(triangle2.hashCode());
        System.out.println(triangle.equals(triangle1));
        System.out.println(triangle1.equals(triangle2));
        System.out.println(triangle.getType());
        System.out.println(triangle.getPerimeter());
        System.out.println();

        System.out.println();

        System.out.println("*****MyRectangle*****");
        Rectangle rectangle = new Rectangle(10, 30);
        System.out.println(rectangle.getPerimeter());

/*        System.out.println();
        System.out.println();

        Author a=new Author("man","qwe",'f');
        Author b=new Author("man","qwe",'f');
        Author c=new Author("maan","qwe",'x');
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(a.equals(b));
        System.out.println(b.equals(a));
        System.out.println(a.equals(c));
        System.out.println(b.equals(c));*/
    }
}
