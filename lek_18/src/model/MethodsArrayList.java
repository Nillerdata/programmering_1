package model;

import java.util.ArrayList;

public class MethodsArrayList {
    
    /**
     *
     * @param list
     * @return sums the mumbers in the list using a for loop
     */
    public static int sumListe(ArrayList<Integer> list) {
        int resultat = 0;
        for (int i = 0; i < list.size(); i++) {
        //	int tal = list.get(i);
            resultat = resultat + list.get(i);
        }
        return resultat;
    }
    
    /**
    *
    * @param list
    * @return sums the mumbers in the list using a forEach loop
    */
    public static int sumListe2(ArrayList<Integer> list) {
        int resultat = 0;
        for (int tal : list) {
            resultat = resultat + tal;
        }
        return resultat;
    }
    
    /**
     *
     * @param list
     * @return index at the first even number
     */
    public static int hasEvenAtIndex(ArrayList<Integer> list) {
        int index = -1;
        int i = 0;
        while (index == -1 && i < list.size()) {
            if (list.get(i) % 2 == 0) {
                index = i;
            }
            i++;
        }
        return index;
        
    }
    public static int min (ArrayList<Integer>list){
        int minInt = Integer.MAX_VALUE;
        for (int i : list){
            if (minInt>i){
                minInt=i;
            }
        }
    return minInt;
    }
    public static double average(ArrayList<Integer> list){
        double averageNumber=0;
        for(double d : list){
            averageNumber+=d;
        }
        return averageNumber/list.size();
    }
    public static int countZeros(ArrayList<Integer> list){
       int count = 0;
       for(int i = 0; i<list.size();i++){
           if (list.get(i) ==0){
               count++;
           }
       }
       return count;
    }
    public static void swapEvenWithZero(ArrayList<Integer>list){
        for (int i=0; i<list.size();i++){
            if(list.get(i)%2==0){
                list.set(i,0);
            }
        }
    }
    public static ArrayList<Integer>aEvenList (ArrayList<Integer>list){
        ArrayList<Integer>evenList = new ArrayList<Integer>();
        for (int i=0; i<list.size();i++){
            if (list.get(i) % 2 == 0){
               evenList.add(list.get(i));


            }
        }
        return evenList;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(19);
        list.add(35);
        list.add(14);
        list.add(7);
        System.out.println(list);
        System.out.println("Summen af tallene i listen med for "
                + sumListe(list));
        System.out.println("Summen af tallene i listen med forEach "
                + sumListe2(list));

        System.out.println("Indeks for det første lige tal: "
                + hasEvenAtIndex(list));
        System.out.println(min(list));
        System.out.println(average(list));
        System.out.println(countZeros(list));
        System.out.println(list);
        swapEvenWithZero(list);

        System.out.println(countZeros(list));
        System.out.println(aEvenList(list));
    }

}
