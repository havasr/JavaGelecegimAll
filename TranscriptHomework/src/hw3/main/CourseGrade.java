package hw3.main;

import hw3.util.Grade;

public class CourseGrade {
    private String courseDepartment;
    private int courseCode;
    private int courseCredit;
    private Grade gradeTaken;

    //four overloaded constructors which fill in the missing parameters with default values
    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Grade gradeTaken) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        setCourseCredit(courseCredit);
        setGradeTaken(gradeTaken);
    }

    //additional constructor that takes gradeTaken as a double value instead of a Grade
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
        checkCourseDepartment(courseDepartment);
    }

    //checks if courseDepartment is from valid values, if not sets default value
    public void checkCourseDepartment(String courseDepartment) {
        courseDepartment = courseDepartment.toUpperCase();
        if (courseDepartment.equals("CENG") || courseDepartment.equals("COMP") || courseDepartment.equals("ECE") ||
                courseDepartment.equals("ME") || courseDepartment.equals("MATH")) {
            this.courseDepartment = courseDepartment;
        } else {
            this.courseDepartment = "CENG";
        }
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        checkCourseCode(courseCode);
    }

    //checks if courseCode is from valid values, if not sets default value
    public void checkCourseCode(int courseCode) {
        if (courseCode > 100 && courseCode < 599) {
            this.courseCode = courseCode;
        } else {
            this.courseCode = 100;
        }
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        checkCourseCredit(courseCredit);
    }

    //checks if courseCredit is from valid values, if not sets default value
    public void checkCourseCredit(int courseCredit) {
        if (courseCredit == 4 || courseCredit == 3) {
            this.courseCredit = courseCredit;
        } else {
            this.courseCredit = 4;
        }
    }

    public Grade getGradeTaken() {
        return gradeTaken;
    }

    public void setGradeTaken(Grade gradeTaken) {
        this.gradeTaken = gradeTaken;
    }

    public void setGradeTaken(double val) {
        checkGradeTaken(val);
    }

    //selects the letter grade whose numeric value is closest to val, otherwise sets gradeTaken to default value
    public void checkGradeTaken(double val) {
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
            this.gradeTaken = Grade.F;
        }
    }


    @Override
    public String toString() {

        return "Department: " + courseDepartment + " CourseCode: " + courseCode +
                " Credit: " + courseCredit + " Grade: " + gradeTaken.getStringValue();
    }
}
