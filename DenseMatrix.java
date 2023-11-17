public class DenseMatrix {
    private int[][] matrix;
    private int numRows;
    private int numCols;

    public DenseMatrix(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.matrix = new int[numRows][numCols];
    }

    public void setElement(int row, int col, int value) {
        if (row >= numRows || col >= numCols || row < 0 || col < 0) {
            throw new IllegalArgumentException("Invalid row or column index.");
        }
        matrix[row][col] = value;
    }

    public int getElement(int row, int col) {
        if (row >= numRows || col >= numCols || row < 0 || col < 0) {
            throw new IllegalArgumentException("Invalid row or column index.");
        }
        return matrix[row][col];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                sb.append(matrix[row][col]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Create a 3x3 dense matrix
        DenseMatrix denseMatrix = new DenseMatrix(3, 3);

        // Set some elements
        denseMatrix.setElement(0, 0, 1);
        denseMatrix.setElement(1, 1, 2);
        denseMatrix.setElement(2, 2, 3);

        // Print the entire matrix
        System.out.println("Dense Matrix:");
        System.out.println(denseMatrix);

        // Retrieve and print a specific element
        int value = denseMatrix.getElement(1, 1);
        System.out.println("Value at (1, 1): " + value);
    }
}
