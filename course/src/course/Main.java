package course;

public class Main {




            // write code here
            public static void printYearsAndDays(long minutes) {
                long hours = minutes / 60;
                long days = hours / 24;
                long years = days / 365;
                long remainingDays = days % 365; //calculate remaining days after converting to years
                System.out.println(minutes + " minutes = " + years + " y and " + remainingDays + "d");
                /*
                Explanation of Changes:
Accurate Remaining Days Calculation:

remainingDays = days % 365: This correctly calculates the number of days left after converting the total days to years.
Correct Output Statement:
Updated the System.out.println statement to correctly format the output.
It's now System.out.println(minutes + " minutes = " + years + " y and " + remainingDays + " d");.
                 */


        }

    public static void main(String[] args) {
        printYearsAndDays(525600);
    }
}