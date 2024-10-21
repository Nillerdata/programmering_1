package opg;

import java.sql.SQLOutput;
import java.util.Scanner;

public class opg_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //indsæt dit tal, nul afslutter
        System.out.println("indsæt dit tal 1 -99, nul afslutter");
        int input = sc.nextInt();
        //lave integers
        int max = 0;
        int min = 101;
        int samletLige = 0;
        int samletUlige = 0;
        //begynde while loop
        // while input !=0
        while (input != 0) {
            if (input > max) {
                max = input;
            }
            if (input < min) {
                min = input;
            }

            if (input % 2 == 0) {
                samletLige++;
            } else {
                samletUlige++;
            }
            System.out.println("indsæt dit tal mellem 1-99. 0 afslutter");
            input = sc.nextInt();
        }


        System.out.println("max er " + max + " " + "min er " + min);
        System.out.println("samletlige er " + samletLige + " Samletulige er " + samletUlige);

    }


//
}
