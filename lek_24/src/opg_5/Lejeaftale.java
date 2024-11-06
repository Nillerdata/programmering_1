package opg_5;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lejeaftale {
    private LocalDate fraDato;
    private LocalDate tilDato;
    private final ArrayList<Lejer>lejers;

    public Lejeaftale(LocalDate fraDato) {
        this.fraDato = fraDato;
        this.tilDato = null;
        lejers = new ArrayList<>();
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public void setFraDato(LocalDate fraDato) {
        this.fraDato = fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    public void setTilDato(LocalDate tilDato) {
        this.tilDato = tilDato;
    }

    //linkattributter---------

    public void addLejere(Lejer lejer){
        if(!lejers.contains(lejer)&&lejers.size() != 2){
            lejers.add(lejer);
        }
    }
    public void removeLejere(Lejer lejer){
        if(lejers.contains(lejer)){
            lejers.remove(lejer);
        }
    }
    //linkattributter til bolig

}
