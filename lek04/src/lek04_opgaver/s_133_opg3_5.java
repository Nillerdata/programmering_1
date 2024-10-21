package lek04_opgaver;
import java.util.Scanner;
public class s_133_opg3_5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
// Den her opgave er en fucking hovedpine.


//indsætte hvilken dag det er ved at bruge nr. 0 som søndag, mandag nr 1 osv.
        System.out.println("indsæt idag som et nummer, søndag som 0, mandag som 1 osv. her: ");
        int idag = scan.nextInt();

//indsætte dage som skal gå
        System.out.println("indsæt dage som der skal gå: ");
        int DageGået = scan.nextInt();
        printDag(idag);

//regne fremtidige dag ud ved at bruge modulus
        int fremtidigeDag = (idag + DageGået) % 7;
        printDag(fremtidigeDag);
    }


    // Metode til at få dag
    public static void printDag(int dag) {
        if (dag == 0) {
            System.out.println("Søndag");
        } else if (dag == 1) {
            System.out.println("Mandag");
        } else if (dag == 2) {
            System.out.println("Tirsdag");
        } else if (dag == 3) {
            System.out.println("Onsdag");
        } else if (dag == 4) {
            System.out.println("Torsdag");
        } else if (dag == 5) {
            System.out.println("Fredag");
        } else if (dag == 6) {
            System.out.println("Lørdag");
        } else {
            System.out.println("fejlresultat ");  // fejl

        }

    }
}








