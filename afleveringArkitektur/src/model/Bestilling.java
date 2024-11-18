package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
    private LocalDate dato;
    private Forestilling forestilling;
    private Kunde kunde;

    //bestilling 0..* -> 0..* plads__________________________________
    private ArrayList<Plads> pladser = new ArrayList<>();



    public Bestilling(LocalDate dato, Kunde kunde, Forestilling forestilling) {
        this.dato = dato;
        this.kunde = kunde;
        kunde.addBestilling(this);


        // komposition 1--- 0...* forestilling__________________
        this.forestilling = forestilling;


    }
    public Forestilling getForestilling() {
        return forestilling;
    }

    public LocalDate getDato() {
        return dato;
    }

    //linkattributter bestilling og plads_______________________
    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public void addPLads(Plads plads) {
        if (!pladser.contains(plads)) {
            pladser.add(plads);
        }
    }
    public void setPladser(ArrayList<Plads>pladser){
        this.pladser = pladser;
    }
    //____________________________________________
    //TODO opgave 7.1
    /**
     * Tilføj til klassen Bestilling metoden samletPris(): int, der returnerer den
     * samlede pris for en bestilling.
     */
    public int samletPris(){
        int pris = 0;
        for (Plads plads : pladser) {
            pris += plads.getPris();

        }return pris;
    }


}
