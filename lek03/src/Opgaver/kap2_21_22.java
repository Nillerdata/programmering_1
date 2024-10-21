package Opgaver;
import java.util.Scanner;
public class kap2_21_22 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //konvertere miles til kilometer
        System.out.print("insert miles ");
                double miles = (scan.nextDouble());
       double kilometer = miles * 1.6;
        System.out.print("kilometer fra miles " + kilometer);
    }
}
