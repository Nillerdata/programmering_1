package opg_klasser.src.model;

import model.Student;

import java.util.Arrays;

public class Team {
    // class fields
    private String name;
    private String room;
    private Student[] students;
    private int studentCount;

    private static final char[] correctAnswers = new char[]{
            'B', 'A', 'A', 'B', 'D', 'A', 'B', 'C', 'D', 'D'
    };


    // Constructor
    public Team(String room, String name) {
        this.room = room;
        this.name = name;
        this.students = new Student[32];
    }

    // Class methods

    public int[] getTestStatistics() {
        int[] statistics = new int[10];

        for (int i = 0; i < correctAnswers.length; i++) {
            int correctAnswerCount = 0;
            for (Student s : students) {
                if (s != null && s.getTestAnswers()[i] == correctAnswers[i]) {
                    correctAnswerCount++;
                }
            }
            statistics[i] = correctAnswerCount;
        }

        return statistics;
    }

    public void printStudents() {
        for (Student s : students) {
            // If the student hasn't had a random array of answers generated
            // the printStudents method will ensure that such array is generated
            if (s != null) {
                if (s.getTestAnswers()[0] == '\u0000') {
                    s.generateRandomTestAnswers();
                }
                System.out.printf(
                        "Name: %s \tGrade average: %.2f \tNumber of correct answers: %d\n"
                        , s.getName(), s.getAverageGrade(), s.correctAnswers(correctAnswers));
            }
        }
    }

    public String[] getStudentsInfo(){
        String[] placeholder = new String[studentCount];
        int currentIndex = 0;
        for (Student s : students) {
            // If the student hasn't had a random array of answers generated
            // the getStudentInfo method will ensure that such array is generated
            if (s != null) {
                if (s.getTestAnswers()[0] == '\u0000') {
                    s.generateRandomTestAnswers();
                }
                String stringToAdd = String.format(
                        "Name: %s \tGrade average: %.2f \tNumber of correct answers: %d\n"
                        , s.getName(), s.getAverageGrade(), s.correctAnswers(correctAnswers));
                placeholder[currentIndex] = stringToAdd;
                currentIndex++;
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

    public void addStudent(Student studentToAdd) {
        assert studentToAdd != null : "studentToAdd cant be null";
        // Ensures that the student doesn't already exist in the students array
        boolean isDuplicate = false;
        for (Student s : students) {
            if (s == null) {
                continue;
            }
            if (s.getName().equalsIgnoreCase(studentToAdd.getName())) {
                isDuplicate = true;
            }
        }

        // Prints an error message or adds the student, depending on the result
        // of the previous operation
        if (isDuplicate) {
            System.out.printf("\nERROR\nStudent with name %s already exists in team %s \n\n",
                    studentToAdd.getName(), this.name);
        } else {
            students[studentCount] = studentToAdd;
            studentCount++;
            System.out.printf("\nStudent with name %s and grades %s was added to team %s\n",
                    studentToAdd.getName(),
                    Arrays.toString(studentToAdd.getGrades()),
                    this.name);
        }
    }

    public void removeStudent(String studentName) {
        int selectedStudentIndex = -1;

        // Get the index of the student that the user wishes to remove
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null && students[i].getName().equalsIgnoreCase(studentName)) {
                selectedStudentIndex = i;
            }
        }

        // Check if the selected student was found
        if (selectedStudentIndex != -1) {
            // shift the current students to keep null values at the end of
            // the student array
            for (int i = selectedStudentIndex; i < studentCount - 1; i++) {
                students[i] = students[i + 1];
            }

            // set the last position in the students array to be null, since
            // all elements have been moved one space to the left
            students[studentCount - 1] = null;

            studentCount--;

            System.out.printf("Student with name %s was removed from team %s\n",
                    studentName, this.name);
        } else {
            // Print message the student wasn't found
            System.out.printf("\nERROR\nStudent with name %s doesn't exists in team %s \n\n",
                    studentName, this.name);
        }
    }


    public double getTeamGradeAverage() {
        // Checks if the team is empty, thereby avoiding division by zero
        // error
        if (studentCount == 0) {
            return 0;
        }

        // Calculate team sum
        double teamGradeSum = 0;
        for (Student s : students) {
            if (s != null) {
                teamGradeSum += s.getAverageGrade();
            }
        }
        // Return team average based on teamGrade sum and the studentCount
        return teamGradeSum / studentCount;
    }

    public Student[] highScoreStudents(int minAverage) {
        // Calculate number of students with grade above minAverage
        int highScoreCount = 0;
        for (Student s : students) {
            if (s != null && s.isActive() && s.getAverageGrade() > minAverage) {
                highScoreCount++;
            }
        }

        // Create a placeholder array with size of highScoreCount, and loop
        // through students array to populate placeholder array
        var placeholder = new Student[highScoreCount];
        int placeholderCurrentIndex = 0;
        for (Student s : students) {
            if (s != null && s.isActive() && s.getAverageGrade() > minAverage) {
                placeholder[placeholderCurrentIndex] = s;
                placeholderCurrentIndex++;
            }
        }
        return placeholder;
    }

    public Student[] getStudents() {
        Student[] placeholder = new Student[studentCount];
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null) {
                placeholder[i] = students[i];
            }
        }
        return placeholder;
    }


    // Getters and setters
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentCount() {
        return studentCount;
    }
}
