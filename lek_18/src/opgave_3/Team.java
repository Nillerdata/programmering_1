package opgave_3;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players;

    public String getName() {
        return name;
    }

    public Team(String name) {
        this.name = name;
        players = new ArrayList<>();

    }

    public void addPlayer(Player player)  {
        players.add(player);
    }

    public void printplayers() {
        for (Player s : players) {
            System.out.println("spiller navn : " + s.getName() + "\n spiller alder : " + s.getAge()
                    + "\nscore er : " + s.getScore());
        }
    }

    public double calcAverageAge() {
        double averageAge = 0;
        for (Player s : players) {
            averageAge += s.getAge();
        }
        return averageAge / players.size();
    }

    public int calcTotalScore() {
        int totaltScore = 0;
        for (Player p : players) {
            totaltScore += p.getScore();
        }
        return totaltScore;
    }

    int calcOldPlayersScore(int ageLimit) {
        int Pensionister = 0;
        for (Player p : players) {
            if (p.getAge() > ageLimit) {
                Pensionister += p.getScore();
            }
        }
        return Pensionister;
    }

    public int maxScore() {
        int max = Integer.MIN_VALUE;
        for (Player p : players) {
            if (p.getScore() > max) {
                max = p.getScore();
            }
        }
        return max;
    }

    public String bestplayer() {
        int max = Integer.MIN_VALUE;
        String bestPlayer = "";
        for (Player p : players) {
            if (p.getScore() > max) {
                max = p.getScore();
                bestPlayer = p.getName();
            }
        }
        return bestPlayer;
    }
}
