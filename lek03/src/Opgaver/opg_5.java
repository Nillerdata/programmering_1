package Opgaver;

import java.util.Locale;

public class opg_5 {
    public static void main(String[] args) {
        String ord1 = "Datamatiker";
        String ord2 =  "Uddannelsen";
        String ord3 = ord1 +" " + ord2.toLowerCase();


    //lave ord1 om til uppercase
    String ord1ToUpper = ord1.toUpperCase();
    System.out.println(ord1ToUpper);


    //lave ord2 om til lowercase opgD
    String ord2ToLower = ord2.toLowerCase();
    System.out.println(ord2ToLower);


    // Sammensætte to strings
    System.out.println(ord1 + " " + ord2);


    /*Færdiggør programmet så det i en ny streng, ord3, sammensætter ord1 og
        ord2, hvor ord2 er med små bogstaver. Udskriv resultatet.*/
    System.out.println(ord3);


        //Udskriv længden af strengen fra opgave d)
        int len = ord3.length();
        System.out.println("teksten " + ord3 + " " + "har længden " + len);


        //F) Udskriv de første 7 bogstaver af ord1.
        String readWordsF = ord1.substring(0,7);
        System.out.println(readWordsF);


        //Udskriv bogstav 3-7 fra ord2.
        String readWordsG = ord2.substring(3,7);
        System.out.println(readWordsG);


        //Udskriv den sidste halvdel af strengen fra opgave d).
        System.out.println(ord3.substring(12));
    }
}
