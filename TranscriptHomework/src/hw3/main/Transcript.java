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
    public void addCourseTaken(CourseGrade courseGrade) {
        if (courseGrade != null) {
            getCourseGradeList().add(courseGrade);
            calculateGPA();
        } else {
            System.out.println("The grade you entered is invalid.");
        }
    }

    public void calculateGPA() {
        double sum = 0;
        for (CourseGrade courseGrade : this.courseGradeList) {
            Grade grade = courseGrade.getGradeTaken();
            int gradeNumber = grade.getNumericValue();
            sum += gradeNumber;
        }
        this.GPA = sum / this.courseGradeList.size();
    }


    @Override
    public String toString() {
        String transcript = courseGradeList.toString().replace("[", "").replace("]", "");

        return "Student ID: " + studentID + "\n" +
                courseGradeList + "\nGPA: " + GPA;



    }


}
