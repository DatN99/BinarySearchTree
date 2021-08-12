package com.company;

/**
 * This class contains a simple binary search tree can perform basic BST operations using integers as a value
 * Insertion and Deletion take O(log2 n) time since the amount of nodes is halved for every iterated node.
 * In other words, for 8 nodes, it would take 3 units of time on average to insert a node
 */

public class BST {
    public Node root = null;

    public void add(int data){
        Node newNode = new Node(data);

        if (root == null){
            root = newNode;
        }

        else {
            add_recur(newNode, root);
        }
    }

    public Node add_recur(Node newNode, Node curr){

        if (curr.left == null && newNode.data < curr.data){
            curr.left = newNode;
            return curr.left;
        }

        else if (curr.right == null && newNode.data > curr.data){
            curr.right = newNode;
            return curr.right;
        }

        else if (curr.data > newNode.data){
            return add_recur(newNode, curr.left);
        }

        else {
            return add_recur(newNode, curr.right);
        }
    }

    public Node search(int data, Node curr){

        if (curr == null){
            return null;
        }

        if (curr.left != null) {
            if (curr.left.data == data){
                    return curr;
                }
        }

        if (curr.right != null){
            if (curr.right.data == data){
                return curr;
            }
        }

        if (curr.data < data){
            return search(data, curr.right);
        }

        else {
            return search(data, curr.left);
        }

    }

    public boolean remove(int data){

        Node parent = search(data, root);

        if (parent == null){
            System.out.println("Node doesn't exit.");
        }

        if (root.data == data){

            if (root.left == null && root.right == null){
                root = null;
            }

            else if (root.left == null){
                root = root.right;
            }

            else if (root.right == null){
                root = root.left;
            }

            else {
                Node minRight = findMin(root.right);
                minRight.left = root.left;

                if (root.right != minRight){
                    minRight.right = root.right;
                }

                root = null;

                root = minRight;
            }

            return true;

        }

        //parent's left child is target
        if (parent.left != null) {
            if (parent.left.data == data) {
                Node del = parent.left;

                if (parent.left.left == null && parent.left.right == null) {
                    parent.left = null;
                } else if (parent.left.left == null) {
                    parent.left = parent.left.right;
                } else if (parent.left.right == null) {
                    parent.left = parent.left.left;
                } else {
                    Node minRight = findMin(parent.left.right);
                    minRight.left = parent.left.left;

                    if (parent.left.right != minRight) {
                        minRight.right = parent.left.right;
                    }

                    parent.left = minRight;

                }

                del = null;
                return true;

            }

        }


        //parent's right child is target
        if (parent.right != null) {
            if (parent.right.data == data) {
                Node del = parent.right;

                if (parent.right.left == null && parent.right.right == null) {
                    parent.right = null;
                } else if (parent.right.left == null) {
                    parent.right = parent.right.right;
                } else if (parent.right.right == null) {
                    parent.right = parent.right.left;
                } else {
                    Node minRight = findMin(parent.right.right);
                    minRight.left = parent.right.left;

                    if (parent.right.right != minRight) {
                        minRight.right = parent.right.right;
                    }

                    parent.right = minRight;

                }

                del = null;
                return true;

            }
        }

    return false;
    }


    private Node findMin(Node curr){
        Node min;

        if (curr.left == null){
            return curr;
        }

        else if (curr.left.left == null){
            min = curr.left;
            curr.left = null;
            return min;
        }

        else {
            return findMin(curr.left);
        }
    }

    public void print_inorder(){
        if (root == null){
            System.out.println("BST is empty");
        }

        else{
            InOrder(root);
        }

    }

    private void InOrder(Node node){


        if ( node == null){
            return;
        }

        InOrder(node.left);
        System.out.println(node.data + ", ");
        InOrder(node.right);



    }

    public void print_preorder(){
        if (root == null){
            System.out.println("BST is empty.");
        }

        else{
            PreOrder(root);
        }
    }

    private void PreOrder(Node node){
        if (node == null){
            return;
        }

        System.out.println(node.data);
        PreOrder(node.left);
        PreOrder(node.right);
    }

    public void print_postorder() {
        if (root == null) {
            System.out.println("BST is empty.");
        } else {
            PostOrder(root);
        }
    }

    private void PostOrder(Node node){
        if (node == null){
            return;
        }

        PostOrder(node.left);
        PostOrder(node.right);
        System.out.println(node.data);
    }
}
