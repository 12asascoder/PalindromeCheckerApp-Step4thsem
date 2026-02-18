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

        // UC2 - User Input Palindrome Check
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word to check if it is a palindrome: ");
        String word = scanner.nextLine();

        boolean isPalindrome = true;

        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }

        scanner.close();
    }
}
