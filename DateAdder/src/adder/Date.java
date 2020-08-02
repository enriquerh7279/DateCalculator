package adder;

public class Date {
    private int month;
    private int day;
    private int year;

    public Date() { }

    public Date(int mm, int dd, int yyyy) {
        month = mm;
        day = dd;
        year = yyyy;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public boolean isValidMonth(int month) {
        return (month > 0 && month < 13);
    }

    public boolean isValidYear(int year) {
        return(year > 1999 && year < 2026);
    }

    public boolean isValidDay(int month, int day, int year) {
        int max = getMaxDaysInMonth(month, year);
        return day <= max;
    }

    public boolean isValidDate() {
        return isValidMonth(month) && isValidDay(month, day, year);
    }

    public boolean isLeapYear(int year) {
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

    public int getMaxDaysInMonth(int monthNum, int year) {
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

    public int getMaxDaysInMonth() {
        switch (month) {
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

    public void print() {
        System.out.println(month + "/" + day + "/" + year);
    }

    public String toString() {
        return (month + "/" + day + "/" + year);
    }
}
