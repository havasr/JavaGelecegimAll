package hw3.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GenerateTranscript {

    public Transcript takeInputFromUser() {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter information for all classes. \nDisclaimer: In case of invalid input, default values will be set.");


        System.out.println("Please enter the student ID: ");
        Transcript transcript = null;
        while (input.hasNext()) {
            int studentID = Integer.parseInt(input.nextLine());

            transcript = new Transcript(studentID);

            while (true) {
                System.out.print("Enter Department: ");
                String department = input.nextLine();
                if (department.equalsIgnoreCase("end")) {
                    break;
                }

                System.out.print("Enter Course Code: ");
                int courseCode = input.nextInt();

                System.out.print("Enter Credit: ");
                int credit = Integer.parseInt(input.nextLine());

                System.out.print("Enter Grade: ");
                double grade = Double.parseDouble(input.nextLine());
                System.out.println("If you want to end course input, please enter 'end'.\n If not, please continue.");


                CourseGrade courseGrade = new CourseGrade(department, courseCode, credit, grade);
                transcript.addCourseTaken(courseGrade);
            }
            System.out.println("\nTo terminate input, use the EOF indicator. For Windows Ctrl + Z, for Linux, macOS Ctrl + D");
        }
        System.out.println(transcript);
        return transcript;

    }

    public Transcript takeInputFromFile() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the file name:  ");
        String pathName = "src/hw3/assets/" + input.nextLine();

        File file = new File(pathName);
        Transcript transcript = null;
        try {
            Scanner scanner = new Scanner(file);

            int studentId = Integer.parseInt(scanner.nextLine());

            transcript = new Transcript(studentId);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String department = parts[0];
                int courseCode = Integer.parseInt(parts[1]);
                int credit = Integer.parseInt(parts[2]);
                double grade = Double.parseDouble(parts[3]);

                CourseGrade courseGrade = new CourseGrade(department, courseCode, credit, grade);
                transcript.addCourseTaken(courseGrade);
            }

            System.out.println(transcript);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + pathName);
        }
        return transcript;
    }
}
