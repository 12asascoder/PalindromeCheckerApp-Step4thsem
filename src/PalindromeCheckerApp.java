import java.util.Scanner;

public class PalindromeCheckerApp {

    // Recursive function to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {

        // Base Condition 1: If start >= end, string is palindrome
        if (start >= end) {
            return true;
        }

        // If characters at start and end don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call for remaining substring
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Recursive Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize input (remove spaces & convert to lowercase)
        input = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindrome(input, 0, input.length() - 1);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
