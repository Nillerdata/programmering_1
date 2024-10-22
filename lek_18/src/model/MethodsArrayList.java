package model;

import java.util.ArrayList;

public class MethodsArrayList {

    /**
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

    public static int min(ArrayList<Integer> list) {
        int minInt = Integer.MAX_VALUE;
        for (int i : list) {
            if (minInt > i) {
                minInt = i;
            }
        }
        return minInt;
    }

    public static double average(ArrayList<Integer> list) {
        double averageNumber = 0;
        for (double d : list) {
            averageNumber += d;
        }
        return averageNumber / list.size();
    }

    public static int countZeros(ArrayList<Integer> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                count++;
            }
        }
        return count;
    }

    public static void swapEvenWithZero(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.set(i, 0);
            }
        }
    }

    public static ArrayList<Integer> aEvenList(ArrayList<Integer> list) {
        ArrayList<Integer> evenList = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                evenList.add(list.get(i));


            }
        }
        return evenList;
    }

    public static void swapFirstAndLast(ArrayList<Integer> list) {
        int temp = list.getFirst();
        list.set(0, list.getLast());
        list.set(list.size() - 1, temp);
    }

    public static void shiftRight(ArrayList<Integer> list) {
        int temp = list.getLast();
        list.removeLast();
        list.add(0, temp);
    }

    public static int nextBiggest(ArrayList<Integer> list) {
        int secondbiggest = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                secondbiggest = max;
                max = list.get(i);

            } else if (list.get(i) > secondbiggest) {
                secondbiggest = list.get(i);

            }
        }
        return secondbiggest;
    }

    public static boolean trueIfSorted(ArrayList<Integer> list) {
        boolean sorted = true;
        // Loop through the list up to the second-to-last element
        for (int i = 0; i < list.size() - 1; i++) {
            // Check if the current element is greater than the next element
            if (list.get(i) > list.get(i + 1)) {
                sorted = false;
            }
        }
        return sorted;
        /*We use list.size() - 1 because we are comparing each element to the next one (list.get(i + 1)). If we
        looped all the way to list.size(), we'd end up trying to access an element beyond the end of the list,
          causing an IndexOutOfBoundsException. Stopping at list.size() - 1 ensures that i + 1 is always a valid
         index within the list. */
    }

    public static boolean trueIfDoubles(ArrayList<Integer> list) {
        boolean doubles = false;
        for (int i = 0; i < list.size() - 1 && !doubles; i++) {
            for (int j = i + 1; j < list.size() && !doubles; j++) {
                if (list.get(i).equals(list.get(j))) {
                    doubles = true;
                }
            }
        }
        return doubles;
    }
//11.18 s.473
    public static ArrayList<Character> toCharacterArray(String s) {
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));

        }
        return list;
    }
//11.13 s.471
    public static void removeDuplicate(ArrayList<Integer> compare) {
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < compare.size(); j++) {
                if (compare.get(i).equals(compare.get(j))) {
                    compare.remove(j);
                    j--;
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        String s = "jeg vil hjem";
        list.add(19);
        list.add(35);
        list.add(14);
        list.add(7);
        System.out.println(list);
        System.out.println("Summen af tallene i listen med for " + sumListe(list));
        System.out.println("Summen af tallene i listen med forEach " + sumListe2(list));
        System.out.println(list);
        swapFirstAndLast(list);
        System.out.println("bytter på første og sidste : " + list);
        shiftRight(list);
        System.out.println("skifter array til højre : " + list);
        System.out.println("returnerer den næststørste : " + nextBiggest(list));
        System.out.println("kontrollerer om sorteret : " + trueIfSorted(list));
        System.out.println("kontrollerer om der er doubles : " + trueIfDoubles(list));
        System.out.println("characterarray : " + toCharacterArray(s));
        System.out.println("\n___________\n");
        ArrayList<Integer> compare = new ArrayList<Integer>();
        compare.add(1);
        compare.add(1);
        compare.add(1);
        compare.add(1);
        compare.add(1);
        compare.add(1);
        compare.add(1);
        compare.add(1);
        compare.add(1);
        compare.add(1);
        System.out.println(compare);
        removeDuplicate(compare);
        System.out.println("efter fjernelse af duplikering" + compare);


//        System.out.println("Indeks for det første lige tal: " + hasEvenAtIndex(list));
//        System.out.println(min(list));
//        System.out.println(average(list));
//        System.out.println(countZeros(list));
//        System.out.println(list);
//        swapEvenWithZero(list);
//
//        System.out.println(countZeros(list));
//        System.out.println(aEvenList(list));
    }

}
