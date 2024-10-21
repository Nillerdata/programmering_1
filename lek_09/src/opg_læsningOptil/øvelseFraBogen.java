package opg_læsningOptil;

import java.util.Arrays;

public class øvelseFraBogen {
    public static void main (String[] args) {
        int[] sourceArray = {2,3,5,6,7};
        int[] targetArray = new int [sourceArray.length];
        for (int i = 0; i< sourceArray.length; i++){
            targetArray[i] = sourceArray[i];
        }
        System.out.println("reultatet er " + Arrays.toString(targetArray));
    }
}
