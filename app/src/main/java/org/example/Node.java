package org.example;

public class Node<T> {
    private T obj;
    private Node<T> left;
    private Node<T> right;

    public Node(T obj) {
        this.obj = obj;
        this.left = null;
        this.right = null;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> left() {
        return this.left;
    }

    public Node<T> right() {
        return this.right;
    }

    public T getObj() {
        return this.obj;
    }
}
