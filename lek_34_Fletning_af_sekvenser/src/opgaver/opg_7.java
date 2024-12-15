package opgaver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class opg_7 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(linFileSearchPerson("personer.txt", "Hansen"));
    }

    public static String linFileSearchPerson(String fileName, String
            target) throws FileNotFoundException {

        String person = "";
        File file = new File(fileName);
        boolean found = false;
        Scanner sc = new Scanner(file);
        String full = sc.nextLine();
        String sub = full.split(" ")[2];
        while (sc.hasNext() && !found) {
            if (target.equals(sub)) {
                found = true;
                System.out.println("target found");
                person = full;
            } else {
                full = sc.nextLine();
                sub = full.split(" ")[2];
            }
        }
        return person;
    }
}
