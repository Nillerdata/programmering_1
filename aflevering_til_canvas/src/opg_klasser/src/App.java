package opg_klasser.src;

import model.Student;
import model.Team;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Team[] teams = new Team[10];
        int teamsCount = 0;
        Student[] students = new Student[320];
        int studentsCount = 0;

        var sc = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                createTeam(sc, teams, teamsCount);
                teamsCount++;
            } else if (choice == 2) {
                createStudent(sc, students, studentsCount, teams);
                studentsCount++;
            } else if (choice == 3) {
                showStudentInfo(sc, teams);
            } else if (choice == 4) {
                showTeamInfo(sc, teams);
            } else if (choice == 5) {
                showTeamInfoAll(teams);
            }

            if (choice < 1 || choice > 6) {
                System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }

    public static void printMenu() {
        System.out.println("\nMENU");
        System.out.println("1. Create a new team");
        System.out.println("2. Create a student");
        System.out.println("3. Show one student's info and results");
        System.out.println("4. Show one team's info and result");
        System.out.println("5. Show info and results for all teams");
        System.out.println("6. Exit program");
    }

    public static void createTeam(Scanner sc, Team[] teams, int teamCount) {
        String teamName;
        String teamRoom;

        sc.nextLine();

        System.out.print("\nTeam name: ");
        teamName = sc.nextLine();
        System.out.print("Team room: ");
        teamRoom = sc.nextLine();

        teams[teamCount] = new Team(teamRoom, teamName);
    }

    public static void createStudent(Scanner sc, Student[] students, int studentCount, Team[] teams) {
        String teamName, studentName;
        Team selectedTeam = null;
        boolean studentActivity;
        int numberOfGrades;
        int[] grades;

        sc.nextLine();


        do {
            System.out.print("Enter student team: ");
            teamName = sc.nextLine();

            for (Team t : teams) {
                if (t != null && t.getName().equalsIgnoreCase(teamName)) {
                    selectedTeam = t;
                }
            }
            if (selectedTeam == null) {
                System.out.println("No such team... please try again");
            }
        } while (selectedTeam == null);

        System.out.print("Enter student name: ");
        studentName = sc.nextLine();

        System.out.print("Enter student activity status: ");
        studentActivity = sc.nextBoolean();

        System.out.print("Enter students number of grades: ");
        numberOfGrades = sc.nextInt();
        grades = new int[numberOfGrades];

        for (int i = 0; i < numberOfGrades; i++) {
            System.out.printf("Enter %d grade: ", i + 1);
            grades[i] = sc.nextInt();
        }

        var studentToAdd = new Student(studentName, studentActivity, grades);
        students[studentCount] = studentToAdd;
        selectedTeam.addStudent(studentToAdd);
    }

    public static void showStudentInfo(Scanner sc, Team[] teams) {
        String teamName;
        Team selectedTeam = null;
        sc.nextLine();

        do {
            System.out.print("Enter student team: ");
            teamName = sc.nextLine();
            System.out.println();

            for (Team t : teams) {
                if (t != null && t.getName().equalsIgnoreCase(teamName)) {
                    selectedTeam = t;
                }
            }
            if (selectedTeam == null) {
                System.out.println("No such team... please try again");
            }
        } while (selectedTeam == null);

        System.out.println("Select student: ");
        for (Student s : selectedTeam.getStudents()) {
            System.out.printf("%s \t", s.getName());
        }
        System.out.println();
        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();

        Student selectedStudent = selectedTeam.getStudentByName(studentName);
        System.out.println(selectedStudent);
    }

    public static void showTeamInfo(Scanner sc, Team[] teams) {
        String teamName;
        Team selectedTeam = null;
        sc.nextLine();

        do {
            System.out.print("Enter team name: ");
            teamName = sc.nextLine();
            System.out.println();

            for (Team t : teams) {
                if (t != null && t.getName().equalsIgnoreCase(teamName)) {
                    selectedTeam = t;
                }
            }
            if (selectedTeam == null) {
                System.out.println("No such team... please try again");
            }
        } while (selectedTeam == null);

        System.out.printf("Team name: %s\tTeam room: %s\tTeam member count: %d\n",
                selectedTeam.getName(),
                selectedTeam.getRoom(),
                selectedTeam.getStudentCount());

        System.out.println("\nTeam students: ");
        selectedTeam.printStudents();
    }

    public static void showTeamInfoAll(Team[] teams) {
        for (Team t : teams) {
            if (t != null) {
                System.out.println("\n\n======" + t.getName() + "======");
                System.out.printf("Team name: %s\tTeam room: %s\tTeam member count: %d\n",
                        t.getName(),
                        t.getRoom(),
                        t.getStudentCount());
                System.out.println("\nTeam students: ");
                t.printStudents();
                System.out.println("====================================");
            }
        }


    }

}
