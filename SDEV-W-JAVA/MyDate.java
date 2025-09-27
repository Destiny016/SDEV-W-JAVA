// Destiny Harris
// Date: 09-10-2025
// Assignment: Exercise 10.14

import java.util.GregorianCalendar;
import java.util.Calendar;

public class MyDate {
    private int year;
    private int month; // 0-based (0 = January)
    private int day;

    // No-arg constructor that sets current date
    public MyDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH); // 0-based
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    // Constructor with elapsed time
    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    // Constructor with specified year, month, and day
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Getter methods
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    // Set date using elapsed time
    public void setDate(long elapsedTime) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH); // 0-based
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }
}

