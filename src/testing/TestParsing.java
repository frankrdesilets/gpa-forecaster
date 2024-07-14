package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.*;
import junit.framework.Assert;

/**
 * The following methods test cases test the application to ensure correct
 * parsing of correctly formatted files. This includes ensuring correct
 * semester, class, and GPA information.
 */
class TestParsing {
	
	/* 
	 * *---*
	 * TEST CASES
	 * *---*
	 * 
	 * PARSING & CORRECT SEMESTER, CLASS, GPA INFORMATION
	 * 
	 * 		testParsing_SingleSemester_NoClasses_SingleFile
	 * 		testParsing_SingleSemester_SingleClass_SingleFile
	 * 		testParsing_SingleSemester_MultipleClass_SingleFile
	 * 		testParsing_MultipleSemesters_NoClasses_SingleFile
	 * 		testParsing_MultipleSemesters_SingleClass_SingleFile
	 * 		testParsing_MultipleSemesters_MultipleClasses_SingleFile
	 * 		testParsing_ClassBeforeSemester_SingleFile
	 * 		testParsing_ClassNoSemester_SingleFile
	 */

	/**
	 * This method tests correct parsing when there is one semester with no classes.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one list (for the
	 * single file processed), with one semester. The semester should have no
	 * classes.
	 */
	@Test
	void testParsing_SingleSemester_NoClasses_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testParsing_SingleSemester_NoClasses.txt");
		Controller applicationController = new Controller(fileNames, true);

		/*
		 * The master list (indexed by semester lists from each file processed) should
		 * contain one list from the only file, with one semester, named "Spring 2024",
		 * with no classes.
		 */
		ArrayList<ArrayList<Semester>> allFilesSemesterList = applicationController.getAllFilesSemesterList();
		ArrayList<Semester> semesterList = allFilesSemesterList.get(0);

		// correct information
		int correctNumberOfSemesters = 1; // correct number of semesters
		String correctSemesterName = "Spring 2024"; // correct semester name
		int correctNumberOfClasses = 0; // correct number of classes
		double correctSemesterGPA = 0.0; // correct semester GPA
		double correctCumulativeGPA = 0.0; // correct cumulative GPA

		// calculated information
		int calculatedNumberOfSemesters = semesterList.size(); // calculated number of semesters
		String calculatedSemesterName = semesterList.get(0).getSemesterName(); // calculated semester name
		int calculatedNumberOfClasses = semesterList.get(0).getClassCount(); // calculated number of classes
		double calculatedSemesterGPA = semesterList.get(0).getSemesterGPA(); // calculated semester GPA
		Calculator calculator = new Calculator(semesterList);
		double calculatedCumulativeGPA = calculator.getGPA(); // calculated cumulative GPA

		// the correct and calculated number of semesters are compared
		Assert.assertEquals(correctNumberOfSemesters, calculatedNumberOfSemesters);
		// the correct and calculated semester name are compared
		Assert.assertEquals(correctSemesterName, calculatedSemesterName);
		// the correct and calculated number of classes are compared
		Assert.assertEquals(correctNumberOfClasses, calculatedNumberOfClasses);
		// the correct and calculated semester GPA are compared
		Assert.assertEquals(correctSemesterGPA, calculatedSemesterGPA);
		// the correct and calculated cumulative GPA are compared
		Assert.assertEquals(correctCumulativeGPA, calculatedCumulativeGPA);
	}

	/**
	 * This method tests correct parsing when there is one semester with one class.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one list (for the
	 * single file processed), with one semester. The semester should have one
	 * class.
	 */
	@Test
	void testParsing_SingleSemester_SingleClass_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testParsing_SingleSemester_SingleClass.txt");
		Controller applicationController = new Controller(fileNames, true);

		/*
		 * The master list (indexed by semester lists from each file processed) should
		 * contain one list from the only file, with one semester, named "Spring 2024",
		 * with one class, named Algorithms, with a grade of A.
		 */
		ArrayList<ArrayList<Semester>> allFilesSemesterList = applicationController.getAllFilesSemesterList();
		ArrayList<Semester> semesterList = allFilesSemesterList.get(0);

		// correct information
		int correctNumberOfSemesters = 1; // correct number of semesters
		String correctSemesterName = "Spring 2024"; // correct semester name
		int correctNumberOfClasses = 1; // correct number of classes
		String correctClassName = "Algorithms"; // correct class name
		String correctClassGrade = Grade.A.toString(); // correct class grade
		double correctSemesterGPA = 4.0; // correct semester GPA
		double correctCumulativeGPA = 4.0; // correct cumulative GPA

		// calculated information
		int calculatedNumberOfSemesters = semesterList.size(); // calculated number of semesters
		String calculatedSemesterName = semesterList.get(0).getSemesterName(); // calculated semester name
		int calculatedNumberOfClasses = semesterList.get(0).getClassCount(); // calculated number of classes
		String calculatedClassName = semesterList.get(0).getClasses().get(0).getName(); // calculated class name
		String calculatedClassGrade = semesterList.get(0).getClasses().get(0).getLetterGrade().toString(); // calculated
																											// class
																											// grade
		double calculatedSemesterGPA = semesterList.get(0).getSemesterGPA(); // calculated semester GPA
		Calculator calculator = new Calculator(semesterList);
		double calculatedCumulativeGPA = calculator.getGPA(); // calculated cumulative GPA

		// the correct and calculated number of semesters are compared
		Assert.assertEquals(correctNumberOfSemesters, calculatedNumberOfSemesters);
		// the correct and calculated semester name are compared
		Assert.assertEquals(correctSemesterName, calculatedSemesterName);
		// the correct and calculated number of classes are compared
		Assert.assertEquals(correctNumberOfClasses, calculatedNumberOfClasses);
		// the correct and calculated class name are compared
		Assert.assertEquals(correctClassName, calculatedClassName);
		// the correct and calculated class grade are compared
		Assert.assertEquals(correctClassGrade, calculatedClassGrade);
		// the correct and calculated semester GPA are compared
		Assert.assertEquals(correctSemesterGPA, calculatedSemesterGPA);
		// the correct and calculated cumulative GPA are compared
		Assert.assertEquals(correctCumulativeGPA, calculatedCumulativeGPA);

	}

	/**
	 * This method tests correct parsing when there is one semester with three
	 * classes.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one list (for the
	 * single file processed), with one semester. The semester should have three
	 * classes.
	 */
	@Test
	void testParsing_SingleSemester_MultipleClass_SingleFile() {
		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testParsing_SingleSemester_MultipleClass.txt");
		Controller applicationController = new Controller(fileNames, true);

		/*
		 * The master list (indexed by semester lists from each file processed) should
		 * contain one list from the only file, with one semester, named "Spring 2024",
		 * with three classes, named Algorithms, with a grade of A, Computer Systems,
		 * with a grade of A+, and Linear Algebra, with a grade of A-.
		 */
		ArrayList<ArrayList<Semester>> allFilesSemesterList = applicationController.getAllFilesSemesterList();
		ArrayList<Semester> semesterList = allFilesSemesterList.get(0);

		// correct information
		int correctNumberOfSemesters = 1; // correct number of semesters
		String correctSemesterName = "Spring 2024"; // correct semester name
		int correctNumberOfClasses = 3; // correct number of classes
		String correctClass1Name = "Algorithms"; // correct first class name
		String correctClass2Name = "Computer Systems"; // correct second class name
		String correctClass3Name = "Linear Algebra"; // correct third class name
		String correctClass1Grade = Grade.B_PLUS.toString(); // correct first class grade
		String correctClass2Grade = Grade.A_PLUS.toString(); // correct second class grade
		String correctClass3Grade = Grade.A_MINUS.toString(); // correct third class grade
		double correctSemesterGPA = 3.667; // correct semester GPA
		double correctCumulativeGPA = 3.667; // correct cumulative GPA

		// calculated information
		int calculatedNumberOfSemesters = semesterList.size(); // calculated number of semesters
		String calculatedSemesterName = semesterList.get(0).getSemesterName(); // calculated semester name
		int calculatedNumberOfClasses = semesterList.get(0).getClassCount(); // calculated number of classes
		String calculatedClass1Name = semesterList.get(0).getClasses().get(0).getName(); // calculated first class name
		String calculatedClass2Name = semesterList.get(0).getClasses().get(1).getName(); // calculated second class name
		String calculatedClass3Name = semesterList.get(0).getClasses().get(2).getName(); // calculated third class name
		String calculatedClass1Grade = semesterList.get(0).getClasses().get(0).getLetterGrade().toString(); // calculated
																											// first
																											// class
																											// grade
		String calculatedClass2Grade = semesterList.get(0).getClasses().get(1).getLetterGrade().toString(); // calculated
																											// second
																											// class
																											// grade
		String calculatedClass3Grade = semesterList.get(0).getClasses().get(2).getLetterGrade().toString(); // calculated
																											// third
																											// class
																											// grade
		double calculatedSemesterGPA = semesterList.get(0).getSemesterGPA(); // calculated semester GPA
		Calculator calculator = new Calculator(semesterList);
		double calculatedCumulativeGPA = calculator.getGPA();

		// the correct and calculated number of semesters are compared
		Assert.assertEquals(correctNumberOfSemesters, calculatedNumberOfSemesters);
		// the correct and calculated semester name are compared
		Assert.assertEquals(correctSemesterName, calculatedSemesterName);
		// the correct and calculated number of classes are compared
		Assert.assertEquals(correctNumberOfClasses, calculatedNumberOfClasses);
		// the correct and calculated first class name are compared
		Assert.assertEquals(correctClass1Name, calculatedClass1Name);
		// the correct and calculated second class name are compared
		Assert.assertEquals(correctClass2Name, calculatedClass2Name);
		// the correct and calculated third class name are compared
		Assert.assertEquals(correctClass3Name, calculatedClass3Name);
		// the correct and calculated first class grade are compared
		Assert.assertEquals(correctClass1Grade, calculatedClass1Grade);
		// the correct and calculated second class grade are compared
		Assert.assertEquals(correctClass2Grade, calculatedClass2Grade);
		// the correct and calculated third class grade are compared
		Assert.assertEquals(correctClass3Grade, calculatedClass3Grade);
		// the correct and calculated semester GPA are compared with an error margin of
		// 0.001
		Assert.assertEquals(correctSemesterGPA, calculatedSemesterGPA, 0.001);
		// the correct and calculated cumulative GPA are compared with an error margin
		// of 0.001
		Assert.assertEquals(correctCumulativeGPA, calculatedCumulativeGPA, 0.001);

	}

	/**
	 * This method tests correct parsing when there are multiple semesters with no
	 * classes.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one list (for the
	 * single file processed), with three semesters. The semesters should have no
	 * classes.
	 */
	@Test
	void testParsing_MultipleSemesters_NoClasses_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testParsing_MultipleSemesters_NoClasses.txt");
		Controller applicationController = new Controller(fileNames, true);
		/*
		 * The master list (indexed by semester lists from each file processed) should
		 * contain one list from the only file, with three semesters, named
		 * "Spring 2024", "Fall 2024" and "Spring 2025", with no classes.
		 */
		ArrayList<ArrayList<Semester>> allFilesSemesterList = applicationController.getAllFilesSemesterList();
		ArrayList<Semester> semesterList = allFilesSemesterList.get(0);

		// correct information
		int correctNumberOfSemesters = 3; // correct number of semesters
		int correctNumberOfClassesForAllSemesters = 0; // correct number of classes for each semester
		String correctSemester1Name = "Spring 2024"; // correct first semester name
		String correctSemester2Name = "Fall 2024"; // correct second semester name
		String correctSemester3Name = "Spring 2025"; // correct third semester name
		double correctSemesterGPA = 0.0; // correct semester GPA
		double correctCumulativeGPA = 0.0; // correct cumulative GPA

		// calculated information
		int calculatedNumberOfSemesters = semesterList.size(); // calculated number of semesters
		int calculatedSemester1NumberOfClasses = semesterList.get(0).getClassCount(); // calculated number of classes
																						// for first semester
		int calculatedSemester2NumberOfClasses = semesterList.get(1).getClassCount(); // calculated number of classes
																						// for second semester
		int calculatedSemester3NumberOfClasses = semesterList.get(2).getClassCount(); // calculated number of classes
																						// for third semester
		String calculatedSemester1Name = semesterList.get(0).getSemesterName(); // calculated first semester name
		String calculatedSemester2Name = semesterList.get(1).getSemesterName(); // calculated second semester name
		String calculatedSemester3Name = semesterList.get(2).getSemesterName(); // calculated third semester name
		double calculatedSemesterGPA = semesterList.get(0).getSemesterGPA(); // calculated semester GPA
		Calculator calculator = new Calculator(semesterList);
		double calculatedCumulativeGPA = calculator.getGPA();

		// the correct and calculated number of semesters are compared
		Assert.assertEquals(correctNumberOfSemesters, calculatedNumberOfSemesters);
		// the correct and calculated number of classes for semester one are compared
		Assert.assertEquals(correctNumberOfClassesForAllSemesters, calculatedSemester1NumberOfClasses);
		// the correct and calculated number of classes for semester two are compared
		Assert.assertEquals(correctNumberOfClassesForAllSemesters, calculatedSemester2NumberOfClasses);
		// the correct and calculated number of classes for semester three are compared
		Assert.assertEquals(correctNumberOfClassesForAllSemesters, calculatedSemester3NumberOfClasses);
		// the correct and calculated semester name for semester one are compared
		Assert.assertEquals(correctSemester1Name, calculatedSemester1Name);
		// the correct and calculated semester name for semester two are compared
		Assert.assertEquals(correctSemester2Name, calculatedSemester2Name);
		// the correct and calculated semester name for semester three are compared
		Assert.assertEquals(correctSemester3Name, calculatedSemester3Name);
		// the correct and calculated semester GPA are compared
		Assert.assertEquals(correctSemesterGPA, calculatedSemesterGPA);
		// the correct and calculated cumulative GPA are compared
		Assert.assertEquals(correctCumulativeGPA, calculatedCumulativeGPA);

	}

	/**
	 * This method tests correct parsing when there are multiple semesters with one
	 * class each.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one list (for the
	 * single file processed), with three semesters. The semesters should have one
	 * class each.
	 */
	@Test
	void testParsing_MultipleSemesters_SingleClass_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testParsing_MultipleSemesters_SingleClass.txt");
		Controller applicationController = new Controller(fileNames, true);
		/*
		 * The master list (indexed by semester lists from each file processed) should
		 * contain one list from the only file, with three semesters, named
		 * "Spring 2024", "Fall 2024" and "Spring 2025", with one class each.
		 */
		ArrayList<ArrayList<Semester>> allFilesSemesterList = applicationController.getAllFilesSemesterList();
		ArrayList<Semester> semesterList = allFilesSemesterList.get(0);

		// correct information
		int correctNumberOfSemesters = 3; // correct number of semesters
		int correctNumberOfClassesForAllSemesters = 1; // correct number of classes for each semester
		String correctSemester1Name = "Spring 2024"; // correct first semester name
		String correctSemester2Name = "Fall 2024"; // correct second semester name
		String correctSemester3Name = "Spring 2025"; // correct third semester name
		String correctSemester1ClassName = "Algorithms"; // correct first semester name
		String correctSemester2ClassName = "Computer Systems"; // correct second semester name
		String correctSemester3ClassName = "Linear Algebra"; // correct third semester name
		String correctSemester1ClassGrade = "A+"; // correct first semester class name
		String correctSemester2ClassGrade = "B"; // correct second semester class name
		String correctSemester3ClassGrade = "B+"; // correct third semester class name
		double correctSemester1GPA = 4.0; // correct semester GPA
		double correctSemester2GPA = 3.0; // correct semester GPA
		double correctSemester3GPA = 3.333; // correct semester GPA
		double correctCumulativeGPA = 3.444; // correct cumulative GPA

		// calculated information
		int calculatedNumberOfSemesters = semesterList.size(); // calculated number of semesters
		int calculatedSemester1NumberOfClasses = semesterList.get(0).getClassCount(); // calculated number of classes
																						// for first semester
		int calculatedSemester2NumberOfClasses = semesterList.get(1).getClassCount(); // calculated number of classes
																						// for second semester
		int calculatedSemester3NumberOfClasses = semesterList.get(2).getClassCount(); // calculated number of classes
																						// for third semester
		String calculatedSemester1Name = semesterList.get(0).getSemesterName(); // calculated first semester name
		String calculatedSemester2Name = semesterList.get(1).getSemesterName(); // calculated second semester name
		String calculatedSemester3Name = semesterList.get(2).getSemesterName(); // calculated third semester name
		String calculatedSemester1ClassName = semesterList.get(0).getClasses().get(0).getName(); // calculated first
																									// semester class
																									// name
		String calculatedSemester2ClassName = semesterList.get(1).getClasses().get(0).getName(); // calculated second
																									// semester class
																									// name
		String calculatedSemester3ClassName = semesterList.get(2).getClasses().get(0).getName(); // calculated third
																									// semester class
																									// name
		String calculatedSemester1ClassGrade = semesterList.get(0).getClasses().get(0).getLetterGrade().toString(); // calculated
																													// first
																													// semester
																													// class
																													// name
		String calculatedSemester2ClassGrade = semesterList.get(1).getClasses().get(0).getLetterGrade().toString(); // calculated
																													// second
																													// semester
																													// class
																													// name
		String calculatedSemester3ClassGrade = semesterList.get(2).getClasses().get(0).getLetterGrade().toString(); // calculated
																													// third
																													// semester
																													// class
																													// name
		double calculatedSemester1GPA = semesterList.get(0).getSemesterGPA(); // calculated first semester GPA
		double calculatedSemester2GPA = semesterList.get(1).getSemesterGPA(); // calculated second semester GPA
		double calculatedSemester3GPA = semesterList.get(2).getSemesterGPA(); // calculated third semester GPA
		Calculator calculator = new Calculator(semesterList);
		double calculatedCumulativeGPA = calculator.getGPA();

		// the correct and calculated number of semesters are compared
		Assert.assertEquals(correctNumberOfSemesters, calculatedNumberOfSemesters);
		// the correct and calculated number of classes for semester one are compared
		Assert.assertEquals(correctNumberOfClassesForAllSemesters, calculatedSemester1NumberOfClasses);
		// the correct and calculated number of classes for semester two are compared
		Assert.assertEquals(correctNumberOfClassesForAllSemesters, calculatedSemester2NumberOfClasses);
		// the correct and calculated number of classes for semester three are compared
		Assert.assertEquals(correctNumberOfClassesForAllSemesters, calculatedSemester3NumberOfClasses);
		// the correct and calculated semester name for semester one are compared
		Assert.assertEquals(correctSemester1Name, calculatedSemester1Name);
		// the correct and calculated semester name for semester two are compared
		Assert.assertEquals(correctSemester2Name, calculatedSemester2Name);
		// the correct and calculated semester name for semester three are compared
		Assert.assertEquals(correctSemester3Name, calculatedSemester3Name);
		// the correct and calculated class name for semester one are compared
		Assert.assertEquals(correctSemester1ClassName, calculatedSemester1ClassName);
		// the correct and calculated class name for semester two are compared
		Assert.assertEquals(correctSemester2ClassName, calculatedSemester2ClassName);
		// the correct and calculated class name for semester three are compared
		Assert.assertEquals(correctSemester3ClassName, calculatedSemester3ClassName);
		// the correct and calculated class grade for semester one are compared
		Assert.assertEquals(correctSemester1ClassGrade, calculatedSemester1ClassGrade);
		// the correct and calculated class grade for semester two are compared
		Assert.assertEquals(correctSemester2ClassGrade, calculatedSemester2ClassGrade);
		// the correct and calculated class grade for semester three are compared
		Assert.assertEquals(correctSemester3ClassGrade, calculatedSemester3ClassGrade);
		// the correct and calculated first semester GPA are compared with an error
		// margin of 0.001
		Assert.assertEquals(correctSemester1GPA, calculatedSemester1GPA, 0.001);
		// the correct and calculated second semester GPA are compared with an error
		// margin of 0.001
		Assert.assertEquals(correctSemester2GPA, calculatedSemester2GPA, 0.001);
		// the correct and calculated third semester GPA are compared with an error
		// margin of 0.001
		Assert.assertEquals(correctSemester3GPA, calculatedSemester3GPA, 0.001);
		// the correct and calculated cumulative GPA are compared with an error margin
		// of 0.001
		Assert.assertEquals(correctCumulativeGPA, calculatedCumulativeGPA, 0.001);

	}

	/**
	 * This method tests correct parsing when there are multiple semesters with
	 * varying amounts of classes each.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one list (for the
	 * single file processed), with three semesters. The first semester should have
	 * three classes, and the second and third semester should each have four
	 * classes.
	 */
	@Test
	void testParsing_MultipleSemesters_MultipleClasses_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testParsing_MultipleSemesters_MultipleClasses.txt");
		Controller applicationController = new Controller(fileNames, true);
		/*
		 * The master list (indexed by semester lists from each file processed) should
		 * contain one list from the only file, with three semesters, named
		 * "Spring 2024" (classes: Algorithms[A+], Computer Systems[A], and Linear
		 * Algebra[B+]), "Fall 2024" (classes: Programming Languages[A], Physics[B-],
		 * Chemistry[B], and Calculus II[A]), and "Spring 2025" (classes:
		 * TestClass1[B+], TestClass4[A-], TestClass8[A+], and TestClass6[B-].
		 */
		ArrayList<ArrayList<Semester>> allFilesSemesterList = applicationController.getAllFilesSemesterList();
		ArrayList<Semester> semesterList = allFilesSemesterList.get(0);

		// correct information
		int correctNumberOfSemesters = 3; // correct number of semesters
		String correctSemester1Name = "Spring 2024"; // correct first semester name
		String correctSemester2Name = "Fall 2024"; // correct second semester name
		String correctSemester3Name = "Spring 2025"; // correct third semester name
		int correctNumberOfClassesSemester1 = 3; // correct number of classes for the first semester
		int correctNumberOfClassesSemester2 = 4; // correct number of classes for the second semester
		int correctNumberOfClassesSemester3 = 4; // correct number of classes for the third semester

		ArrayList<String> correctSemesterClassNames = new ArrayList<>(); // used for comparing correct and calculated
																			// values
		String correctSemester1Class1Name = "Algorithms"; // correct first semester first class name
		String correctSemester1Class2Name = "Computer Systems"; // correct first semester second class name
		String correctSemester1Class3Name = "Linear Algebra"; // correct first semester third class name
		String correctSemester2Class1Name = "Programming Languages"; // correct second semester first class name
		String correctSemester2Class2Name = "Physics"; // correct second semester second class name
		String correctSemester2Class3Name = "Chemistry"; // correct second semester third class name
		String correctSemester2Class4Name = "Calculus II"; // correct second semester fourth class name
		String correctSemester3Class1Name = "TestClass1"; // correct third semester first class name
		String correctSemester3Class2Name = "TestClass4"; // correct third semester second class name
		String correctSemester3Class3Name = "TestClass8"; // correct third semester third class name
		String correctSemester3Class4Name = "TestClass6"; // correct third semester fourth class name
		correctSemesterClassNames.add(correctSemester1Class1Name);
		correctSemesterClassNames.add(correctSemester1Class2Name);
		correctSemesterClassNames.add(correctSemester1Class3Name);
		correctSemesterClassNames.add(correctSemester2Class1Name);
		correctSemesterClassNames.add(correctSemester2Class2Name);
		correctSemesterClassNames.add(correctSemester2Class3Name);
		correctSemesterClassNames.add(correctSemester2Class4Name);
		correctSemesterClassNames.add(correctSemester3Class1Name);
		correctSemesterClassNames.add(correctSemester3Class2Name);
		correctSemesterClassNames.add(correctSemester3Class3Name);
		correctSemesterClassNames.add(correctSemester3Class4Name);

		ArrayList<String> correctSemesterClassGrades = new ArrayList<>(); // used for comparing correct and calculated
																			// values
		String correctSemester1Class1Grade = Grade.A_PLUS.toString(); // correct first semester first class name
		String correctSemester1Class2Grade = Grade.A.toString(); // correct first semester second class name
		String correctSemester1Class3Grade = Grade.B_PLUS.toString(); // correct first semester third class name
		String correctSemester2Class1Grade = Grade.A.toString(); // correct second semester first class name
		String correctSemester2Class2Grade = Grade.C_MINUS.toString(); // correct second semester second class name
		String correctSemester2Class3Grade = Grade.D.toString(); // correct second semester third class name
		String correctSemester2Class4Grade = Grade.F.toString(); // correct second semester fourth class name
		String correctSemester3Class1Grade = Grade.C_PLUS.toString(); // correct third semester first class name
		String correctSemester3Class2Grade = Grade.D_MINUS.toString(); // correct third semester second class name
		String correctSemester3Class3Grade = Grade.D_PLUS.toString(); // correct third semester third class name
		String correctSemester3Class4Grade = Grade.B.toString(); // correct third semester fourth class name
		correctSemesterClassGrades.add(correctSemester1Class1Grade);
		correctSemesterClassGrades.add(correctSemester1Class2Grade);
		correctSemesterClassGrades.add(correctSemester1Class3Grade);
		correctSemesterClassGrades.add(correctSemester2Class1Grade);
		correctSemesterClassGrades.add(correctSemester2Class2Grade);
		correctSemesterClassGrades.add(correctSemester2Class3Grade);
		correctSemesterClassGrades.add(correctSemester2Class4Grade);
		correctSemesterClassGrades.add(correctSemester3Class1Grade);
		correctSemesterClassGrades.add(correctSemester3Class2Grade);
		correctSemesterClassGrades.add(correctSemester3Class3Grade);
		correctSemesterClassGrades.add(correctSemester3Class4Grade);

		double correctSemester1GPA = 3.777; // correct semester GPA
		double correctSemester2GPA = 1.667; // correct semester GPA
		double correctSemester3GPA = 1.833; // correct semester GPA
		double correctCumulativeGPA = 2.426; // correct cumulative GPA

		// calculated information
		int calculatedNumberOfSemesters = semesterList.size(); // calculated number of semesters
		String calculatedSemester1Name = semesterList.get(0).getSemesterName(); // calculated first semester name
		String calculatedSemester2Name = semesterList.get(1).getSemesterName(); // calculated second semester name
		String calculatedSemester3Name = semesterList.get(2).getSemesterName(); // calculated third semester name
		int calculatedSemester1NumberOfClasses = semesterList.get(0).getClassCount(); // calculated number of classes
																						// for first semester
		int calculatedSemester2NumberOfClasses = semesterList.get(1).getClassCount(); // calculated number of classes
																						// for second semester
		int calculatedSemester3NumberOfClasses = semesterList.get(2).getClassCount(); // calculated number of classes
																						// for third semester

		ArrayList<String> calculatedSemesterClassNames = new ArrayList<>(); // used for comparing correct and calculated
																			// values
		String calculatedSemester1Class1Name = semesterList.get(0).getClasses().get(0).getName(); // calculated first
																									// semester first
																									// class name
		String calculatedSemester1Class2Name = semesterList.get(0).getClasses().get(1).getName(); // calculated first
																									// semester second
																									// class name
		String calculatedSemester1Class3Name = semesterList.get(0).getClasses().get(2).getName(); // calculated first
																									// semester third
																									// class name
		String calculatedSemester2Class1Name = semesterList.get(1).getClasses().get(0).getName(); // calculated second
																									// semester first
																									// class name
		String calculatedSemester2Class2Name = semesterList.get(1).getClasses().get(1).getName(); // calculated second
																									// semester second
																									// class name
		String calculatedSemester2Class3Name = semesterList.get(1).getClasses().get(2).getName(); // calculated second
																									// semester third
																									// class name
		String calculatedSemester2Class4Name = semesterList.get(1).getClasses().get(3).getName(); // calculated second
																									// semester fourth
																									// class name
		String calculatedSemester3Class1Name = semesterList.get(2).getClasses().get(0).getName(); // calculated third
																									// semester first
																									// class name
		String calculatedSemester3Class2Name = semesterList.get(2).getClasses().get(1).getName(); // calculated third
																									// semester second
																									// class name
		String calculatedSemester3Class3Name = semesterList.get(2).getClasses().get(2).getName(); // calculated third
																									// semester third
																									// class name
		String calculatedSemester3Class4Name = semesterList.get(2).getClasses().get(3).getName(); // calculated third
																									// semester fourth
																									// class name
		calculatedSemesterClassNames.add(calculatedSemester1Class1Name);
		calculatedSemesterClassNames.add(calculatedSemester1Class2Name);
		calculatedSemesterClassNames.add(calculatedSemester1Class3Name);
		calculatedSemesterClassNames.add(calculatedSemester2Class1Name);
		calculatedSemesterClassNames.add(calculatedSemester2Class2Name);
		calculatedSemesterClassNames.add(calculatedSemester2Class3Name);
		calculatedSemesterClassNames.add(calculatedSemester2Class4Name);
		calculatedSemesterClassNames.add(calculatedSemester3Class1Name);
		calculatedSemesterClassNames.add(calculatedSemester3Class2Name);
		calculatedSemesterClassNames.add(calculatedSemester3Class3Name);
		calculatedSemesterClassNames.add(calculatedSemester3Class4Name);

		ArrayList<String> calculatedSemesterClassGrades = new ArrayList<>(); // used for comparing correct and
																				// calculated values
		String calculatedSemester1Class1Grade = semesterList.get(0).getClasses().get(0).getLetterGrade().toString(); // calculated
																														// first
																														// semester
																														// first
																														// class
																														// name
		String calculatedSemester1Class2Grade = semesterList.get(0).getClasses().get(1).getLetterGrade().toString(); // calculated
																														// first
																														// semester
																														// second
																														// class
																														// name
		String calculatedSemester1Class3Grade = semesterList.get(0).getClasses().get(2).getLetterGrade().toString(); // calculated
																														// first
																														// semester
																														// third
																														// class
																														// name
		String calculatedSemester2Class1Grade = semesterList.get(1).getClasses().get(0).getLetterGrade().toString(); // calculated
																														// second
																														// semester
																														// first
																														// class
																														// name
		String calculatedSemester2Class2Grade = semesterList.get(1).getClasses().get(1).getLetterGrade().toString(); // calculated
																														// second
																														// semester
																														// second
																														// class
																														// name
		String calculatedSemester2Class3Grade = semesterList.get(1).getClasses().get(2).getLetterGrade().toString(); // calculated
																														// second
																														// semester
																														// third
																														// class
																														// name
		String calculatedSemester2Class4Grade = semesterList.get(1).getClasses().get(3).getLetterGrade().toString(); // calculated
																														// second
																														// semester
																														// fourth
																														// class
																														// name
		String calculatedSemester3Class1Grade = semesterList.get(2).getClasses().get(0).getLetterGrade().toString(); // calculated
																														// third
																														// semester
																														// first
																														// class
																														// name
		String calculatedSemester3Class2Grade = semesterList.get(2).getClasses().get(1).getLetterGrade().toString(); // calculated
																														// third
																														// semester
																														// second
																														// class
																														// name
		String calculatedSemester3Class3Grade = semesterList.get(2).getClasses().get(2).getLetterGrade().toString(); // calculated
																														// third
																														// semester
																														// third
																														// class
																														// name
		String calculatedSemester3Class4Grade = semesterList.get(2).getClasses().get(3).getLetterGrade().toString(); // calculated
																														// third
																														// semester
																														// fourth
																														// class
																														// name
		calculatedSemesterClassGrades.add(calculatedSemester1Class1Grade);
		calculatedSemesterClassGrades.add(calculatedSemester1Class2Grade);
		calculatedSemesterClassGrades.add(calculatedSemester1Class3Grade);
		calculatedSemesterClassGrades.add(calculatedSemester2Class1Grade);
		calculatedSemesterClassGrades.add(calculatedSemester2Class2Grade);
		calculatedSemesterClassGrades.add(calculatedSemester2Class3Grade);
		calculatedSemesterClassGrades.add(calculatedSemester2Class4Grade);
		calculatedSemesterClassGrades.add(calculatedSemester3Class1Grade);
		calculatedSemesterClassGrades.add(calculatedSemester3Class2Grade);
		calculatedSemesterClassGrades.add(calculatedSemester3Class3Grade);
		calculatedSemesterClassGrades.add(calculatedSemester3Class4Grade);

		double calculatedSemester1GPA = semesterList.get(0).getSemesterGPA(); // calculated first semester GPA
		double calculatedSemester2GPA = semesterList.get(1).getSemesterGPA(); // calculated second semester GPA
		double calculatedSemester3GPA = semesterList.get(2).getSemesterGPA(); // calculated third semester GPA
		Calculator calculator = new Calculator(semesterList);
		double calculatedCumulativeGPA = calculator.getGPA();

		// the correct and calculated number of semesters are compared
		Assert.assertEquals(correctNumberOfSemesters, calculatedNumberOfSemesters);
		// the correct and calculated number of classes for semester one are compared
		Assert.assertEquals(correctNumberOfClassesSemester1, calculatedSemester1NumberOfClasses);
		// the correct and calculated number of classes for semester two are compared
		Assert.assertEquals(correctNumberOfClassesSemester2, calculatedSemester2NumberOfClasses);
		// the correct and calculated number of classes for semester three are compared
		Assert.assertEquals(correctNumberOfClassesSemester3, calculatedSemester3NumberOfClasses);

		// the correct and calculated semester name for semester one are compared
		Assert.assertEquals(correctSemester1Name, calculatedSemester1Name);
		// the correct and calculated semester name for semester two are compared
		Assert.assertEquals(correctSemester2Name, calculatedSemester2Name);
		// the correct and calculated semester name for semester three are compared
		Assert.assertEquals(correctSemester3Name, calculatedSemester3Name);

		// the correct and calculated class names are compared
		for (int i = 0; i < correctSemesterClassNames.size(); i++) {
			Assert.assertEquals(correctSemesterClassNames.get(i), calculatedSemesterClassNames.get(i));
		}
		// the correct and calculated class grades are compared
		for (int i = 0; i < correctSemesterClassGrades.size(); i++) {
			Assert.assertEquals(correctSemesterClassGrades.get(i), calculatedSemesterClassGrades.get(i));
		}
		// the correct and calculated first semester GPA are compared with an error
		// margin of 0.001
		Assert.assertEquals(correctSemester1GPA, calculatedSemester1GPA, 0.001);
		// the correct and calculated second semester GPA are compared with an error
		// margin of 0.001
		Assert.assertEquals(correctSemester2GPA, calculatedSemester2GPA, 0.001);
		// the correct and calculated third semester GPA are compared with an error
		// margin of 0.001
		Assert.assertEquals(correctSemester3GPA, calculatedSemester3GPA, 0.001);
		// the correct and calculated cumulative GPA are compared with an error margin
		// of 0.001
		Assert.assertEquals(correctCumulativeGPA, calculatedCumulativeGPA, 0.001);
	}

	/**
	 * This method tests the application for correct functionality when a new class
	 * line is encountered before a new semester line.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one empty semester
	 * list corresponding to the incorrectly formatted file.
	 */
	@Test
	void testParsing_ClassBeforeSemester_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testParsing_ClassBeforeSemester.txt");
		Controller applicationController = new Controller(fileNames, true);

		/*
		 * The master list of semester lists, maintained by the Controller (indexed by
		 * semester lists from each file processed) should contain one empty semester
		 * list corresponding to the incorrectly formatted file.
		 */
		ArrayList<ArrayList<Semester>> allFilesSemesterList = applicationController.getAllFilesSemesterList();
		ArrayList<Semester> semesterList = allFilesSemesterList.get(0);

		// correct information
		int correctNumberOfSemesters = 0; // correct number of semesters
		// calculated information
		int calculatedNumberOfSemesters = semesterList.size(); // calculated number of semesters

		// the correct and calculated number of semesters are compared
		Assert.assertEquals(correctNumberOfSemesters, calculatedNumberOfSemesters);

	}

	/**
	 * This method tests the application for correct functionality when there exists
	 * a new class line but no new semester lines.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one empty semester
	 * list corresponding to the incorrectly formatted file.
	 */
	@Test
	void testParsing_ClassNoSemesters_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testParsing_ClassNoSemesters.txt");
		Controller applicationController = new Controller(fileNames, true);

		/*
		 * The master list of semester lists, maintained by the Controller (indexed by
		 * semester lists from each file processed) should contain one empty semester
		 * list corresponding to the incorrectly formatted file.
		 */
		ArrayList<ArrayList<Semester>> allFilesSemesterList = applicationController.getAllFilesSemesterList();
		ArrayList<Semester> semesterList = allFilesSemesterList.get(0);

		// correct information
		int correctNumberOfSemesters = 0; // correct number of semesters
		// calculated information
		int calculatedNumberOfSemesters = semesterList.size(); // calculated number of semesters

		// the correct and calculated number of semesters are compared
		Assert.assertEquals(correctNumberOfSemesters, calculatedNumberOfSemesters);

	}

}
