package opg_5;

import java.time.LocalDate;
import java.time.LocalDate;

public class app {
    public static void main(String[] args) {
        Kollegie k1 = new Kollegie("Damager","Damagervej 12");
        Bolig b1 = new Bolig(25,"sdfinoj",203,k1);
        k1.addBolig(b1);
        Lejeaftale l1 = b1.createLejeaftale(LocalDate.of(2023,1,1));
        l1.setTilDato(LocalDate.of(2024,1,1));
        System.out.println(k1.gennenmsnitligAntalDage());
        System.out.println(k1.getAntalLejeAftaler());
    }
}