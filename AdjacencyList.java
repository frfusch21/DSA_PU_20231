import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdjacencyList {
    //Function to declare the list
    public static List<Integer>[] initializeAdjacencyList(int vertices) {
        //Declare the list
        List<Integer>[] adjacencyList = new ArrayList[vertices];
        //Loop to assign the ArrayList to the adjacency list
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        return adjacencyList;
    }

    public static List<Integer>[] addEdgeToList(List<Integer>[] adjacencyList, int u, int v, boolean isDirected) {
        adjacencyList[u].add(v); //We add the second Vertex to the list
        if (!isDirected) { //Check if it's directed or undirected
            adjacencyList[v].add(u); //We add the first vertex to the list also
        }
        return adjacencyList;
    }

    public static void displayList(List<Integer>[] adjacencyList) {
        //Loop to display the list
        for (int i = 0; i < adjacencyList.length; i++) {
            System.out.println("Vertex " + i + ": " + adjacencyList[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int numberOfVertices = scanner.nextInt();

        System.out.print("Is the graph directed? (true for directed, false for undirected): ");
        boolean isDirected = scanner.nextBoolean();

        //Call the function to initialize the list
        List<Integer>[] adjacencyList = initializeAdjacencyList(numberOfVertices);

        System.out.print("Enter number of edges: ");
        int numberOfEdges = scanner.nextInt();

        for (int i = 0; i < numberOfEdges; i++) {
            System.out.println("Enter source and destination vertex for edge " + (i + 1) + ":");
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjacencyList = addEdgeToList(adjacencyList, u, v, isDirected);
        }

        // Display the adjacency list
        displayList(adjacencyList);

        scanner.close();
    }
}
