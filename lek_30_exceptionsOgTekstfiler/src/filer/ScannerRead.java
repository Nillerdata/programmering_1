package filer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerRead {

    public static void main(String[] args) {

        File filein = new File("tal.txt");

        try {
            Scanner scan = new Scanner(filein);
            while (scan.hasNext()) {
                System.out.println(scan.nextLine());
            }
			scan.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
