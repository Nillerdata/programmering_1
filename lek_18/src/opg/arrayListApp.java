package opg;
import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class arrayListApp {

    public static void main(String[] args) {
    ArrayList <String> navne = new ArrayList<>();

    navne.add("Hans");
    navne.add("Viggo");
    navne.add("Jens");
    navne.add("Børge");
    navne.add("Bent");

        System.out.println(navne.size());

        navne.set(2,"Jane");
        System.out.println(navne);
        navne.remove(1);
        navne.addFirst("Pia");
        navne.addLast("Ib");

        System.out.println(navne.size());

        navne.set(2,"Hansi");
        System.out.println(navne.size());
        System.out.println(navne);
        for (int i = 0; i<navne.size();i++){
            System.out.println( navne.get(i).length());
        }
        System.out.println("\n__________________________\n");
        for(String s : navne){
            System.out.println(navne.get(s.length()).length());
        }

    }
}
