package model;

import java.util.ArrayList;

public class Deltager {

    private String navn;
    private String adresse;
    private String land;
    private String firmanavn;
    private String tlfNr;
    private String firmatlfNr;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();


    public Deltager(String navn, String adresse, String land, String firmanavn, String tlfNr, String firmatlfNr) {
        this.navn = navn;
        this.adresse = adresse;
        this.land = land;
        this.firmanavn = firmanavn;
        this.tlfNr = tlfNr;
        this.firmatlfNr = firmatlfNr;
    }

    public Deltager(String navn, String adresse, String land, String tlfNr) {
        this.navn = navn;
        this.adresse = adresse;
        this.land = land;
        this.tlfNr = tlfNr;
    }


    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getFirmanavn() {
        return firmanavn;
    }

    public void setFirmanavn(String firmanavn) {
        this.firmanavn = firmanavn;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public void setTlfNr(String tlfNr) {
        this.tlfNr = tlfNr;
    }

    public String getFirmatlfNr() {
        return firmatlfNr;
    }

    public void setFirmatlfNr(String firmatlfNr) {
        this.firmatlfNr = firmatlfNr;
    }


    //------------------------------------------------------------

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public void addTilmelding(Tilmelding tilmelding){
        if(!tilmeldinger.contains(tilmelding)){
            tilmeldinger.add(tilmelding);
            tilmelding.setDeltager(this);
        }
    }

//    public void removeTilmelding(Tilmelding tilmelding){
//        if(tilmeldinger.contains(tilmelding)){
//            tilmeldinger.remove(tilmelding);
//        }
//}

    // muligvis en remove


    @Override
    public String toString() {
        return "Deltager{" +
                "navn='" + navn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", land='" + land + '\'';
    }
}
