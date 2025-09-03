// Destiny Harris
// Date: 09-02-2025
// Assignment: Exercise 6.9

public class ConversionTable {

    /** Convert from feet to meters */
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    /** Convert from meters to feet */
    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    public static void main(String[] args) {
        // Print table headers
        System.out.printf("%-10s%-10s | %-10s%-10s%n", "Feet", "Meters", "Meters", "Feet");
        System.out.println("-----------------------------------------------");

        // Loop to display the table
        double feet = 1.0;
        double meters = 20.0;

        for (int i = 0; i < 10; i++) {
            double footToMeterValue = footToMeter(feet);
            double meterToFootValue = meterToFoot(meters);

            System.out.printf("%-10.1f%-10.3f | %-10.1f%-10.3f%n",
                    feet, footToMeterValue, meters, meterToFootValue);

            feet++;
            meters += 5;
        }
    }
}
