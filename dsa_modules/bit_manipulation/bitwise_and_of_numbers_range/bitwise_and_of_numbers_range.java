### Developer Notes - Bitwise AND of Numbers Range

#### Concept Overview
Bitwise operations allow us to manipulate individual bits of numbers at the binary level. The `&` (AND) operation compares each bit of its first operand with the corresponding bit of its second operand. If both bits are 1, then the corresponding result bit is set to 1; otherwise, it is set to 0.

#### Problem Description
Given two integers `left` and `right`, inclusive, return the bitwise AND of all numbers in this range `[left, right]`.

For example, if `left = 5` and `right = 7`, the function should return `4` because:
- Binary representation of `5`: `101`
- Binary representation of `6`: `110`
- Binary representation of `7`: `111`
The AND operation between these three numbers results in `4` (`100`).

#### Approach
To solve this efficiently, we need to observe that as we move from `left` to `right` in the range, more bits of the numbers will start differing. This means that the common bits among all numbers in the range will be preserved until they start differing. 

Let's consider an example:
- For `left = 8` (binary `1000`) and `right = 9` (binary `1001`), the AND operation will yield `8` (`1000`).
- For `left = 12` (binary `1100`) and `right = 13` (binary `1101`), the result will still be `12` (`1100`).
- However, for `left = 14` (binary `1110`) and `right = 15` (binary `1111`), the result would be `14` (`1110`).

We can see that when `left` and `right` have different high bits, the result will always be lower than `left`. Therefore, we shift both numbers right until they become equal, keeping track of how many shifts we make. Once they are equal, we shift them back left by the same number of shifts to get the final result.

#### Clean Java Implementation
```java
public class BitwiseAndOfRange {
    /**
     * Computes the bitwise AND of all numbers in the range [left, right].
     *
     * @param left the lower bound of the range.
     * @param right the upper bound of the range.
     * @return the bitwise AND result of the range.
     */
    public int rangeBitwiseAnd(int left, int right) {
        // Count the number of shifts needed to make left and right equal
        int shiftCount = 0;
        while (left < right) {
            left >>= 1;  // Shift left right by 1 bit
            right >>= 1; // Shift right right by 1 bit
            shiftCount++; // Increment the count
        }
        
        // Shift back left by the count to get the result
        return left << shiftCount;
    }

    public static void main(String[] args) {
        BitwiseAndOfRange solution = new BitwiseAndOfRange();
        
        // Test cases
        System.out.println(solution.rangeBitwiseAnd(5, 7)); // Output: 4
        System.out.println(solution.rangeBitwiseAnd(12, 15)); // Output: 12
        System.out.println(solution.rangeBitwiseAnd(14, 15)); // Output: 14
    }
}
```

#### Time Complexity
- **O(log n)**: We perform a loop that divides both `left` and `right` by 2 until they are equal, which takes logarithmic time.

#### Space Complexity
- **O(1)**: The algorithm uses a constant amount of extra space regardless of the input size.

#### Filename Suggestion