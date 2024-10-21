package model;

import java.util.Arrays;
import java.util.Random;

public class Student {
    private String name;
    private boolean active = true;
    private int[] grades;
    private char[] answer;


    public Student(String name, boolean active, int[] grades) {//constructor
        this.name = name;
        this.active = active;
        this.grades = grades;
        studentAnswersToQuestions();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int findMax() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
            }
        }
        return max;
    }

    public double findGradeAverage() {
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return sum / grades.length;
    }

    /*OPG 5 På en studerende skal det være muligt at registrere den studerendes svar på en mutiple choice
test. Der er 10 spørgsmål i testen, og mulige svar er 'A', 'B', 'C' og 'D'. Udvid Student klassen
med et array, der husker den studerendes svar på multiple choice testen.
Lav også en metode i Student klassen, som genererer den studerendes svar til testen vha.
Random klassen (et svar skal være et af bogstaverne 'A', 'B', 'C' og 'D'). */

    public char[] studentAnswersToQuestions() {//hyldest til Emma
        //metode til at generere et tilfældigt svar fra den studerende

        answer = new char[10];
        for (int i = 0; i < answer.length; i++) {
            char test = (char) (Math.random() * 4 + 65);
            answer[i] = test;
        }
        return answer;
    }

    /*Udvid klassen Student med en metode, der returnerer, hvor mange korrekte svar den
studerende har på sin multiple choice test. Metoden får som parameter et array indeholde de
rigtige svar. Metoden kan have nedenstående signatur:
public int corectAnswers(char[] correct)
 */
    public int correctAnswers(char[] correctAnswers) {
        int rigtigeSvar = 0;
        for (int i = 0; i < 10; i++) {
            if (correctAnswers[i] == answer[i]) {
                rigtigeSvar++;
            }
        }
        return rigtigeSvar;
    }

    public char[] getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return String.format("Name: %s \tisActive: %b\tgrades: %s", this.name, this.active, Arrays.toString(this.grades));
    }
    }


