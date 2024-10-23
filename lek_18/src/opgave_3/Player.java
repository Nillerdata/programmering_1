package opgave_3;

public class Player {
    private String name;
    private int age;
    private int score = 0;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Player(String name, int age){
        this.name=name;
        this.age=age;
        this.score = 0;

    }
    public void addScore(int score){
        this.score += score;
    }
}
