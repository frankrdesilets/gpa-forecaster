package app;

import java.util.ArrayList;

/**
 * An object of this class calculates and prints a GPA report to the console for
 * each file in a collection of files passed in.
 */
public class Controller {

	/*
	 * Used for testing. Each index corresponds to a semester list from one file.
	 */
	private ArrayList<ArrayList<Semester>> allFilesSemesterList;

	/**
	 * The only constructor for this class accepts an ArrayList<String> filesToRun
	 * and a boolean isTest as parameters. For every file in the list, a GPA report
	 * will be calculated and printed to the console. If isTest is true, reports
	 * will not be printed.
	 * 
	 * @param filesToRun
	 * @param isTest
	 */
	public Controller(ArrayList<String> filesToRun, double targetGPA, boolean isTest) {

		this.allFilesSemesterList = new ArrayList<>();

		/*
		 * If the file list, filesToRun, is empty, further processing is not attempted.
		 */
		if ((filesToRun.isEmpty()) && (!isTest)) {
			System.out.println("No files found in input list.");
			return;
		}

		/*
		 * The FileLoader object's purpose is to parse an appropriately formatted .txt
		 * file, and load and return an ArrayList<Semester> for that file.
		 */
		FileLoader loader = new FileLoader();

		/*
		 * The Reporter object's purpose is to calculate and print a GPA report on a
		 * file to the console.
		 */
		Reporter reporter = new Reporter();

		// every file in filesToRun is processed, and generated and printed a report to
		// the console
		for (int i = 0; i < filesToRun.size(); i++) {
			String currentFile = filesToRun.get(i); // the current file is retrieved from filesToRun
			/*
			 * The file is parsed via the FileLoader object and the list of semesters,
			 * semesterList, for that file is returned.
			 */
			ArrayList<Semester> semesterList = loader.loadFile(currentFile, isTest);
			this.allFilesSemesterList.add(semesterList); // each file's semester list is added to a master list for
															// testing
			/*
			 * If the semester list is empty, meaning the file was not properly formatted, a
			 * report is not printed, nor is it printed if isTest is true.
			 */
			if (!semesterList.isEmpty() && (!isTest)) {
				/*
				 * A GPA report is printed to the console for the currently processed file in
				 * the filesToRun via the Reporter object.
				 */
				reporter.report(semesterList, currentFile, targetGPA);
			}
		}
	}

	/**
	 * Used for testing, returns the list of ArrayList<Semester> generated for each
	 * file processed.
	 * 
	 * @return
	 */
	public ArrayList<ArrayList<Semester>> getAllFilesSemesterList() {
		return allFilesSemesterList;
	}

}
