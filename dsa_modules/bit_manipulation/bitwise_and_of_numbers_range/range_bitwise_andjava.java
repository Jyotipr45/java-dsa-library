### Developer Notes: Bitwise AND of Numbers Range

#### Concept

The concept revolves around bitwise operations, specifically using the AND operation (&) between two integers to determine common bits between them. This is useful when you need to find the lower bound of a range of numbers where only some bits are set consistently.

#### Problem Description

Given two integers `m` and `n`, return the bitwise AND of all numbers in the inclusive range `[m, n]`.

**Example**:  
For `m = 5` (binary `101`) and `n = 7` (binary `111`), the range includes the numbers `5, 6, 7`. The bitwise AND of these numbers is `4` (binary `100`).

#### Approach

To solve this problem efficiently, we need to understand that as we move from `m` to `n`, more bits will eventually become different. Therefore, the result of the bitwise AND operation will have fewer bits set as `n` increases beyond `m`. 

We can leverage bit manipulation to identify the common prefix between `m` and `n` because any differing bits will result in zero in the AND operation. Hence, finding the common prefix gives us the result.

Here’s a step-by-step breakdown of the approach:
1. **Identify Differences**: Find how many positions the least significant bits of `m` and `n` differ.
2. **Right Shift**: Right shift both `m` and `n` by the number of differing bits until they are equal. This effectively removes the differing bits and leaves only the common prefix.
3. **Left Shift Back**: Left shift the resulting number back by the same number of positions to restore the original bit lengths.

#### Java Implementation

```java
public class BitwiseAndOfNumbersRange {
    public static int rangeBitwiseAnd(int m, int n) {
        // Step 1: Count the number of differing bits
        int shift = 0;
        while(m != n) {
            m >>= 1;  // right shift m
            n >>= 1;  // right shift n
            shift++;  // increment the shift count
        }
        
        // Step 2: Return the common prefix after shifting back
        return m << shift;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));  // Output: 4
        System.out.println(rangeBitwiseAnd(10, 12));  // Output: 8
    }
}
```

#### Time Complexity

- **Counting Differing Bits**: The loop runs until `m` equals `n`, which means it runs for approximately log₂(n - m + 1) iterations.
- **Time Complexity**: O(log₂(n)) since each iteration halves the difference between `m` and `n`.

#### Space Complexity

- **Space Complexity**: O(1) as there are no additional data structures used other than variables.

#### Filename Suggestion

snake_case filename: `range_bitwise_and.java`