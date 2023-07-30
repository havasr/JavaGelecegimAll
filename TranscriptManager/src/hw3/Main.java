package hw3;

import hw3.main.CourseGrade;
import hw3.main.GenerateTranscript;
import hw3.main.Transcript;
import hw3.util.Grade;

public class Main {
    public static void main(String[] args) {

        /*
        CourseGrade courseGrade1 = new CourseGrade("ME", 120, 4, 3.5);
        CourseGrade courseGrade2 = new CourseGrade("ece", 20, 3, Grade.D);
        CourseGrade courseGrade3 = new CourseGrade("ABC", 60, 1, 6);

        System.out.println(courseGrade2);

        Transcript transcript1 = new Transcript(1234);
        transcript1.addCourseTaken(courseGrade1);
        transcript1.addCourseTaken(courseGrade2);
        transcript1.addCourseTaken(courseGrade3);

        System.out.println(transcript1);
*/
        GenerateTranscript generateTranscript = new GenerateTranscript();
        Transcript transcript2 = generateTranscript.takeInputFromUser();
        Transcript transcript3 =generateTranscript.takeInputFromFile();

    }
}