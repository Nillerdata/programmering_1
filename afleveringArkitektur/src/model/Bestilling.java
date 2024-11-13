package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
    private LocalDate dato;
    private Forestilling forestilling;
    private Kunde kunde;

    //bestilling 0..* -> 0..* plads
    private final ArrayList<Plads> pladser = new ArrayList<>();

    public Bestilling(LocalDate dato, Kunde kunde, Forestilling forestilling) {
        this.dato = dato;
        this.kunde = kunde;
        kunde.addBestilling(this);


        // komposition 1--- 0...* forestilling
        this.forestilling = forestilling;


    }

    public LocalDate getDato() {
        return dato;
    }

    //linkattributter bestilling og plads
    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public void addPLads(Plads plads) {
        if (!pladser.contains(plads)) {
            pladser.add(plads);
        }
    }


}
