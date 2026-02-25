import java.util.Scanner;
import java.util.Stack;

// UC11: Object-Oriented Palindrome Service
class PalindromeChecker {

    // Encapsulated method to check palindrome
    public boolean checkPalindrome(String input) {

        // Normalize string (remove spaces and convert to lowercase)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Using Stack (Data Structure)
        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }

        // Compare original string with stack (reverse order)
        for (int i = 0; i < normalized.length(); i++) {
            if (normalized.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Object-Oriented Palindrome Checker (UC11) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Creating service object (Encapsulation in action)
        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}