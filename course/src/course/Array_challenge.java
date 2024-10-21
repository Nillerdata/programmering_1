package course;

import java.util.Arrays;
import java.util.Random;

public class Array_challenge {
    public static void main(String[] args) {
        // Generate an array of 10 random integers
        int[] firstArray = getRandomArray(10);
        // Print the original array
        System.out.println(Arrays.toString(firstArray));
        // Sort the array in ascending order
        Arrays.sort(firstArray);

        System.out.println(Arrays.toString(firstArray));
        // Reverse the array
        /*here i make a for loop where i initialize int i
        * and set it to 0, i initialize int j and set it to the last number in the array
        * and i make temp without giving it a value */
        for (int i = 0, j = firstArray.length - 1, temp; i < j; i++, j--) {
            //temp becomes the first number in the array, because otherwise the number would be lost
            temp = firstArray[i];
            firstArray[i] = firstArray[j];
            firstArray[j] = temp; // here i insert temp at the otherside of the array.
        }
        // Print the reversed array
        System.out.println(Arrays.toString(firstArray));
    }

    // Method to generate an array of random integers of a given length
    public static int[] getRandomArray(int len) {
        Random random = new Random(); // Create a new Random object
        int[] newint = new int[len]; // Initialize a new integer array of the given length
        for (int i = 0; i < len; i++) {
            newint[i] = random.nextInt(100); // Assign a random integer (0-99) to each element
        }
        return newint; // Return the generated array

    }
}
