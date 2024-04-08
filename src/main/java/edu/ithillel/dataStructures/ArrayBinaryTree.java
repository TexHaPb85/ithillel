package edu.ithillel.dataStructures;

public class ArrayBinaryTree<T extends Comparable<T>> {
    private T[] array;

    public ArrayBinaryTree(int size) {
        array = null;
    }

    public void insert(T value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = value;
                return;
            }
        }
        System.out.println("Tree is full, cannot insert more elements.");
    }

    public void traverseInOrder(){
        traverseInOrder(0);
    }

    public void traverseInOrder(int index) {
        if (index >= array.length) {
            return;
        }
        traverseInOrder(2 * index + 1);
        System.out.print(array[index] + " ");
        traverseInOrder(2 * index + 2);
    }

    public static void main(String[] args) {
//        ArrayBinaryTree<Person> tree = new ArrayBinaryTree<>(10);
//        tree.insert(new Person());
//        tree.insert(3);
//        tree.insert(8);
//        tree.insert(2);
//        tree.insert(4);
//        tree.insert(7);
//        tree.insert(9);
//        System.out.println("Inorder traversal:");
//        tree.traverseInOrder(0);
        "12344567".lastIndexOf("12344567");
        System.out.println(findSymbolOccurance("12344567", '4'));
    }

    public static int findSymbolOccurance(String str, char chr) {
        return (int) str.chars().filter(c -> c == chr).count();
    }
}


