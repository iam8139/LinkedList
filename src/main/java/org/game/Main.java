package org.game;

import org.game.service.LinkedList;
import org.game.serviceImpl.LinkedListImpl;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
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
    }
}