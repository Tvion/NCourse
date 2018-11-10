package com.tvion.forth;

public class Node<E> {
    private Node<E> next;
    private Node<E> prev;
    private E datum;

    public Node(E datum,Node<E> prev,Node<E> next){
        this.datum=datum;
        this.next=next;
        this.prev=prev;
    }
    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> last) {
        this.prev = last;
    }

    public E getDatum() {
        return datum;
    }

    public void setDatum(E datum) {
        this.datum = datum;
    }

}
