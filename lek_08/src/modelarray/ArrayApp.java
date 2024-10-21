package modelarray;

import java.lang.reflect.Parameter;
import java.sql.Array;
import java.util.Arrays;

public class ArrayApp {
    public static int[] fyldArrayPP() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
            result[i] = i * 3;
        }
        return result;
    }

    public static int findMax(int[] tabel) {
        int max = -1;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] > max) {
                max = tabel[i];
            }
        }
        return max;
    }

    public static void printArray(int[] tabel) {
        System.out.print("{");
        for (int i = 0; i < tabel.length; i++) {
            if (i == 0) {
                System.out.print(tabel[i]);
            } else {
                System.out.print(", " + tabel[i]);
            }
        }
        System.out.println("}  ");
    }

    // OPGAVER


    /**
     * @return et array med indhold [0,0,0,0,0,0,0,0,0,0]
     */
    public static int[] fyldArrayA() {
        int[] result = new int[10];


        return result;
    }

    /**
     * @return et array med indhold [2,44,-23,99,8,-5,7,10,20,30]
     */
    public static int[] fyldArrayB() {
        //int[] result =new int[10];
        int[] result = {2, 44, -23, 99, 8, -5, 7, 10, 20, 30};

        return result;
    }

    /**
     * @return et array med indhold [0,1,2,3,4,5,6,7,8,9]
     */
    public static int[] fyldArrayC() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    /**
     * @return et array med indhold [2,4,6,8,10,12,14,16,18,20]
     */
    public static int[] fyldArrayD() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++)
            result[i] = (i + 1) * 2;
        //TODO
        return result;
    }

    /**
     * @return et array med indhold [1,4,9,16,25,36,49,64,81,100]
     */
    public static int[] fyldArrayE() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++)
            result[i] = (i + 1) * (i + 1);

        //TODO
        return result;
    }

    /**
     * @return et array med indhold [0,1,0,1,0,1,0,1,0,1]
     */
    public static int[] fyldArrayF() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++)
            result[i] = i % 2;
        //TODO
        return result;
    }

    /**
     * @return et array med indhold [0,1,2,3,4,0,1,2,3,4]
     */
    public static int[] fyldArrayG() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++)
            result[i] = i % 5;

        //TODO
        return result;
    }

    public static int sum(int[] tabel) {

        int sum = 0;
        for (int i = 0; i < tabel.length; i++) {
            sum = sum + tabel[i];
        }
        return sum;
    }

    public static double sum(double[] tabel) {
        double sum = 0;
        for (int i = 0; i < tabel.length; i++) {
            sum = sum + tabel[i];
        }
        return sum;
    }

    public static int antalLige(int[] tabel) {
        int antalLige = 0;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] % 2 == 0) {
                antalLige++;
            }

        }
        return antalLige;
    }

    public static int antalForekomster(int[] tabel, int tal) {
        int antalForekomester = 0;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] == tal) {
                antalForekomester++;
            }
        }
        return antalForekomester;
    }

    public static int[] makesum(int[] a, int[] b) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] + b[i];


        }
        return result;
    }

    public static boolean hasUneven(int[] tabel) {
        boolean kat = false;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] % 2 != 0) {
                kat = true;


            }
        }
        return kat;
    }

/* opg. 2 i denne opgave skal du arbejde med et array der indeholder string.
tilføj til klassen arrayapp 2 metoder og afprøv dem fra main*/
    /*opg. 2.1 En metode der finder antallet af Strings i input Arrayet,
    der har længden 4 */
    public static int numberFour (String[] tabel){
        ;
        int count = 0;
        for (int i = 0; i < tabel.length; i++){

            count++;
        }
        return count;
    }

    public static void main(String[] args) {

        int tabel[] = fyldArrayPP();
        System.out.println("Forventet: [0, 3, 6, 9, 12, 15, 18, 21, 24, 27]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));

        int[] tabel2 = {78, 23, 1, 4, 65, 3, 87, 5, 12};
        printArray(tabel2);
        System.out.println(findMax(tabel2));

        tabel = fyldArrayA();
        System.out.println("Forventet: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayB();
        System.out.println("Forventet: [2, 44, -23, 99, 8, -5, 7, 10, 20, 30]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayC();
        System.out.println("Forventet: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayD();
        System.out.println("Forventet: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayE();
        System.out.println("Forventet: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayF();
        System.out.println("Forventet: [0, 1, 0, 1, 0, 1, 0, 1, 0, 1]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayG();
        System.out.println("Forventet: [0, 1, 2, 3, 4, 0, 1, 2, 3, 4]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        int[] test = {5, 10, 20, 12};
        System.out.println("aktuelt : " + sum(test));
        System.out.println();

        double[] test1 = {2.5, 2.5, 2.5, 2.5};
        System.out.println("aktuelt ; " + sum(test1));
        System.out.println();

        int[] test2 = {2, 1, 4, 5, 6};
        System.out.println("aktuelt : " + antalLige(test2));
        System.out.println();

        int[] test3 = {2, 5, 7, 5, 3, 2};
        System.out.println("aktuelt : " + antalForekomster(test3, 7));
        System.out.println();

        int[] test4 = {2, 5, 3, 5, 1};
        int[] test5 = {1, 2, 3, 4, 5};
        int[] makesum = makesum(test4, test5);
        System.out.println(" opg6 resultat af a+b er " + Arrays.toString(makesum));
        System.out.println();

        int[] test6 = {2, 4, 7, 8, 2};
        System.out.println("resultat af opg7 er " + hasUneven(test6));
        System.out.println();

        String[] string = {"hej mit navn er bob"};
        System.out.println("resultat af 2.1 er : " + numberFour(string));

    }

}
