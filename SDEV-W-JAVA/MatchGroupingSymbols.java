// Destiny Harris
// Date: 09-26-2025
// Assignment: Exercise 20.11


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class MatchGroupingSymbols {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java MatchGroupingSymbols <filename>");
            System.exit(1);
        }

        String filename = args[0];

        try {
            if (checkFile(filename)) {
                System.out.println("The file has correct pairs of grouping symbols.");
            } else {
                System.out.println("The file has incorrect pairs of grouping symbols.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    public static boolean checkFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        Stack<Character> stack = new Stack<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (char ch : line.toCharArray()) {
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')' || ch == '}' || ch == ']') {
                    if (stack.isEmpty()) return false; // No matching opening
                    char open = stack.pop();
                    if (!matches(open, ch)) return false;
                }
            }
        }

        scanner.close();
        return stack.isEmpty(); // must be empty if all matched
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}

