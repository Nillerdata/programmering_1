package opgaver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class opg_5 {
    public static void main(String[] args) throws FileNotFoundException {
        fletAlleHeltal("fileName1", "fileName2", "fileNameNy");
    }

    /**
     * Laver en sorteret fil i fileNameNy der indeholder alle
     * heltal fra fileName1 og fileName2 (MAX_VALUE skal ikke i
     * resultatet)
     * Krav: filename1 og filename2 er navne på to sorterede filer.
     */
    public static void fletAlleHeltal(String fileName1, String
            fileName2, String fileNameNy) throws FileNotFoundException {
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        File fileFærdig = new File(fileNameNy);
        Scanner sc1 = new Scanner(file1);
        Scanner sc2 = new Scanner(file2);


        PrintWriter printWriter = new PrintWriter(fileFærdig);
        try {
            int i1 = sc1.hasNext() ? sc1.nextInt() : Integer.MAX_VALUE;
            int i2 = sc2.hasNext() ? sc2.nextInt() : Integer.MAX_VALUE;
            while (i1 != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {
                if (i1 <= i2) {
                    if (i1 != Integer.MAX_VALUE) {
                        printWriter.println(i1);
                    }
                    i1 = sc1.hasNext() ? sc1.nextInt() : Integer.MAX_VALUE;
                } else {
                    if (i2 != Integer.MAX_VALUE) {
                        printWriter.println(i2);
                    }
                    i2 = sc2.hasNext() ? sc2.nextInt() : Integer.MAX_VALUE;
                }
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            printWriter.close();
            sc1.close();
            sc2.close();
        }
    }


}
