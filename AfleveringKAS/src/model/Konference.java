package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private String adresse;
    private LocalDate startDato;
    private LocalDate slutDato;
    private String kortBeskrivelse;
    private double konferenceAfgift;
    //TODO linkattributter
    private final ArrayList<Hotel> hoteller = new ArrayList<>();
    private final ArrayList<Udflugt>udflugter = new ArrayList<>();
    private final ArrayList<Tilmelding>tilmeldinger = new ArrayList<>();
    private Tilmelding tilmelding;
    //--------------------------------
    //Constructor
    public Konference(String navn, String adresse, LocalDate startDato, LocalDate slutDato,
                      String kortBeskrivelse, double konferenceAfgift) {
        this.navn = navn;
        this.adresse = adresse;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.kortBeskrivelse = kortBeskrivelse;
        this.konferenceAfgift = konferenceAfgift;
    }
    //gettere

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public String getKortBeskrivelse() {
        return kortBeskrivelse;
    }

    public double getKonferenceAfgift() {
        return konferenceAfgift;
    }

    //---------------------------------------
    //Settere

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public void setKortBeskrivelse(String kortBeskrivelse) {
        this.kortBeskrivelse = kortBeskrivelse;
    }
    public void setKonferenceAfgift(double konferenceAfgift) {
        this.konferenceAfgift = konferenceAfgift;
    }
    //--------------------------------------
    //TODO linkattributter
    //konference aggregering 0..* -- 0.. * Hotel
    //add
    public void addhotel(Hotel hotel){
        if(!hoteller.contains(hotel)){
            hoteller.add(hotel);
            hotel.addKonference(this);
        }
    }
    //remove
    public void removeHotel(Hotel hotel){
        if(hoteller.contains(hotel)){
            hoteller.remove(hotel);
            hotel.removeKonference(this);
        }
    }
    //get
    public ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    //-----------------------------------------
    //konference 1 komp -- 0..* udflugt

    //create
    public Udflugt createUdflugt(LocalDate dato, LocalTime startTidspunkt, LocalTime slutTidspunkt,
                                 String navn, String mødested, double pris){
        Udflugt udflugt = new Udflugt(dato,startTidspunkt,slutTidspunkt,navn,mødested,pris,this);
        udflugter.add(udflugt);
        return udflugt;
    }
    //remove
    public void removeUdflugt(Udflugt udflugt){
        if(udflugter.contains(udflugt)){
            udflugter.remove(udflugt);
            //mangler måske noget. spørg Margrethe?
        }
    }
    //get

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }


    //createTilmelding
    public Tilmelding createTilmelding(LocalDate ankomstDato, LocalDate afrejseDato,boolean foredragsholder,Deltager deltager){
        Tilmelding tilmelding = new Tilmelding(ankomstDato,afrejseDato,foredragsholder,deltager);
        tilmeldinger.add(tilmelding);

        return tilmelding;
    }



    //TODO metoder
}
