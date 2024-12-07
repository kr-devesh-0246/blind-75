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


#include <iostream>
#include <string>

using namespace std;

int howLongTillMidnight(string S) {
    // Extract hours, minutes, and seconds from the string
    int hours = stoi(S.substr(0, 2));
    int minutes = stoi(S.substr(3, 2));
    int seconds = stoi(S.substr(6, 2));
    
    // Total seconds in a day (24 hours)
    int totalSecondsInDay = 24 * 60 * 60;
    
    // Calculate elapsed seconds since the last midnight
    int elapsedSeconds = (hours * 60 * 60) + (minutes * 60) + seconds;
    
    // Calculate remaining seconds until midnight
    int remainingSeconds = totalSecondsInDay - elapsedSeconds;
    
    return remainingSeconds;
}

int main() {
    string S; 
    cin >> S; // Input time in HH:MM:SS format
    int result;
    result = howLongTillMidnight(S); // Call the function
    cout << result << endl; // Output the result
    return 0;
}



#include <iostream>
using namespace std;

const int MOD = 1e9 + 7;

int main() {
    int N;
    cin >> N;

    int arr[5001] = {0}; // DP array
    arr[0] = 1; // Base case: one way to partition 0

    // Fill DP array
    for (int num = 1; num <= N; ++num) {
        for (int sum = num; sum <= N; ++sum) {
            arr[sum] = (arr[sum] + arr[sum - num]) % MOD;
        }
    }

    // Output the result
    cout << arr[N] << endl;

    return 0;
}


#include <iostream>
#include <stack>
#include <string>
using namespace std;

int longestValidParentheses(string s) {
    stack<int> st;
    st.push(-1); // Base for calculating lengths
    int maxLength = 0;

    for (int i = 0; i < s.length(); i++) {
        if (s[i] == '(') {
            st.push(i); // Push index of '('
        } else {
            st.pop(); // Pop the top
            if (st.empty()) {
                st.push(i); // Push current index as base
            } else {
                maxLength = max(maxLength, i - st.top()); // Calculate length
            }
        }
    }

    return maxLength;
}

int main() {
    string s;
    cout << "Enter a string: ";
    cin >> s;

    cout << "Length of the longest valid parentheses substring: " 
         << longestValidParentheses(s) << endl;

    return 0;
}