import java.util.Scanner;

public class LongestCommonSubsequence
{
    // Function to find LCS length
    public static int lcs(String s1, String s2)
    {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Build dp table
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    // Function to reconstruct LCS string
    public static String getLCS(String s1, String s2)
    {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstruct LCS string
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0)
        {
            if (s1.charAt(i - 1) == s2.charAt(j - 1))
            {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            }
            else if (dp[i - 1][j] > dp[i][j - 1])
            {
                i--;
            }
            else
            {
                j--;
            }
        }

        return lcs.reverse().toString();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        int length = lcs(s1, s2);
        String subsequence = getLCS(s1, s2);

        System.out.println("\nString 1: " + s1);
        System.out.println("String 2: " + s2);
        System.out.println("Length of LCS: " + length);
        System.out.println("LCS: " + subsequence);

        sc.close();
    }
}
