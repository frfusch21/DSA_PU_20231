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
    //@TODO with iterative, will upload later -FY
        return null;
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
