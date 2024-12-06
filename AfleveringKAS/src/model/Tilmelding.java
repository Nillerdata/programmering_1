package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Tilmelding {
    private LocalDate ankomstDato;
    private LocalDate afrejseDato;
    private boolean foredragsholder;
    //---------------------------------------------
    //TODO linkattributter
    private final ArrayList<Ekstra> ekstras = new ArrayList<>();
    private final ArrayList<Udflugt> udflugter = new ArrayList<>();
    private final ArrayList<Hotel> Hoteller = new ArrayList<>();
    private Hotel hotel;
    private Ledsager ledsager;
    private Deltager deltager;
    private Konference konference;



    //---------------------------------------------
    //constructor
    Tilmelding(LocalDate ankomstDato, LocalDate afrejseDato, boolean foredragsholder, Konference konference, Deltager deltager) {
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
        this.foredragsholder = foredragsholder;
        this.konference = konference;
        this.setDeltager(deltager);

    }
    //---------------------------------------------
    //gettere


    public LocalDate getAnkomstDato() {
        return ankomstDato;
    }

    public LocalDate getAfrejseDato() {
        return afrejseDato;
    }

    public boolean isForedragsholder() {
        return foredragsholder;
    }
    //---------------------------------------------
    //settere

    public void setAnkomstDato(LocalDate ankomstDato) {
        this.ankomstDato = ankomstDato;
    }

    public void setAfrejseDato(LocalDate afrejseDato) {
        this.afrejseDato = afrejseDato;
    }

    public void setForedragsholder(boolean foredragsholder) {
        this.foredragsholder = foredragsholder;
    }
    //---------------------------------------------


    //---------------------------------------------
    //Createmetode
    public Ledsager createLedsager(String navn, String tlf) {
        ledsager = new Ledsager(navn, tlf, this);
        return ledsager;
    }


    //get metode
    public Ledsager getLedsager() {
        return ledsager;
    }


    //---------------------------------------------
    //hjælpemetode til constructor
    void setDeltager(Deltager deltager) {
        if (this.deltager != deltager) {
            this.deltager = deltager;
            if (deltager != null) {
                deltager.addTilmelding(this);
            }
        }
    }

    public Deltager getDeltager() {
        return deltager;
    }
    //--------------------------------------

    public Konference getKonference() {
        return konference;
    }


    //--------------------------------------
    //tilmelding * -- 0..1 Hotel

    //set
    public void setHotel(Hotel hotel) {
        if (this.hotel != hotel) {
            Hotel gammelHotel = this.hotel;
            if (gammelHotel != null) {
                gammelHotel.removeTilmelding(this);
            }
            this.hotel = hotel;
            if (hotel != null) {
                hotel.addTilmelding(this);
            }
        }
    }
    //get

    public ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(Hoteller);
    }
    //---------------------------------------------------


    //tilmelding 0..* --> 0..* Ekstra

    //add
    public void addEkstra(Ekstra ekstra) {
        if (!ekstras.contains(ekstra)) {
            ekstras.add(ekstra);
        }
    }

    //remove
    public void removeEkstra(Ekstra ekstra) {
        if (ekstras.remove(ekstra)) {
            ekstras.remove(ekstra);
        }
    }
    //get

    public ArrayList<Ekstra> getEkstras() {
        return new ArrayList<>(ekstras);
    }
//-----------------------------------------------
    //Tilmelding 0..* -- 0..* Udflugt

    //add
    public void addUdflugt(Udflugt udflugt) {
        if (!udflugter.contains(udflugt)) {
            udflugter.add(udflugt);
            udflugt.addTilmelding(this);
        }
    }

    //remove
    public void removeUdflugt(Udflugt udflugt) {
        if (!udflugter.contains(udflugt)) {
            udflugter.add(udflugt);
            udflugt.removeTilmelding(this);
        }
    }
    //get

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public double getSamletPris() {
        double samletPris = 0;
        double hotelEnkeltprisPris = 0;
        double hotelDobbeltPris = 0;
        double ekstraPris = 0;
        double udflugtPris = 0;
        long antalDage = ChronoUnit.DAYS.between(ankomstDato,afrejseDato)+1;
        long antalNætter = antalDage-1;


            double konferencePris = konference.getKonferenceAfgift() * antalDage;
        if(isForedragsholder()||deltager.getFirmaNavn() != null){
            konferencePris = 0;
        }

        if (hotel != null) {
            if(ledsager == null) {

                hotelEnkeltprisPris = hotel.getEnkeltpris() * antalNætter;
            }else {
                hotelDobbeltPris = hotel.getDobbeltpris() * antalNætter;

            }


            for (Ekstra ekstra1 : ekstras) {
                ekstraPris += ekstra1.getPris() * antalNætter;
            }

        }

        for (Udflugt udflugt1 : udflugter) {
            udflugtPris += udflugt1.getPris();

        }

        return samletPris +=  konferencePris + hotelEnkeltprisPris + hotelDobbeltPris + ekstraPris +
                udflugtPris;

}
//---------------------------------------------------------------------------------------------------


    @Override
    public String toString() {
        return "Tilmelding{" +
                "hotel=" + hotel +
                ", deltager=" + deltager.getNavn() +

                '}';
    }
}
