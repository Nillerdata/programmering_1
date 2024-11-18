package model;


import java.time.LocalDate;

import java.util.ArrayList;
import java.util.stream.Collectors;

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

    public Bestilling createBestilling(LocalDate dato, Kunde kunde, Forestilling forestilling) {
        Bestilling bestilling = new Bestilling(dato, kunde, this);
        bestillings.add(bestilling);
        return bestilling;
    }

    //TODO lave tostring metode
    //________________________________
    @Override
    public String toString() {
        return navn + "(Fra " + startDato + "til " + slutDato + ")";
    }

    //__________________________________
    //TODO opgave 6
    //---------------------------------------
    public boolean erPladsLedig(int række, int nr, LocalDate dato) {
        boolean erLedig = true;
        for (Bestilling b : bestillings) {
            if (b.getDato().equals(dato)) {
                for (Plads p : b.getPladser()) {
                    if (p.getRække() == række && p.getNr() == nr) {
                        erLedig = false;
                    }
                }

            }
        }
        return erLedig;

    }
    //__________________________
    //TODO opgave 7.2

    /**
     * Tilføj til klassen Forestilling metoden
     * antalBestiltePladserPåDag(LocalDate dato): int
     * der returnerer, hvor mange pladser der er bestilt til forestillingen på den pågældende dato.
     */
    public int antalBestiltePladserPåDag(LocalDate dato) {
        int antalPladser = 0;

        for (Bestilling b : bestillings) {
            if (b.getDato().equals(dato)) {
                antalPladser += b.getPladser().size();
            }


        }
        return antalPladser;
    }
    //________________________________________________________
    //TODO opgave 7.3
    /**
     * Tilføj til klassen Forestilling en metode succesDato, der returnerer datoen for den
     * dag, hvor der har været flest pladser bestilt til forestillingen. Hvis der er flere dage, der har
     * haft dette antal, returneres blot en af datoerne.
     */

    public LocalDate succesDato(){
        LocalDate succesdato = null;
        int flestBestillinger = Integer.MIN_VALUE;
        ArrayList<LocalDate>datoer = new ArrayList<>(startDato.datesUntil(slutDato.plusDays(1))
                .collect(Collectors.toList()));

        for (LocalDate dato : datoer) {
            if(antalBestiltePladserPåDag(dato)>flestBestillinger){
                flestBestillinger = antalBestiltePladserPåDag(dato);
                succesdato = dato;
            }
        }
            return succesdato;
        }



}
