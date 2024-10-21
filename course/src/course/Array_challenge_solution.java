package course;

import java.util.Arrays;
import java.util.Random;
//fra course 122 arrays challenge exercise
public class Array_challenge_solution {
    public static void main(String[] args) {
    int[]unsortedArray = getRandomArray(5);
        System.out.println(Arrays.toString(unsortedArray));

        int[] sortedArray = sortIntegers(new int[]{7,30,35});
        System.out.println(Arrays.toString(sortedArray));

    }
    public static int[] getRandomArray(int len){
        Random random = new Random();
        int[] randomArray = new int [len];
        for(int i =0; i<len;i++){
            randomArray[i] = random.nextInt(1000);
        }
        return randomArray;
    }
    private static int[] sortIntegers(int[] array) {
        // Make a copy of the input array to avoid modifying the original array
        System.out.println(Arrays.toString(array));
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true; // A flag to track if any swaps were made during an iteration
        int temp; // A temporary variable used for swapping

        while (flag) {
            flag = false; // Assume no swaps will be made
            for (int i = 0; i < sortedArray.length - 1; i++) {
                // If the current element is less than the next element, swap them
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true; // A swap was made, so set the flag to true
                    System.out.println("------->" + Arrays.toString(sortedArray));
                }
            }
            System.out.println("-->" + Arrays.toString(sortedArray));

        }
        return sortedArray; // Return the sorted array
    }

}
