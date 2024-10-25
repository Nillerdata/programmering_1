package course;

public class MainChallenge {

    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;
        int highscore =  calculateScore(gameOver, score, levelCompleted, bonus);
        System.out.println("the highscore is : " + highscore);
        score = 10000;
        levelCompleted = 8;
        bonus = 200;
        System.out.println("the next highscore is " +
        calculateScore(gameOver, score, levelCompleted, bonus));

    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        int finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;

        }
        return finalScore;
    }
}
