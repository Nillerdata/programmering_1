package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kunde {
    private String navn;
    private String mobil;

    // kunde 1 ---0...* bestilling
    private final ArrayList<Bestilling>bestillings = new ArrayList<>();


    public Kunde(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public ArrayList<Bestilling> getBestillings() {
        return bestillings;
    }

    public void addBestilling(Bestilling bestilling){
        if(!bestillings.contains(bestilling)){
            bestillings.add(bestilling);
        }
    }
//TODO string metode


    @Override
    public String toString() {
        return "Navn: " + navn + " mobil " + mobil;
    }

    //TODO opgave 7.4
    /**
     * Tilføj til klassen Kunde en metode bestiltePladserTilForestillingPådag.
     * Metoden skal tage en forestilling og en dato som parameter og returnere en liste med alle
     * pladser, kunden har bestilt til forestillingen på datoen. Bemærk, at en kunde kan have flere
     * bestillinger til forestillingen på dagen.
     */
    public ArrayList<Plads>bestiltePladserTilForestillingPåDag(Forestilling forestilling, LocalDate dato){
        ArrayList<Plads>pladser = new ArrayList<>();

      for(Bestilling b : bestillings){
          if(b.getForestilling().equals(forestilling) && b.getDato().equals(dato)){
              for (Plads p : b.getPladser()) {
                  pladser.add(p);
              }
          }
      }return pladser;
    }//________________________________________
}
