package opgaver;

import java.util.ArrayList;
import java.util.Collections;

public class opgave_4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Jan");
        list.add("Bent");
        list.add("Thomas");
        list.add("Karsten");
        list.add("Dan");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
