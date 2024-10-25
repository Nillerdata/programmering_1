package methodChallenge;

import javax.swing.text.Position;

public class challenge {
    public static void main(String[] args) {
        int highScorePosition = calculateHighScorePosition(1500);
        displayHighScorePosition("Tim",highScorePosition);

        displayHighScorePosition("Niels",calculateHighScorePosition(999));

        highScorePosition = calculateHighScorePosition(499);
        displayHighScorePosition("bob",highScorePosition);

         highScorePosition = calculateHighScorePosition(99);
        displayHighScorePosition("john",highScorePosition);

         highScorePosition = calculateHighScorePosition(-1000);
        displayHighScorePosition("tommy",highScorePosition);
    }

    public static void displayHighScorePosition(String name, int position) {
        System.out.println(name + " managed to get into " + position +
                " on the highscore list");
    }

    public static int calculateHighScorePosition(int playerScore) {
        int position = 4;
        if (playerScore >= 1000) {
            position = 1;
        } else if (playerScore >= 500) {
            position = 2;
        } else if (playerScore >= 100) {
            position = 3;
        }
        return position;
    }
}


