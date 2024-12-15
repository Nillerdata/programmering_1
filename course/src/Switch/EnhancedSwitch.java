package Switch;

public class EnhancedSwitch {

    public static void main(String[] args) {
//        printWeekDay(0);
//        printWeekDay(1);
//        printWeekDay(2);
//        printWeekDay(3);
//        printWeekDay(4);
//        printWeekDay(5);
//        printWeekDay(6);
//        printWeekDay(7);
        printNumberInWord(0);
        printNumberInWord(11);

    }


    public static void printDayOfWeek(int day) {


        String dayOfWeek = switch (day) {
            case 0 -> {
                yield "sunday";
            }
            case 1 -> "monday";
            case 2 -> "tuesday";
            case 3 -> "wednesday";
            case 4 -> "thursday";
            case 5 -> "friday";
            case 6 -> "saturday";
            default -> "Invalid day";
        };
        System.out.println(day + " stands for " + dayOfWeek);
    }

    public static void printWeekDay(int day) {
        String dayOfWeek = "Invalid day";
        if (day == 0) {
            dayOfWeek = "sunday";
        } else if (day == 1) {
            dayOfWeek = "monday";
        } else if (day == 2) {
            dayOfWeek = "tuesday";
        } else if (day == 3) {
            dayOfWeek = "wednesday";
        } else if (day == 4) {
            dayOfWeek = "thursday";
        } else if (day == 5) {
            dayOfWeek = "friday";
        } else if (day == 6) {
            dayOfWeek = "saturday";
        } else dayOfWeek = "invalid day";


        System.out.println(day + " stands for " + dayOfWeek);
    }

    public static void printNumberInWord(int number) {
        String inWord = switch (number) {
            case 0 -> "ZERO";
            case 1 -> "ONE";
            case 2 -> "TWO";
            case 3 -> "THREE";
            case 4 -> "FOUR";
            case 5 -> "FIVE";
            case 6 -> "SIX";
            case 7 -> "SEVEN";
            case 8 -> "EIGHT";
            case 9 -> "NINE";
            default -> "other";
        };
        System.out.println(inWord);
    }

}
