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


public class VowelPermutations {
    public static int countPermutations(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int vowelCount = 0;
        int consonantCount = 0;

        // Count vowels and consonants
        for (char c : s.toLowerCase().toCharArray()) {
            if (isVowel(c)) {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        // If there are no consonants, return 0 as per the note
        if (consonantCount == 0) {
            return 0;
        }

        // Calculate factorial of consonant count
        int result = factorial(consonantCount);

        return result;
    }

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(countPermutations("ABC")); // Should output 2
        System.out.println(countPermutations("CDF")); // Should output 6
    }
}

