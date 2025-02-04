public class mindConnectLinked {
    static Node head; //initialize first node
    
    static void add(int data) { //adding integer data and linking nodes
        Node newNode = new Node(data);
        if (head == null) { //if no first node, create it
            head = newNode;
        } else { //if node available, find the next null node and make it the new node with the data
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    static void add(String data) { //adding string data and linking nodes
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
    }
    
    static void display() { //display the linked list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.next;
        }
    }
    
    //method to empty list then add a single node and display it
    static void nodeEmptyList(){
        head = null;
        System.out.println("\nPrint empty list");
        display();
        System.out.println("\nAdding a node to an empty list, output below:");
        add(10);
        display();
    }
    
    public static void main(String[] args) {
        add("Urgent Care");
        add("Novant Health");
        System.out.println("Displays a list of some mental health resrouces around us:");
        display();
    }
}

//class to set up the nodes
class Node {
    Object data;
    Node next;
    Node(Object data) { this.data = data; }
}