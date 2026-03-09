snake_case filename: message_queue_basics

### Description
A `MessageQueue` is a data structure that handles messages in a sequential manner where each message is processed one after another in the order they arrive.

In this guide, we will implement a simple `MessageQueue` using an array list to store the messages, demonstrating how to add messages (`enqueue`) and remove messages (`dequeue`). We'll also show how to check if the queue is empty, get the size of the queue, and peek at the front element without removing it.

### Approach
1. **Initialization**: Create an array list to store the messages.
2. **Enqueue Operation**: Add a message to the end of the array list.
3. **Dequeue Operation**: Remove the message from the start of the array list.
4. **isEmpty Operation**: Check if the array list is empty.
5. **size Operation**: Return the number of elements in the array list.
6. **peek Operation**: Get the first element of the array list without removing it.

### Java Code with Comments
```java
import java.util.ArrayList;
import java.util.List;

public class MessageQueue {
    private List<String> messages; // Array list to store the messages
    
    // Constructor to initialize the message queue
    public MessageQueue() {
        messages = new ArrayList<>();
    }
    
    // Method to enqueue (add) a message to the queue
    public void enqueue(String message) {
        messages.add(message);
    }
    
    // Method to dequeue (remove) the front message from the queue
    public String dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return messages.remove(0);
    }
    
    // Method to check if the queue is empty
    public boolean isEmpty() {
        return messages.isEmpty();
    }
    
    // Method to get the current size of the queue
    public int size() {
        return messages.size();
    }
    
    // Method to peek at the front message of the queue
    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return messages.get(0);
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue();
        
        queue.enqueue("Hello");
        queue.enqueue("World");
        
        System.out.println("Front Element: " + queue.peek());
        System.out.println("Size of Queue: " + queue.size());
        
        String removedMessage = queue.dequeue();
        System.out.println("Removed Message: " + removedMessage);
        System.out.println("New Front Element: " + queue.peek());
        
        System.out.println("Is Queue Empty? " + queue.isEmpty());
    }
}
```

### Complexity
- **Time Complexity**:
  - Enqueue (`enqueue`): \(O(1)\)
  - Dequeue (`dequeue`): \(O(n)\) (where \(n\) is the number of elements), because all subsequent elements need to be shifted left by one position.
  - Peek (`peek`): \(O(1)\)
  - Size (`size`): \(O(1)\)
  - isEmpty (`isEmpty`): \(O(1)\)

- **Space Complexity**: 
  - The space complexity is \(O(n)\) where \(n\) is the number of messages stored in the queue.

This implementation provides a basic understanding of how a message queue can work. For larger applications, consider implementing more efficient versions using circular arrays or linked lists to achieve \(O(1)\) dequeue time.