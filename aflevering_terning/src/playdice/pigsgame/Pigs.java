package playdice.pigsgame;


import java.util.Arrays;
import java.util.Scanner;

public class Pigs {
    // her er samlet score og antal kast for hver spiller
    private static int player1Score;
    private static int player2Score;
    private static int player1DiceThrows;
    private static int player2DiceThrows;
    private static int runder;

    public static void main(String[] args) {
        printRules();
        playpigs();
        statistic();
    }
// har sat player til 1 så spiller 1 starter.
    public static void playpigs() {
        int player = 1;

        //metode til selve spillet.
        Scanner scan = new Scanner(System.in);
        String answer = "";
        System.out.println("hvad vil i spille til? ");//indtast værdi spillere vil spille til.
        int færdig = scan.nextInt();
        scan.nextLine();
        System.out.println();


        while (player1Score < færdig && player2Score < færdig) {
            player = playerRoll(player,færdig, scan);
        }

        if (player1Score >= færdig) {
            System.out.println("player 1 vandt");
        } else {
            System.out.println("player 2 vandt");
        }


    }

    public static int playerRoll(int player, int færdig, Scanner scan) {
        int roundScore = 0;

        String answer = "";

        System.out.println("------------------------------------");
        if (player == 1) {
            System.out.println("lige nu spiller spiller1");
        } else {
            System.out.println("lige nu spiller spiller2");
        }

        System.out.println("------------------------------------");
        System.out.println("tryk enter for at spille");
        answer= scan.nextLine();


        while (!answer.equals("n")) {
            System.out.println("tast enter for at starte spillet");
            int[] temp = rollDice();
            int sumOfDice = temp[0] + temp[1];


            //hvis terningerne viser 1,1
            if (temp[0] == 1 && temp[1] == 1) {
                System.out.println("du slog:" + Arrays.toString(temp));
                System.out.println("du har mistet alle dine point og turen er tabt");
                runder++;
                if (player == 1) {
                    player1Score = 0;
                    player1DiceThrows++;
                    return 2;
                } else {
                    player2DiceThrows++;
                    player2Score = 0;
                    return 1;
                }
                //hvis en af terningerne viser 1
            } else if (temp[0] == 1 || temp[1] == 1) {
                System.out.println("du slog:" + Arrays.toString(temp));
                System.out.println("runden er slut og du får ikke point");
                runder++;
                if (player == 1) {
                    player1DiceThrows++;
                    return 2;
                } else {
                    player2DiceThrows++;
                    return 1;
                }
            } else {

                roundScore += sumOfDice;
                if (player == 1) {
                //hvis spiller1 ikke slår 1 med nogen af terningnerne
                    player1DiceThrows++;
                    System.out.println("din samlede score før denne runde var : " + player1Score);
                    System.out.println("du slog" + Arrays.toString(temp));
                    System.out.println("din score for nuværende runde er nu : " + roundScore);
                    System.out.println("din totale er : " + (player1Score + roundScore));

                } else {
                //hvis spiller2 ikke slår 1 med nogen af terningerne
                    player2DiceThrows++;
                    System.out.println("din samlede score før denne runde var : " + player2Score);
                    System.out.println("du slog" + Arrays.toString(temp));
                    System.out.println("din score for nuværende runde er nu : " + roundScore);
                    System.out.println("din totale er : " + (player2Score + roundScore));
                }


            }

            //check om spiller vinder efter dette loop
            if ((player == 1 && player1Score + roundScore >= færdig) || (player == 2 && player1Score + roundScore >= færdig)) {
                if (player == 1) {
                    player1Score += roundScore;

                } else {
                    player2Score += roundScore;
                }
                return player;

            }
            //prompte bruger til at slå igen eller stoppe.
            System.out.println("vil du slå igen?(tryk n for at gemme point og stoppe din tur)");
            answer = scan.nextLine();

        }
        //hvis spiller stopper selv gemmes point
        if (player == 1) {
            player1Score += roundScore;

        } else {
            player2Score += roundScore;
        }
        //hvis spiller stopper selv byttes spillere
        if (player == 1) {
            player = 2;
        } else {
            player = 1;
        }

        return player;
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Pigs:");
        System.out.println("The player throws 2 dice until they reach 100 points");
        System.out.println("if the player hits : 1,1 eyes they lose all points");
        System.out.println("and have to start over");
        System.out.println("=====================================================");
    }


    private static int[] rollDice() {
        int[] phases = new int[2];
        for (int i = 0; i < phases.length; i++) {
            phases[i] = (int) (Math.random() * 6 + 1);
        }
        return phases;
    }
    public static void statistic(){
        System.out.println("=====================================================");
        System.out.println("============statistik over spillet===================");
        System.out.println();
        System.out.println("hvor mange runder var der i spillet i alt : " + runder);
        System.out.println();
        System.out.println("statistik over spiller 1 : ");
        System.out.println( "Hvor mange point spiller 1 fik : " + player1Score);
        System.out.println("hvor mange terningekast spiller 1 havde : " + player1DiceThrows);
        System.out.println("gns. score pr. runde er: " + (player1Score/player1DiceThrows));
        System.out.println();
        System.out.println("statistik over spiller 2 : ");
        System.out.println("Hvor mange point spiller 2 fik : " + player2Score);
        System.out.println("hvor mange terningekast spiller 2 havde : " + player2DiceThrows);
        System.out.println("gns. score pr. runde er: " + (player2Score/player2DiceThrows));




    }
}
