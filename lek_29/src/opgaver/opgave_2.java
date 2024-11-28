package opgaver;

import model.Customer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class opgave_2 {
    public static void main(String[] args) {
        String[] Stringnavne = {"Bob","John","Thomas","Niels"};
    Customer c1 = new Customer("Niels","Glensgaard",24);
    Customer c2 = new Customer("Bob","Byggemand",30);
    Customer c3 = new Customer("John","Byggemand",30);
    Customer c4 = new Customer("Thomas","Byggemand",30);
    Customer c5 = new Customer("Christoffer","Albertsen",32);
    ArrayList<Customer>hej  =new ArrayList<>();
    hej.add(c1);
        hej.add(c2);
        hej.add(c3);
        hej.add(c4);
        hej.add(c5);
        System.out.println(hej);
        selectionSort1(hej);
        System.out.println(hej);
        System.out.println(Arrays.toString(Stringnavne));
        selectionSort(Stringnavne);
        System.out.println(Arrays.toString(Stringnavne));
    }
    private static void swap(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void selectionSort(String[] list) {
        Customer customer = null;
        for (int i = 0; i < list.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].compareTo(list[minPos]) <0) {
                    minPos = j;
                }

            }
            swap(list, i, minPos);
        }
    }
    private static void swapArraylist(ArrayList<Customer> list, int i, int j) {
        Customer temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

    public static void selectionSort1(ArrayList<Customer> list) {
        for (int i = 0; i < list.size(); i++) {
            int minPos = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getFirstName().compareTo(list.get(minPos).getFirstName())<0) {
                    minPos = j;
                }

            }
            swapArraylist(list, i, minPos);
        }
    }
}
