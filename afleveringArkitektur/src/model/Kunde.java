package model;

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


}
