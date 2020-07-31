package adder;

public class Date {
    private static int month;
    private static  int day;
    private static int year;

    public Date() {

    }

    public Date(int mm, int dd, int yyyy) {
        month = mm;
        day = dd;
        year = yyyy;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public static boolean isValidMonth(int month) {
        return (month > 0 && month < 13);
    }

    public static boolean isValidYear(int year) {
        return(year > 1999 && year < 2026);
    }

    public static boolean isValidDay(int month, int day, int year) {
        int max = getMaxDaysInMonth(month, year);
        return (day < (max + 1) && day > 0);
    }

    public static boolean isLeapYear(int year) {
        boolean isLeap = false;
        if (year % 4 == 0) {
            isLeap = !isLeap;
            if (year % 100 == 0) {
                isLeap = !isLeap;
                if (year % 400 == 0) isLeap = !isLeap;
            }
        }
        return isLeap;
    }

    public static int getMaxDaysInMonth(int monthNum, int year) {
        switch (monthNum) {
            case 1:
                return 31;
            case 2:
                if(isLeapYear(year)) return 29;
                return 28;
            case 3 :
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                //This should never be the case
                return 0;
        }
    }

    public static void print() {
        System.out.println(month + "/" + day + "/" + year);
    }
}
