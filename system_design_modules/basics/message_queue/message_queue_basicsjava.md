snake_case filename: message_queue_basics.java

### Message Queue Basics

#### Description
A Message Queue is a mechanism that enables asynchronous communication between processes or components by decoupling the sender from the receiver. It acts as an intermediary buffer to store messages until they are processed.

#### Approach
The basic operations of a Message Queue include:
- **Enqueue**: Add a message to the end of the queue.
- **Dequeue**: Remove and return the message at the front of the queue.
- **Front**: Return the message at the front without removing it.
- **IsEmpty**: Check if the queue is empty.
- **Size**: Return the number of messages in the queue.

For simplicity, we can implement a Message Queue using a singly linked list.

#### Java Code with Comments
```java
// Node class represents each element in the queue
class Node {
    String message;
    Node next;

    // Constructor to create a new node
    public Node(String message) {
        this.message = message;
        this.next = null;
    }
}

// Queue class represents the overall message queue
public class MessageQueue {
    private Node front;  // Pointer to the first node in the queue
    private Node rear;   // Pointer to the last node in the queue
    private int size;     // Number of elements in the queue

    // Constructor to initialize an empty queue
    public MessageQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Method to add a message at the rear of the queue
    public void enqueue(String message) {
        Node newNode = new Node(message);
        
        // If the queue is empty, set both front and rear to the new node
        if (this.isEmpty()) {
            this.front = newNode;
            this.rear = newNode;
        } else {
            // Otherwise, link the new node to the current rear and update the rear pointer
            this.rear.next = newNode;
            this.rear = newNode;
        }
        
        this.size++;
    }

    // Method to remove and return the message from the front of the queue
    public String dequeue() {
        // If the queue is empty, throw an exception
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        
        String message = this.front.message;
        
        // Move the front pointer to the next node
        this.front = this.front.next;
        
        // If the queue becomes empty after dequeuing, reset the rear pointer
        if (this.isEmpty()) {
            this.rear = null;
        }
        
        this.size--;
        return message;
    }

    // Method to get the message at the front of the queue without removing it
    public String front() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return this.front.message;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return this.front == null && this.rear == null;
    }

    // Method to get the size of the queue
    public int size() {
        return this.size;
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        MessageQueue mq = new MessageQueue();
        mq.enqueue("Hello");
        mq.enqueue("World");

        System.out.println(mq.dequeue());  // Output: Hello
        System.out.println(mq.front());    // Output: World
        System.out.println(mq.isEmpty());  // Output: false
        System.out.println(mq.size());     // Output: 1

        mq.dequeue();  // Removes "World"
        System.out.println(mq.isEmpty());  // Output: true
    }
}
```

#### Complexity
- **Time Complexity**:
  - `enqueue`: O(1)
  - `dequeue`: O(1)
  - `front`: O(1)
  - `isEmpty`: O(1)
  - `size`: O(1)

- **Space Complexity**: O(n), where n is the number of messages in the queue.

This implementation provides a simple and efficient way to manage messages in a queue using a singly linked list.