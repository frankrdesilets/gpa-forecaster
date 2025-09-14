package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.*;
import junit.framework.Assert;

/**
 * The following test cases test the application to ensure that incorrectly
 * formatted files are properly identified and handled.
 */
class TestFileFormatting {
	
	/* 
	 * *---*
	 * TEST CASES
	 * *---*
	 * 
	 * INCORRECT FORMATTING
	 * 
	 * 		testIncorrectFormat_NoFiles
	 * 		testIncorrectFormat_emptyFile_SingleFile
	 * 		testIncorrectFormat_emptyFile_MultipleFiles
	 * 		testIncorrectFormat_ClassLine_Notation_First_SingleFile
	 * 		testIncorrectFormat_ClassLine_Notation_Middle_SingleFile
	 * 		testIncorrectFormat_ClassLine_Notation_Last_SingleFile
	 * 		testIncorrectFormat_ClassLine_ClassInfo_First_SingleFile
	 * 		testIncorrectFormat_ClassLine_ClassInfo_Middle_SingleFile
	 * 		testIncorrectFormat_ClassLine_ClassInfo_Last_SingleFile
	 * 		testIncorrectFormat_ClassLine_ClassGrade_SingleFile
	 * 		testIncorrectFormat_SemesterLine_Notation_First_SingleFile
	 * 		testIncorrectFormat_SemesterLine_Notation_Middle_SingleFile
	 * 		testIncorrectFormat_SemesterLine_Notation_Last_SingleFile
	 * 		testIncorrectFormat_RandomText_SingleFile
	 */

	/**
	 * This method tests the application for correct functionality when the list of
	 * file names passed into the Controller is empty.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should be empty if there are no
	 * files to process.
	 */
	@Test
	void testIncorrectFormat_NoFiles() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>(); // empty file list
		Controller applicationController = new Controller(fileNames, 4.0, true);
		/*
		 * The master list (indexed by semester lists from each file processed) should
		 * be empty if there are no files to process.
		 */
		ArrayList<ArrayList<Semester>> allFilesSemesterList = applicationController.getAllFilesSemesterList();
		int correctListSize = 0;
		int calculatedListSize = allFilesSemesterList.size();

		Assert.assertEquals(correctListSize, calculatedListSize);
	}

	/**
	 * This method tests the application for correct functionality when there is one
	 * empty file in the list of file names passed into the Controller.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one empty semester
	 * list corresponding to the empty file.
	 */
	@Test
	void testIncorrectFormat_emptyFile_SingleFile() {

		/*
		 * A list of file names and a controller object are created.
		 */
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testIncorrectFormat_emptyFile.txt");
		Controller applicationController = new Controller(fileNames, 4.0,  true);
		/*
		 * The master list (indexed by semester lists from each file processed) should
		 * only contain one list, which should be empty; empty files are incorrectly
		 * formatted.
		 */
		ArrayList<ArrayList<Semester>> allFilesSemesterList = applicationController.getAllFilesSemesterList();
		int correctSemesterListSize = 0; // correct size
		int calculatedSemesterListSize = allFilesSemesterList.get(0).size(); // calculated size

		Assert.assertEquals(correctSemesterListSize, calculatedSemesterListSize);

	}

	/**
	 * This method tests the application for correct functionality when there are
	 * three empty files in the list of file names passed into the Controller.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain three empty semester
	 * list corresponding to the three empty files.
	 */
	@Test
	void testIncorrectFormat_emptyFile_MultipleFiles() {

		/*
		 * A list of file names and a controller object are created.
		 */
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testIncorrectFormat_emptyFile.txt");
		fileNames.add("testIncorrectFormat_emptyFile2.txt");
		fileNames.add("testIncorrectFormat_emptyFile3.txt");
		Controller applicationController = new Controller(fileNames, 4.0,  true);
		/*
		 * The master list (indexed by semester lists from each file processed) should
		 * be empty if there are no files to process.
		 */
		ArrayList<ArrayList<Semester>> allFilesSemesterList = applicationController.getAllFilesSemesterList();
		// correct size
		int correctSemesterListSize = 0;
		// calculated sizes
		int calculatedSemesterListSizeFile1 = allFilesSemesterList.get(0).size();
		int calculatedSemesterListSizeFile2 = allFilesSemesterList.get(1).size();
		int calculatedSemesterListSizeFile3 = allFilesSemesterList.get(2).size();

		Assert.assertEquals(correctSemesterListSize, calculatedSemesterListSizeFile1);
		Assert.assertEquals(correctSemesterListSize, calculatedSemesterListSizeFile2);
		Assert.assertEquals(correctSemesterListSize, calculatedSemesterListSizeFile3);

	}

	/**
	 * This method tests the application for correct functionality when there is an
	 * incorrectly formatted new class notation in the first of three new class
	 * lines.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one empty semester
	 * list corresponding to the incorrectly formatted file.
	 */
	@Test
	void testIncorrectFormat_ClassLine_Notation_First_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testIncorrectFormat_ClassLine_Notation_First.txt");
		Controller applicationController = new Controller(fileNames, 4.0,  true);

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
	 * This method tests the application for correct functionality when there is an
	 * incorrectly formatted new class notation in the second of three new class
	 * lines.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one empty semester
	 * list corresponding to the incorrectly formatted file.
	 */
	@Test
	void testIncorrectFormat_ClassLine_Notation_Middle_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testIncorrectFormat_ClassLine_Notation_Middle.txt");
		Controller applicationController = new Controller(fileNames, 4.0,  true);

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
	 * This method tests the application for correct functionality when there is an
	 * incorrectly formatted new class notation in the last of three new class
	 * lines.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one empty semester
	 * list corresponding to the incorrectly formatted file.
	 */
	@Test
	void testIncorrectFormat_ClassLine_Notation_Last_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testIncorrectFormat_ClassLine_Notation_Last.txt");
		Controller applicationController = new Controller(fileNames, 4.0,  true);

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
	 * This method tests the application for correct functionality when there is
	 * incorrectly formatted new class information in a new class line in the first
	 * of three new class lines.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one empty semester
	 * list corresponding to the incorrectly formatted file.
	 */
	@Test
	void testIncorrectFormat_ClassLine_ClassInfo_First_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testIncorrectFormat_ClassLine_ClassInfo_First.txt");
		Controller applicationController = new Controller(fileNames, 4.0,  true);

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
	 * This method tests the application for correct functionality when there is
	 * incorrectly formatted new class information in a new class line in the second
	 * of three new class lines.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one empty semester
	 * list corresponding to the incorrectly formatted file.
	 */
	@Test
	void testIncorrectFormat_ClassLine_ClassInfo_Middle_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testIncorrectFormat_ClassLine_ClassInfo_Middle.txt");
		Controller applicationController = new Controller(fileNames, 4.0,  true);

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
	 * This method tests the application for correct functionality when there is
	 * incorrectly formatted new class information in a new class line in the last
	 * of three new class lines.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one empty semester
	 * list corresponding to the incorrectly formatted file.
	 */
	@Test
	void testIncorrectFormat_ClassLine_ClassInfo_Last_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testIncorrectFormat_ClassLine_ClassInfo_Last.txt");
		Controller applicationController = new Controller(fileNames, 4.0,  true);

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
	 * This method tests the application for correct functionality when there an
	 * invalid class grade in a new class line.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one empty semester
	 * list corresponding to the incorrectly formatted file.
	 */
	@Test
	void testIncorrectFormat_ClassLine_ClassGrade_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testIncorrectFormat_ClassLine_ClassGrade.txt");
		Controller applicationController = new Controller(fileNames, 4.0,  true);

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
	 * This method tests the application for correct functionality when there is an
	 * incorrectly formatted new semester notation in the first of three new
	 * semester lines.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one empty semester
	 * list corresponding to the incorrectly formatted file.
	 */
	@Test
	void testIncorrectFormat_SemesterLine_Notation_First_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testIncorrectFormat_SemesterLine_Notation_First.txt");
		Controller applicationController = new Controller(fileNames, 4.0,  true);

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
	 * This method tests the application for correct functionality when there is an
	 * incorrectly formatted new semester notation in the second of three new
	 * semester lines.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one empty semester
	 * list corresponding to the incorrectly formatted file.
	 */
	@Test
	void testIncorrectFormat_SemesterLine_Notation_Middle_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testIncorrectFormat_SemesterLine_Notation_Middle.txt");
		Controller applicationController = new Controller(fileNames, 4.0,  true);

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
	 * This method tests the application for correct functionality when there is an
	 * incorrectly formatted new semester notation in the last of three new semester
	 * lines.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one empty semester
	 * list corresponding to the incorrectly formatted file.
	 */
	@Test
	void testIncorrectFormat_SemesterLine_Notation_Last_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testIncorrectFormat_SemesterLine_Notation_Last.txt");
		Controller applicationController = new Controller(fileNames, 4.0,  true);

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
	 * This method tests the application for correct functionality when there is
	 * random (incorrectly formatted) text.
	 * 
	 * The master list of semester lists, maintained by the Controller (indexed by
	 * semester lists from each file processed) should contain one empty semester
	 * list corresponding to the incorrectly formatted file.
	 */
	@Test
	void testIncorrectFormat_RandomText_SingleFile() {

		// A list of file names and a controller object are created
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("testIncorrectFormat_RandomText.txt");
		Controller applicationController = new Controller(fileNames, 4.0,  true);

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
