package lektion4hashing.undervisningsmateriale;

import java.util.Arrays;

public class MyHashSetChaining<E> implements MySet<E> {
    // The number of elements in the set
    private int size;
    // LOAD Faktor
    /**
    Loadfaktoren beregnes som antallet af elementer divideret med antallet af buckets i hash-tabellen.
    Den viser altså, hvor fyldt tabellen er.
    Hvis loadfaktoren bliver for høj, vil der opstå flere kollisioner, og kæderne i separate chaining bliver længere, hvilket gør operationer som add, contains og remove langsommere.
    Derfor vælger man ofte en grænse på 0.75, fordi den giver en god balance mellem effektiv søgetid og et rimeligt pladsforbrug.
    Når loadfaktoren overstiger denne grænse, udføres rehashing, så elementerne fordeles på en større tabel.
     */
    private static final double maxLoadFaktor = 0.75;

    // Hash table is an array with each cell that is a linked list
    private Node<E>[] table;

    public MyHashSetChaining(int bucketsLength) {
        table = (Node<E>[])new Node[bucketsLength];
        size = 0;
    }

    /** Hash function */
    private int hash(int hashCode) {
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        return hashCode % table.length;
    }

    @Override /** Remove all elements from this set */
    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    @Override /** Return true if the element is in the set */
    public boolean contains(E e) {
        int bucketIndex = hash(e.hashCode());
        boolean found = false;
        Node<E> current = table[bucketIndex];

        while (!found && current != null){
            if (current.data.equals(e)) {
                found = true;
            } else {
                current = current.next;
            }
        }
        return found;
    }

    @Override /** Add an element to the set */
    public boolean add(E e) {
        int bucketIndex = hash(e.hashCode());
        Node<E> current = table[bucketIndex];
        boolean found = false;
        while (!found && current != null) {
            if (current.data.equals(e)) {
                found = true;
                // Already in the set
            } else {
                current = current.next;
            }
        }
        if (!found) {
            Node newNode = new Node();
            newNode.data = e;
            newNode.next = table[bucketIndex];
            table[bucketIndex] = newNode;
            size++;
        }

        double loadFaktor = (double) size / maxLoadFaktor;
        if (loadFaktor > maxLoadFaktor) {
            rehash();
        }
        return !found;
    }

    private void rehash() {
        Node<E>[] oldTable = table;
        table = (Node<E>[]) new Node[oldTable.length * 2];
        size = 0;
        for (Node<E> bucket : oldTable) {
            Node<E> current = bucket;
            while (current != null) {
                add(current.data);
                current = current.next;
            }
        }
    }

    @Override /** Remove the element from the set */
    public boolean remove(E e) {
        int bucketIndex = hash(e.hashCode());
        boolean found = false;
        Node<E> current = table[bucketIndex];

        while (!found && current.next != null){
            if (table[bucketIndex].data.equals(e)) {
                table[bucketIndex] = current.next;
                size--;
                found = true;
            } else if (current.next.data.equals(e)) {
                current.next = current.next.next;
                size--;
                found = true;
            } else {
                current = current.next;
            }
        }
        return found;
    }

    @Override /** Return true if the set contains no elements */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override /** Return the number of elements in the set */
    public int size() {
        return size;
    }

    // method only for test purpose
    void writeOut() {
        for (int i = 0; i < table.length; i++) {
            Node<E> temp = table[i];
            if (temp != null) {
                System.out.print(i + "\t");
                while (temp != null) {
                    System.out.print(temp.data + "\t");
                    temp = temp.next;
                }
                System.out.println();
            }
        }
    }


   private class Node<E>{
        public E data;
        public Node<E> next;
    }

}
