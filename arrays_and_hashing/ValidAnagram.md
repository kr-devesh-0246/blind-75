**Concepts Involved:** Loop invariant, Linear Search, Sorting and HashTable

***Editorial ss: https://github.com/akhilkammila/leetcode-screenshotter/blob/main/editorial-screenshots/1-999/217.%20Contains%20Duplicate.png***

# Approach 1: Sorting 
### Algorithm 
Anagram: is produced by rearranging the lettersos s into t. Therefore, sorting both will result in two identical strings. 
Furthermore, if both s and t have different length, they must not be anagram, and we can return early. 
```java
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }

    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    // sorting arranges them in alphabetical order
    Arrays.sort(str1);
    Arrays.sort(str2);

    return Arrays.equals(str1, str2); // built-in method for array comparison
}
// Time limit error
```
**Time Complexity**: O(n*logn + n) => O(n*logn)

**Space Complexity**: Dependent on the sorting algo used. O(1) if heapSort is used.

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
