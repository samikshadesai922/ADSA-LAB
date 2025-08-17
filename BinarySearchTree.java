import java.util.Scanner;

public class BinarySearchTree
 {

    // Node class representing each node in the BST
    class Node 
    {
        int key;
        Node left, right;

        public Node(int value)
         {
            key = value;
            left = right = null;
        }
    }

    Node root;

    // Insert method to add a new node in the BST (recursive)
    public Node insert(Node root, int value) 
    {
        if (root == null)
         {
            root = new Node(value);
            return root;
        }

        if (value < root.key) 
        {
            root.left = insert(root.left, value);
        } else if (value > root.key) 
        {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // In-order traversal: Left -> Root -> Right
    public void inorder(Node root) 
    {
        if (root != null) 
        {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    // Pre-order traversal: Root -> Left -> Right
    public void preorder(Node root)
     {
        if (root != null) 
        {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Post-order traversal: Left -> Right -> Root
    public void postorder(Node root)
     {
        if (root != null) 
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Search method to return true if key is found
    public boolean search(Node root, int key) 
    {
        if (root == null)
            return false;

        if (root.key == key)
            return true;

        if (key < root.key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    // Main method
    public static void main(String[] args) 
    {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of nodes to insert: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++)
         {
            int value = sc.nextInt();
            bst.root = bst.insert(bst.root, value);
        }

        System.out.println("\nIn-order Traversal:");
        bst.inorder(bst.root);

        System.out.println("\nPre-order Traversal:");
        bst.preorder(bst.root);

        System.out.println("\nPost-order Traversal:");
        bst.postorder(bst.root);

        System.out.print("\nEnter key to search: ");
        int key = sc.nextInt(); // Only use Scanner once

        boolean found = bst.search(bst.root, key); //  Correct way to call

        if (found) 
        {
            System.out.println(key + " is found in the BST.");
        } else
         {
            System.out.println(key + " is not found in the BST.");
        }

        sc.close(); // Close scanner
    }
}


