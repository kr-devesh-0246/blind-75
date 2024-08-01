public String userIdGeneration(String firstName, String lastName, int pin, int n) {
    String smallerName, longerName;

    // Step 1: Determine smaller and longer names
    if (firstName.length() != lastName.length()) {
        smallerName = firstName.length() < lastName.length() ? firstName : lastName;
        longerName = firstName.length() < lastName.length() ? lastName : firstName;
    } else {
        smallerName = firstName.compareToIgnoreCase(lastName) < 0 ? firstName : lastName;
        longerName = firstName.compareToIgnoreCase(lastName) < 0 ? lastName : firstName;
    }

    // Step 2: Generate the base user ID
    String baseUserId = Character.toString(smallerName.charAt(0)) + longerName +
                       Integer.toString(pin / (int) Math.pow(10, n - 1) % 10) +
                       Integer.toString(pin % (int) Math.pow(10, n));

    // Step 3: Toggle case
    StringBuilder userId = new StringBuilder();
    for (char c : baseUserId.toCharArray()) {
        userId.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
    }

    return userId.toString();
}

Explanation:
 * Determine smaller and longer names:
   * If lengths differ, assign shorter and longer names accordingly.
   * If lengths are equal, compare alphabetically and assign smaller and longer names.
 * Generate base user ID:
   * Extract the first character of the smaller name.
   * Append the entire longer name.
   * Extract the Nth digit from the left of the PIN.
   * Extract the Nth digit from the right of the PIN.
 * Toggle case:
   * Create a StringBuilder to construct the final user ID.
   * Iterate over the base user ID characters, toggling case for each character.
Key points:
 * The code is well-structured and easy to understand.
 * It efficiently handles both equal and unequal length names.
 * It uses clear variable names and comments to enhance readability.
 * The code is concise and avoids unnecessary complexity.
This implementation effectively addresses the given problem and provides a clear and efficient solution.





import java.util.ArrayList;
import java.util.List;

public class TValueCalculator {

    public int findTValue(int input1, int input2, int input3) {
        int t = 0;

        // Check if input2 is prime
        boolean isPrime = isPrime(input2);

        // Calculate t based on input2 and its primality
        if (isPrime) {
            if (input2 % 2 == 0) { // Even prime
                t = input1 * input1 * sumOfFirstNPrimes(input2);
            } else { // Odd prime
                t = input2 * input2 * sumOfFirstNPrimes(input2 + input3);
            }
        } else {
            if (input2 % 2 == 0) { // Even composite
                t = input3 * input3 * sumOfFirstNPrimes(input2 + input3);
            } else { // Odd composite
                t = sumOfFirstNPrimes(input1 + input2 + input3);
            }
        }

        // Check if t is prime
        if (isPrime(t)) {
            return t + input3;
        } else {
            return t - input3;
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    private int sumOfFirstNPrimes(int n) {
        int count = 0, num = 2, sum = 0;

        while (count < n) {
            if (isPrime(num)) {
                sum += num;
                count++;
            }
            num++;
        }

        return sum;
    }
}

