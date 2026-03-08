### Module: find_single_number

**Description:**  
Given an array of integers where every element appears twice except for one, this module finds the single number that does not appear twice.

**Approach:**  
We can use bitwise XOR operation to solve this problem efficiently. The property of XOR is such that a number XORed with itself results in 0 (a ^ a = 0), and any number XORed with 0 remains unchanged (a ^ 0 = a). Therefore, if we XOR all numbers in the array, pairs will cancel each other out leaving only the single number.

**Java Code with Comments:**  

```java
public class FindSingleNumber {
    /**
     * Finds the single number in an array where every element appears twice except for one.
     *
     * @param nums Array of integers
     * @return The single number
     */
    public static int findSingleNumber(int[] nums) {
        // Initialize result to 0
        int result = 0;
        
        // XOR all elements in the array
        for (int num : nums) {
            result ^= num; // Using XOR to cancel out pairs
        }
        
        // The remaining value in result is the single number
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        System.out.println("The single number is: " + findSingleNumber(arr));
        // Output should be 4
    }
}
```

**Complexity:**  
- **Time Complexity**: O(n), where n is the length of the input array. We iterate through the array once performing the XOR operation.
- **Space Complexity**: O(1), since we are using a constant amount of space regardless of the size of the array.

**Suggested Filename:**  
`find_single_number.java`