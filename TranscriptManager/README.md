# Transcript Generator
## Project Overview
This project is created as a homework for the Java course in GelecegimAll program. The purpose of the application is to generate transcripts of students.
________________________________

## Structure of the project
*Enum Grade  
*GradeTest  
*CourseGrade  
*Transcript  
*GenerateTranscript

## Class Descriptions

### Enum Grade
The enum type Grade represents the grade of a student and defines constants representing the grades of A, B, C, D, F.
Grade has two instance fields, stringValue and numericValue. stringValue contains a String representation of the letter grade. numericValue contains the numeric grade corresponding to the letter grade, which are 4, 3, 2, 1, 0 for A, B, C, D, and F respectively.

### GradeTest
In this class a for each loop, and the values() method of Grade is used to print out a formatted String output.

### CourseGrade
The CourseGrade class keeps information about the department the course is offered,
course code of the course, credit of the course and the grade taken for that course in the
courseDepartment, courseCode and courseCredit and gradeTaken fields.
Four overloaded constructors that take different number of parameters are implemented. Missing parameters for the fields are filled to default values.
An additional constructor that takes gradeTaken as a double value instead of a Grade is also added.
Different method is to check if the input values for the fields are valid. They are called in set methods of the corresponding fields.

### Transcript
This class keeps the transcript of a student with id studentID. With this it creates an empty CourseGrade List and sets the initial GPA to 0.0.
An addCourseTaken method takes a CourseGrade object as input and
inserts it into the list of course grades stored in the Transcript. This method first checks
that CourseGrade object given as parameter is not null then updates the GPA of the student
accordingly.
The calculateGPA method calculates and stores the GPA of the student as a double field which is the average
of all grades taken by the student for all the courses. GPA is therefore a value between 0.0 and
4.0.

### Generate Transcript
This class keeps a method called generateTranscript that prompts the user to choose between manually entering transcript data or from a file. With the input the respective
method is called. The first method is called takeInputFromUser, returns a Transcript object. The method takes input from the user to enter a number of classes and grades and adds
them to a transcript object one by one using addCourseTaken method. When the user is done entering input for classes the user exists by entering "end". Additionally by pressing
end of file indicator, the method prints the transcript of the student whose grades have been entered.
The second method called takeInputFromFile takes a text file name from the user as input. The text file contains information about courses taken by a student. After filename is
taken it processes the file, generates and prints the student transcript.


## Input/Output Format
The expected input/output format for the '1. Input data manually.' choice and takeInputFromUser method would be as following;

**Input:**  
Enter Student Id:  
1112234  
Enter Department: CENG  
Enter Course Code: 201  
Enter Credit: 5  
Enter Grade: 4  
Enter Department: CENG  
Enter Course Code: 205  
Enter Credit: 5  
Enter Grade: 3

**Output**  
Student ID: 1112234  
Department: CENG Code: 201 Credit: 5 Grade: C  
Department: CENG Code: 201 Credit: 5 Grade: A  
Department: CENG Code: 201 Credit: 5 Grade: C  
Department: CENG Code: 201 Credit: 5 Grade: A  
Department: CENG Code: 201 Credit: 5 Grade: B  
GPA:3.0

The expected input/output format for the '2. Take data from file.' choice and takeInputFromFile method would be as following;

**Input:**  
120122  
CENG 201 5 3.5  
MATH 200 3 2.5  
ECE 121 5 2.2

**Output**  
Student ID: 120122  
Department: CENG CourseCode: 201 Credit: 4 Grade: A  
Department: MATH CourseCode: 200 Credit: 3 Grade: B  
Department: ECE CourseCode: 121 Credit: 4 Grade: C   
GPA: 3.0

## Error Handling
The GenerateTranscript class includes error handling mechanisms to handle various situations where the user might input invalid or incorrect data.  
In the takeInputFromUser method, program catches the InputMismatchException and displays an error message when the user inputs an invalid input, such as non-numeric characters.
In the takeInputFromFile method, the program
catches the FileNotFoundException and displays an error message informing the user about the issue.
