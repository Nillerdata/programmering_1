package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Udflugt {
    private LocalDate dato;
    private LocalTime startTidspunkt;
    private LocalTime slutTidspunkt;
    private String navn;
    private String mødested;
    private double pris;
    //----------------------------------------
    //TODO linkattributter
    private Konference konference;
    private final ArrayList<Tilmelding>tilmeldinger = new ArrayList<>();
    //----------------------------------------
    //constructor
    Udflugt(LocalDate dato, LocalTime startTidspunkt, LocalTime slutTidspunkt,
            String navn, String mødested, double pris,Konference konference) {
        this.dato = dato;
        this.startTidspunkt = startTidspunkt;
        this.slutTidspunkt = slutTidspunkt;
        this.navn = navn;
        this.mødested = mødested;
        this.pris = pris;
    }
    //------------------------------------------
    //gettere

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getStartTidspunkt() {
        return startTidspunkt;
    }

    public LocalTime getSlutTidspunkt() {
        return slutTidspunkt;
    }

    public String getNavn() {
        return navn;
    }

    public String getMødested() {
        return mødested;
    }

    public double getPris() {
        return pris;
    }
    //----------------------------------------------
    //settere

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public void setStartTidspunkt(LocalTime startTidspunkt) {
        this.startTidspunkt = startTidspunkt;
    }

    public void setSlutTidspunkt(LocalTime slutTidspunkt) {
        this.slutTidspunkt = slutTidspunkt;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setMødested(String mødested) {
        this.mødested = mødested;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }
    //---------------------------------------------------
    //TODO linkattributter

    //---------------------------------------------------
    //udflugt 0..* -- komp konference

    //get
    public Konference getKonference() {
        return konference;
    }
    //---------------------------------------------------
    //Udflugt 0..* -- 0..* Tilmelding

    //add
    public void addTilmelding(Tilmelding tilmelding){
        if(!tilmeldinger.contains(tilmelding)){
            tilmeldinger.add(tilmelding);
            tilmelding.addUdflugt(this);
        }
    }
    //remove
    public void removeTilmelding(Tilmelding tilmelding){
        if(tilmeldinger.contains(tilmelding)){
            tilmeldinger.remove(tilmelding);
            tilmelding.removeUdflugt(this);
        }
    }
    //get

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }
//---------------------------------------------------------
    //TODO metoder
}
