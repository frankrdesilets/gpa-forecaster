package app;

import java.util.ArrayList;

/**
 * An object of this class prints a GPA report for a list of semesters
 * (one input file) to the console in the format:
 * 
 * 		--- Report for file "fileName.txt" ---
 * 		Number of semesters: numberOfSemesters
 * 		Total number of classes: numberOfClasses
 * 
 * 		semester1Name
 * 		Classes: numberOfClassesInSemester1
 * 		Semester GPA: semesterGPA
 * 			-> class1Name
 * 			-> class2Name
 * 			-> class3Name
 * 			-> ...
 * 
 * 		semester2Name
 * 		Classes: numberOfClassesInSemester2
 *		Semester GPA: semesterGPA
 * 			-> class1Name
 * 			-> class2ame
 * 			-> class3Name
 * 			-> ...
 * 
 * 		***
 * 		Cumulative GPA: cumulativeGPA
 * 		***
 */
public class Reporter {

	public Reporter() {
	}

	/**
	 * Prints a GPA report for a list of semesters (one input file) to the console.
	 * 
	 * @param semesterList
	 * @param fileName
	 */
	public void report(ArrayList<Semester> semesterList, String fileName, double targetGPA) {

		/*
		 * A Calculator object is created to calculate the cumulative GPA value for
		 * every semester in the list
		 */
		Calculator calculator = new Calculator(semesterList);

		// the report title is printed, which includes the name of the file
		System.out.println("--- Report for file \"" + fileName + "\" ---");

		/*
		 * The total number of semesters in the list and classes in every semester are
		 * counted and printed.
		 */
		System.out.println("Number of semesters: " + semesterList.size());
		int classCount = 0;
		for (int i = 0; i < semesterList.size(); i++) {
			classCount += semesterList.get(i).getClassCount();
		}
		System.out.println("Total number of classes: " + classCount);
		System.out.println();

		/*
		 * Each semester is generated a report including the semester name, number of
		 * classes, semester GPA, and the list of classes and their grades.
		 */
		for (int i = 0; i < semesterList.size(); i++) {
			// the current semester is retrieved and printed
			Semester currentSemester = semesterList.get(i);
			System.out.println(currentSemester);
			// the number of classes and semester GPA are printed
			System.out.println("Classes: " + currentSemester.getClassCount());
			System.out.print("Semester GPA: ");
			System.out.printf("%,.3f", (currentSemester.getSemesterPoints() / currentSemester.getClassCount()));
			System.out.println();
			/*
			 * The current semester's classes and their grades are printed.
			 */
			for (int j = 0; j < currentSemester.getClasses().size(); j++) {
				System.out.print("-> ");
				System.out.println(currentSemester.getClasses().get(j) + " | "
						+ currentSemester.getClasses().get(j).getLetterGrade());
			}
			System.out.println();
		}
		// The cumulative GPA for all semesters in the list is printed
		double cumulativeGPA = calculator.getGPA();
		System.out.println("***");
		System.out.print("Cumulative GPA: ");
		System.out.printf("%,.3f", cumulativeGPA);
		System.out.println();
		if (cumulativeGPA >= targetGPA) {
			System.out.println("This scenario ACHIEVES the target GPA of "+targetGPA+".");
		} else {
			System.out.println("This scenario DOES NOT achieve the target GPA of "+targetGPA+".");
		}
		System.out.println("***");
		System.out.println("--- End of Report ---");
		System.out.println();
		System.out.println();

	}

}
