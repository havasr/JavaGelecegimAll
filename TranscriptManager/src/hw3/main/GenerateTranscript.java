package hw3.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GenerateTranscript {

//Prompt user to choose a way to generate transcript, call the respective method
    public Transcript generateTranscript(){
        Scanner input = new Scanner(System.in);
        System.out.println("Choose an option to generate transcript:");
        System.out.println("1. Input data manually.");
        System.out.println("2. Take data from file.\n");

        String option = input.nextLine();
        Transcript transcript = null;

        if (option.equals("1")) {
            transcript = takeInputFromUser(input);
        } else if (option.equals("2")) {
            transcript = takeInputFromFile(input);
        } else {
            System.out.println("Invalid option.");
        }
        return transcript;
    }

    // Method to take input from the user to create a transcript
    public Transcript takeInputFromUser(Scanner input) {
        System.out.println("Please enter data for all classes. " +
                "\nDisclaimer: In case the respective data does not exist please enter '0'. Student ID is mandatory.");

        System.out.println("Please enter the student ID: ");
        Transcript transcript = null;
        while (input.hasNext()) {

            int studentID = 0;
            try {
                studentID = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Invalid input for student ID.");
                break;
            }

            // Create a new Transcript object for the student
            transcript = new Transcript(studentID);

            // Loop to take input for each course taken by the student
            while (true) {
                System.out.print("Enter Department: ");
                String department = input.nextLine();
                // Check if the user wants to end the input for courses
                if (department.equalsIgnoreCase("end")) {
                    break;
                }

                int courseCode = 0;
                int credit = 0;
                double grade = 0.0;

                try {
                    System.out.print("Enter Course Code: ");
                    courseCode = input.nextInt();

                    System.out.print("Enter Credit: ");
                    credit = input.nextInt();

                    System.out.print("Enter Grade: ");
                    grade = input.nextDouble();
                    input.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input for course details. Please re-enter details.");
                    input.nextLine();
                    continue; // Go to the next iteration to re-ask for the course details
                }

                System.out.println("If you want to end course input, please enter 'end'." +
                        "\nIf not, please continue.");

                // Create a new CourseGrade object for the course and add it to the transcript
                CourseGrade courseGrade = new CourseGrade(department, courseCode, credit, grade);
                transcript.addCourseTaken(courseGrade);
            }
            // Prompt for termination of input using the appropriate EOF indicator
            System.out.println
                    ("\nTo terminate input, use the EOF indicator. For Windows Ctrl + Z, for Linux, macOS Ctrl + D");

        }
        System.out.println(transcript);
        return transcript;
    }

    // Method to take input from a file to create a transcript
    public Transcript takeInputFromFile(Scanner input) {
        // Prompt for the file name from which to read the input
        System.out.print("Enter filename:  ");
        //File named Transcript.txt has been used to check code
        String fileName = input.nextLine();
        String pathName = "src/hw3/assets/" + fileName;

        File file = new File(pathName);
        Transcript transcript = null;
        try {
            Scanner scanner = new Scanner(file);

            // Read the student ID from the first line of the file
            int studentId = scanner.nextInt();
            scanner.nextLine();

            transcript = new Transcript(studentId);

            // Loop to read input for each course taken by the student from the file
            while (scanner.hasNextLine()) {
                String lines = scanner.nextLine();
                String[] parts = lines.split(" ");
                String department = parts[0];
                int courseCode = Integer.parseInt(parts[1]);
                int credit = Integer.parseInt(parts[2]);
                double grade = Double.parseDouble(parts[3]);

                // Create a new CourseGrade object for the course and add it to the transcript
                CourseGrade courseGrade = new CourseGrade(department, courseCode, credit, grade);
                transcript.addCourseTaken(courseGrade);
            }

            System.out.println(transcript);
            scanner.close();
        } catch (FileNotFoundException e) {
            // Handle the case when the specified file is not found
            System.out.println("File not found: " + pathName);
        }
        return transcript;
    }
}
