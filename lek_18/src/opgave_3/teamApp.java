package opgave_3;

import java.util.ArrayList;

public class teamApp {
    public static void main(String[] args) {
    Player p1 = new Player("John",24);
    p1.addScore(3);
    Player p2 = new Player("simon",24 );
    p2.addScore(42);
    Player p3 = new Player("Bo", 48);
    p3.addScore(240);
    Team t1 = new Team("vib");
    t1.addPlayer(p1);
    t1.addPlayer(p2);
    t1.addPlayer(p3);
        System.out.println("__________________");
        System.out.println("average age is : " +t1.calcAverageAge());
        System.out.println("calc total score is : " + t1.calcTotalScore());
        System.out.println("score for players over 30 is : " + t1.calcOldPlayersScore(30));
        System.out.println("max score is : " + t1.maxScore());




    }
}
