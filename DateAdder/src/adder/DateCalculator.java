package adder;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DateCalculator {

    private Date enteredDate;
    private int daysToAdd;

    public DateCalculator() {
        getDate();
        getDaysToAdd();
        Date[] dateArr = fillArr();
        dateArr[dateArr.length - 1].print();

        //This would be my preferred execution of this assignment
//        Date newDate = addDaysToDate();
//        newDate.print();
    }

    /*
    This constructor is used for testing
    the integer parameter is only used to differentiate it from the the other constructor
     */
    public DateCalculator(int i) {
    }

    //This method is used for testing
    public Date testDateCalculator(int mm, int dd, int yyyy, int daysToAdd) {
        enteredDate = new Date(mm,dd,yyyy);
        this.daysToAdd = daysToAdd;
        Date[] dateArr = fillArr();
        return dateArr[dateArr.length - 1];
    }

    /*
    This method return the date entered by the user, unless the input is invalid, in which case
    it will prompt the user to re-enter the date in the correct format.
     */
    private void getDate() {

        String input;
        int day;
        int month;
        int year;
        boolean isValid = false;
        Date d = new Date();

        try {
            do {
                System.out.println("Enter a date in the following format: mm/dd/yyyy");
                Scanner s = new Scanner((System.in));
                input = s.next();
                month = Integer.parseInt(input.substring(0, 2));
                if (!d.isValidMonth(month)) continue;
                year = Integer.parseInt(input.substring(6, 10));
                if (!d.isValidYear(year)) continue;
                day = Integer.parseInt(input.substring(3, 5));
                if (!d.isValidDay(month, day, year)) continue;
                enteredDate = new Date(month, day, year);
                isValid = !isValid;
            } while (isValid == false);
        } catch (NumberFormatException e) {
            System.out.println("Error formatting string into int");
        } catch (InputMismatchException e) {
            System.out.println("That is not a valid input!");
        }
    }

    /*
    This method prompts the user for the number of days to be added to the previously entered date.
    If the user enters invalid input, they are prompted to enter a valid number.
     */
    private void getDaysToAdd() {
        boolean inputIsValid = false;
        try {
            do {
                System.out.println("Enter a number 1 to 60 to add to the previously entered date");
                Scanner s = new Scanner(System.in);
                daysToAdd = s.nextInt();
                if (daysToAdd > 60 || daysToAdd < 1) continue;
                inputIsValid = !inputIsValid;
            } while (!inputIsValid);
        } catch (NumberFormatException e) {
            System.out.println("An error occured whe trying to parse number of days to add.");
        } catch (InputMismatchException e) {
            System.out.println("That is not a valid input!");
        }
    }

    /*
    This method returns an array of the length of the number of days to be added to the entered day.
    each element of the array thus contains the next incremented day after the entered one.
     */
    private Date[] fillArr() {
        int enteredMonth = enteredDate.getMonth();
        int enteredDay = enteredDate.getDay();
        int enteredYear = enteredDate.getYear();
        boolean isValid;
        Date[] arr = new Date[daysToAdd];

        for (int i = 0; i < daysToAdd; i++) {
            isValid = false;
            while (!isValid) {
                enteredDay++;
                Date date = new Date(enteredMonth, enteredDay, enteredYear);
                if (date.isValidDate()) {//if the date of the next number is valid, add it to the array
                    isValid = true;
                    arr[i] = new Date(enteredMonth, enteredDay, enteredYear);
                } else { //it's not, so we will try again with the first of the next month
                    if (date.getDay() > date.getMaxDaysInMonth()) {
                        enteredDay = 0;
                        enteredMonth++;
                        if (enteredMonth == 13) { //if the next month will be in the next year
                            enteredMonth = 1;
                            enteredYear++;
                        }
                    }
                }
            }
        }
        return arr;
    }

    //This is my preferred solution to the problem
//    private Date addDaysToDate() {
//        int enteredMonth = enteredDate.getMonth();
//        int enteredDay = enteredDate.getDay();
//        int enteredYear = enteredDate.getYear();
//        boolean isValid;
//        Date date = new Date();
//
//        for (int i = 0; i < daysToAdd; i++) {
//            isValid = false;
//            while (!isValid) {
//                enteredDay++;
//                date = new Date(enteredMonth, enteredDay, enteredYear);
//                if (date.isValidDate()) {//if the date of the next number is valid, add it to the array
//                    isValid = true;
//                } else { //it's not, so we will try again with the first of the next month
//                    if (date.getDay() > date.getMaxDaysInMonth()) {
//                        enteredDay = 0;
//                        enteredMonth++;
//                        if (enteredMonth == 13) { //if the next month will be in the next year
//                            enteredMonth = 1;
//                            enteredYear++;
//                        }
//                    }
//                }
//            }
//        }
//        return date;
//    }
}
