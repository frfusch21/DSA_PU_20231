import java.util.*;

class TreeNode<T extends Comparable<T>> { //Construct A Tree Node
    T data;
    TreeNode<T> left; //Construct Left node
    TreeNode<T> right; //Construct Right node

    //Constructor to initialize a new node
    public TreeNode(T data){
        this.data = data;
        this.left = null; //Assign null to the left
        this.right = null; //Assign null to the right
    }
}

public class BinaryTree<T extends Comparable<T>> {
    TreeNode<T> root;

    public TreeNode<T> insertNode(TreeNode<T> current, T value) {
        //Do insert recursively
        if(current == null){
            return  new TreeNode<>(value);
        }
        if(value.compareTo(current.data) < 0){ //Less than 0 insert to left
            current.left = insertNode(current.left, value);
        } else if(value.compareTo(current.data) > 0){ //More than 0 insert to right
            current.right = insertNode(current.right, value);
        }

        return current;
    }

    public TreeNode<T> searchNode(TreeNode<T> current, T value) {
        //Do search recursively
        if(current == null || current.data.equals((value))){ //Data is on the root or null
            return  current;
        }

        if(current.data.compareTo(value) > 0){ //Searching on the left first
            return searchNode(current.left, value);
        }

        //If value is not found in left subtree, go to right subtree
        return searchNode(current.right, value);
    }

    public TreeNode<T> deleteNode(TreeNode<T> current, T value) {
        if (current == null) {
            return null;
        }

        TreeNode<T> parent = null;  // To keep track of the parent of the current node.
        TreeNode<T> node = current; // Starting with the root node to search for the node to delete.

        // Step 1: Search for the node to be deleted.
        while (node != null && !node.data.equals(value)) {
            parent = node;
            if (value.compareTo(node.data) < 0) {
                node = node.left;  // Go left if value is smaller.
            } else {
                node = node.right; // Go right if value is larger.
            }
        }

        // If node is not found in the tree, return the original tree.
        if (node == null) {
            return current;
        }

        // Step 2: Handle the cases for node deletion.

        // Case 1: Node to be deleted has no children (leaf node).
        if (node.left == null && node.right == null) {
            // If the node is the root node itself, return null.
            if (node == current) {
                return null;
            }
            // Disconnect the node from its parent.
            if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        // Case 2: Node to be deleted has only one child.
        else if (node.left == null || node.right == null) {
            TreeNode<T> child = (node.left != null) ? node.left : node.right;

            // If the node to delete is the root, make the child the new root.
            if (node == current) {
                return child;
            }

            // Otherwise, reconnect the parent to the child.
            if (parent.left == node) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        // Case 3: Node to be deleted has two children.
        else {
            // Find the in-order successor (the smallest value in the right subtree).
            TreeNode<T> successorParent = node;
            TreeNode<T> successor = node.right;

            // Find the leftmost child of the right subtree (smallest node).
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // Replace the node's data with the successor's data.
            node.data = successor.data;

            // Now delete the successor node.
            if (successorParent.left == successor) {
                successorParent.left = successor.right; // Successor might have a right child.
            } else {
                successorParent.right = successor.right;
            }
        }

        return current;  // Return the root of the modified tree.
    }

    public T minValue(TreeNode<T> root) {
        //Search for the minimum value inside a tree
        T minValue = root.data; //Assign Root as the minimum value in the beginning.
        while (root.left != null){ //If left child of the root exist, assign it as minValue
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public static void main(String[] args) {
        //OOP to call upon the class
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        //Create binary tree nodes and form the tree
        binaryTree.root = binaryTree.insertNode(binaryTree.root,20);
        binaryTree.insertNode(binaryTree.root,5);
        binaryTree.insertNode(binaryTree.root,25);
        //@TODO Add traverse to the next node

        //Display data in the root node
        System.out.println("Root Node Data: " + binaryTree.root.data);

        //Display the data in the left and right child nodes
        System.out.println("Left Child Node Data: " + binaryTree.root.left.data);
        System.out.println("Right Child Node Data: " + binaryTree.root.right.data);

    }
}
