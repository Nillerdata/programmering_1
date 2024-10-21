package course;

import java.util.ArrayList;
import java.util.Arrays;

public class arraylist_testing {
    public static void main(String[] args) {


        ArrayList<Integer> numre = new ArrayList<>();
        numre.add(5);
       numre.add(3);
       numre.set(0,4);
       numre.remove(0);
        System.out.println(numre.toString());
        System.out.println("størrelse på arraylist er : " + numre.size());
        numre.clear();

    }
}
