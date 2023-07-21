package main;

import util.Grade;

public class CourseGrade {

    private String courseDepartment;
    private int courseCode;
    private int courseCredit;
    private Grade gradeTaken;

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Grade gradeTaken) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        setCourseCredit(courseCredit);
        setGradeTaken(gradeTaken);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, double gradeTaken) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        setCourseCredit(courseCredit);
        setGradeTaken(gradeTaken);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit) {
        this(courseDepartment, courseCode, courseCredit, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode) {
        this(courseDepartment, courseCode, 4, Grade.F);
    }

    public CourseGrade(String courseDepartment) {
        this(courseDepartment, 100, 4, Grade.F);
    }



    public String getCourseDepartment() {
        return courseDepartment;
    }

    public void setCourseDepartment(String courseDepartment) {
        if (courseDepartment.equals("CHENG") || courseDepartment.equals("COMP") || courseDepartment.equals("ECE") ||
                courseDepartment.equals("ME") || courseDepartment.equals("MATH")) {
            this.courseDepartment = courseDepartment;
        } else {
            System.out.println("Wrong input for course department, default value is set.");
            this.courseDepartment = "CHENG";
        }
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        if (courseCode > 100 && courseCode < 599) {
            this.courseCode = courseCode;
        } else {
            System.out.println("Wrong input for course code, default value is set.");
            this.courseCode = 100;
        }
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        if (courseCredit == 4 || courseCredit == 3) {
            this.courseCredit = courseCredit;
        } else {
            System.out.println("Wrong input for course credit, default value is set.");
            this.courseCredit = 4;
        }
    }

    public Grade getGradeTaken() {
        return gradeTaken;
    }

    public void setGradeTaken(double val) {
        double roundedNum = Math.round(val);
        if (roundedNum == 0) {
            this.gradeTaken = Grade.F;
        } else if (roundedNum == 1) {
            this.gradeTaken = Grade.D;
        } else if (roundedNum == 2) {
            this.gradeTaken = Grade.C;
        } else if (roundedNum == 3) {
            this.gradeTaken = Grade.B;
        } else if (roundedNum == 4) {
            this.gradeTaken = Grade.A;
        } else {
            System.out.println("Wrong input for grade, default value is set.");
            this.gradeTaken = Grade.F;
        }

    }

    public void setGradeTaken(Grade gradeTaken) {
        this.gradeTaken = gradeTaken;
    }

    @Override
    public String toString() {
        return "Department: " + courseDepartment + " CourseCode: " + courseCode +
                " Credit: " + courseCredit + " Grade: " + gradeTaken + "\n";
    }
}
