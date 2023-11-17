import java.util.ArrayList;
import java.util.List;

public class SparseMatrix {
    private List<Node> nodes;
    private int numRows;
    private int numCols;

    public SparseMatrix(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.nodes = new ArrayList<>();
    }

    public void addElement(int row, int col, int value) {
        if (row >= numRows || col >= numCols || row < 0 || col < 0) {
            throw new IllegalArgumentException("Invalid row or column index.");
        }
        if (value != 0) {
            nodes.add(new Node(row, col, value));
        }
    }

    public int get(int row, int col) {
        if (row >= numRows || col >= numCols || row < 0 || col < 0) {
            throw new IllegalArgumentException("Invalid row or column index.");
        }
        for (Node node : nodes) {
            if (node.row == row && node.col == col) {
                return node.value;
            }
        }
        return 0;
    }

    private static class Node {
        int row;
        int col;
        int value;

        Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                sb.append(get(row, col)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Create a 5x5 sparse matrix
        SparseMatrix sparseMatrix = new SparseMatrix(5, 5);

        // Add some elements
        sparseMatrix.addElement(0, 1, 1);
        sparseMatrix.addElement(1, 2, 5);
        sparseMatrix.addElement(2, 3, 8);
        sparseMatrix.addElement(3, 4, 2);

        // Print the entire matrix
        System.out.println("Sparse Matrix:");
        System.out.println(sparseMatrix);

        // Retrieve and print a specific element
        int value = sparseMatrix.get(1, 2);
        System.out.println("Value at (1, 2): " + value);
    }
}

