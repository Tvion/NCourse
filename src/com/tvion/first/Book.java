package com.tvion.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Book {
    private static final int m = 3;
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    // проверка null в переданном масиве авторов, соблюдение ограничения m связей, сортировка авторов
    private Author[] calcArray(Author[] sourceArray) {
        ArrayList<Author> authors = new ArrayList<>();
        for (Author aSourceArray : sourceArray) {
            if (authors.size() >= m) break;
            if (aSourceArray != null) authors.add(aSourceArray);
        }
        Author[] result = authors.toArray(new Author[authors.size()]);
        Arrays.sort(result, Comparator.comparing(Author::getName).thenComparing(Author::getGender).thenComparing(Author::getEmail));
        return result;

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


    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (!(otherObject instanceof Book)) return false;
        Book other = (Book) otherObject;
        return name.equals(other.name) && price == other.price && qty == other.qty && Arrays.equals(authors, other.authors);
    }


    @Override
    public int hashCode() {
        int result = 23;
        result = 31 * result + name.hashCode();
        result = 31 * result + qty;
        result = 31 * result + Arrays.hashCode(authors);
        long priceLong = Double.doubleToLongBits(price);
        result = 31 * result + (int) (priceLong ^ (priceLong >>> 32));
        return result;
    }

}
