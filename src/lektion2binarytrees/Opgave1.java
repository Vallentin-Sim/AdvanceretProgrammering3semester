package lektion2binarytrees;

import lektion2binarytrees.lektionsmateriale.BST;

public class Opgave1 {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.insert(45);
        bst.insert(22);
        bst.insert(77);
        bst.insert(11);
        bst.insert(30);
        bst.insert(90);
        bst.insert(15);
        bst.insert(25);
        bst.insert(88);
        bst.preorder();
        bst.inorder();
        bst.postorder();
    }
}
