**Concepts Involved:** Loop invariant, Linear Search, Sorting and HashTable

***Editorial ss: https://github.com/akhilkammila/leetcode-screenshotter/blob/main/editorial-screenshots/1-999/217.%20Contains%20Duplicate.png***

# Approach 1: Naive Linear Search(TLE)
For array of n integers, n(n-1)/2 pairs of integer are there. We may see each pairs for duplicate element.

### Algorithm 
Loop through all the n integers. For i'th integer nums[i], we search in the previous i-1 integers for the duplicate of nums[i]. 

If we find one, return true; If not we continue. 

Return false at the end of the program. 

***Loop invariant: A loop invariant is a logical assertion that is true at the beginning and end of every iteration of a computer program loop. It's similar to a class invariant, which is true at the beginning and end of every public method.***
```java
public boolean containsDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = 0; j < i; j++) { // check all prev val
            if (nums[j] == nums[i])   // if duplicate found
                return true; 
        }
    }
    // at the end of iterations, return false
    return false;
}
// Time limit error
```
**Time Complexity**: O(n^2)

**Space Complexity**: O(1)

# Approach2 : Sorting (Accepted)
If there are any duplicate integers, they'll be consecutive after sorting. Sorting algorithms like heap sort takes O(nlogn) worst case performance.
```java
public boolean containsDuplicate(int[] nums) {

    Arrays.sort(nums);

    for (int i = 1; i < nums.length; i++) {
        if (nums[i] == nums[i-1]) 
            return true;
    }

    return false;
}
```
**Time Complexity**: O(n*logn) as entire algorithm is dominated by sorting step. 

**Space Complexity**: O(1)

***Note: This approach modifies orginal array. Bad practice. Instead modify a copy instead.***
# Approach3 : Hash Table
### Intution
Utilize a dynamic data structure that supports fast search and insert operations. 

```java
public boolean containsDuplicate(int[] nums) {

    Set<Integer> set = new HashSet<>();

    for (int num : nums) {
        if (set.contains(num)) 
            return true;
        set.add(num);
    }

    return false;
}
```
**Time Complexity**: O(n^2)

**Space Complexity**: O(1)
