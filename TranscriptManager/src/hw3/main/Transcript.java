package hw3.main;
import hw3.util.Grade;
import java.util.ArrayList;

public class Transcript {
    private int studentID;
    private ArrayList<CourseGrade> courseGradeList;
    private double GPA;

    public Transcript(int studentID) {
        this.studentID = studentID;
        this.courseGradeList = new ArrayList<CourseGrade>();
        this.GPA = 0.0;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public ArrayList<CourseGrade> getCourseGradeList() {
        return courseGradeList;
    }

    public void setCourseGradeList(ArrayList<CourseGrade> courseGradeList) {
        this.courseGradeList = courseGradeList;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA() {
        calculateGPA();
    }

    //adds the courseGrade to the getCourseGradeList() if not null and re-calculates the GPA
    public void addCourseTaken(CourseGrade courseGrade) {
        if (courseGrade != null) {
            getCourseGradeList().add(courseGrade);
            calculateGPA();
        } else {
            System.out.println("The grade you entered is invalid.");
        }
    }

    //calculates the GPA as the average of the grades from all the courses taken
    public void calculateGPA() {
        double sum = 0;
        for (CourseGrade courseGrade : this.courseGradeList) {
            Grade grade = courseGrade.getGradeTaken();
            int gradeNumber = grade.getNumericValue();
            sum += gradeNumber;
        }
        this.GPA = sum / this.courseGradeList.size();
    }

    //adds a newline character to all the elements of courseGradeList except the last one
    @Override
    public String toString() {

        String formattedCourseGradeList = "";

        for (int i = 0; i < courseGradeList.size(); i++) {
            CourseGrade courseGrade = courseGradeList.get(i);

            formattedCourseGradeList += courseGrade.toString()
                    .replace("[", "").replace("]", "").replace(",", "");

            if (i < courseGradeList.size() - 1) {
                formattedCourseGradeList += "\n";
            }
        }

        String formattedGPA = String.format("%.1f", GPA);

        return "Student ID: " + studentID + "\n" +
                formattedCourseGradeList + "\nGPA: " + formattedGPA;
    }
}
