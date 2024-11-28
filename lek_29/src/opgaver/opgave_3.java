package opgaver;

import model.Customer;

import java.util.ArrayList;
import java.util.Arrays;

public class opgave_3 {
    public static void main(String[] args) {
        String[] StringNavne = {"Bob","Albert","Niels","Åge","Thomas"};
        System.out.println(Arrays.toString(StringNavne));
        insertioneSort(StringNavne);
        System.out.println(Arrays.toString(StringNavne));
        Customer c1 = new Customer("Niels","Glensgaard",24);
        Customer c2 = new Customer("Bob","Byggemand",30);
        Customer c3 = new Customer("John","Byggemand",30);
        Customer c4 = new Customer("Thomas","Byggemand",30);
        Customer c5 = new Customer("Christoffer","Albertsen",32);
        ArrayList<Customer> hej  =new ArrayList<>();
        hej.add(c1);
        hej.add(c2);
        hej.add(c3);
        hej.add(c4);
        hej.add(c5);
        System.out.println(hej);
        ArraylistinsertioneSort(hej);
        System.out.println(hej);
    }
    public static void insertioneSort(String[] list) {
        for (int i = 1; i < list.length; i++) {
            String next = list[i];
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(list[j-1])>0) {
                    found = true;
                } else {
                    list[j] = list[j - 1];
                    j--;
                }
            }
            list[j] = next;
        }
    }
    public static void ArraylistinsertioneSort(ArrayList<Customer> list) {
        for (int i = 1; i < list.size(); i++) {

            Customer next = list.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.getFirstName().compareTo(list.get(j-1).getFirstName())>=0) {
                    found = true;
                } else {

                    list.set(j,list.get(j-1));
                    j--;
                }
            }
            list.set(j,next);
        }
    }
}
