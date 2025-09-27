// Destiny Harris
// Date: 09-02-2025
// Assignment: Exercise 8.29


import java.util.Scanner;

public class SumMajorDiagonal {

    // Return the sum of the major diagonal in a square matrix 
    public static double sumMajorDiagonal(double[][] m) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][i]; // add element at [i][i]
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] matrix = new double[4][4];

        // Prompt user for input
        System.out.println("Enter a 4-by-4 matrix row by row:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }

        // Compute and display result
        double result = sumMajorDiagonal(matrix);
        System.out.println("Sum of the elements in the major diagonal is " + result);

        input.close();
    }
}
