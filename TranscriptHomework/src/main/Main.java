package main;
import util.Grade;
import util.GradeTest;

import java.nio.charset.CoderResult;

public class Main {
    public static void main(String[] args) {

        CourseGrade courseGrade1 = new CourseGrade("CHE", 30, 5, 8);
        CourseGrade courseGrade2 = new CourseGrade("ABC", 60, 4, Grade.F);


        System.out.println(courseGrade1);

        Transcript transcript1 = new Transcript(1234);

        System.out.println(transcript1);

        transcript1.getCourseGradeList().add(courseGrade1);
        transcript1.getCourseGradeList().add(courseGrade2);

        System.out.println(transcript1);




    }
}