import java.util.Scanner;

public class HashTableWithAscii {

    // Function to calculate ASCII sum
    public static int calculateAsciiSum(String input) {
        int sum = 0;
        System.out.print("Characters and ASCII values: ");
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int ascii = (int) ch;
            sum += ascii;
            System.out.print(ch + "(" + ascii + ") ");
        }   
            System.out.println("\nTotal ASCII Sum: " + sum);
            return sum;
    }

    // Function to calculate hash index
    public static int getHashIndex(int asciiSum, int tableSize) {
            return asciiSum % tableSize;
    }

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

        // Take input string
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

        // Take size of hash table
            System.out.print("Enter hash table size: ");
            int tableSize = scanner.nextInt();

        // Step 1: Calculate ASCII sum
            int asciiSum = calculateAsciiSum(input);

        // Step 2: Calculate hash index
           int index = getHashIndex(asciiSum, tableSize);

        // Display result
           System.out.println("The string \"" + input + "\" will be stored at index: " + index);
    }
}