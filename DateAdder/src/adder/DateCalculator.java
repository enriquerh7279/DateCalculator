package adder;

import java.util.Scanner;

public class DateCalculator {

    private static Date enteredDate;
    private static Date newDate;
    private static int daysToAdd;

    public static void main(String[] args) {
        getDate();
        getDaysToAdd();
        newDate = addDaysToDate();
        newDate.print();
    }

    private static void getDate() {

        String input;
        int day;
        int month;
        int year;
        boolean isValid = false;

        try {
            do {
                System.out.println("Enter a date in the following format: mm/dd/yyyy");
                Scanner s = new Scanner((System.in));
                input = s.next();
                month = Integer.parseInt(input.substring(0, 2));
                if (!Date.isValidMonth(month)) continue;
                year = Integer.parseInt(input.substring(6, 10));
                if (!Date.isValidYear(year)) continue;
                day = Integer.parseInt(input.substring(3, 5));
                if (!Date.isValidDay(month, day, year)) continue;
                enteredDate = new Date(month, day, year);
                isValid = !isValid;
            } while (isValid == false);
        } catch (NumberFormatException e) {
            System.out.println("Error formatting string into int");
        }
    }

    private static void getDaysToAdd() {
        boolean inputIsValid = false;
        try{
            do{
                System.out.println("Enter a number 1 to 60 to add to the previously entered date");
                Scanner s = new Scanner(System.in);
                daysToAdd = s.nextInt();
                if(daysToAdd > 60 || daysToAdd < 1) continue;
                inputIsValid = !inputIsValid;
            }while (!inputIsValid);
        } catch (NumberFormatException e) {
            System.out.println("An error occured whe trying to parse number of days to add.");
        }
    }

    private static Date addDaysToDate() {
        int enteredDay = enteredDate.getDay();
        int monthMax = Date.getMaxDaysInMonth(enteredDate.getMonth(), enteredDate.getYear());
        int sumOfDays = enteredDay + daysToAdd;

        //if the sum of the days is before or at the end of the month the date is in this month
        boolean dateIsInThisMonth = (sumOfDays <= monthMax);

        int newMonth = enteredDate.getMonth();
        int newDay = sumOfDays;
        int newYear = enteredDate.getYear();
        int daysLeftInMonth;

        //while the date isn't in this month
        //we need to increment the month until the day falls into the
        //current month
        while(!dateIsInThisMonth) {
            daysLeftInMonth = Date.getMaxDaysInMonth(newMonth, newYear) - enteredDay;
            sumOfDays -= daysLeftInMonth;
            newMonth ++;
            if(!Date.isValidMonth(newMonth)) {
                newMonth = 1;
                newYear++;
            }
            enteredDay = 0;
            newDay -= Date.getMaxDaysInMonth(newMonth, newYear);
            if(sumOfDays <= Date.getMaxDaysInMonth(newMonth, newYear)) {
                dateIsInThisMonth = true;
                if(newDay == 0) newDay = 1;
            }
        }
            return new Date(newMonth, newDay, newYear);
    }
}
