import java.util.Scanner;

public class FloydWarshall
{
    final static int INF = 99999; // Representing infinity

    // Function to implement Floyd Warshall Algorithm
    public static void floydWarshall(int graph[][], int V)
    {
        int dist[][] = new int[V][V];

        // Initialize solution matrix same as input graph
        for (int i = 0; i < V; i++)
        {
            for (int j = 0; j < V; j++)
            {
                dist[i][j] = graph[i][j];
            }
        }

        // Floyd-Warshall Algorithm
        for (int k = 0; k < V; k++)
        {
            for (int i = 0; i < V; i++)
            {
                for (int j = 0; j < V; j++)
                {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                    {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print shortest distance matrix
        printSolution(dist, V);
    }

    // Function to print solution
    public static void printSolution(int dist[][], int V)
    {
        System.out.println("\nAll Pairs Shortest Path Matrix:");

        for (int i = 0; i < V; i++)
        {
            for (int j = 0; j < V; j++)
            {
                if (dist[i][j] == INF)
                {
                    System.out.print("INF ");
                }
                else
                {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int graph[][] = new int[V][V];

        System.out.println("Enter adjacency matrix (use " + INF + " for no edge): ");
        for (int i = 0; i < V; i++)
        {
            for (int j = 0; j < V; j++)
            {
                graph[i][j] = sc.nextInt();
            }
        }

        floydWarshall(graph, V);

        sc.close();
    }
}
