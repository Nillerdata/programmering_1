package opg_klasser.src.model;

import java.util.Random;
import java.util.Arrays;

public class Student {
    // Class fields
    private String name;
    private boolean active;
    private int[] grades;
    private char[] testAnswers;

    // Constructor
    public Student(String name, boolean active, int[] grades) {
        this.name = name;
        this.active = active;
        this.grades = grades;
        this.testAnswers = new char[10];
    }

    // Class methods
    public void generateRandomTestAnswers() {
        // char array containing possible answers
        var possibleChoices = new char[]{'A', 'B', 'C', 'D'};
        // creates a new instance of the Random class
        var rand = new Random();
        // loops through answers and populates the testAnswers array
        // by choosing a random answer with the rand object, using the nextInt()
        // method with an upperbound of the answer arrays length
        for (int i = 0; i < testAnswers.length; i++) {
            testAnswers[i] = possibleChoices[rand.nextInt(possibleChoices.length)];
        }
    }

    public int correctAnswers(char[] correct){
        // Counter for the number of correct answers
        int correctAnswersCount = 0;
        // Loops through testAnswers and compares the chars to the chars of the
        // correct array passed in as a parameter
        for (int i = 0; i < testAnswers.length; i++){
            if (testAnswers[i] == correct[i]){
                correctAnswersCount++;
            }
        }
        return correctAnswersCount;
    }

    public int getHighestGrade() {
        int maxGrade = Integer.MIN_VALUE;
        for (int grade : grades) {
            if (grade > maxGrade) {
                maxGrade = grade;
            }
        }
        return maxGrade;
    }

    public double getAverageGrade() {
        int gradeSum = 0;
        for (int grade : grades) {
            gradeSum += grade;
        }
        return (double) gradeSum / grades.length;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public char[] getTestAnswers() {
        return testAnswers;
    }

    // Overridden methods
    @Override
    public String toString() {
        return String.format("Name: %s \tisActive: %b\tgrades: %s", this.name, this.active, Arrays.toString(this.grades));
    }
}
