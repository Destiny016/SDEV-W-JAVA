// Destiny Harris
// Date: 09-02-2025
// Assignment: Exercise 9.9


public class RegularPolygon {
    // Data fields
    private int n = 3;          // number of sides (default 3)
    private double side = 1;    // length of side (default 1)
    private double x = 0;       // x-coordinate (default 0)
    private double y = 0;       // y-coordinate (default 0)

    // No-arg constructor (default values)
    public RegularPolygon() {
    }

    // Constructor with number of sides and side length
    public RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
    }

    // Constructor with number of sides, side length, and center coordinates
    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    // Getters and setters
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Method to calculate perimeter
    public double getPerimeter() {
        return n * side;
    }

    // Method to calculate area
    public double getArea() {
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }
}
