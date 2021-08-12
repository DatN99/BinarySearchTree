package com.company;

public class Main {

    public static void main(String[] args) {

        BST BST = new BST();

        BST.add(5);
        BST.add(1);
        BST.add(10);
        BST.add(3);
        BST.add(9);
        BST.add(15);
        BST.add(14);
        BST.add(13);
        BST.add(2);


        BST.print_postorder();

    }

}



