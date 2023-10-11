class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinarySearchTree {

    Node root;

    // Function to search for an element
    boolean findElement(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (node.data == value) {
            return true;
        }

        if (value < node.data) {
            return findElement(node.left, value);
        }

        return findElement(node.right, value);
    }

    // Function to find minimum value node
    Integer findMinimum(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left == null) {
            return node.data;
        }

        return findMinimum(node.left);
    }

    // Function to find maximum value node
    Integer findMaximum(Node node) {
        if (node == null) {
            return null;
        }

        if (node.right == null) {
            return node.data;
        }

        return findMaximum(node.right);
    }

    // Function to insert a new node
    Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.data) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        return node;
    }

    // Function to delete a node
    Node deleteNode(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.data) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.data) {
            node.right = deleteNode(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.data = findMaximum(node.left).intValue();
            node.left = deleteNode(node.left, node.data);
        }

        return node;
    }

    // Function to handle deletion of nodes with two children
    void deleteNodeWithTwoChildren(Node tree, Node node) {
        if (node.left != null && node.right != null) {
            Node temp = node.left;
            node.data = temp.data;

            if (temp.right != null) {
                findMax(temp).right = temp.right;
            }

            node.right = temp.right;
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

