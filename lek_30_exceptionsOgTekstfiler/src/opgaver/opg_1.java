package opgaver;

import com.sun.tools.javac.Main;
import model.Customer;

import java.util.ArrayList;
import java.util.Arrays;

public class opg_1 {
    public static void main(String[] args) {
        Customer c1 = new Customer("Niels","Glensgaard",24);
        Customer c2 = new Customer("Bob","Byggemand",30);
        Customer c3 = new Customer("Cohn","Byggemand",30);
        Customer c4 = new Customer("Dhomas","Byggemand",30);
        Customer c5 = new Customer("Fhristoffer","Albertsen",32);
        Customer c6 = new Customer("CohnnyBoy","g",30);
//        ArrayList<Customer> list  =new ArrayList<>();
//        list.add(c1);
//        list.add(c2);
//        list.add(c3);
//        list.add(c4);
//        list.add(c5);
//
//
//
//        System.out.println(list);
//        ArraylistinsertioneSort(list);
//        System.out.println(list);
//        insertCustomer(list,c6);
//        System.out.println(list);

        Customer[] StringNavne = new Customer[6];
        StringNavne[0] = c1;
        StringNavne[1]=c2;
        StringNavne[2]=c3;
        StringNavne[3]=c4;
        StringNavne[4]=c5;
        System.out.println(Arrays.toString(StringNavne));
        insertCustomerarray(StringNavne,c6);


    }
    /**
     * Indsætter kunde i kunder. Arrayet kunder er sorteret
     * Krav: kunder er sorteret
     *
     */
    public static void insertCustomerarray(Customer[] list,
                                      Customer customer) {
        int j = list.length-1;
        while(j>=0 && list[j]== null) {
            j--;
        }
        j++;
        boolean found = false;
        while (!found && j>0) {
            if (customer.getFirstName().compareTo(list[j-1].getFirstName())<0) {
                found = true;
            }
            else {
                list[j] = list[j-1];
                j--;
            }
        }
        list[j]= customer;

    }



    /**
     * Indsætter kunde i kunder. Listen kunder er sorteret
     * Krav: kunder er sorteret
     *
     */
    public static void insertCustomer(ArrayList<Customer>
                                              list, Customer customer){

        boolean found = false;
        int i = 0;

    while(!found && i<list.size()){
        if(customer.getFirstName().compareTo(list.get(i).getFirstName()) < 0){
            found = true;
        }
        else{
            System.out.println("det her er træls");
            i++;
        }
    }

    list.add(i,customer);

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
    public static void insertioneSort(Customer[] list) {
        for (int i = 1; i < list.length; i++) {
            Customer next = list[i];
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.getFirstName().compareTo(list[j-1].getFirstName())>0) {
                    found = true;
                } else {
                    list[j] = list[j - 1];
                    j--;
                }
            }
            list[j] = next;
        }
    }
}
