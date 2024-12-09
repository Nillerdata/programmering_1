package model;

public class Ledsager {

    private String navn;
    private String tlf;
    private Deltager deltager;
    private Tilmelding tilmelding;


    Ledsager(String navn, String tlf, Tilmelding tilmelding) {
        this.navn = navn;
        this.tlf = tlf;
        this.tilmelding = tilmelding;

    }

    public Deltager getDeltager() {
        return deltager;
    }

    public String getNavn() {
        return navn;
    }

    public String getTlf() {
        return tlf;
    }

    @Override
    public String toString() {
        return "Ledsager{" +
                "tlf='" + tlf + '\'' +
                ", navn='" + navn + '\'' +
                '}';
    }
}
