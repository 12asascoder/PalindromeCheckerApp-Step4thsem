import java.util.Scanner;

public class PalindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker App";
    private static final String VERSION = "v1.0";

    public static void main(String[] args) {

        // UC1 - Welcome Message
        System.out.println("=================================");
        System.out.println("   Welcome to " + APP_NAME);
        System.out.println("   Version: " + VERSION);
        System.out.println("=================================");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word to check if it is a palindrome: ");
        String input = scanner.nextLine();

        // UC4 - Convert String to Character Array
        char[] characters = input.toCharArray();

        // Two-Pointer Technique
        int start = 0;
        int end = characters.length - 1;

        boolean isPalindrome = true;

        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }

        scanner.close();
    }
}
