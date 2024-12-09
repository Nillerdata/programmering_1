package opgaver;

import model.Customer;

import java.util.ArrayList;

public class opg_1 {
    public static void main(String[] args) {
        ArrayList<Customer> list1 = new ArrayList<>();
        ArrayList<Customer> list2 = new ArrayList<>();

        Customer c1 = new Customer("Anne", "Glensgaard,'", 27);
        Customer c2 = new Customer("Børge", "Glensgaard,'", 20);
        Customer c3 = new Customer("Charlie", "Glensgaard,'", 24);
        Customer c4 = new Customer("Dagmar", "Barbre,'", 24);
        Customer c5 = new Customer("Eoin", "Bond,'", 40);
        Customer c6 = new Customer("Bo", "NotStirred,'", 27);
        Customer c7 = new Customer("Dortmund", "ogCola,'", 27);
        Customer c8 = new Customer("Hest", "Ideer,'", 27);
        Customer c9 = new Customer("Ib", "WeLikeThat,'", 27);
        Customer c10 = new Customer("John", "WeLikeThat,'", 27);

        list1.add(c1);
        list1.add(c2);
        list1.add(c3);
        list1.add(c4);
        list1.add(c5);

        list2.add(c6);
        list2.add(c7);
        list2.add(c8);
        list2.add(c9);
        list2.add(c10);

        System.out.println(flet(list1,list2));

    }

    public static ArrayList<Customer> flet(ArrayList<Customer> s1, ArrayList<Customer> s2) {
        ArrayList<Customer> sorteret = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;

        while (i1 < s1.size() && i2 < s2.size()) {
            if (s1.get(i1).getFirstName().compareTo(s2.get(i2).getFirstName()) < 0) {
                sorteret.add(s1.get(i1));
                i1++;
            } else {
                sorteret.add(s2.get(i2));
                i2++;
            }
        }
        while (i1 < s1.size()) {
            sorteret.add(s1.get(i1));
            i1++;
        }
        while (i2 < s2.size()) {
            sorteret.add(s2.get(i2));
            i2++;
        }
        return sorteret;
    }

}
