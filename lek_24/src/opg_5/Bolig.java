package opg_5;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bolig {
    private int kvm;
    private String adresse;
    private int prisPrMåned;
    private ArrayList<Lejeaftale>lejeaftales;

    private Kollegie kollegie;


    public Bolig(int kvm, String adresse, int prisPrMåned,Kollegie kollegie) {
        this.kvm = kvm;
        this.adresse = adresse;
        this.prisPrMåned = prisPrMåned;
        lejeaftales = new ArrayList<>();
        this.kollegie = kollegie;
    }


    public int getKvm() {
        return kvm;
    }

    public void setKvm(int kvm) {
        this.kvm = kvm;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPrisPrMåned() {
        return prisPrMåned;
    }

    public void setPrisPrMåned(int prisPrMåned) {
        this.prisPrMåned = prisPrMåned;
    }

    //linkattributter------------
    public ArrayList<Lejeaftale>getLejeaftales(){
        return new ArrayList<>(lejeaftales);
    }

    public Lejeaftale createLejeaftale(LocalDate fraDato){
        Lejeaftale lejeaftale = new Lejeaftale(fraDato);
        lejeaftales.add(lejeaftale);
        return lejeaftale;
    }

    public void removeLejeaftales(Lejeaftale lejeaftale){
        if(lejeaftales.contains(lejeaftale)){
            lejeaftales.remove(lejeaftale);
        }
    }

    public void setKollegie(Kollegie kollegie){
        if(this.kollegie != kollegie){
            Kollegie gammelKollegie =this.kollegie;
            if(gammelKollegie != null){
                gammelKollegie.removeBolig(this);
            }
            this.kollegie = kollegie;
            if(kollegie != null){
                kollegie.addBolig(this);
            }
        }
    }

}
