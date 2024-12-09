package opgaver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class opg_7 {
    public static void main(String[] args) {
        String filename = "indtast.txt";

        try (Scanner scan = new Scanner(System.in); PrintWriter printWriter = new PrintWriter(filename)) {

            System.out.println("indtast int. -1 afslutter");
            int input = scan.nextInt();
            do {
                printWriter.println(input);
                input = scan.nextInt();
            }
            while (input != -1);
            System.out.println("fil gemt");

        } catch (IOException e) {
            System.out.println("Det er mandag;gå hjem og tag en lur");
        }
    }
}
