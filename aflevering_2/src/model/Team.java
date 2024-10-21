package model;

import java.util.Arrays;

public class Team {
    //attributter
    private String name;
    private String room;
    private Student[] students;
    private int numberOfStudents = 0;
    private static final char[] correctAnswers = new char[]{'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D', 'A', 'B'};



    public Team(String name, String room) {
        this.name = name;
        this.room = room;
        this.students = new Student[32];
        this.getCorrectAnswer();


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }
    public char[] getCorrectAnswer(){
        return correctAnswers;
    }

    public void setRoom(String room) {
        this.room = room;


    }

    public void addStudent(Student student) {
        if (numberOfStudents < 32) {
            this.students[numberOfStudents] = student;
            numberOfStudents++;
        }
    }


    public Student[] returnStudent() {

        Student[] nonull = new Student[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            nonull[i] = students[i];
        }
        return nonull;

    }

    public void removeStudent(String name) {
        //her finder vi navnet når 'i' rammer den i indexet
        int index = -1;
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].getName().equals(name)) {
                index = i;
            }
        }
        //når den har fundet navnet rykker den index
        if (index != -1) {
            for (int j = index; j < numberOfStudents - 1; j++) {
                students[j] = students[j + 1];
            }
            numberOfStudents--;
        }
    }

    /*OPG 3 Udvid klassen Team med en metode, der kan returnere gennemsnittet af alle de karakterer,
    der er givet for de studerende på teamet.*/
    public double average() {
        double average = 0;
        int count = 0;
        for (int j = 0; j < numberOfStudents; j++) {
            average += students[j].findGradeAverage();
        }

        return average / numberOfStudents;
    }

    /*OPG 4 Udvid klassen Team med en metode, der returnerer et array med de aktive studerende, som
har opnået mindst et bestemt gennemsnit. */
    public Student[] highScoreStudent(double minAverage) {
        int count = 0;

        int[] buenEstudiante = new int[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].isActive() && students[i].findGradeAverage() >= minAverage) {
                buenEstudiante[count] = i;
                count++;
            }
        }
        Student[] stræbere = new Student[count];
        for (int i = 0; i < count; i++) {
            stræbere[i] = students[buenEstudiante[i]];
        }
        return stræbere;
    }

    public String[] studentInfo() {
        String[] info  = new String[numberOfStudents];
        for ( int i=0; i< students.length;i++){
            if (students[i] != null){
            String navn = students[i].getName();
            double gradeAverage = students[i].findGradeAverage();
            int answersCorrect =  students[i].correctAnswers(correctAnswers);
            String result = "name : " + navn + "\tgrade average is : " + gradeAverage + "\t" +
                    "correct answers are : " + answersCorrect + "\n";
            info[i] = result;
        }
            }
        return info;
    }
    public int[] getStatistic(){
        int [] statistics = new int[10];
        for (int i =0; i<correctAnswers.length;i++){
           int correctStudentAnswerCount = 0;
           for (Student s : students){
               if (s != null && s.getAnswer()[i] == correctAnswers[i]){
                   correctStudentAnswerCount++;
               }
           }
           statistics[i] = correctStudentAnswerCount;
        }
        return statistics;
    }

    public void printTeam() {
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println(students[i].getName());
            System.out.println(Arrays.toString(students[i].getGrades()));
        }
        System.out.println(average());
        System.out.println(Arrays.toString(highScoreStudent(4)));
        System.out.println(room);

    }
    public Student[] getStudents() {
        Student[] placeholder = new Student[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i] != null) {
                placeholder[i] = students[i];
            }
        }
        return placeholder;
    }
    public Student getStudentByName(String studentName){
        Student selectedStudent = null;
        for (Student s : students){
            if (s != null && s.getName().equalsIgnoreCase(studentName)){
                selectedStudent = s;
            }
        }
        return selectedStudent;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

}





