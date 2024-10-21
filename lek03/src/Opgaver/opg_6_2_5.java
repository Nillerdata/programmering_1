package Opgaver;
import java.util.Scanner;
public class opg_6_2_5 {
    public static void main(String[] args) {
        //betaling
        System.out.print("indtast betaling ");
        Scanner scan = new Scanner(System.in);
        double pay = scan.nextDouble();

//drikkepenge
        System.out.print("indtast drikkepenge ");
        double gratuity = scan.nextDouble();

    //printe betaling og drikkepenge
    System.out.println(pay + gratuity + " kr.");

    //driktotal
double driktotal = pay * (gratuity/100);
System.out.println(driktotal + " kr.");

    }
}
