package edu.ithillel.dataStructures;

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}

public class LinkedBinaryTree implements Tree {
    Node root;

    public LinkedBinaryTree() {
        root = null;
    }

    @Override
    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insertRecursive(root, value);
        }
    }

    @Override
    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root != null) {
            traverseInOrder(root.left);
            System.out.print(root.value + " ");
            traverseInOrder(root.right);
        }
    }

    private void insertRecursive(Node root, int value) {
        if (value < root.value) {
            if (root.left == null) {
                root.left = new Node(value);
            } else {
                insertRecursive(root.left, value);
            }
        } else if (value > root.value) {
            if (root.right == null) {
                root.right = new Node(value);
            } else {
                insertRecursive(root.right, value);
            }
        }
    }

    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);
        System.out.println("Inorder traversal:");
        tree.traverseInOrder();
    }
}
