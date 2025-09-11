import java.util.Scanner;

public class OptimalTapeStorage {

    // Bubble Sort to arrange program lengths in ascending order
    static void bubbleSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of programs: ");
        int n = sc.nextInt();

        int[] programs = new int[n];

        System.out.println("Enter program lengths:");
        for (int i = 0; i < n; i++) {
            programs[i] = sc.nextInt();
        }

        // Step 1: Sort using Bubble Sort
        bubbleSort(programs, n);

        // Step 2: Calculate Retrieval Time and MRT
        int[] retrievalTime = new int[n];
        retrievalTime[0] = programs[0];
        int total = retrievalTime[0];

        for (int i = 1; i < n; i++) {
            retrievalTime[i] = retrievalTime[i - 1] + programs[i];
            total += retrievalTime[i];
        }

        double MRT = (double) total / n;

        // Output results
        System.out.println("\nOptimal Order of Programs (after sorting):");
        for (int i = 0; i < n; i++) {
            System.out.print(programs[i] + " ");
        }

        System.out.println("\n\nRetrieval Times:");
        for (int i = 0; i < n; i++) {
            System.out.println("Program " + (i + 1) + " : " + retrievalTime[i]);
        }

        System.out.println("\nMean Retrieval Time (MRT) = " + MRT);

        sc.close();
    }
}
