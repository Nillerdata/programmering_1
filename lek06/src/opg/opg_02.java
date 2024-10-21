package opg;

import java.util.Scanner;

public class opg_02 {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        System.out.println("indsæt tal mellem 1 -  99 afslut med 0");
        int input = scan.nextInt();
        int sum = 0;
        while (input != 0) {
            sum = sum + input;
            System.out.println("den løbende sum er " + sum);
            input = scan.nextInt();
        }
    }
}
/*
skabe en scanner
while (input!=0){


 */
