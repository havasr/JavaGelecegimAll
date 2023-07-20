package util;

public class GradeTest {
    public static void gradeTest() {
        for (Grade grade : Grade.values()) {
            System.out.println(grade.toString());
        }
    }

}
