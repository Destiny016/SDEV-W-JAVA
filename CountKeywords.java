// Destiny Harris
// Date: 09-26-2025
// Assignment: Exercise 21.3 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CountKeywords {
    // Java keywords list
    private static final String[] keywordString = {
        "abstract", "assert", "boolean", "break", "byte", "case", "catch",
        "char", "class", "const", "continue", "default", "do", "double",
        "else", "enum", "extends", "for", "final", "finally", "float",
        "goto", "if", "implements", "import", "instanceof", "int",
        "interface", "long", "native", "new", "package", "private",
        "protected", "public", "return", "short", "static", "strictfp",
        "super", "switch", "synchronized", "this", "throw", "throws",
        "transient", "try", "void", "volatile", "while"
    };

    private static final Set<String> keywords = new HashSet<>(Arrays.asList(keywordString));

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.out.println("Usage: java CountKeywords <source-file>");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File not found: " + args[0]);
            System.exit(2);
        }

        int count = countKeywords(file);
        System.out.println("The number of keywords in " + args[0] + " is " + count);
    }

    public static int countKeywords(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        int count = 0;
        boolean inBlockComment = false;

        while (input.hasNextLine()) {
            String line = input.nextLine();

            // Handle block comments
            if (inBlockComment) {
                int endComment = line.indexOf("*/");
                if (endComment != -1) {
                    inBlockComment = false;
                    line = line.substring(endComment + 2);
                } else {
                    continue; // skip whole line inside block comment
                }
            }

            // Remove line comments
            int lineComment = line.indexOf("//");
            if (lineComment != -1) {
                line = line.substring(0, lineComment);
            }

            // Handle start of block comments
            int startComment = line.indexOf("/*");
            if (startComment != -1) {
                int endComment = line.indexOf("*/", startComment + 2);
                if (endComment != -1) {
                    line = line.substring(0, startComment) + line.substring(endComment + 2);
                } else {
                    inBlockComment = true;
                    line = line.substring(0, startComment);
                }
            }

            // Skip strings
            line = line.replaceAll("\".*?\"", " ");

            // Tokenize words
            String[] tokens = line.split("[\\s\\p{Punct}]+");
            for (String token : tokens) {
                if (keywords.contains(token)) {
                    count++;
                }
            }
        }

        input.close();
        return count;
    }
}



