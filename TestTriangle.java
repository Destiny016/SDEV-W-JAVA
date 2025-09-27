// Destiny Harris
// Date: 09-10-2025
// Assignment: Exercise 11.1
import java.util.Scanner;
public class TestTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get sides
        System.out.print("Enter side 1 of the triangle: ");
        double side1 = input.nextDouble();

        System.out.print("Enter side 2 of the triangle: ");
        double side2 = input.nextDouble();

        System.out.print("Enter side 3 of the triangle: ");
        double side3 = input.nextDouble();

        // Get color and filled
        System.out.print("Enter the color of the triangle: ");
        String color = input.next();

        System.out.print("Is the triangle filled? (true/false): ");
        boolean filled = input.nextBoolean();

        // Create triangle
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);

        // Output
        System.out.println("\n" + triangle.toString());
        System.out.printf("Area: %.2f\n", triangle.getArea());
        System.out.printf("Perimeter: %.2f\n", triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + triangle.isFilled());

        input.close();
    }
}
