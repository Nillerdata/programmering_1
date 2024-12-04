package model;

import java.util.ArrayList;

public class Deltager {
    private String navn;
    private String adresse;
    private String byOgLand;
    private String firmaNavn;
    private String tlfnr;
    private String firmaTlf;
    //-------------------------------------------------------------------
    //TODO linkattributter
    Tilmelding tilmelding;

    private final ArrayList<Tilmelding>Tilmeldinger = new ArrayList<>();


    //constructors
    //med firma
    public Deltager(String navn, String adresse, String byOgLand, String firmaNavn, String tlfnr, String firmaTlf) {
        this.navn = navn;
        this.adresse = adresse;
        this.byOgLand = byOgLand;
        this.firmaNavn = firmaNavn;
        this.tlfnr = tlfnr;
        this.firmaTlf = firmaTlf;
    }
    //uden firma
    public Deltager(String navn, String adresse, String byOgLand, String tlfnr) {
        this.navn = navn;
        this.adresse = adresse;
        this.byOgLand = byOgLand;
        this.tlfnr = tlfnr;
    }

    //gettere og settere
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

    public String getByOgLand() {
        return byOgLand;
    }

    public void setByOgLand(String byOgLand) {
        this.byOgLand = byOgLand;
    }

    public String getFirmaNavn() {
        return firmaNavn;
    }

    public void setFirmaNavn(String firmaNavn) {
        this.firmaNavn = firmaNavn;
    }

    public String getTlfnr() {
        return tlfnr;
    }

    public void setTlfnr(String tlfnr) {
        this.tlfnr = tlfnr;
    }

    public String getFirmaTlf() {
        return firmaTlf;
    }

    public void setFirmaTlf(String firmaTlf) {
        this.firmaTlf = firmaTlf;
    }

    //--------------------------------
    //TODO linkattributter

    public void addTilmelding(Tilmelding tilmelding){
        if(!Tilmeldinger.contains(tilmelding)){
            Tilmeldinger.add(tilmelding);
            tilmelding.setDeltager(this);
        }
    }
//    public void removeTilmelding(Tilmelding tilmelding){
//        if(Tilmeldinger.contains(tilmelding)){
//            Tilmeldinger.remove(tilmelding);
//            tilmelding.setDeltager(null);
//        }
//    }


    //------------------------------------------------
    //getmetode til arraylist

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(Tilmeldinger);
    }

    //------------------------------------------------
    //tostring metode


    @Override
    public String toString() {
        return "Deltager{" +
                "navn='" + navn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", byOgLand='" + byOgLand + '\'' +
                ", firmaNavn='" + firmaNavn + '\'' +
                ", tlfnr='" + tlfnr + '\'' +
                ", firmaTlf='" + firmaTlf + '\'' +
                ", tilmelding=" + tilmelding +
                ", Tilmeldinger=" + Tilmeldinger +
                '}';
    }
}
