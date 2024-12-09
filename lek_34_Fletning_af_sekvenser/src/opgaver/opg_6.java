package opgaver;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class opg_6 {
    public static void main(String[] args) throws Exception {
        findfællesTal("opg_6_1.txt", "opg_6_2.txt", "fileName6");
    }

    /**
     * Laver en sorteret fil i fileNameNy der indeholder alle
     * heltal som de to filer har til fælles
     * Krav: filename1 og filename2 er navne på to sorterede filer.
     */
    public static void findfællesTal(String fileName1, String
            fileName2, String fileNameNy) throws Exception {
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        File fileFærdig = new File(fileNameNy);
        Scanner sc1 = new Scanner(file1);
        Scanner sc2 = new Scanner(file2);

        PrintWriter pw = new PrintWriter(fileFærdig);
        int i1 = sc1.nextInt();
        int i2 = sc2.nextInt();
        while (i1 != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {

            if (i1 < i2) {
                i1 = sc1.nextInt();

            } else if (i1 > i2) {
                i2 = sc2.nextInt();


            } else {
                pw.println(i1);
                i1 = sc1.nextInt();
                i2 = sc2.nextInt();
            }

        }
        pw.close();
        sc1.close();
        sc2.close();
    }
}
