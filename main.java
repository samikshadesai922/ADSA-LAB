import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int value) {
        data = value;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // Insert nodes into the binary tree (manual BST insert for simplicity)
    Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);
        return root;
    }

    // Preorder Traversal (Root -> Left -> Right)
    void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Inorder Traversal (Left -> Root -> Right)
    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // Postorder Traversal (Left -> Right -> Root)
    void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // Search for a key in the binary tree
    boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        if (key < root.data) return search(root.left, key);
        return search(root.right, key);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        // Construct Binary Tree
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            tree.root = tree.insert(tree.root, value);
        }

        // Traversals
        System.out.println("\nPreorder Traversal:");
        tree.preorder(tree.root);

        System.out.println("\nInorder Traversal:");
        tree.inorder(tree.root);

        System.out.println("\nPostorder Traversal:");
        tree.postorder(tree.root);

        // Search key
        System.out.print("\n\nEnter key to search: ");
        int key = sc.nextInt();
        if (tree.search(tree.root, key))
            System.out.println("Key " + key + " found in tree.");
        else
            System.out.println("Key " + key + " not found in tree.");
        
        sc.close();
    }
}
