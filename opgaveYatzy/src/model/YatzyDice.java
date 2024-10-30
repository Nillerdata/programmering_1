package model;

import jdk.jfr.Frequency;

import java.util.Arrays;
import java.util.Random;

public class YatzyDice {
    // Face values of the 5 dice.
    // 1 <= values[i] <= 6.
    private int[] values = new int[5];

    // Number of times the 5 dice have been thrown.
    // 0 <= throwCount <= 3.
    private int throwCount = 0;

    // Random number generator.
    private Random random = new Random();

    public YatzyDice() {
        //
    }

    /**
     * Returns the 5 face values of the dice.
     */
    public int[] getValues() {
        // TODO
        return values;
    }

    /**
     * Sets the 5 face values of the dice. Pre: values contains 5 face values in
     * [1..6]. Note: This method is only meant to be used for test, and
     * therefore has package visibility.
     */
    void setValues(int[] values) {
        // TODO
        this.values = values;
    }

    /**
     * Returns the number of times the 5 dice has been thrown.
     */
    public int getThrowCount() {
        // TODO
        return throwCount;
    }

    /**
     * Resets the throw count.
     */
    public void resetThrowCount() {
        this.throwCount = 0;
        // TODO
    }

    /**
     * Rolls the 5 dice. Only roll dice that are not hold. Pre: holds contain 5
     * boolean values.
     */
    public void throwDice(boolean[] holds) {
        for (int i = 0; i < holds.length; i++) {
            if (!holds[i]) {
                values[i] = random.nextInt(6) + 1;
            }
        }
        // TODO
        throwCount++;
    }

    // -------------------------------------------------------------------------

    /**
     * Return all results possible with the current face values.<br/>
     * The order of the results is the same as on the score board.<br/>
     * Note: This is an optional method. Comment this method out,<br/>
     * if you don't want use it.
     */
    public int[] getResults() {
        int[] results = new int[15];
        for (int i = 0; i <= 5; i++) {
            results[i] = this.sameValuePoints(i + 1);
        }
        results[6] = this.onePairPoints();
        results[7] = this.twoPairPoints();
        results[8] = this.threeSamePoints();
        results[9] = this.fourSamePoints();
        results[10] = this.fullHousePoints();
        results[11] = this.smallStraightPoints();
        results[12] = this.largeStraightPoints();
        results[13] = this.chancePoints();
        results[14] = this.yatzyPoints();

        return results;
    }

    // -------------------------------------------------------------------------

    // Return an int[7] containing the frequency of face values.
    // Frequency at index v is the number of dice with the face value v, 1 <= v <= 6.
    // Index 0 is not used.
    // Note: This method can be used in several of the following methods.
    private int[] frequency() {
        // TODO
        int[] frequencyArray = new int[7];
        for (int i = 0; i < values.length; i++) {
            frequencyArray[values[i]]++;
        }
        return frequencyArray;
    }

    /**
     * Return same-value points for the given face value.<br/>
     * Returns 0, if no dice has the given face value.<br/>
     * Pre: 1 <= value <= 6;
     */
    public int sameValuePoints(int value) {
        int result = 0;
        int[] frequencyArray = frequency();
        result = frequencyArray[value] * value;
        return result;
    }

    /**
     * Return points for one pair (for the face value giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value.
     */
    public int onePairPoints() {
        int result = 0;
        int[] frequencyArray = frequency();
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] >= 2) {
                result = i * 2;
            }
        }
        return result;
    }

    /**
     * Return points for two pairs<br/>
     * (for the 2 face values giving the highest points).<br/>
     * Return 0, if there aren't 2 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int twoPairPoints() {
        int result = 0;
        int pairCounter = 0;
        int[] frequencyArray = frequency();

        for (int j = 1; j < frequencyArray.length; j++) {
            if (frequencyArray[j] >= 2) {
                result += (j) * 2;
                pairCounter++;
            }
        }
        if (pairCounter != 2) {
            result = 0;
        }

        return result;
    }

    /**
     * Return points for 3 of a kind.<br/>
     * Return 0, if there aren't 3 dice with the same face value.
     */
    public int threeSamePoints() {
        int result = 0;
        int[] frequencyArray = frequency();
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] >= 3) {
                result = i * 3;
            }
        }
        return result;
    }

    /**
     * Return points for 4 of a kind.<br/>
     * Return 0, if there aren't 4 dice with the same face value.
     */
    public int fourSamePoints() {
        int result = 0;
        int[] frequencyArray = frequency();
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] >= 4) {
                result = i * 4;
            }
        }
        return result;
    }

    /**
     * Return points for full house.<br/>
     * Return 0, if there aren't 3 dice with the same face value<br/>
     * and 2 other dice with the same but different face value.
     */
    public int fullHousePoints() {
        int result = 0;
        int number = 0;
        int numberThree = 0;
        int[] frequencyArray = frequency();
        for (int j = 0; j < frequencyArray.length; j++) {
            if (frequencyArray[j] == 3) {
                result += j * 3;
                numberThree++;
            } else if (frequencyArray[j] == 2) {
                result += j * 2;
                number++;
            }
        }
        if (number != 1 || numberThree != 1) {
            result = 0;
        }
        return result;
    }

    /**
     * Return points for small straight.<br/>
     * Return 0, if the dice aren't showing 1,2,3,4,5.
     */
    public int smallStraightPoints() {
        int result = 0;
        boolean test = true;
        int[] frequencyArray = frequency();
        for (int i = 1; i < frequencyArray.length - 1; i++) {
            if (frequencyArray[i] != 1) {
                test = false;

            }
        }
        if (test) {
            result = 15;
        }
        // TODO
        return result;
    }

    /**
     * Return points for large straight.<br/>
     * Return 0, if the dice aren't showing 2,3,4,5,6.
     */
    public int largeStraightPoints() {
        int result = 0;
        int[] frequencyArray = frequency();
        int[] smallStraight = {0, 0, 1, 1, 1, 1, 1};
        if (Arrays.equals(frequencyArray, smallStraight)) {
            result = 20;
        }
        return result;
    }

    /**
     * Return points for chance (the sum of face values).
     */
    public int chancePoints() {
        int result = 0;
        for (int number : values) {
            result += number;
        }

        return result;
    }

    /**
     * Return points for yatzy (50 points).<br/>
     * Return 0, if there aren't 5 dice with the same face value.
     */
    public int yatzyPoints() {
        int result = 0;
        int[] frequencyArray = frequency();
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] == 5) {
                result = 50;
            }

        }

        return result;
    }

}
