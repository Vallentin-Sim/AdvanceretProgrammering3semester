package lektion3binarytreeMedDictionary;

import lektion3binarytreeMedDictionary.lektionsmateriale.BST;

import java.util.Arrays;

public class Opgave2 {
    // Implementere removeMin(), removeMax(), greaterThanCount(E element), greaterThan(E element).

    // Test løsningerne her.
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] values = {45, 22, 77, 11, 30, 90, 15, 25, 88};
        for (int v : values) {
            bst.insert(v);
        }

        System.out.println("greaterThanCount(30) = " + bst.greaterThanCount(30)); // forvent 4 (45,77,88,90)
        System.out.println("greaterThanCount(45) = " + bst.greaterThanCount(45)); // forvent 3 (77,88,90)
        System.out.println("greaterThanCount(88) = " + bst.greaterThanCount(88)); // forvent 1 (90)
        System.out.println("greaterThanCount(100) = " + bst.greaterThanCount(100)); // forvent 0

        System.out.println("greaterThan(30) = " + bst.greaterThan(30)); // forvent [45,77,90,88] (rækkefølge kan variere)
        System.out.println("greaterThan(45) = " + bst.greaterThan(45)); // forvent [77,90,88]
        System.out.println("greaterThan(88) = " + bst.greaterThan(88)); // forvent [90]
        System.out.println("greaterThan(100) = " + bst.greaterThan(100)); // forvent []

        System.out.println("Inorder før: " + bst.toString());
        System.out.println("Size før: " + bst.getSize());

        bst.removeMin();
        System.out.println("Efter removeMin: " + bst.toString());
        System.out.println("Size efter removeMin: " + bst.getSize());
        // forvent at 11 er fjernet

        while (bst.getSize() != 0){
            bst.removeMax();
            System.out.println("Efter removeMax: " + bst.toString());
            System.out.println("Size efter removeMax: " + bst.getSize());
            // forvent at 90 er fjernet
        }
    }
}
