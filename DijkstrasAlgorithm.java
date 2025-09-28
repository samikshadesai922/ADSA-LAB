import java.util.Scanner;

public class DijkstrasAlgorithm
{

    static final int INF = Integer.MAX_VALUE;

    // Function to find the vertex with minimum distance value
    static int minDistance(int[] dist, boolean[] visited, int n)
    {
        int min = INF;
        int minIndex = -1;

        for (int v = 0; v < n; v++)
        {
            if (!visited[v] && dist[v] < min)
            {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to implement Dijkstra's algorithm
    static void dijkstra(int[][] graph, int src, int n)
    {
        int[] dist = new int[n];       // Shortest distance from source
        boolean[] visited = new boolean[n]; // Track visited vertices

        // Initialize distances as infinite and visited[] as false
        for (int i = 0; i < n; i++)
        {
            dist[i] = INF;
            visited[i] = false;
        }

        // Distance from source to itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < n - 1; count++)
        {
            int u = minDistance(dist, visited, n);
            visited[u] = true;

            // Update distance of adjacent vertices
            for (int v = 0; v < n; v++)
            {
                if (!visited[v] && graph[u][v] != 0 &&
                    dist[u] != INF &&
                    dist[u] + graph[u][v] < dist[v])
                {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Print the shortest distances
        System.out.println("Vertex   Distance from Source (" + src + ")");
        for (int i = 0; i < n; i++)
        {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    // Main function
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter adjacency matrix (0 if no edge):");
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                graph[i][j] = sc.nextInt();
                if (i == j)
                {
                    graph[i][j] = 0; // no self-loop
                }
            }
        }

        System.out.print("Enter source vertex (0 to " + (n - 1) + "): ");
        int src = sc.nextInt();

        dijkstra(graph, src, n);

        sc.close();
    }
}
