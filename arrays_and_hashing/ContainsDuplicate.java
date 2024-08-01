package arrays_and_hashing;

import java.util.Set;
import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) 
                return true;
            set.add(num);
        }
        return false;
    }
}
