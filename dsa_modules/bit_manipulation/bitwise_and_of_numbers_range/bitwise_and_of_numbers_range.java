## Bitwise AND of Numbers Range

### Concept
The bitwise AND operation is one of the basic operations on binary numbers, where each bit in the result is set to 1 if both corresponding bits in the operands are 1; otherwise, it is set to 0.

This module focuses on finding the bitwise AND of all numbers in a given range [m, n].

### Problem Description
Given two integers `m` and `n`, find the bitwise AND of all numbers in the inclusive range between `m` and `n`.

**Example**:  
For `m = 5` and `n = 7`, the function should return `4`. The number representation in binary is as follows:
- 5 (binary): `101`
- 6 (binary): `110`
- 7 (binary): `111`

Applying the AND operation across these three numbers yields `4` (binary: `100`).

### Approach
To solve this efficiently, observe that as you perform an AND operation over a sequence of increasing integers, there will be more zeros appearing from the right because at least one number in any range greater than 1 will have a zero in those positions. Therefore, the common bits will eventually disappear as `n` increases past `m`. 

The trick is to find up to which leftmost bit the numbers remain identical. This can be found by shifting both `m` and `n` to the right until they become equal. The count of shifts indicates how many bits have been removed from the right, which we then shift back to the left to get our final answer.

### Implementation
```java
public class BitwiseAndOfNumbersRange {
    // Function to calculate bitwise AND of numbers in the range [m, n]
    public int rangeBitwiseAnd(int m, int n) {
        // Initialize shift count
        int shiftCount = 0;
        
        // Continue shifting both m and n to the right until they are equal
        while (m < n) {
            m >>= 1; // Shift m right by 1
            n >>= 1; // Shift n right by 1
            shiftCount++; // Increment the shift count
        }
        
        // Shift back m (or equivalently n) to the original position
        return m << shiftCount; // Left shift to compensate for the right shifts
    }

    // Main method for testing
    public static void main(String[] args) {
        BitwiseAndOfNumbersRange solution = new BitwiseAndOfNumbersRange();
        System.out.println(solution.rangeBitwiseAnd(5, 7)); // Expected output: 4
    }
}
```

### Time Complexity
The time complexity of this solution is O(log N), where N is the difference between `n` and `m`. Each iteration effectively reduces the problem size by half.

### Space Complexity
The space complexity of this solution is O(1) since only a few extra variables (`shiftCount`) are used regardless of the input size.

### Filename Suggestion