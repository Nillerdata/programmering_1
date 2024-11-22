package øvelse;

import java.util.ArrayList;

public class opgave_6 {
    public static void main(String[] args) {
        ArrayList<Integer> liste = new ArrayList();
        liste.add(10);
        liste.add(12);
        liste.add(30);
        liste.add(45);
        liste.add(50);
        System.out.println(liste);
       find(liste,30);
        System.out.println(liste);
    }


    public static int find(ArrayList<Integer> list, int n){
        int i = 0;
        int index = -1;
        int temp  = 0;
        while( i < list.size() && index == -1){
            if(list.get(i) == n){
                index = i;


            }
            else i++;
        }
        if(index != -1) {
            if (i != 0) {
                temp = list.get(i - 1);
                list.set(i - 1, list.get(i));
                list.set(i, temp);
                index = i - 1;
            }
        }
        else{
            index = 0;
        }
    return index;
    }

}
