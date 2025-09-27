// Destiny Harris
// Date: 09-17-2025
// Assignment: Exercise 13.9


import java.util.Scanner;

public class DecimalToFraction {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a decimal number: ");
        String decimalStr = input.nextLine();
        
        if (!decimalStr.contains(".")) {
            Rational rational = new Rational(Long.parseLong(decimalStr), 1);
            System.out.println("The fraction representation is: " + rational);
            return;
        }

        String[] parts = decimalStr.split("\\.");
        String intPartStr = parts[0];
        String fracPartStr = parts[1];

        long numerator = Long.parseLong(fracPartStr);
        long denominator = (long)Math.pow(10, fracPartStr.length());

        Rational fractionalPart = new Rational(numerator, denominator);
        long intPart = Long.parseLong(intPartStr);

        Rational wholePart = new Rational(intPart, 1);
        Rational total = wholePart.add(fractionalPart);

        System.out.println("The fraction representation is: " + total);
    }
}

