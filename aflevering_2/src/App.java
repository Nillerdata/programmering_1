import model.Team;
import model.Student;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Team[] teams = new Team[10];
        int teamCount = 0;
        Student[] students = new Student[320];
        int studentCount = 0;

        var sc = new Scanner(System.in);
        int choice;
        //prompt bruger
        do {
            printMenu();// hiver fat i metode printmenu (no shit)
            System.out.print("enter number  1-6 : ");//prompt bruger til at indtaste int
            choice = sc.nextInt();//får indtastet int gemt på int choice

            if (choice == 1) {
                createTeam(sc, teams, teamCount);//hiver fat i metode createteam og parametre
                teamCount++;
            } else if (choice == 2) {
                createStudent(sc, students, studentCount, teams);
                studentCount++;
            } else if (choice == 3) {
                showStudentInfo(sc,teams);
            } else if (choice == 4) {
                showTeamInfo(sc,teams);
            } else if (choice == 5) {
                showTeamInfoAll(teams);
            }
            if (choice < 1 || choice > 6) {
                System.out.println("invalid number");
            }

        } while (choice != 6);
    }

    public static void printMenu() {//denne metode printer blot metode ud for at bruger kan aflæse
        System.out.println("\nMENU");
        System.out.println("1: Create a team");
        System.out.println("2: Create a student");
        System.out.println("3: Show one student's info and results");
        System.out.println("4: Show one team's info and results");
        System.out.println("5: Show info and results for all teams");
        System.out.println("6: Exit program");
    }

    public static void createTeam(Scanner sc, Team[] teams, int teamCount) {
        String teamName;//make 2 local strings
        String teamRoom;
        sc.nextLine();//clear leftover input from former scanner usage
        System.out.print("\nenter team name: ");
        teamName = sc.nextLine();
        System.out.print("enter class room: ");
        teamRoom = sc.nextLine();
        teams[teamCount] = new Team(teamName, teamRoom);//et team har et navn og et klasselokale

    }

    public static void createStudent(Scanner sc, Student[] students, int studentCount, Team[] teams) {
        String teamName, studentName;//laver lokale Strings
        Team selectedTeam = null; //laver null værdi da den skal have en value fra start.
        boolean studentActivity;
        int numberOfGrades; //antal karakterer den studerernde har
        int[] grades; // array af hvilke karakterer de har

        sc.nextLine();

        do {// do while loopet sørger for at uanset hvad kører loopet mindst en gang
            System.out.print("input students team: ");
            teamName = sc.nextLine();

            for (Team t : teams) { /* for-each loop der sørger for at det team navn der er indtastet
               faktisk er et team */
                if (t != null && t.getName().equalsIgnoreCase(teamName)) {
                    selectedTeam = t;
                }
            }
            if (selectedTeam == null){
                System.out.println("invalid input");
            }
        } while (selectedTeam == null);
        //dette er efter bruger har indtastet team navn
        //prompt bruger til at indtaste navn
        System.out.println("Enter student name: ");
        studentName = sc.nextLine();
        System.out.println("enter student activity: ");
        studentActivity = sc.nextBoolean();
        System.out.println("enter number of grades");
        numberOfGrades = sc.nextInt();
        System.out.println("enter grades: ");
        grades = new int[numberOfGrades];
        for (int i = 0; i < numberOfGrades; i++) {
            System.out.printf("Enter %d grade: ", i + 1); //%d er placement holder for en int, i dette tilfælde 'i'
            grades[i] = sc.nextInt();
        }
        var studentToAdd = new Student(studentName, studentActivity, grades); /* var bruges når det er tydeligt at
        se hvilken variabel der er på højre side af lighedstegnet */
        students[studentCount] = studentToAdd;
        selectedTeam.addStudent(studentToAdd);

    }

    public static void showStudentInfo(Scanner sc, Team[] teams) {
        String teamName;
        Team selectedTeam = null;
        sc.nextLine();
        do {
            System.out.print("input students team: ");
            teamName = sc.nextLine();

            for (Team t : teams) {//dette for each loop bruges til at sikre at indtastet team eksisterer
                if (t != null && t.getName().equalsIgnoreCase(teamName)) {
                    selectedTeam = t;//du tager teamets navn og gemmer det i selectedTeam
                }
            }
        } while (selectedTeam == null);//dette sker inden et team er valgt eg. fejlsikring
        System.out.println("select student: ");
        for(Student s : selectedTeam.getStudents()){//s er fundet via team og derefter den udvalgte elev bliver 's'
            System.out.printf("%s \t",s.getName());//%s er en placement holder for string
        }
        System.out.println();
        System.out.println("enter name of student");
        String studentName = sc.nextLine();
        Student selectedStudent = selectedTeam.getStudentByName(studentName); /*
         selsected student er den elev man hiver fat i når man indskriver teamet og vælger en elev*/
        System.out.println(selectedStudent);//eleven bliver bagefter printet her
    }

    public static void showTeamInfo(Scanner sc, Team[] teams) {
    String teamName;
    Team selectedTeam = null;
    sc.nextLine();
        do {// do-while loop kører indtil et korrekt team er indskrevet
            System.out.print("input students team: ");
            teamName = sc.nextLine();

            for (Team t : teams) {
                if (t != null && t.getName().equalsIgnoreCase(teamName)) {
                    selectedTeam = t;
                }
            }
            if (selectedTeam == null){
                System.out.println("invalid input");
            }
        } while (selectedTeam == null);

        System.out.printf("team name: %s\tteam room is: %s\tteam member count is: %d", //\t er tab
                //til l.155 er med i printf
                selectedTeam.getName(),
                selectedTeam.getRoom(),
             selectedTeam.getNumberOfStudents());
        System.out.println("\nstudents in team: ");

        String[] studentInfo = selectedTeam.studentInfo(); //laver et array jeg referer elever på team overpå
        for(String s : studentInfo){
            System.out.println(s);
        }
    }

    public static void showTeamInfoAll(Team[] teams) {
        for (Team t: teams){
            if (t != null){
                System.out.println("\n\n_________________" + t.getName() + "_________________");
                System.out.printf("team name: %s\tteam room is: %s\tteam member count is: %d",
                        // til og med l.172 er med i printf
                        t.getName(),
                        t.getRoom(),
                        t.getNumberOfStudents());
                System.out.println("\nstudents in team: ");
//printer hver enkelte elev ved at lave et array og loope igennem det med for each loop
                String[] studentInfo = t.studentInfo();
                for(String s : studentInfo){
                    System.out.println(s);
                }
                System.out.println("_________________");
            }

        }

    }

}

