package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Konference {

    private String navn;
    private String adresse;
    private LocalDate startDato;
    private LocalDate slutDato;
    private String kortBeskrivelse;
    private int konkurrenceAfgit;
    private ArrayList<Hotel> hotels = new ArrayList<>();
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();


    public Konference(String navn, String adresse, LocalDate startDato, LocalDate slutDato, String kortBeskrivelse, int konkurrenceAfgit) {
        this.navn = navn;
        this.adresse = adresse;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.kortBeskrivelse = kortBeskrivelse;
        this.konkurrenceAfgit = konkurrenceAfgit;
    }

    public String getNavn() {
        return navn;
    }

    public int getKonkurrenceAfgit() {
        return konkurrenceAfgit;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public String getAdresse() {
        return adresse;
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public String getKortBeskrivelse() {
        return kortBeskrivelse;
    }

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

    public void setKonkurrenceAfgit(int konkurrenceAfgit) {
        this.konkurrenceAfgit = konkurrenceAfgit;
    }

    public void addHotel(Hotel hotel) {
        if (!hotels.contains(hotel)) {
            hotels.add(hotel);
            hotel.addkonference(this);
        }
    }

    public void removeHotel(Hotel hotel) {
        if (hotels.contains(hotel)) {
            hotels.remove(hotel);
            hotel.removeKonference(this);
        }
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public Udflugt createUdflugt(LocalDate dato, LocalTime startTidspunkt, LocalTime slutTidspunkt, String navn, String mødested, double pris) {
        Udflugt udflugt1 = new Udflugt(dato, startTidspunkt, slutTidspunkt, navn, mødested, pris, this);
        udflugter.add(udflugt1);
        return udflugt1;
    }

    public void removeUdflugt(Udflugt udflugt) {
        if (!udflugter.contains(udflugt)) {
            udflugter.remove(udflugt);

        }
    }

    public Tilmelding createTilmelding(LocalDate ankomstdato, LocalDate afrejseDato, Boolean foredragsHolder, Deltager deltager) {
        Tilmelding tilmelding = new Tilmelding(ankomstdato, afrejseDato, foredragsHolder, deltager, this);
        tilmeldinger.add(tilmelding);
        return tilmelding;

    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }


    @Override
    public String toString() {
        return "Konference{" +
                "navn='" + navn + '\'' +
                ", kortBeskrivelse='" + kortBeskrivelse + '\'' +
                ", konkurrenceAfgit=" + konkurrenceAfgit;
    }
}
