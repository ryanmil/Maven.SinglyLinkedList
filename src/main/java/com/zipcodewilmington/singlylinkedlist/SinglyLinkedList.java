package com.zipcodewilmington.singlylinkedlist;

import java.util.Comparator;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {
    private Node head;

    public void add(T element) {
        if(head == null) {
            head = new Node(element);
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = new Node(element);
        }
    }

    public void remove(Integer index) {
        if(index.equals(0)) {
            head = head.next;
        } else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n.next = n.next.next;
        }
    }

    public Boolean contains(T element) {
        for (Node n = head; n != null; n = n.next) {
            if (n.data.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public Integer find(T element) {
        Node n = head;
        for (int i = 0; n != null; n = n.next, i++) {
            if (n.data.equals(element)) {
                return i;
            }
        }
        return null;
    }

    public Integer size() {
        int i = 0;
        for (Node n = head; n != null; n = n.next) {
            i++;
        }
        return i;
    }

    public T get(Integer index) {
        Node n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n.data;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copy = new SinglyLinkedList<T>();

        for (Node n = head; n != null; n = n.next) {
            copy.add(n.data);
        }

        return  copy;
    }

    public void sort(Comparator<T> comparator) {
        SinglyLinkedList<T> sorted = new SinglyLinkedList<T>();

        int size = this.size();
        for (int i = 0; i < size; i++) {

            T smallest = head.data;
            for (Node n = head; n != null; n = n.next) {
                if(comparator.compare(smallest, n.data) >= 0) {
                    smallest = n.data;
                }
            }
            this.remove(this.find(smallest));
            sorted.add(smallest);
        }
        this.head = sorted.head;
    }


    private class Node {
        private Node next;
        private T data;

        public Node() {}

        public Node(T data) {
            this.data = data;
        }
    }
}
