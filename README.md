![Static Badge](https://img.shields.io/badge/License-MIT-blue)

# gpa-forecaster
This application parses one or multiple input .txt files representing an academic career (semesters taken or planned and their classes) and calculates and prints a grade point average (GPA) report for each file to the console, enabling a student to plan semesters by comparing classes/grade scenarios against a target GPA.

Note: This applications currently only supports Southwestern University grade-point values and 4 credit classes.

### Sample Input File “SampleMultipleSemesters.txt”:
```
s Spring 2024
c Algorithms,A+
c Computer Systems,A
c Linear Algebra,B+
s Fall 2024
c Programming Languages,A
c Physics,C-
c Chemistry,C
c Calculus II,B
s Spring 2025
c Finance,B+
c Calculus III,B-
c Database Systems,A+
c Theory of Computation,A+
```

### GPA Report Outputted to Console:
```
--- Report for file "SampleMultipleSemesters.txt" ---
Number of semesters: 3
Total number of classes: 11

Spring 2024
Classes: 3
Semester GPA: 3.778
-> Algorithms | A+
-> Computer Systems | A
-> Linear Algebra | B+

Fall 2024
Classes: 4
Semester GPA: 2.667
-> Programming Languages | A
-> Physics | C-
-> Chemistry | C
-> Calculus II | B

Spring 2025
Classes: 4
Semester GPA: 3.500
-> Finance | B+
-> Calculus III | B-
-> Database Systems | A+
-> Theory of Computation | A+

***
Cumulative GPA: 3.273
This scenario DOES NOT achieve the target GPA of 3.4.
***
--- End of Report ---
```

## Project Description
This application enables a student to forecast semesters by planning their future classes and anticipated grades, and predict a final cumulative GPA. 

.txt files are used as input to represent a school “career”; files contain semesters taken or planned and their classes. Each semester in the file is calculated a semester GPA by taking the average of the grade point values of the classes in the semester, and a final cumulative is calculated by taking the average of the GPAs of every semester. Appropriately formatted .txt files (containing semester and class information) are added to src/inputfiles and to the list of files to process in src/app/GPAForecaster.java. When run, the program will print a report for each file, as shown above for a single file.

The application was written in Java with Eclipse IDE 2023-12 4.30.0, and was tested thoroughly with JUnit 5. Tests include ensuring correct calculations, accurate file parsing, correct semester, class, and GPA information, and incorrect file format detection. Test suites and .txt files used for testing are located in src/testing and src/testfiles, respectively.

The worst-case efficiency of the application is in O(*n*).

## Motivation
I built this application to enable myself to forecast semesters and easily see what combinations of grades I would need to earn to achieve a specific final cumulative GPA.

## Features
-	Parses school “career” (semester and class) information from .txt files
-	Prints GPA report for files
    - Reports include each semester, their classes and semester GPA, and the final cumulative GPA matched against a target.
    -	Reports generated for an unlimited number of .txt files at once.
-	Easily configure .txt file with semester and class information

## How to Install and Run
1. Clone and import the repository to your Java IDE workspace.
2. Add JUnit 5 to the classpath.
3. Run the project (the main method is located in src/app/GPAForecaster.java).

## How to Use
The input for the application is one or multiple .txt files. Input files to be run regularly are located in src/inputfiles, and those run to test the application are located in src/testfiles.

### Using the Application:
1. Install and run the application (see How to Install and Run above).
2. Create a .txt file with semesters and classes formatted in the style outlined below.
3. Move the file to src/inputfiles.
4. Add the file to the file names list in the main method, located in src/app/GPAForecaster.java (for example, fileNames.add("FILE_NAME.txt")).
5. Repeat steps 2-4 as desired. A report will be generated for each file in the list.
6. Set the target GPA to match scenarios against in src/app/GPAForecaster.java.
7. Run the application.

### Formatting an Input File
There are two acceptable line formats in an input file:

```
s semesterName
c className,classGrade
```
where *s* denotes a new semester, and *c* denotes a new class. Class names and grades are separated by a comma delimiter, and as such are not able to be used in class names (for example, Schools, Society, and Diversity). The set of acceptable classGrade values are: {A+, A, A-, B+, B, B-, C+, C, C-, D+, D, D-, F}.

Spaces are considered, and as such the below line is incorrectly formatted:

```
c className, classGrade
```

Every new class is added to the previously encountered semester until a new semester is encountered. </br>
For example, for the below input file,

```
s Spring 2024
c Computer Systems,A+
c Calculus II,A-
c Linear Algebra,A
c Fundamentals of Physics,A+
s Fall 2024
c Programming Languages,A+
c Machine Learning,A
c Theory of Computation,A
c Chemistry I,A
```

there are two semesters, Spring 2024, with classes Computer Systems, Calculus II, Linear Algebra, and Fundamentals of Physics, and Fall 2024, with classes Programming Languages, Machine Learning, Theory of Computation, and Chemistry I.

## Testing
The application was tested thoroughly with JUnit 5. Tests include ensuring correct calculations, accurate file parsing, correct semester, class, and GPA information, and incorrect file format detection. Test suites and input .txt files used for testing are located in src/testing and src/testfiles, respectively.
