import java.util.Scanner;

public class AdjacencyMatrix {
    //Function used to build the matrix based on vertex from user input
    public static int[][] initializeMatrix(int vertices) {
        //The matrix ordo(order) will consist of vertices inputted by the user
        int[][] matrix = new int[vertices][vertices];
        //Loop to fill the matrix with 0's (Zeroes)
        for (int i = 0; i < vertices; i++) { //Loop Row
            for (int j = 0; j < vertices; j++) { //Loop Column
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    //Function to add edge (turn 0 to 1) on the matrix
    public static int[][] addEdge(int[][] matrix, int u, int v, boolean isDirected) {
        matrix[u][v] = 1; //Changing the value of the matrix based on the ordo value
        if (!isDirected) { //Check if it is directed or undirected graph
            matrix[v][u] = 1; //If it is undirected then also turn v,u to 1
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //User input
        //Insert user value for how many vertex in the graph
        System.out.println("Enter number of vertices:");
        int numberOfVertices = scanner.nextInt();
        //Insert value to determine graph directed or undirected
        System.out.println("Is the graph directed? (true for directed, false for undirected):");
        boolean isDirected = scanner.nextBoolean();

        //Call the function to build the matrix
        int[][] adjMatrix = initializeMatrix(numberOfVertices);
        //Enter how many edges
        System.out.println("Enter number of edges:");
        int numberOfEdges = scanner.nextInt();

        //Loop to enter the vertex that connects to each other
        for (int i = 1; i <= numberOfEdges; i++) {
            System.out.println("Enter source and destination vertex for edge " + i + ":");
            int u = scanner.nextInt(); //The row of the vertex
            int v = scanner.nextInt(); //The column of the vertex
            adjMatrix = addEdge(adjMatrix, u, v, isDirected);
        }
        //Display the matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
