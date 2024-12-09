package opgaver;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class opg_4 {

    public static void main(String[] args) {
        ArrayList<Integer> frafil = new ArrayList<>();
        File filein = new File("tal.txt");
        try (Scanner scan = new Scanner(filein)) {
            while (scan.hasNextLine()) {
                frafil.add(scan.nextInt() * 2);

            }
            System.out.println(frafil);
            reverselist(frafil);
            System.out.println(frafil);

        } catch (IOException ie) {
            System.out.println("du har fejl");
        }
    }

    public static void reverselist(ArrayList<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(size - 1 - i));
            list.set(size - 1 - i, temp);
        }
        /* Explanation: 1. Determine the Size: - The variable `size` stores
         the total number of elements in the ArrayList. `int size = list.size();
         ` 2. Iterate through Half of the List: - The for-loop runs from the
          start of the list to the midpoint (size / 2). `for (int i = 0; i < size / 2; i++)
           {` 3. Swap Elements: - Temporary Storage: The `temp` variable temporarily holds
            the element at the ith position. `String temp = list.get(i);` - Swap First Half
             with Second Half: - The element at the ith position is replaced with the element
              at the `size - 1 - i` position. `list.set(i, list.get(size - 1 - i));` - The
               element at the `size - 1 - i` position is replaced with the element stored
                in `temp`. `list.set(size - 1 - i, temp);` */
    }
}
