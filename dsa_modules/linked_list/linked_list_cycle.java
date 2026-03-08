### Module: Linked List Cycle

**Description:**
Given a singly-linked list, determine if the list contains a cycle in it. For this problem, we define a cycle as any node that can be reached again by continuously following the next pointer. Once we have entered a cycle, we will never leave it.

**Approach:**
To solve this problem, we use Floyd's Tortoise and Hare algorithm (also known as the slow pointer and fast pointer technique). The idea is to move two pointers through the list—one at a regular speed ("tortoise") and one twice as fast ("hare"). If there is a cycle, the hare will eventually meet the tortoise inside the cycle.

Here are the steps:
1. Initialize two pointers, `slow` and `fast`, both pointing to the head of the list.
2. Move `slow` by one step and `fast` by two steps in each iteration.
3. Continue moving until either:
   - `fast` reaches the end of the list (`null`), indicating no cycle.
   - `fast` meets `slow` during traversal, indicating the presence of a cycle.

**Java Code with Comments:**

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
    /**
     * Determines if the linked list has a cycle.
     *
     * @param head the head of the linked list
     * @return true if there is a cycle, false otherwise
     */
    public boolean hasCycle(ListNode head) {
        // Initialize slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        // Loop until fast pointer reaches the end or fast pointer meets slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow pointer by 1 step
            fast = fast.next.next;     // Move fast pointer by 2 steps

            // Check if slow pointer meets fast pointer
            if (slow == fast) {
                return true;           // Cycle detected
            }
        }

        return false;                  // No cycle detected
    }
}
```

**Complexity:**
- **Time Complexity:** \(O(n)\), where \(n\) is the number of nodes in the linked list. In the worst case, both pointers traverse the entire list once before determining whether a cycle exists.
- **Space Complexity:** \(O(1)\), since only two additional pointers are used regardless of the size of the linked list.

**Suggestions Filename:**
snake_case filename: linked_list_cycle