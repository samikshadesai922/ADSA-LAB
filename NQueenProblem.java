import java.util.Scanner;

public class NQueenProblem
{
    // Function to print the board
    public static void printBoard(int[][] board, int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Function to check if queen can be placed safely
    public static boolean isSafe(int[][] board, int row, int col, int n)
    {
        // Check column
        for (int i = 0; i < row; i++)
        {
            if (board[i][col] == 1)
            {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        {
            if (board[i][j] == 1)
            {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++)
        {
            if (board[i][j] == 1)
            {
                return false;
            }
        }

        return true;
    }

    // Recursive function to solve N-Queen problem
    public static boolean solveNQ(int[][] board, int row, int n)
    {
        if (row == n)
        {
            printBoard(board, n);   // Print one solution
            return true;
        }

        boolean res = false;

        for (int col = 0; col < n; col++)
        {
            if (isSafe(board, row, col, n))
            {
                board[row][col] = 1;   // Place queen

                res = solveNQ(board, row + 1, n) || res;

                board[row][col] = 0;   // Backtrack
            }
        }

        return res;
    }

    // Main driver
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of queens (N): ");
        int n = sc.nextInt();

        int[][] board = new int[n][n];

        if (!solveNQ(board, 0, n))
        {
            System.out.println("No solution exists");
        }

        sc.close();
    }
}
