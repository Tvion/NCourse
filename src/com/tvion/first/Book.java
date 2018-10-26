package com.tvion.first;

import java.util.ArrayList;
import java.util.Arrays;

public class Book {
    private static final int m = 3;
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    private Author[] calcArray(Author[] sourceArray) {
        ArrayList<Author> authors = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (sourceArray[i] != null) authors.add(sourceArray[i]);
        }
        return authors.toArray(new Author[authors.size()]);

    }

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = calcArray(authors);
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = calcArray(authors);
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book[name=" + name + ",authors=" + Arrays.toString(authors) + ",price=" + price + ",qty=" + qty + "]";
    }


}
