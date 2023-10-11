class AVLNode {
    int value, height;
    AVLNode left, right;

    AVLNode(int d) {
        value = d;
        height = 1;
    }
}

class AVLTree {
    AVLNode root;

    int height(AVLNode N) {
        if (N == null)
            return 0;
        return N.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    }

    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }

    int getBalance(AVLNode N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    AVLNode insert(AVLNode node, int value) {
        if (node == null)
            return (new AVLNode(value));
        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);
        else
            return node;

        node.height = 1 + max(height(node.left), height(node.right));
        int balance = getBalance(node);
        if (balance > 1 && value < node.left.value)
            return rightRotate(node);
        if (balance < -1 && value > node.right.value)
            return leftRotate(node);
        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
}

class BTreeNode {
    int[] keys;
    int t; // Minimum degree (defines the range for number of keys)
    BTreeNode[] children;
    int numKeys; // Current number of keys
    boolean isLeaf;

    public BTreeNode(int t, boolean isLeaf) {
        this.t = t;
        this.isLeaf = isLeaf;
        keys = new int[2 * t - 1];
        children = new BTreeNode[2 * t];
        numKeys = 0;
    }
}

class BTree {
    BTreeNode root;
    int t;

    BTree(int t) {
        this.t = t;
        root = null;
    }

    void insert(int k) {
        if (root == null) {
            root = new BTreeNode(t, true);
            root.keys[0] = k;
            root.numKeys = 1;
        } else {
            if (root.numKeys == 2 * t - 1) {
                BTreeNode s = new BTreeNode(t, false);
                s.children[0] = root;
                splitChild(s, 0);
                int i = 0;
                if (s.keys[0] < k) i++;
                insertNonFull(s.children[i], k);
                root = s;
            } else {
                insertNonFull(root, k);
            }
        }
    }

    void splitChild(BTreeNode x, int i) {
        BTreeNode z = new BTreeNode(t, x.children[i].isLeaf);
        z.numKeys = t - 1;
        for (int j = 0; j < t - 1; j++) {
            z.keys[j] = x.children[i].keys[j + t];
        }
        if (!x.children[i].isLeaf) {
            for (int j = 0; j < t; j++) {
                z.children[j] = x.children[i].children[j + t];
            }
        }
        x.children[i].numKeys = t - 1;
        for (int j = x.numKeys; j >= i + 1; j--) {
            x.children[j + 1] = x.children[j];
        }
        x.children[i + 1] = z;
        for (int j = x.numKeys - 1; j >= i; j--) {
            x.keys[j + 1] = x.keys[j];
        }
        x.keys[i] = x.children[i].keys[t - 1];
        x.numKeys = x.numKeys + 1;
    }

    void insertNonFull(BTreeNode x, int k) {
        int i = x.numKeys - 1;
        if (x.isLeaf) {
            while (i >= 0 && k < x.keys[i]) {
                x.keys[i + 1] = x.keys[i];
                i--;
            }
            x.keys[i + 1] = k;
            x.numKeys = x.numKeys + 1;
        } else {
            while (i >= 0 && k < x.keys[i]) i--;
            i++;
            if (x.children[i].numKeys == 2 * t - 1) {
                splitChild(x, i);
                if (k > x.keys[i]) i++;
            }
            insertNonFull(x.children[i], k);
        }
    }

    BTreeNode search(BTreeNode x, int k) {
        int i = 0;
        while (i < x.numKeys && k > x.keys[i]) {
            i++;
        }
        if (i < x.numKeys && k == x.keys[i]) {
            return x; // Found the key.
        } else if (x.isLeaf) {
            return null; // Key not found.
        }
        return search(x.children[i], k); // Recurse to the next level.
    }

    public static void main(String[] args) {
        BTree bTree = new BTree(3);

        // Insert into BTree
        bTree.insert(10);
        bTree.insert(20);
        bTree.insert(5);
        bTree.insert(6);
        bTree.insert(12);
        bTree.insert(30);
        bTree.insert(7);
        bTree.insert(17);

        // Search in BTree
        BTreeNode foundNode = bTree.search(bTree.root, 6);
        if (foundNode != null) {
            System.out.println("Key 6 found in BTree.");
        } else {
            System.out.println("Key 6 not found in BTree.");
        }
    }
}

        // Delete from BTree (placeholder, not functional)
        // bTree.delete(6);


        //AVLTree avlTree = new AVLTree();

        // Insert into AVL
        //avlTree.root = avlTree.insert(avlTree.root, 10);
        //avlTree.root = avlTree.insert(avlTree.root, 20);
        //avlTree.root = avlTree.insert(avlTree.root, 5);

        // Search in AVL
        //boolean foundInAVL = avlTree.search(avlTree.root, 5);
       // if (foundInAVL) {
          //  System.out.println("Key 5 found in AVL.");
        //} else {
      //      System.out.println("Key 5 not found in AVL.");
    //    }
  //  }
//}

