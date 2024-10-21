package model;

import java.sql.SQLInvalidAuthorizationSpecException;
import java.sql.SQLOutput;
import java.util.Arrays;

public class ArrayApp2 {

    // Metode der adderer 1 til alle tal i array og returnerer en kopi
    public static int[] addOne(int[] tabel) {
        int[] result = new int[tabel.length];
        for (int i = 0; i < tabel.length; i++) {
            result[i] = tabel[i] + 1;
        }
        return result;
    }

    // Metode der adderer 1 til alle tal i input array
    public static void addOne2(int[] tabel) {
        for (int i = 0; i < tabel.length; i++) {
            tabel[i] = tabel[i] + 1;
        }
    }

    public static void shiftLeft(int[] tabel) {
        int temp = tabel[0];
        for (int i = 1; i < tabel.length; i++) {
            tabel[i - 1] = tabel[i];
        }
        tabel[tabel.length - 1] = temp;
    }


    // Metode der finder antal tekster i et array der starter med et bestemt begyndelses bogstav
    public static int starterMed(String[] tabel, char c) {
        int antal = 0;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i].charAt(0) == c) {
                antal++;
            }
        }
        return antal;
    }

    // Eksempel med forEach
    // Metode der finder antal tekster i et array der starter med et bestemt begyndelses bogstav
    public static int starterMed2(String[] tabel, char c) {
        int antal = 0;
        for (String tekst : tabel) {
            if (tekst.charAt(0) == c) {
                antal++;
            }
        }
        return antal;
    }


    // Opgave 1.1
    public static void swapFirstLast(int[] tabel) {
        // TODO 1.1
        int temp = tabel[0];
        tabel[0] = tabel [1];
        tabel[1] = temp;



    }

    // Opgave 1.2
    public static void swapEvenWithZero(int[] tabel) {
        // TODO 1.2

    }

    //opgave 4
    public static void shiftToRight(int[] tabel) {
        int temp = tabel[tabel.length - 1];
        for (int i = tabel.length - 1; i > 0; i--) {
            tabel[i] = tabel[i - 1];
        }
        tabel[0] = temp;
    }

    //opgave 5
    //en metode der returnerer det næststørste tal i arrayet
    public static int nextBig(int[] tabel) {
        int max = 0;
        int next = 0;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] > max) {
                max = tabel[i];
            }
        }
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] < max && tabel[i] > next) {
                next = tabel[i];
            }
        }
        return next;
    }

    //opgave 6
    //En metode der returnerer true hvis input-arrayet er sorteret i stigende orden.
    public static boolean rising(int[] tabel) {

        for (int i = 0; i < tabel.length - 1; i++) {
            if (tabel[i] >= tabel[i + 1]) {
                return false;
            }
        }
        return true;
    }

    //opg7 En metode der returnerer true hvis et array har dubletter. Fx returneres true for {2, 5, 8, 5}
    //men false for {2, 5, 8, 6}
    public static boolean isDouble(int[] table) {


        boolean duble = false;
        for (int i = 0; i < table.length; i++) {//ydre loop

            //indre loop
            for (int j = i + 1; j < table.length; j++) {//lader j altid være en foran i inde i arrayet
                if (table[i] == table[j]) {//måler position i mod position j inde i arrayet
                    duble = true;//hvis de møder det samme tal bliver duble skiftet til true

                }
            }


        }
        return duble;
    }

    //opgave 2
    /* denne opgave skal du arbejde med et array der indeholder String. Tilføj til klassen ArrayApp2
    metoder og afprøv dem fra main: */
    //opg 2.1 En metode der finder antallet af Strings i input Arrayet der har længden 4.


    public static int chara4(String[] tabel) {
        int count = 0; // tæller antal gange

        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i].length() == 4) {//tæller antal bogstaver på den string, som den er kommet til
                count++;
            }
        }
        return count; // returnerer resultat
    }

    //opg.2.2
    /*En metode der finder antallet af Strings i input arrayet, der har en bestemt længde angivet
    som parameter til metoden.*/
    //angiver bare i parameterne istedet for at gøre det i loopet
    //vil sige det gør det mere fleksibelt, da du bare kan skrive det ind hurtigt i din main.
    public static int method4(int amount, String[] tabel) {
        int count = 0;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i].length() == amount) {
                count++;

            }
        }
        return count;
    }

    //2.3
    /*En metode der givet et input array af Strings, opretter og returneret et nyt array der
    indeholder de samme tekster, hvor alle bogstaver er med store bogstaver*/
    public static String[] opg2_3(String[] tabel) {
        String[] nyArray = new String[tabel.length];
        for (int i = 0; i < tabel.length; i++) {
            nyArray[i] = tabel[i].toUpperCase();

        }
        return nyArray;
    }

    //opg3 lav opgaverne fra opg 2 om til for each løkker

    //opg3.1
    public static int chara4_1(String[] tabel) {
        int count = 0; //tæller
        for (String forbedret : tabel) {//mit for each loop
            System.out.println("hvad sker der = " + forbedret);
            if (forbedret != null && forbedret.length() == 4) {
                count++;
            }
// husk at hvis jeg skriver 4 så er det inklusiv mellemrum.
        }
        return count;
    }

    //opg 3.2
    public static int metode3_2(String[] tabel, int amount) {
        int count1 = 0;//tæller
        for (String forbedret1 : tabel) {//for each loop
            if (forbedret1.length() == amount) {
                count1++;
            }


        }
        return count1;
    }

    //opg.3.3
    public static String[] bigLetter(String[] tabel) {
        String[] newArray = new String[tabel.length];
        int index = 0;
        for (String stor : tabel) {
            newArray[index++] = stor.toUpperCase();
        }
        return newArray;

    }


    public static void main(String[] args) {
        int[] tal = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(tal));
        int[] newTabel = addOne(tal);
        System.out.println("Gamle: " + Arrays.toString(tal));
        System.out.println("Nye  : " + Arrays.toString(newTabel));
        System.out.println();
        addOne2(tal);
        System.out.println("Gamle: " + Arrays.toString(tal));
//
        int[] copy = new int[tal.length];
        for (int i = 0; i < tal.length; i++) {
            copy[i] = tal[i];
        }


        System.out.println();
        shiftLeft(tal);
        System.out.println(Arrays.toString(tal));

        System.out.println();
        String[] navne = {"Maria", "Mette", "Lene", "Mona", "Jane"};
        System.out.println("Starter med M: " + starterMed(navne, 'M'));
        //System.out.println("Starter med M: " + starterMed2(navne,'M'));

        int[] forsøg = {1, 2, 3, 4, 5, 6};
        System.out.println("opgave 4 er før :" + Arrays.toString(forsøg));
        shiftToRight(forsøg);
        System.out.println("efter" + Arrays.toString(forsøg));

        int[] forsøg2 = {1, 2, 3, 4, 5, 6};
        System.out.println("opgave 5 før :" + Arrays.toString(forsøg2));
        System.out.println(nextBig(forsøg2));
        System.out.println();

        int[] forsøg3 = {1, 2, 2, 4, 5, 6};
        System.out.println("opg. 6 før : " + Arrays.toString(forsøg3));
        System.out.println(rising(forsøg3));
        System.out.println();

        int[] forsøg4 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(forsøg4));
        System.out.println("opg 7 " + isDouble(forsøg4));
        System.out.println();
//opg 2.1
        System.out.println("opg2.1");
        String[] træls = {"træt", "book", "ikkeFireBogstaver", "kode"};
        int resultat = chara4(træls);
        System.out.println("antal string med fire bogstaver er : " + resultat);
        System.out.println();
//opg2.2
        System.out.println("opg.2.2");
        String[] parameter = {"tre", "fem", "femten", "tolv"};
        int result = method4(3, parameter);
        System.out.println("antallet er  : " + result);
        System.out.println();
//opg2.3
        System.out.println("opg.2.3");
        String[] løberTørForNavne = {"skærm ", "verden ", "solen ", "skinner"};
        String[] resultat2 = opg2_3(løberTørForNavne);
        System.out.println(Arrays.toString(resultat2));
//opg 3.1
        System.out.println();
        System.out.println("opg3.1");
        String[] opg3_1 = {"træt", "john", "ikkeFireBogstaver", "kode"};
        System.out.println("resultatet er : " + chara4_1(opg3_1));

        System.out.println();
//opg 3.2
        System.out.println("opg3.2");
        String[] opg3_2 = {"femten", "tttt", "aaaa", "kaffe"};
        int resultat3_2 = metode3_2(opg3_2, 4);
        System.out.println("antal strings med 4 bogstaver : " + resultat3_2);
        System.out.println();
        //opg 3.3
        System.out.println("opg3.3");
        String[] opg3_3main = {"print", "til", "stor"};
        System.out.println("resultat er : " + Arrays.toString(bigLetter(opg3_3main)));


    }


}

