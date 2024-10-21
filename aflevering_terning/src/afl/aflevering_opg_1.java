package afl;

import playdice.onedie.RollOneDie;

import java.util.Arrays;
import java.util.Scanner;

public class aflevering_opg_1 {
public static int rollCount = 0;

    public static void main(String[] args) {

    playDice(rollDice());

    }

    public static void playDice(int[] tabel) {
        Scanner scan = new Scanner(System.in);

        int sum = 0;
        System.out.println("roll? ('n' stops)");
        String answer = scan.nextLine();
        while (!answer.equals("n")) {
            int[] array = rollDice();

        sum = array[0]+array[1];
            System.out.println("første terning : "+ Arrays.toString(array));

            System.out.println(sum);
            updateStatistics(array);
            System.out.print("Roll? ('n' stops) ");
            answer = scan.nextLine();
        }

    }

    private static int[] rollDice() {
        int[] phases = new int[2];
        for (int i = 0; i < phases.length; i++) {
            phases[i] = (int) (Math.random() * 6 + 1);

        }
        return phases;

    }
        private static void updateStatistics(int[] face) {
        rollCount++;
    }
        private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Roll count:", rollCount);
    }
}
//public class RollOneDie {
//    private static int rollCount = 0;
//
//    public static void main(String[] args) {
//        System.out.println("Welcome to the game of RollOneDie");
//        printRules();
//        System.out.println();
//
//        playOneDie();
//
//        System.out.println();
//        System.out.println("Thank you for playing RollOneDie");
//    }
//
//    private static void printRules() {
//        System.out.println("=====================================================");
//        System.out.println("Rules of RollOneDie:");
//        System.out.println("The player throws one die as long as he/she wants.");
//        System.out.println("=====================================================");
//    }
//
//    private static void playOneDie() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Roll? ('no' stops) ");
//        String answer = scanner.nextLine();
//        while (!answer.equals("no")) {
//            int face = rollDie();
//            System.out.println("Eyes: " + face);
//            System.out.println();
//
//            updateStatistics(face);
//
//            System.out.print("Roll? ('no' stops) ");
//            answer = scanner.nextLine();
//        }
//
//        printStatistics();
//        scanner.close();
//    }
//
//    private static int rollDie() {
//        return (int) (Math.random() * 6 + 1);
//    }
//
//    private static void updateStatistics(int face) {
//        rollCount++;
//    }
//
//    private static void printStatistics() {
//        System.out.println("\nResults:");
//        System.out.println("-------");
//        System.out.printf("%17s %4d\n", "Roll count:", rollCount);
//    }
//}