package ro.scit.utilities;

import java.time.LocalDate;

/**
 * @author Georgiana
 *
 * calculateAge() method
 * in the constructor there  are set validities conditions for the date
 * Local Date is the currentDate
 *
 */

public class DateOfBirth {
    private int month;
    private int day;
    private int year;
    private static final int[] daysPerMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public DateOfBirth(int month, int day, int year) {
        if (year <= 1900 || year > 2018)
            throw new IllegalArgumentException(
                    "year (" + year + ") must be betwen 1900-2018");
        if (month <= 0 || month > 12)
            throw new IllegalArgumentException(
                    "month (" + month + ") must be 1-12");
        if (day <= 0 | (day > daysPerMonth[month] && !(month == 2 && day == 29)))
            throw new IllegalArgumentException
                    ("day (" + day + ") out-of-range for the specified month and year");
        if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
            throw new IllegalArgumentException
                    ("day (" + day + ") out-of-range for the specified month and year");

        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }

    public static int calculateAge(DateOfBirth birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)&&(birthDate.getYear() < currentDate.getYear())) {
            int age = currentDate.getYear() - birthDate.getYear();
            return age;
        } else {
            return 0;
        }
    }
}
