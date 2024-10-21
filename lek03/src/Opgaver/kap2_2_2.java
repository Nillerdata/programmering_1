package Opgaver;
import java.util.Scanner;
public class kap2_2_2 {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        //loads scanner
     System.out.print("insert length of any one side of equilateral triangle ");
//insert length
     double length = scan.nextDouble();
     double area = Math.sqrt(3)/4 * Math.pow(length,2);
     //shows area
     System.out.println("the area of the triangle is " +  area);
     double volume = area * length;
     //shows volume
System.out.print("the volume of the triangle is " + volume);

    }
}
