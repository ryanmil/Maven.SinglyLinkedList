package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {


    @Test
    public void testAdd() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.add(3);
        list.add(10);

        Assert.assertEquals(3, list.get(0).intValue());
        Assert.assertEquals(10, list.get(1).intValue());
    }

    @Test
    public void testRemove() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.add(3);
        list.add(10);
        list.add(15);
        list.add(2);
        list.add(-14);

        Assert.assertEquals(15, list.get(2).intValue());
        list.remove(2);
        Assert.assertEquals(2, list.get(2).intValue());

        Assert.assertEquals(3, list.get(0).intValue());
        list.remove(0);
        Assert.assertEquals(10, list.get(0).intValue());
        Assert.assertEquals(3, list.size().intValue());
    }

    @Test
    public void testContains() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.add(3);
        list.add(10);
        list.add(15);
        list.add(2);
        list.add(-14);

        Assert.assertTrue(list.contains(3));
        Assert.assertTrue(list.contains(-14));
        Assert.assertTrue(list.contains(15));

        Assert.assertFalse(list.contains(213));

    }

    @Test
    public void testFind() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.add(3);
        list.add(10);
        list.add(15);
        list.add(2);
        list.add(-14);

        Assert.assertEquals( 0, list.find(3).intValue() );
        Assert.assertEquals( 2, list.find(15).intValue() );
        Assert.assertEquals( 4, list.find(-14).intValue() );

    }

    @Test
    public void testSize() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.add(3);
        list.add(10);
        list.add(15);
        list.add(2);
        list.add(-14);


        Assert.assertEquals(5, list.size().intValue());
    }

    @Test
    public void testGet() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.add(3);
        list.add(10);
        list.add(15);
        list.add(2);
        list.add(-14);

        Assert.assertEquals(3, list.get(0).intValue());
        Assert.assertEquals(10, list.get(1).intValue());
        Assert.assertEquals(2, list.get(3).intValue());
        Assert.assertEquals(-14, list.get(4).intValue());

    }

    @Test
    public void testClone() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.add(3);
        list.add(10);
        list.add(15);
        list.add(2);
        list.add(-14);

        SinglyLinkedList<Integer> newList = list.copy();

        Assert.assertEquals(3, newList.get(0).intValue());
        Assert.assertEquals(10, newList.get(1).intValue());
        Assert.assertEquals(2, newList.get(3).intValue());
        Assert.assertEquals(-14, newList.get(4).intValue());
    }


    @Test
    public void testSort() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.add(3);
        list.add(10);
        list.add(15);
        list.add(2);
        list.add(-14);

        list.sort(Comparator.<Integer>naturalOrder());

        Assert.assertEquals(-14, list.get(0).intValue());
        Assert.assertEquals(2, list.get(1).intValue());
        Assert.assertEquals(10, list.get(3).intValue());
        Assert.assertEquals(15, list.get(4).intValue());
    }
}
