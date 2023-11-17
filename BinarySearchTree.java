class Node {
    //Construct a node
    int data;
    Node left, right;

    public Node(int item) {
        data = item;

        //Set left and right node as null
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root; //Construct the root

    // Function to search for an element
    boolean findElement(Node node, int value) {
        //Set as boolean to determine Tur or False element exist.
        if (node == null) { //Node does not exist
            return false;
        }

        if (node.data == value) { //Node exist
            return true;
        }
        //Check the left subtree if value searched is less than current node.
        if (value < node.data) {
            return findElement(node.left, value);
        }
        //Executed only if value is greater than the current node.
        return findElement(node.right, value);
    }

    // Function to find minimum value node
    //Return the minimum value and not just boolean
    Integer findMinimum(Node node) {
        if (node == null) { //Base condition check if tree is null or not
            return null;
        }
        //Check if node on left subtree exist
        if (node.left == null) {
            return node.data;
        }
        //Return left subtree recursively
        return findMinimum(node.left);
    }

    // Function to find maximum value node
    Integer findMaximum(Node node) {
        if (node == null) { //Base condition if tree is null
            return null;
        }
        //check if node on right subtree exist
        if (node.right == null) {
            return node.data;
        }
        //Call function recursively until maximum value is found
        return findMaximum(node.right);
    }

    // Function to insert a new node
    Node insert(Node node, int value) {
        if (node == null) { //Base condition to check if tree is null
            return new Node(value);
        }
        //Check condition if value inserted is less than current node
        if (value < node.data) {
            //Insert to the left
            node.left = insert(node.left, value);
        } else { //If value is greater than current node
            //Insert to the right
            node.right = insert(node.right, value);
        }

        return node;
    }

    // Function to delete a node
    Node deleteNode(Node node, int value) {
        if (node == null) { //Base condition to check if tree is null
            return null;
        }
        //Check if value is less than current node
        if (value < node.data) {
            //Delete node on the left
            node.left = deleteNode(node.left, value);
        } else if (value > node.data) { //if it's greater than current node
            //Delete node on the right
            node.right = deleteNode(node.right, value);
        } else {
            //If node on the left is null
            if (node.left == null) {
                //Node right become the newNode
                return node.right;
            } else if (node.right == null) {//If node on the right is null
                //Node left become the newNode
                return node.left;
            }
            //Find maximum value to recalculate the BST
            node.data = findMaximum(node.left).intValue();
            //delete left node
            node.left = deleteNode(node.left, node.data);
        }

        return node;
    }

    // Function to handle deletion of nodes with two children
    void deleteNodeWithTwoChildren(Node tree, Node node) {
        if (node.left != null && node.right != null) {
            //Make left child that wants to be deleted, temporary node
            Node temp = node.left;
            node.data = temp.data;

            //Right child of temporary node
            if (temp.right != null) {
                //Find maximum on the right
                findMax(temp).right = temp.right;
            }
            //Make the maximum node, the new right node
            node.right = temp.right;
            //delete temporary node
            deleteNode(tree, temp.data);
        }
    }

    // Function to find node with the maximum value
    Node findMax(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // This function is to initiate the delete operation
    void deleteNode(int value) {
        root = deleteNode(root, value);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 25);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);

        System.out.println("Element 40 exists: " + tree.findElement(tree.root, 40));

        // Delete node with value 40
        tree.deleteNode(40);
        System.out.println("Element 40 exists after deletion: " + tree.findElement(tree.root, 40));
    }
}

