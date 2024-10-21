package Opgaver;
import java.util.Scanner;
public class opg_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    //lav en simpel skatteberegner
        System.out.print("personfradrag ");
    int personfradrag = scan.nextInt();
        System.out.print("årlige løn ");
    double yearlyPay = scan.nextDouble();
    double tax = 0.37;
double yearlypayWithoutTax = yearlyPay - personfradrag;
System.out.println("this is your pay without taxes " + yearlypayWithoutTax + " kr");
//this is yearly pay with tax
        System.out.println("this is yearly pay with tax " + yearlypayWithoutTax * tax + " kr. ");
        //månedlig indkomst før skat
        System.out.println("monthly income " + yearlypayWithoutTax / 12);
//this is monthly tax
System.out.println("this is tax per month " + (yearlypayWithoutTax * tax) /12 + " kr.");
    }
}
