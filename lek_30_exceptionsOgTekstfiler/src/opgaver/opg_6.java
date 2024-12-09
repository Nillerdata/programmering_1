package opgaver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class opg_6 {
    public static void main(String[] args) {

        String filename = "ulige.txt";

        try (Scanner scan = new Scanner(System.in); PrintWriter printWriter = new PrintWriter(filename)) {


            for (int i = 0; i <= 100; i++) {
                if (i % 2 == 1) {

                    printWriter.println(i);
                }
            }
            System.out.println("filen er lavet");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
