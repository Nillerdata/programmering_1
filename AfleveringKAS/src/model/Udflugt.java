package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Udflugt {


    private LocalDate Dato;
    private LocalTime StartTidspunkt;
    private LocalTime SlutTidspunkt;
    private String navn;
    private String mødested;
    private double pris;
    private ArrayList<Ledsager> ledsager = new ArrayList<>();
    private Konference konference;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    Udflugt(LocalDate dato, LocalTime startTidspunkt, LocalTime slutTidspunkt, String navn, String mødested, double pris, Konference konference) {
        this.Dato = dato;
        this.StartTidspunkt = startTidspunkt;
        this.SlutTidspunkt = slutTidspunkt;
        this.navn = navn;
        this.mødested = mødested;
        this.pris = pris;
        this.konference = konference;
    }

    public LocalDate getDato() {
        return Dato;
    }

    public void setDato(LocalDate dato) {
        Dato = dato;
    }

    public LocalTime getStartTidspunkt() {
        return StartTidspunkt;
    }

    public void setStartTidspunkt(LocalTime startTidspunkt) {
        StartTidspunkt = startTidspunkt;
    }

    public LocalTime getSlutTidspunkt() {
        return SlutTidspunkt;
    }

    public void setSlutTidspunkt(LocalTime slutTidspunkt) {
        SlutTidspunkt = slutTidspunkt;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getMødested() {
        return mødested;
    }

    public void setMødested(String mødested) {
        this.mødested = mødested;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public ArrayList<Ledsager> getLedsager() {
        return ledsager;
    }

    public void setLedsager(ArrayList<Ledsager> ledsager) {
        this.ledsager = ledsager;
    }

    public Konference getKonference() {
        return konference;
    }

    public void addTilmelding(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
            tilmelding.addUdflugt(this);
        }
    }

    public void removeTilmeldning(Tilmelding tilmelding) {
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
            tilmelding.removeUdflugt(this);
        }
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    @Override
    public String toString() {
        return "Udflugt{" +
                "navn='" + navn + '\'' +
                ", mødested='" + mødested + '\'' +
                ", pris=" + pris + '}';
    }
}

