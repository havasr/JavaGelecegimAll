# Transcript Generator Homework
This project is created as a homework for the Java course in GelecegimAll program. The purpose of the application is to generate transcripts of students. 
________________________________

## Structure of the project
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
Different method are made to check if the input values for the fields are valid. They are called in set methods of the corresponding fields.

### Transcript
This class keeps the transcript of a student with id studentID. With this it creates a empty CourseGrade List and sets the initial GPA to 0.0.
An addCourseTaken method takes a CourseGrade object as input and
inserts it into the list of course grades stored in the Transcript. This method first checks
that CourseGrade object given as parameter is not null then updates the GPA of the student
accordingly.
The calculateGPA method calculates and stores the GPA of the student as a double field which is the average
of all grades taken by the student for all the courses. GPA is therefore a value between 0.0 and
4.0.



