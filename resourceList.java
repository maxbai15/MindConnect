package MindConnect;

// Class to represent a node in both linked list and tree
class Node {
    Object data;
    Node next; // For Linked List
    TreeNode treeLink; // Link to a corresponding tree node if needed
    
    Node(Object data) {
        this.data = data;
    }
}

// Class for TreeNode
class TreeNode {
    String data;
    TreeNode left, right;
    
    TreeNode(String data) {
        this.data = data;
        left = right = null;
    }
}

public class resourceList {
    static Node head; // Head of linked list
    static TreeNode root; // Root of the tree
    
    // Adding to linked list
    static void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        // Also insert into the tree
        root = insertIntoTree(root, data);
    }
    
    // Insert into a binary search tree
    static TreeNode insertIntoTree(TreeNode node, String data) {
        if (node == null) {
            return new TreeNode(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = insertIntoTree(node.left, data);
        } else {
            node.right = insertIntoTree(node.right, data);
        }
        return node;
    }
    
    // Display linked list
    static void displayLinkedList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // In-order traversal of the tree
    static void displayTree(TreeNode node) {
        if (node != null) {
            displayTree(node.left);
            System.out.print(node.data + " ");
            displayTree(node.right);
        }
    }
    
    public static void main(String[] args) {
        add("Urgent Care");
        add("Novant Health");
        add("Mental Wellness Center");
        add("Therapy Hub");
        add("Mindful Support");
        
        System.out.println("Mental health resources (Linked List):");
        displayLinkedList();
        
        System.out.println("\nMental health resources (Tree - In-order Traversal):");
        displayTree(root);
    }
}
