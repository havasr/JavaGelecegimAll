package main;

import java.util.ArrayList;

public class Transcript {
    private int studentID;
    private ArrayList<CourseGrade> courseGradeList;
    private double GPA;

    public Transcript(int studentID) {
        setStudentID(studentID);
        setGPA(0.0);
        setCourseGradeList(new ArrayList<CourseGrade>());
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

    public void setGPA(double GPA) {

        for (CourseGrade courseGrade : this.courseGradeList) {
            int sum += ;
        }

        } else {
            System.out.println("Wrong input.");
        }
    }


    public void addCourseTaken(CourseGrade courseGrade) {
        if (courseGrade != null) {
            if (this.getCourseGradeList() != null) {
                this.getCourseGradeList().add(courseGrade);
            } else {
                ArrayList<CourseGrade> newCourseGradeList = new ArrayList<>();
                newCourseGradeList.add(courseGrade);
                this.setCourseGradeList(newCourseGradeList);
            }
        } else {
            System.out.println("The grade you entered is invalid.");
        }
    }


}
