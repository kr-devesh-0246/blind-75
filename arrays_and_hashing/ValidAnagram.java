package arrays_and_hashing;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) 
            return false;

        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}

import java.util.*;

public class Solution {
    static final int MOD = 1_000_000_007;

    public static int GetAnswer(int N, List<Integer> P) {
        int[] permutation = new int[N];
        for (int i = 0; i < N; i++) {
            permutation[i] = P.get(i) - 1; // Convert to 0-based indexing
        }

        // Find cycles in the permutation
        boolean[] visited = new boolean[N];
        List<List<Integer>> cycles = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                List<Integer> cycle = new ArrayList<>();
                int current = i;
                while (!visited[current]) {
                    visited[current] = true;
                    cycle.add(current);
                    current = permutation[current];
                }
                cycles.add(cycle);
            }
        }

        // Find the two largest cycles
        int maxCycle1 = 0, maxCycle2 = 0;
        for (List<Integer> cycle : cycles) {
            int size = cycle.size();
            if (size > maxCycle1) {
                maxCycle2 = maxCycle1;
                maxCycle1 = size;
            } else if (size > maxCycle2) {
                maxCycle2 = size;
            }
        }

        // Calculate the result
        long result = 0;
        if (cycles.size() == 1) {
            // If there's only one cycle, any swap within the cycle is optimal
            result = (long) maxCycle1 * (maxCycle1 - 1) / 2;
        } else {
            // If there are multiple cycles, we need to count swaps between the two largest cycles
            result = (long) maxCycle1 * maxCycle2;
        }

        return (int) (result % MOD);
    }

    // Test the solution
    public static void main(String[] args) {
        System.out.println(GetAnswer(3, Arrays.asList(1, 2, 3))); // Expected: 3
        System.out.println(GetAnswer(6, Arrays.asList(2, 3, 1, 5, 6, 4))); // Expected: 9
    }
}
