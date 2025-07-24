
import java.util.Scanner;

public class MergeSort {
    
    public static void mergeSort(int[] arr, int lb, int ub) {
        if (lb < ub) {
            int mid = lb + (ub - lb) / 2;
            
            // Recursively sort first and second halves


            mergeSort(arr, lb, mid);
            mergeSort(arr, mid + 1, ub);
            
            // Merge the sorted halves
            merge(arr, lb, mid, ub);
        }
    }
    
    public static void merge(int[] arr, int lb, int mid, int ub)
     {
        // Find sizes of two subarrays to be merged

        int n1 = mid - lb + 1;
        int n2 = ub - mid;
        
        // Create temporary arrays

        int[] left = new int[n1];
        int[] right = new int[n2];
        
       


        for (int i = 0; i < n1; i++)
            left[i] = arr[lb + i];

        for (int j = 0; j < n2; j++)
            right[j] = arr[mid + 1 + j];
        
       

        int i = 0, j = 0;
        int k = lb;
        
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of left[], if any

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of right[], if any

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    
    public static void printArray(int[] arr)
     {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
       
        
        // Call merge sort with lb=0 and ub=n-1
        mergeSort(arr, 0, n - 1);
        
        System.out.println("Sorted array:");
        printArray(arr);
        
        scanner.close();
    }
}
