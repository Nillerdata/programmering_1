package opgaver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class opg_4 {
    public static void main(String[] args) throws IOException {
        try {
            System.out.println(linFileSearch("tal10.txt", 9));
        } catch (Exception e) {
            throw new IOException("we fucked up friend" + e.getMessage() + e.getLocalizedMessage());
        }

    }

    public static boolean linFileSearch(String fileName, int target) throws FileNotFoundException {
        File file = new File(fileName);
        boolean found = false;
        Scanner scan = new Scanner(file);
        scan.nextInt();

        while (!found && scan.hasNext()) {
            int next = scan.nextInt();
            if (next == target) {
                found = true;
            }

        }

        return found;
    }
}
