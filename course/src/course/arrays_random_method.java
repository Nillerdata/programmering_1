package course;

import java.util.Arrays;
import java.util.Random;

public class arrays_random_method {
    public static void main(String[] args) {
        int[]firstArray = getRandomArrray(10);
        System.out.println(Arrays.toString(firstArray));
        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = new int[10];
        System.out.println(Arrays.toString(secondArray));
        Arrays.fill(secondArray,5);
        System.out.println(Arrays.toString(secondArray));

        int[] thirdArray = getRandomArrray(10);
        System.out.println(Arrays.toString(thirdArray));

        /* her bliver thirdarray kopieret over ved at angive hvilket array og derefter angive en længde
        * man vil have det nye array til */
        int[] fourthArray = Arrays.copyOf(thirdArray,thirdArray.length);
        System.out.println(Arrays.toString(fourthArray));

        Arrays.sort(fourthArray);
        System.out.println(Arrays.toString(thirdArray));
        System.out.println(Arrays.toString(fourthArray));
        System.out.println();
        int[]smallerArray  = Arrays.copyOf(thirdArray,5);
        System.out.println(Arrays.toString(smallerArray));

        System.out.println();
        int[] largerArray = Arrays.copyOf(thirdArray,15);
        System.out.println(Arrays.toString(largerArray));


    }
    private static int[] getRandomArrray(int len){

        Random random = new Random();
        int[] newInt = new int [len];
    for ( int i = 0; i<len; i++){
        newInt[i] = random.nextInt(100);
    }
        return newInt;
    }
}
