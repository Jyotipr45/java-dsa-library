### LinkedList Introduction

A linked list is a linear data structure that consists of nodes where each node contains a value and a reference (link) to the next node in the sequence.

#### Key Concepts:
- **Node**: An individual element in the linked list containing a value and a reference to the next node.
- **Head**: The first node in the linked list.
- **Tail**: The last node in the linked list.
- **Size**: The total number of elements in the linked list.
- **Insertion**: Adding a node to the list.
- **Deletion**: Removing a node from the list.
- **Traversal**: Iterating over the elements in the list.

#### Operations:
- **Insertion**:
  - At the beginning of the list.
  - At a specific position.
  - At the end of the list.
  
- **Deletion**:
  - From the beginning of the list.
  - From a specific position.
  - From the end of the list.
  
- **Search**:
  - Linear search (traverse the list until the desired value is found).
  
- **Traverse**:
  - Print all elements in the list.
  
- **Get Size**:
  - Return the number of elements in the list.
  
### Approach

To implement a basic singly linked list, we need to create a `Node` class and a `LinkedList` class. 

#### Node Class:
- Each `Node` will have two properties: `data` (the value stored in the node) and `next` (a reference to the next node).

#### LinkedList Class:
- Contains methods to insert, delete, search, traverse, and get the size of the linked list.
- Uses a `head` pointer to keep track of the first node in the list.

### Java Code with Comments

```java
// Define the Node class
class Node {
    int data; // Data part of the node
    Node next; // Reference to the next node
    
    // Constructor to create a new node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Define the LinkedList class
public class LinkedList {
    private Node head; // Head pointer to the first node
    private int size; // Total number of nodes in the list
    
    // Constructor to initialize an empty linked list
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Method to add a new node at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Method to add a new node at a specific position
    public void insertAtPosition(int data, int position) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Invalid position");
        }
        
        Node newNode = new Node(data);
        if (position == 0) {
            insertAtBeginning(data);
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    // Method to add a new node at the end of the list
    public void insertAtEnd(int data) {
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
        size++;
    }

    // Method to remove a node from the beginning of the list
    public void removeFromBeginning() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        head = head.next;
        size--;
    }

    // Method to remove a node from a specific position
    public void removeFromPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("Invalid position");
        }
        
        if (position == 0) {
            removeFromBeginning();
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }

    // Method to remove a node from the end of the list
    public void removeFromEnd() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (size == 1) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    // Method to search for a node by value
    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to traverse and print the list
    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    // Method to get the size of the list
    public int getSize() {
        return size;
    }

    // Main method to test the linked list operations
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        list.traverse(); // Output: 10 -> 20 -> 30 -> NULL

        list.insertAtBeginning(5); 
        list.insertAtPosition(15, 2); 

        list.traverse(); // Output: 5 -> 10 -> 15 -> 20 -> 30 -> NULL

        list.removeFromBeginning(); 
        list.removeFromPosition(2); 
        list.removeFromEnd(); 

        list.traverse(); // Output: 10 -> 20 -> NULL
    }
}
```

### Complexity

- **Time Complexity**:
  - Insertion at the beginning: \(O(1)\)
  - Insertion at a specific position: \(O(n)\)
  - Insertion at the end: \(O(n)\)
  - Deletion from the beginning: \(O(1)\)
  - Deletion from a specific position: \(O(n)\)
  - Deletion from the end: \(O(n)\)
  - Search: \(O(n)\)
  - Traversal: \(O(n)\)

- **Space Complexity**:
  - \(O(n)\), where \(n\) is the number of elements in the list, because each node requires additional space.

### Suggested Filename

snake_case filename: `singly_linked_list.java`