import java.util.Scanner;

public class DayCal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month;
        int year;
        boolean validInput = false;

        // Loop until valid month and year are entered
        while (!validInput) {
            System.out.print("Enter the month (full name, abbreviation, or number):\nExample: January ~ Jan. ~ Jan ~ 1\n");
            month = scanner.nextLine().trim();

            System.out.print("Enter the year (non-negative number): ");
            String yearInput = scanner.nextLine().trim();

            if (isValidMonthhelper(month) && isValidYear(yearInput)) {
                year = Integer.parseInt(yearInput);
                int days = getDaysInMonth(month, year);
                System.out.println("The number of days in " + month + " of " + year + " is: " + days);
                validInput = true;
            } else {
                System.out.println("Invalid month or year. Please try again.");
            }
        }

        scanner.close();
    }

    public static boolean isValidMonthhelper(String month) {
        String[] validMonths = {
            "January", "Jan.", "Jan", "1",
            "February", "Feb.", "Feb", "2",
            "March", "Mar.", "Mar", "3",
            "April", "Apr.", "Apr", "4",
            "May", "5",
            "June", "Jun.", "Jun", "6",
            "July", "Jul.", "Jul", "7",
            "August", "Aug.", "Aug", "8",
            "September", "Sep.", "Sep", "9",
            "October", "Oct.", "Oct", "10",
            "November", "Nov.", "Nov", "11",
            "December", "Dec.", "Dec", "12"
        };

        for (String validMonth : validMonths) {
            if (month.equalsIgnoreCase(validMonth)) {
                return true;
            }
        }
        return false;
    }

    // Check if the year is a valid non-negative integer
    public static boolean isValidYear(String year) {
        try {
            int yearInt = Integer.parseInt(year);
            return yearInt >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Determine if the given year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Get the number of days in the given month and year
    public static int getDaysInMonth(String month, int year) {
        month = month.toLowerCase();

        switch (month) {
            case "january": case "jan.": case "jan": case "1":
            case "march": case "mar.": case "mar": case "3":
            case "may": case "5":
            case "july": case "jul.": case "jul": case "7":
            case "august": case "aug.": case "aug": case "8":
            case "october": case "oct.": case "oct": case "10":
            case "december": case "dec.": case "dec": case "12":
                return 31;
            
            case "april": case "apr.": case "apr": case "4":
            case "june": case "jun.": case "jun": case "6":
            case "september": case "sep.": case "sep": case "9":
            case "november": case "nov.": case "nov": case "11":
                return 30;

            case "february": case "feb.": case "feb": case "2":
                return isLeapYear(year) ? 29 : 28;

            default:
                throw new IllegalArgumentException("Invalid month.");
        }
    }
}
