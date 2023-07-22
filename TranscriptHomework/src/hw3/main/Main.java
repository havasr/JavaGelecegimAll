package hw3.main;
import hw3.util.Grade;

public class Main {
    public static void main(String[] args) {

        CourseGrade courseGrade1 = new CourseGrade("ME", 120, 4, 3.4);
        CourseGrade courseGrade2 = new CourseGrade("ece", 20, 3, Grade.D);
        CourseGrade courseGrade3 = new CourseGrade("ABC", 60, 1, 3);

        System.out.println(courseGrade2);

        Transcript transcript1 = new Transcript(1234);
        transcript1.addCourseTaken(courseGrade1);
        transcript1.addCourseTaken(courseGrade2);
        transcript1.addCourseTaken(courseGrade3);

        System.out.println(transcript1);

    }
}