package org.game;

import org.game.service.CircularlyLinkedList;
import org.game.service.DoublyLinkedList;
import org.game.service.LinkedList;
import org.game.service.List;
import org.game.serviceImpl.ArrayList;
import org.game.serviceImpl.CircularlyLinkedListImpl;
import org.game.serviceImpl.DoublyLinkedListImpl;
import org.game.serviceImpl.LinkedListImpl;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        testListADT();

        // LinkedListTest
        System.out.println("--------- Test Started for Single LinkedList ---------");

        LinkedList<String> list = new LinkedListImpl<>();
        list.addFirst("Kargil");
        list.addLast("Anand");
        list.addLast("Anurag");
        list.addLast("Shreya");
        list.addFirst("Akanksha");
        list.addFirst("Sai");
        System.out.println("first: " + list.first());
        System.out.println("last: " + list.last());
        System.out.println("Initial List Size: " + list.size());
        while (!list.isEmpty()) {
            System.out.println("list element: " + list.removeFirst());
        }

        System.out.println("Final List Size: " + list.size());

        System.out.println("--------- Test Successful for Single LinkedList ---------");

        // Circularly Linked List
        System.out.println("--------- Test Started for Circularly LinkedList ---------");

        CircularlyLinkedList<Person<String, Integer>> circularlyLinkedList = new CircularlyLinkedListImpl<>();
        System.out.println("size: " + circularlyLinkedList.size());
        circularlyLinkedList.addFirst(new Person<>("Kargil", 24));
        circularlyLinkedList.removeFirst();
        System.out.println("First: " + circularlyLinkedList.first());

        circularlyLinkedList.addLast(new Person<>("Abhinav", 31));
        circularlyLinkedList.addFirst(new Person<>("Charul", 30));
        circularlyLinkedList.addLast(new Person<>("Zeba", 31));
        circularlyLinkedList.addFirst(new Person<>("Kargil", 25));

        System.out.println("Updated size: " + circularlyLinkedList.size());
        System.out.println("First: " + circularlyLinkedList.first().toString());
        System.out.println("Last: " + circularlyLinkedList.last().toString());

        while (!circularlyLinkedList.isEmpty()) {
            circularlyLinkedList.rotate();
            System.out.println("Person: " + circularlyLinkedList.removeFirst().toString());
        }

        System.out.println("--------- Test Successful for Circularly LinkedList ---------");


        // Doubly Linked List
        System.out.println("--------- Test Started for Doubly LinkedList ---------");

        DoublyLinkedList<Person<String, String>> doublyLinkedList = new DoublyLinkedListImpl<>();
        System.out.println("Initial size: " + doublyLinkedList.size());
        doublyLinkedList.addFirst(new Person<>("Kargil", "Indore"));
        System.out.println("First Removed: " + doublyLinkedList.removeFirst());
        System.out.println("First Element: " + doublyLinkedList.first());

        doublyLinkedList.addFirst(new Person<>("Abhinav", "Bihar"));
        doublyLinkedList.addLast(new Person<>("Charul", "West Bengal"));
        doublyLinkedList.addFirst(new Person<>("Zeba", "Uttar Pradesh"));
        doublyLinkedList.addLast(new Person<>("Kargil", "Madhya Pradesh"));

        System.out.println("Updated Size: " + doublyLinkedList.size());
        System.out.println("First: " + doublyLinkedList.first().toString());
        System.out.println("Last: " + doublyLinkedList.last().toString());

        while(!doublyLinkedList.isEmpty()) {
            System.out.println("Doubly Linked List Element: " + doublyLinkedList.removeLast().toString());
        }

        System.out.println("--------- Test Successful for Doubly LinkedList ---------");
    }

    public static void testListADT() {
        System.out.println("LIST ADT Test");

        List<Person<String, Integer>> list = new ArrayList<>(3);

        System.out.println("Empty: " + list.isEmpty() + " size: " + list.size());
        Person<String, Integer> p1 = new Person<>("kargil", 25);
        Person<String, Integer> p2 = new Person<>("Anand", 25);
        Person<String, Integer> p3 = new Person<>("Anurag", 25);
        list.add(0, p1);
        System.out.println("Get Person: " + list.get(0));
        System.out.println("Get Person: " + list.get(1));
        list.set(1, p2);
        list.add(2, p3);
        System.out.println("Remove: " + list.remove(0) + " size: " + list.size());
        list.set(2, p1);
    }

    private static class Person<T, E> {
        T name;
        E age;
        public Person(T name, E age) {
            this.name = name;
            this.age = age;
        }

        public T getName() {
            return name;
        }

        public E getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name=" + name +
                    ", age=" + age +
                    '}';
        }
    }
}