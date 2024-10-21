package opgave_1;

import java.util.Scanner;

public class AppNielsG {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //prompt bruger til at indtaste antal km til EAAA fra hjem
        System.out.println("indtast antal km til eaaa fra hjem");
        int antalKm = scan.nextInt();

        //prompt bruger til at indtaste antal gange man har cyklet
        System.out.println("indtast antal gange der er  cyklet til EAAA");
        int antalGange = scan.nextInt();

        int samlet = 2 * antalKm * antalGange;
        if (samlet < 100) {
            System.out.println("lavt");
        } else if (samlet > 400) {
            System.out.println("højt");
        } else {
            System.out.println("mellem");
        }

    }
}

