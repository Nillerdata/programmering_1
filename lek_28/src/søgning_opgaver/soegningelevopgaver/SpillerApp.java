package søgning_opgaver.soegningelevopgaver;

import java.util.ArrayList;

public class SpillerApp {
    // TODO Opgave 4.1
    public static  Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
            Spiller spiller = null; //initialisér resultat til ikke-fundet
            int i = 0;
            while(spiller == null && i<spillere.size()){ //initialisér km og km != Ø
                Spiller s = spillere.get(i); //udvælg k fra km
                if(s.getMaal() == score){//k er lig m
                    spiller = s;
                }else //split km i forhold til k og m
                    i++;
            }return spiller;
        }



    // Her tilføjes metoder der løser opgve 4.2 og 4.3
    //TODO opgave 4.2
    public static Spiller findScoreBinær(ArrayList<Spiller> spillere,int score){
        Spiller spiller = null; // initialisér resultat til ikke fundet
        int left  = 0;
        int right = spillere.size()-1; // initialisér søgemængde && km != Ø
        while (spiller == null && left <= right){
            int middle = (left + right)/2;
            Spiller s = spillere.get(middle);
            if(s.getMaal() == score){
                spiller = s;

            }else if(s.getMaal() > score){ // split km i forhold til k og m
                left = middle + 1;
            }else{
                right = middle - 1;
            }

        }
        return spiller;
    }
    //TODO 4.3
    public static String godSpiller (ArrayList<Spiller> spillere){
        String resultat = null;
        int i = 0;
        while(resultat == null && i<spillere.size()){
            Spiller s  = spillere.get(i);
            if(s.getHoejde() < 170 && s.getMaal() > 50){
                resultat = s.toString();
            }else i++;
        }return resultat;
    }
    public static void main(String[] args) {

        // Her afprøves opgave 4.1
        ArrayList<Spiller> spillerListe = new ArrayList<>();
        spillerListe.add(new Spiller("Bo", 155, 89, 60));
        spillerListe.add(new Spiller("Hans", 196, 99, 45));
        spillerListe.add(new Spiller("Mads", 200, 103, 37));
        spillerListe.add(new Spiller("Lars", 192, 86, 35));
        spillerListe.add(new Spiller("Jens", 188, 109, 32));
        spillerListe.add(new Spiller("Finn", 194, 102, 12));



        System.out.println("Spiller der har scoret 35 mål: " + findScoreLinear(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål: " + findScoreLinear(spillerListe, 30));
        System.out.println( "spillere som har scoret: " + findScoreBinær(spillerListe,60));
        // Tilføj kode der afprøver opgaver 4.2 og 4.3
        System.out.println("den gode spiller er : " + godSpiller(spillerListe));

    }

}
