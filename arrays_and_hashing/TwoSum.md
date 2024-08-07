***Editorial ss: https://github.com/akhilkammila/leetcode-screenshotter/blob/main/editorial-screenshots/1-999/001.%20Two%20Sum.png***

# Approach 1: Brute Force 
### Algorithm 
Loop through each element x and check if there is another value that equals to target-x. 
```java
public int[] twoSum(int[] nums, target) {
        for (int i = 0; i < nums.length(); i++) {
            for (int j = i+1; j < nums.length(); j++) {
                if (nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
}
// Time limit error
```
**Time Complexity**: O(n^2)

**Space Complexity**: O(1)

# Approach2 : Two-pass Hash Table
### Intution
To improve O(n^2) runtime complexity, we need more efficient way to check if the complement exists. If the complement exists, we need to get its index faster. A hash table can map each element to its index. 

We can reduce t.c. to O(n) by trading space for speed. It supports near fast lookup in near constant time. "Near" because if a collision occured, a lookup could degenerate to O(n) time. 

### Algorithm
Simply use two iterations. 
* First iteration: Add each key(element) : value(index) pair. 
* Second iteration: Check if the element's complement (target - nums[i]) exists in the hash table. If it exists, return current element's index and its complement's index. 

Note: Beware the complement must not be the same element itself. 
```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length(); i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length(); i++) {
        if (map.containsKey(target - nums[i])) {
            return new int[]{map.get(i), i};
        }
    }

    return null;
}
```
**Time Complexity**: O(n). We traverse the list twice. Since the hash table reduces the lookup to O(1), the overall time complexity is O(n). 

**Space Complexity**: O(n). The extra space required depends on the number of items stored in the hash table, which stores exactly n elements.

# Approach3 : One-pass Hash Table
### Intution
In a single iteration, we are inserting elements in the hash table, we also look back to check if current element's complement exist in table. If found, return indices. 

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length(); i++) {
        int current = nums[i];
        int complement = target - current;
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        map.put(current, i);
    }

    return null;
}
```
**Time Complexity**: O(n). We traverse the list exactly once. 

**Space Complexity**: O(n). The extra space required depends on the number of items stored in the hash table, which stores exactly n elements.