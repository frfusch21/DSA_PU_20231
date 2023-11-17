public class SudokuSolver {

    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        int[][] grid = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solveSudoku(grid)) {
            printGrid(grid);
        } else {
            System.out.println("No solution exists");
        }
    }

    private static boolean solveSudoku(int[][] grid) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (grid[row][col] == 0) {
                    for (int number = 1; number <= GRID_SIZE; number++) {
                        if (isSafe(grid, row, col, number)) {
                            grid[row][col] = number;

                            if (solveSudoku(grid)) {
                                return true;
                            } else {
                                grid[row][col] = 0; // Backtrack
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true; // Puzzle solved
    }

    private static boolean isSafe(int[][] grid, int row, int col, int num) {
        for (int d = 0; d < grid.length; d++) {
            if (grid[row][d] == num) {
                return false;
            }
        }

        for (int r = 0; r < grid.length; r++) {
            if (grid[r][col] == num) {
                return false;
            }
        }

        int sqrt = (int) Math.sqrt(grid.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (grid[r][d] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printGrid(int[][] grid) {
        for (int r = 0; r < GRID_SIZE; r++) {
            for (int d = 0; d < GRID_SIZE; d++) {
                System.out.print(grid[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int) Math.sqrt(GRID_SIZE) == 0)
                System.out.print("");
        }
    }
}
