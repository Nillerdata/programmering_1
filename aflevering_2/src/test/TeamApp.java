package test;

import model.Student;
import model.Team;

import java.util.Arrays;

public class TeamApp {
    public static void main(String[] args) {
        int[] karakter1 = {07,04,10,12,07};
        int[] karakter2 = {04,02,07,02,12};
        int[] karakter3 = {04,07,04,07,07};
        int[] karakter4 = {12,12,10,010,04};
        int[] karakter5 = {12,12,12,10,07};
        int[] karakter6 = {04,02,04,02,07};
        Student s1 = new Student("Niels",true,karakter1);
        Student s2 = new Student("Anne",true,karakter2);
        Student s3 = new Student("Marie",true,karakter3);
        Student s4 = new Student("Jørgen",true,karakter4);
        Student s5 = new Student("Bob",true,karakter5);
        Student s6 = new Student("Francois",true,karakter6);


        Team t1 = new Team("K1","s24");
        t1.addStudent(s1);
        t1.addStudent(s2);
        t1.addStudent(s3);
        System.out.println("______________________");
        System.out.println(s1.getName());
        System.out.println(s1.findGradeAverage());
        System.out.println("______________________");
        System.out.println(s2.getName());
        System.out.println(s2.findGradeAverage());

        System.out.println(s3.findGradeAverage());
        System.out.println("______________________");
        System.out.println();
        t1.printTeam();
        System.out.println("______________________");
        System.out.println(s1.getName());
        System.out.println(s1.studentAnswersToQuestions());
        System.out.println(s1.correctAnswers(t1.getCorrectAnswer()));
        System.out.println();
        System.out.println(Arrays.toString(t1.studentInfo()));
        System.out.println(Arrays.toString(t1.getStatistic()));









        System.out.println();
        System.out.println("______________");
        System.out.println();

        Team t2 = new Team("k2","t24");
        t2.addStudent(s4);
        t2.addStudent(s5);
        t2.addStudent(s6);

        System.out.println("___________________");
        System.out.println(s4.findGradeAverage());
        System.out.println(s5.findGradeAverage());
        System.out.println(s6.findGradeAverage());
        System.out.println("___________________");

        System.out.println(t2.average());

        System.out.println("___________________");





    }
}
