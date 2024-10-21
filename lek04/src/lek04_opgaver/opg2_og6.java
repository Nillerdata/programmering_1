package lek04_opgaver;

public class opg2_og6 {
    public static String sign (int number) {
    /*Lav et program der indlæser et result fra tastaturet og udskriver negativ, nul eller
positiv, afhængig af om det indlæste tal er <, == eller > end 0.*/


        String result = "";
        if (number < 0) {
            System.out.println("negativ");
        } else if (number == 0) {
            result = "nul";
        } else if (number > 0) {
            result = "positiv";
        }
return result;
    }
    public static void main(String[] args) {
        System.out.println("indtast et tal positivt eller negativt");

        System.out.println(sign(7));


    }
}
