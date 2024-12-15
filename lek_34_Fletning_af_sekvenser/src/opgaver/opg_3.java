package opgaver;

import model.Customer;

import java.util.ArrayList;

public class opg_3 {
    public static void main(String[] args) {
//        Customer c1 = new Customer("Anne", "Glensgaard,'", 27);
//        Customer c2 = new Customer("Børge", "Glensgaard,'", 20);
//        Customer c3 = new Customer("Charlie", "Glensgaard,'", 24);
//        Customer c4 = new Customer("Dagmar", "Barbre,'", 24);
//        Customer c5 = new Customer("Eoin", "Bond,'", 40);
//        Customer c6 = new Customer("Bo", "NotStirred,'", 27);
//        Customer c7 = new Customer("Dortmund", "ogCola,'", 27);
//        Customer c8 = new Customer("Hest", "Ideer,'", 27);
//        Customer c9 = new Customer("Ib", "WeLikeThat,'", 27);
//        Customer c10 = new Customer("John", "WeLikeThat,'", 27);
//        ArrayList<Customer> list1 = new ArrayList<>();
//        list1.add(c1);
//        list1.add(c2);
//        list1.add(c3);
//        list1.add(c4);
//        list1.add(c5);
//
//        Customer[]l2 = {c1,c6,c7,c8,c9,c10};
        Customer c1 = new Customer("Anders", "Hippity", 24);
        Customer c2 = new Customer("Bob", "Hoppity", 30);
        Customer c3 = new Customer("Christoffer", "This", 30);
        Customer c4 = new Customer("Dennis", "Code", 30);
        Customer c5 = new Customer("Erik", "Is", 32);
        Customer c6 = new Customer("Frede", "My", 30);


        Customer c7 = new Customer("Gert", "God", 45);
        Customer c8 = new Customer("Hans", "Damn", 78);
        Customer c9 = new Customer("Ingemann", "Property", 67);

        ArrayList<Customer> foretningsListe = new ArrayList<>();
        foretningsListe.add(c1);
        foretningsListe.add(c2);
        foretningsListe.add(c3);
        foretningsListe.add(c4);
        foretningsListe.add(c5);
        foretningsListe.add(c6);

        Customer[] dårligeBetalere = {c2, c3, c7, c8, c9};
        System.out.println(goodCustomers(foretningsListe, dårligeBetalere));
    }

    /**
     * Returnerer en sorteret ArrayList der indeholder alle
     * customers fra l1 der ikke er i l2
     * Krav: l1 og l2 er sorterede, indeholder ikke dubletter og
     * indeholder ikke tomme pladser
     */
    public static ArrayList goodCustomers(ArrayList<Customer> l1,
                                          Customer[] l2) {

        ArrayList<Customer> godkendte = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < l1.size() && i2 < l2.length) {
            if (l1.get(i1).getFirstName().compareTo(l2[i2].getFirstName()) < 0) {
                godkendte.add(l1.get(i1));
                i1++;

            } else if (l1.get(i1).getFirstName().compareTo(l2[i2].getFirstName()) > 0) {
                i2++;

            } else {
                i1++;
                i2++;
            }

        }
        while (i1 < l1.size()) {
            godkendte.add(l1.get(i1));
            i1++;
        }
        return godkendte;
    }
}
