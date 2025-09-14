package app;

import java.util.ArrayList;

/**
 * This class contains the main method of the application. The names of files to
 * process are added to a list and passed into a Controller object.
 */
public class GPAForecaster {

	/**
	 * The main method creates a collection of file names, which is then passed into
	 * a controller object, which calculates and prints a GPA report to the console
	 * for each file in the collection.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * File names added to this list will be loaded and a GPA report will be printed
		 * to the console.
		 */
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames.add("SampleSingleSemester.txt");
		fileNames.add("SampleMultipleSemesters.txt");
		
		// the target GPA to match scenarios against
		final double TARGET_GPA = 3.4;

		/*
		 * A Controller object calculates and prints a report to the console for each
		 * file in the collection.
		 * 
		 * The boolean value represents whether a list of files being run is for testing
		 * purposes. It enables the application to look in the correct package for the
		 * file. If true, reports are not printed.
		 * 
		 */
		Controller applicationController = new Controller(fileNames, TARGET_GPA, false);

	}

}
