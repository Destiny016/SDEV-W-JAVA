// Destiny Harris
// Date: 09-10-2025
// Assignment: Exercise 12.9

public class TestBinaryConverter {
    public static void main(String[] args) {
        String[] testStrings = {"10101", "10201", "111000", "abc"};

        for (String binary : testStrings) {
            try {
                int decimal = BinaryConverter.bin2Dec(binary);
                System.out.println(binary + " -> " + decimal);
            } catch (BinaryFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

