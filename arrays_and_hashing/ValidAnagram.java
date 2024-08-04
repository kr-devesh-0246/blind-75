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



















import java.util.*;

class Solution {
    private static final int MOD = 1000000007;

    public static int GetAnswer(int N, List<Integer> A) {
        int overallGCD = A.get(0);
        for (int i = 1; i < N; i++) {
            overallGCD = gcd(overallGCD, A.get(i));
        }

        Map<Integer, Integer> factorCount = new HashMap<>();
        for (int num : A) {
            int reducedNum = num / overallGCD;
            for (int i = 2; i * i <= reducedNum; i++) {
                while (reducedNum % i == 0) {
                    factorCount.put(i, factorCount.getOrDefault(i, 0) + 1);
                    reducedNum /= i;
                }
            }
            if (reducedNum > 1) {
                factorCount.put(reducedNum, factorCount.getOrDefault(reducedNum, 0) + 1);
            }
        }

        long result = 1;
        for (int count : factorCount.values()) {
            result = (result * (count + 2)) % MOD;
        }

        return (int) ((result - 1 + MOD) % MOD);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
