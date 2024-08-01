class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);

        int ptr1 = 0, ptr2 = s.length() - 1;
        while (ptr1 < ptr2) {
            if (s.charAt(ptr1) != s.charAt(ptr2)) {
                return false;
            }
            ptr1++;
            ptr2--;
        }

        return true;
    }
}