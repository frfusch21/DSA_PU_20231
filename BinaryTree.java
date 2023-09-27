class TreeNode<T> {
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

public class BinaryTree {
    public static void main(String[] args) {
        // Creating binary tree nodes
        TreeNode<Integer> rootNode = new TreeNode<>(10);
        TreeNode<Integer> leftChild = new TreeNode<>(5);
        TreeNode<Integer> rightChild = new TreeNode<>(15);

        // Connecting nodes to form a binary tree
        rootNode.left = leftChild;
        rootNode.right = rightChild;

        // Displaying the data in the root node
        System.out.println("Root Node Data: " + rootNode.data);

        // Displaying the data in the left and right child nodes
        System.out.println("Left Child Data: " + rootNode.left.data);
        System.out.println("Right Child Data: " + rootNode.right.data);
    }
}
