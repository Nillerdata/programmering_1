package Opgaver;
import java.util.Scanner;
public class moms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("tal 1 ");
        double tal1 = scan.nextDouble();
        //indsæt moms som er 25 %
        System.out.print(" momsen er = " + tal1 * 0.25);

    }
}
