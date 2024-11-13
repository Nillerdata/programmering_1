package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Forestilling {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;

    // composition 1 --> 0..* Bestilling
    private final ArrayList<Bestilling> bestillings = new ArrayList<>();

    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    //TODO linkmetoder til bestilling komposition forestilling 1---0...* bestilling

    public ArrayList<Bestilling> getBestillings() {
        return new ArrayList<>(bestillings);
    }

    public Bestilling createBestilling(LocalDate dato, Kunde kunde) {
        Bestilling bestilling = new Bestilling(dato, kunde, this);
        bestillings.add(bestilling);
        return bestilling;
    }
}
