import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

// =======================
// 1️⃣ Strategy Interface
// =======================
interface PalindromeStrategy {
    boolean check(String input);
    String getName(); // To identify strategy
}

// =======================
// 2️⃣ Stack Strategy
// =======================
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "Stack Strategy";
    }
}

// =======================
// 3️⃣ Deque Strategy
// =======================
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return "Deque Strategy";
    }
}

// =======================
// 4️⃣ Performance Runner
// =======================
class PerformanceAnalyzer {

    public static void analyze(PalindromeStrategy strategy, String input) {

        long startTime = System.nanoTime();

        boolean result = strategy.check(input);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("-----------------------------------");
        System.out.println("Algorithm: " + strategy.getName());
        System.out.println("Result   : " + (result ? "Palindrome" : "Not Palindrome"));
        System.out.println("Time Taken (ns): " + duration);
    }
}

// =======================
// 5️⃣ Application (UC13)
// =======================
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC13: Performance Comparison ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Create strategies
        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy dequeStrategy = new DequeStrategy();

        // Run and compare
        PerformanceAnalyzer.analyze(stackStrategy, input);
        PerformanceAnalyzer.analyze(dequeStrategy, input);

        scanner.close();
    }
}