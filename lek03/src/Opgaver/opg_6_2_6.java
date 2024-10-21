package Opgaver;
import java.util.Scanner;
public class opg_6_2_6 {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);
        System.out.print(" indtast tal mellem 0 og 1000 ");
        int tal = Scan.nextInt();
//dividere tallet med 10 og dermed få det sidste ciffer
    int rest1 = tal%10;
    tal=tal/10;
    /*vi kan dividere det indtastede tal for at få det næste ciffer f.eks 932%10=2
    nu har vi 93 tilbage 93%10 er 9, 9%10 er 9 da 9 ikke er et helt tal og derfor ikke
     kan divideres med 10*/
    int rest2=tal%10;
    tal=tal/10;
    // -||-
    int rest3 = tal%10;
        tal=tal/10;
    int rest4 = tal%10;
        tal= tal/10;

//addere rest og vis resultat
        System.out.println(rest1);
        System.out.println(rest2);
        System.out.println(rest3);
        System.out.print(rest4);
        System.out.println(rest1+rest2+rest3+rest4);


    }
}
