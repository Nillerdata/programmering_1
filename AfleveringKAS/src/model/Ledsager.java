package model;

public class Ledsager {
    private String navn;
    private String tlf;
    //Linkattribut
    private Tilmelding tilmelding;


    Ledsager(String navn, String tlf,Tilmelding tilmelding){
        this.navn = navn;
        this.tlf = tlf;
        this.tilmelding = tilmelding;
    }



    public String getNavn() {
        return navn;
    }

    public String getTlf() {
        return tlf;
    }
    //linkattribut

    public Tilmelding getTilmelding() {
        return tilmelding;
    }

    //--------------------------------------------
    //tostring metode


    @Override
    public String toString() {
        return "Ledsager{" +
                "navn='" + navn + '\'' +
                '}';
    }
}
