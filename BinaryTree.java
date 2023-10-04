import java.util.*;

class TreeNode<T extends Comparable<T>> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    // Constructor to initialize a new node
    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree<T extends Comparable<T>> {
    TreeNode<T> root;

    public TreeNode<T> insertNode(TreeNode<T> current, T value) {
        if (current == null) {
            return new TreeNode<>(value);
        }

        if (value.compareTo(current.data) < 0) {
            current.left = insertNode(current.left, value);
        } else if (value.compareTo(current.data) > 0) {
            current.right = insertNode(current.right, value);
        }

        return current;
    }

    public TreeNode<T> searchNode(TreeNode<T> current, T value) {
        if (current == null || current.data.equals(value)) {
            return current;
        }

        if (current.data.compareTo(value) > 0) {
            return searchNode(current.left, value);
        }

        return searchNode(current.right, value);
    }

    public TreeNode<T> deleteNode(TreeNode<T> current, T value) {
        if (current == null) return current;

        if (value.compareTo(current.data) < 0) {
            current.left = deleteNode(current.left, value);
        } else if (value.compareTo(current.data) > 0) {
            current.right = deleteNode(current.right, value);
        } else {
            if (current.left == null) return current.right;
            else if (current.right == null) return current.left;

            current.data = minValue(current.right);
            current.right = deleteNode(current.right, current.data);
        }

        return current;
    }

    public T minValue(TreeNode<T> root) {
        T minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        // Creating binary tree nodes and forming the tree
        binaryTree.root = binaryTree.insertNode(binaryTree.root, 10);
        binaryTree.insertNode(binaryTree.root, 5);
        binaryTree.insertNode(binaryTree.root, 15);

        // Displaying the data in the root node
        System.out.println("Root Node Data: " + binaryTree.root.data);

        // Displaying the data in the left and right child nodes
        System.out.println("Left Child Data: " + binaryTree.root.left.data);
        System.out.println("Right Child Data: " + binaryTree.root.right.data);
    }
}
