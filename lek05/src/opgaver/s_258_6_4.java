package opgaver;
import java.util.Scanner;
public class s_258_6_4 {

    //anbefale at slette denne og prøve igen da jeg fik hjælp af AI
    public static void reverse (int number){
    //vende nummeret om
        //indsætte integers
    int reversed = 0;
    int remainder;
    //indsætte while og sørge for at nummeret ikke er 0
while (number!= 0) {
    //bruge modulus
    remainder = number %10; //giver os cifferet
    reversed = reversed * 10 + remainder; //tilføj tallet til reversed værdien
    number = number/10; //fjerner sidste ciffer så man får det næste


}
        System.out.println("reversed number is " + reversed);

    }


 public static void main (String [] args) {
     //Få bruger til at sætte nummer ind
     System.out.println("enter number");
     Scanner scan = new Scanner (System.in);
     int number = scan.nextInt();

     reverse(number);

 }
}
