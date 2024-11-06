package opg_4enum;

import java.util.ArrayList;

public class App {
    public static int samletPris(ArrayList<Hund> Hunde, Race race) {
        int samletPris = 0;
        for (Hund h : Hunde) {
            if (race.equals(h.getRace())) {
                samletPris += h.getPris();
            }
        }return samletPris;

    }
    public static void main(String[] args) {
        ArrayList<Hund>hunde = new ArrayList<>();
        Hund h1 = new Hund("Molly",false,6000,Race.TERRIER);
        Hund h2 = new Hund("Prang",true,2000,Race.TERRIER);
        Hund h3 = new Hund("Tommy",true,3000,Race.PUDDEL);
        Hund h4 = new Hund("asøoidfjgf",false,4000,Race.BOKSER);
        Hund h5 = new Hund("Queen",false,1000,Race.BOKSER);
        hunde.add(h1);
        hunde.add(h2);
        hunde.add(h3);
        hunde.add(h4);
        hunde.add(h5);
        System.out.println(samletPris(hunde,Race.TERRIER));
        System.out.println(samletPris(hunde,Race.PUDDEL));
        System.out.println(samletPris(hunde,Race.BOKSER));
    }



}
