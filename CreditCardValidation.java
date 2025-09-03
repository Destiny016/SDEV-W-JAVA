// Destiny Harris
// Date: 09-02-2025
// Assignment: Exercise 6.31

import java.util.Scanner;

public class CreditCardValidation {

    // Return true if the card number is valid 
    public static boolean isValid(long number) {
        int size = getSize(number);
        // Check length between 13 and 16 and prefix for Visa, Master, AmEx, Discover
        boolean validPrefix = prefixMatched(number, 4) || 
                              prefixMatched(number, 5) || 
                              prefixMatched(number, 37) || 
                              prefixMatched(number, 6);

        if (size >= 13 && size <= 16 && validPrefix) {
            int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
            return sum % 10 == 0;
        }
        return false;
    }

    // Get the result from Step 2: Double every second digit from right to left 
    public static int sumOfDoubleEvenPlace(long number) {
        String numStr = Long.toString(number);
        int sum = 0;
        // Start from the second-to-last digit
        for (int i = numStr.length() - 2; i >= 0; i -= 2) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            sum += getDigit(digit * 2);
        }
        return sum;
    }

    // Return this number if it is a single digit, otherwise, sum the two digits 
    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        }
        return number / 10 + number % 10;
    }

    // Return sum of odd-place digits in number (from right to left) 
    public static int sumOfOddPlace(long number) {
        String numStr = Long.toString(number);
        int sum = 0;
        // Start from the last digit
        for (int i = numStr.length() - 1; i >= 0; i -= 2) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            sum += digit;
        }
        return sum;
    }

    // Return true if the number d is a prefix for number 
    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    // Return the number of digits in d 
    public static int getSize(long d) {
        return Long.toString(d).length();
    }

    // Return the first k number of digits from number 
    public static long getPrefix(long number, int k) {
        String numStr = Long.toString(number);
        if (numStr.length() < k) {
            return number;
        }
        return Long.parseLong(numStr.substring(0, k));
    }

    // Main method: Prompt user for input 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a credit card number as a long integer: ");
        long number = input.nextLong();

        if (isValid(number)) {
            System.out.println(number + " is valid");
        } else {
            System.out.println(number + " is invalid");
        }
        input.close();
    }
}

