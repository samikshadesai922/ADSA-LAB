import java.util.Scanner;

public class HamiltonianCycle
{
    int V;
    int path[];

    boolean isSafe(int v, int graph[][], int path[], int pos, boolean visited[])
    {
        // Check if there is an edge from previous vertex to current vertex
        if (graph[path[pos - 1]][v] == 0)
        {
            return false;
        }

        // Check if vertex is already included
        if (visited[v])
        {
            return false;
        }

        return true;
    }

    boolean hamCycleUtil(int graph[][], int path[], boolean visited[], int pos)
    {
        // Base case: if all vertices are included
        if (pos == V)
        {
            // Check if there is an edge from last to first vertex
            if (graph[path[pos - 1]][path[0]] == 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        // Try different vertices as next candidate
        for (int v = 1; v < V; v++)
        {
            if (isSafe(v, graph, path, pos, visited))
            {
                path[pos] = v;
                visited[v] = true;

                if (hamCycleUtil(graph, path, visited, pos + 1))
                {
                    return true;
                }

                // Backtrack
                visited[v] = false;
                path[pos] = -1;
            }
        }

        return false;
    }

    boolean hamCycle(int graph[][])
    {
        path = new int[V];
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++)
        {
            path[i] = -1;
            visited[i] = false;
        }

        // Start at vertex 0
        path[0] = 0;
        visited[0] = true;

        if (hamCycleUtil(graph, path, visited, 1))
        {
            printSolution(path);
            return true;
        }
        else
        {
            System.out.println("No Hamiltonian cycle found");
            return false;
        }
    }

    void printSolution(int path[])
    {
        System.out.print("Hamiltonian Cycle: ");
        for (int i = 0; i < V; i++)
        {
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]);
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        HamiltonianCycle hc = new HamiltonianCycle();

        System.out.print("Enter number of vertices: ");
        hc.V = sc.nextInt();

        int graph[][] = new int[hc.V][hc.V];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < hc.V; i++)
        {
            for (int j = 0; j < hc.V; j++)
            {
                graph[i][j] = sc.nextInt();
            }
        }

        hc.hamCycle(graph);
        sc.close();
    }
}
