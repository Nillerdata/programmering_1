package lek04_opgaver;
import javax.xml.transform.Result;
import java.util.Date;
import java.time.Month;

public class opg8 {
    /*Hvis måned er 1,2 eller 3 er årstid = ”Vinter”
Ellers hvis måned er 4,5 eller 6 er årstid = ”Forår”
Ellers hvis måned er 7,8 eller 9 er årstid = ”Sommer”
Eller hvis måned er 10, 11 eller 12 er årstid = ”Efterår”
Hvis måned er divider bar med 3 og dagen >= 21
Hvis årstid er ”Vinter” årstid = ”Forår”
Ellers hvis årstid er ”Forår” årstid = ”Sommer”
Ellers hvis årstid er ”Sommer” årstid = ”Efterår”
Ellers årstid = ”Vinter”
Skriv er metode der tager to heltal som parametre (måned og dag) og returnerer
en String der beskriver årstiden.
Skriv en main() metode der spørg brugeren efter måned og år, kalder metoden og
udskriver reultatet af metode kaldet.*/
    public static String dato(int måned, int dag) {

        String result = "";
        if (måned <= 3) {
            result = " vinter ";
        } else if (måned <= 6 ) {
            result = " forår ";
        } else if (måned <= 9 ) {
            result = ", sommer ";
        } else if (måned <= 12 ) {
            result = " efterår ";
        }
        if ((måned %3 ==0) && dag >=21) {
            if  (result == "vinter");
            result = "forår";
            //fortsæt videre
        }
        return result;
    }
public static void main (String[] args) {
    System.out.println("indtast dato");

    System.out.println("din indtaste dato er" + dato(4,7));
}


    }

