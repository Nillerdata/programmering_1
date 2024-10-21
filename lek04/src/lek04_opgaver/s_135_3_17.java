package lek04_opgaver;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;
public class s_135_3_17 {
    //lave sten,saks,papir spil.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //lave integer
        final int sten = 0;
        final int saks = 1;
        final int papir = 2;


        //få user input
        System.out.println("0 er sten, 1 er saks og 2 er papir, vælg en for at spille: ");
        int brugerTræk = scan.nextInt();
        //sørge for at bruger input ikke stiger over eller under
        if (brugerTræk < 0 || brugerTræk > 2) {
            System.out.println("det er ikke muligt at bruge pistol, i sten saks papir på trods af hvad dine venner end siger");
        }

    /* få computer til at lave et træk (how the fuck??)
    jeg bruger random class, længe leve google
     */
        Random cpuTræk = new Random();
        //lave integer 0 gælder og 3 gælder ikke?
        int nummer = cpuTræk.nextInt(3);
//printe resultat

        //hvis spiller og cpu vælger samme move
        if (brugerTræk == nummer) {
            System.out.println("i valgte det samme. ommer?");
        // hvis spiller vinder
        } else if (brugerTræk == sten && nummer == saks ||
                brugerTræk == saks && nummer == papir || brugerTræk ==
                papir && nummer == sten) {
            System.out.println("du vandt, du valgte " + brugerTræk + "cpu'en valgte " + nummer);}
        //hvis spiller taber
        else {
            System.out.println("du tabte, du valgte " + brugerTræk);
        }
        System.out.println(" cpu'en valgte " + nummer);

    }
}