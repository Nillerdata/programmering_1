package opg_klasser.src.test;

import model.Student;
import model.Team;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        var t1 = new Team("A.31", "DreamTeam");
        var t2 = new Team("A.31", "losers");


        var s1 = new Student("Simon", true, new int[]{4, 4});
        var s2 = new Student("Mikkel", false, new int[]{7, 4});
        var s3 = new Student("Mathias", true, new int[]{7, 10});

        var s4 = new Student("Andreas", false, new int[]{10, 7});
        var s5 = new Student("Jonas", true, new int[]{7, 12});
        var s6 = new Student("Hans", false, new int[]{2, 4});

        t1.addStudent(s1);
        t1.addStudent(s2);
        t1.addStudent(s3);

        System.out.println("Mathias highest grade: " + s3.getHighestGrade());
        System.out.println("Mathias average grade: " + s3.getAverageGrade());

        t2.addStudent(s4);
        t2.addStudent(s5);
        t2.addStudent(s6);

        for (Student s : t1.getStudents()) {
            System.out.println(s);
        }
        for (Student s : t2.getStudents()) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("=============");
        System.out.println();

        t1.removeStudent("Mikkel");
        t2.removeStudent("Hans");

        System.out.println("Team 1 average: " + t1.getTeamGradeAverage());
        System.out.println("Team 2 average: " + t2.getTeamGradeAverage());

        for (Student s : t1.getStudents()) {
            s.generateRandomTestAnswers();
        }
        for (Student s : t2.getStudents()) {
            s.generateRandomTestAnswers();
        }


        System.out.println("=========");
        System.out.println();
        t1.printStudents();
        System.out.println(Arrays.toString(t1.getTestStatistics()));
        System.out.println("=========");
        System.out.println();
        t2.printStudents();

        System.out.println("test method");
        System.out.println(Arrays.toString(t2.getStudentsInfo()));


    }
}
