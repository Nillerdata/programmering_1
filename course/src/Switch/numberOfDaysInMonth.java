package Switch;

import com.sun.source.tree.SwitchTree;

public class numberOfDaysInMonth {
    public static boolean isLeapYear(int year) {
        boolean leapYear = false;
        if (year < 1 || year > 9999) {
            leapYear = false;
        } else if ((year % 4 == 0) && (year % 100 != 0)) {
            leapYear = true;
        } else if ((year % 100 == 0) && (year % 400 == 0)) {
            leapYear = true;
        }
        return leapYear;
    }

    public static int getDaysInMonth(int month, int year) {


        int days = switch (month) {
            case 1 -> days = 31;
            case 2 -> isLeapYear(year) ? 29 : 28;
            case 3 -> days = 31;
            case 4 -> days = 30;
            case 5 -> days = 31;
            case 6 -> days = 30;
            case 7 -> days = 31;
            case 8 -> days = 31;
            case 9 -> days = 30;
            case 10 -> days = 31;
            case 11 -> days = 30;
            case 12 -> days = 31;

            default -> -1;
        };
        if (month < 1 || month > 12) {
            days = -1;

        }
        if (year < 1 || year > 9999) {
            days = -1;

        }

        return days;
    }

    public static void main(String[] args) {
        System.out.println(getDaysInMonth(1, 2020));
        System.out.println(getDaysInMonth(2, 2020));
        System.out.println(getDaysInMonth(2, 2018));
        System.out.println(getDaysInMonth(-1, 2020));
        System.out.println(getDaysInMonth(1, -2020));
    }
}
