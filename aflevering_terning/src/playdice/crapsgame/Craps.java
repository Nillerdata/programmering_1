package playdice.crapsgame;

import java.util.Scanner;


public class Craps {

    public static int sum;
    public static int andetKast;

    public static void main(String[] args) {
        playCraps();
        System.out.println("roll out point var: " + sum);

    }

    public static void playCraps() {
        Scanner scan = new Scanner(System.in);

        System.out.println("tryk enter hvis du er klar til at spille");
        String answer = scan.nextLine();

        int die1 = (int) (Math.random() * 6 + 1);
        int die2 = (int) (Math.random() * 6 + 1);
        System.out.println(die1);
        System.out.println(die2);
        sum = die1 + die2;
        System.out.println(sum);


        if (sum == 7 || sum == 11) {
            System.out.println("du vandt");


        } else if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("du tabte");
        } else {

            rollForPoint(sum);


        }
        scan.close();
        return;

    }

    public static boolean rollForPoint(int point) {
        Scanner scan = new Scanner(System.in);
        point = sum;
        boolean resultat = false;
        System.out.println("du slog: " + point);
        String answer="";

        while (andetKast != 7 && andetKast != point && !answer.equals("n")) {
            System.out.println("tast på enter igen for at fortsætte spillet");
            scan.nextLine();
            int die1 = (int) (Math.random() * 6 + 1);
            int die2 = (int) (Math.random() * 6 + 1);
            int andetKast = die1 + die2;

            if (andetKast == point) {
                System.out.println("tillykke du har vundet craps");
                resultat = true;

            } else {
                System.out.println("du slog uheldigvis 7");
                break;
            }
            System.out.println("vil du spille igen? (tast n for stop");
            answer = scan.nextLine();
        }

        return resultat;
    }

}
