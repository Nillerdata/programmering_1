package stjerne_opgaver;

import java.util.*;

public class opg_7_6 {
    public static int[] random(int[] tabel) {

        for (int i = 0; i < 200; i++) {
            Random random = new Random();
            int number = random.nextInt(10);
            tabel[number]++;
            }
        return tabel;
    }

    public static void main(String[] args) {
        int[] count = new int[10];
        System.out.println(Arrays.toString(random(count)));
    }
}
