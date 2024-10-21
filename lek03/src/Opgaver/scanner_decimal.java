package Opgaver;
import java.util.Scanner;
public class scanner_decimal {
    public static void main(String[] args) {
Scanner Scan = new Scanner(System.in);
System.out.print("tal 1 ");
//enter first number
double tal1 = Scan.nextDouble();
System.out.print("tal 2 ");
//enter second number
double tal2 = Scan.nextDouble();
System.out.print("tal 3 ");
//enter third number
double tal3 = Scan.nextDouble();
//result of addition of the three numbers
        System.out.println("resultat addition" + " " + (tal1 + tal2 + tal3));
//result of multiplying the three numbers
        System.out.println("produkt resultat" + " " + (tal1 * tal2 *tal3)+ " bajer");
    }
}
