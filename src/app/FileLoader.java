package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * An object of this class populates a list of Semester objects by parsing an
 * appropriately structured text file.
 * 
 * Incorrectly formatted files are not processed.
 */
public class FileLoader {

	public FileLoader() {
	}

	/**
	 * Populates and returns a list of semesters by parsing a .txt file. The file is
	 * first checked for correct formatting; incorrectly formatted files are not
	 * processed.
	 * 
	 * @param fileName
	 * @return
	 */
	public ArrayList<Semester> loadFile(String fileName, boolean isTest) {

		/*
		 * This list is populated with semesters encountered in the file, which is then
		 * returned for further use by other objects (ex. Reporter, Calculator).
		 * 
		 * It is returned empty if the file is incorrectly formatted.
		 */
		ArrayList<Semester> semesterList = new ArrayList<>();

		/*
		 * The file is checked for correct formatting to prevent errors with parsing. If
		 * incorrectly formatted, the semester list is returned empty and further
		 * processing is not attempted.
		 */
		if (!isCorrectFormat(fileName, isTest)) {
			if (!isTest) {
				System.out.println("File format incorrect for: " + fileName);
				System.out.println();
				System.out.println();
			}
			return semesterList;
		}

		try {

			/*
			 * The file location is specified, depending on whether the file is being run
			 * regularly or for testing.
			 */
			File currentFile;
			if (isTest) {
				currentFile = new File("src/testfiles/" + fileName);
			} else {
				currentFile = new File("src/inputfiles/" + fileName);
			}

			// FileReaders are created to parse each line of the file
			FileReader fileReader = new FileReader(currentFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			/*
			 * currentLine represents the current line being processed in the file. It is
			 * set to be the first line of the file, to begin processing.
			 */
			String currentLine = bufferedReader.readLine();
			Semester newSemester = new Semester(null);

			// lines in the file are processed until an empty line is reached
			while (currentLine != null) {
				/*
				 * Lines starting with 's' denote a new semester. Every line following a new
				 * semester line, beginning with 'c', are added to that semester until a new
				 * semester line is reached.
				 */
				if (currentLine.charAt(0) == 's') {
					if (!(newSemester.getSemesterName() == null)) {
						semesterList.add(newSemester); // the previous semester is added to the list
					}
					/*
					 * A new semester is created and a new line is read. The beginning 's' notation
					 * is removed prior to naming a new semester.
					 */
					newSemester = new Semester(currentLine.replaceFirst("s ", ""));
					currentLine = bufferedReader.readLine();
				}
				/*
				 * If the new line is empty, indicating that the end of the file has been
				 * reached, the current semester is added to the list and the list is returned.
				 */
				if (currentLine == null) {
					semesterList.add(newSemester);
					return semesterList;
				}
				/*
				 * Every new class line following a new semester, denoted with 'c', is parsed
				 * and the respective information is used to create a new class, which is then
				 * added to the current semester. The loop runs until a line does not have the
				 * 'c' notation, indicating that a new semester line has been reached.
				 */
				while ((currentLine.charAt(0) == 'c')) {
					/*
					 * The beginning 'c' notation is removed prior to splitting the name and grade.
					 */
					currentLine = currentLine.replaceFirst("c ", "");
					String[] parsedClass = currentLine.split("[,]"); // the current line is split around delimiter ','
					// a new class is created with information parsed from the current line
					Class newClass = new Class(parsedClass[0], getEnumValue(parsedClass[1]), newSemester);
					newSemester.addClass(newClass); // the new class is added to the current semester
					/*
					 * A new line is read. If the new line is empty, indicating that the end of the
					 * file has been reached, the current semester is added to the list and the list
					 * is returned.
					 */
					currentLine = bufferedReader.readLine();
					if (currentLine == null) {
						semesterList.add(newSemester);
						return semesterList;
					}

				}
			}
			// the reader is closed
			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println();
		} finally {
		}

		return semesterList;
	}

	/**
	 * Scans a file to ensure correct formatting to prevent errors with processing.
	 * 
	 * There are two acceptable line formats in an input file:
	 * 
	 * s semesterName c className,classGrade
	 * 
	 * 
	 * where s denotes a new semester, and c denotes a new class.
	 * 
	 * The set of acceptable classGrade values are: {A+, A, A-, B+, B, B-, C+, C,
	 * C-, D+, D, D-, F}/ Spaces are considered, and as such the below line is
	 * incorrectly formatted:
	 * 
	 * c className, classGrade ^ incorrect space
	 * 
	 * 
	 * @param fileName
	 * @param isTest
	 * @return
	 */
	private boolean isCorrectFormat(String fileName, boolean isTest) {

		try {

			/*
			 * The file location is specified, depending on whether the file is being run
			 * regularly or for testing.
			 */
			File currentFile;
			if (isTest) {
				currentFile = new File("src/testfiles/" + fileName);
			} else {
				currentFile = new File("src/inputfiles/" + fileName);
			}

			// FileReaders are created to parse each line of the file
			FileReader fileReader = new FileReader(currentFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			/*
			 * currentLine represents the current line being processed in the file. It is
			 * set to be the first line of the file, to begin processing.
			 */
			String currentLine = bufferedReader.readLine();

			// the file is not formatted correctly if the first line is empty
			if (currentLine == null) {
				return false;
			}
			// the file is not formatted correctly if the first line is not a new semester
			if ((currentLine.charAt(0) != 's')) {
				return false;
			}
			// every line in the file is processed, until an empty line is reached
			while (currentLine != null) {
				// the current line must start with 's' or 'c', to indicate a new semester or
				// class
				if ((currentLine.charAt(0) == 's') || (currentLine.charAt(0) == 'c')) {
					// the current line must have a space following 's' or 'c'
					if (currentLine.charAt(1) == ' ') {
						/*
						 * The line is parsed to remove the 's' or 'c' notations, and the line is split
						 * around delimiter ',' .
						 */
						String modifiedLine = currentLine.replaceAll("s ", "");
						modifiedLine = modifiedLine.replaceAll("c ", "");
						String[] parsedLine = modifiedLine.split("[,]");
						/*
						 * If the current line is a new class line, array String[] parsedLine must have
						 * only two Strings, indicating the presence of a name and grade.
						 */
						if ((currentLine.charAt(0) == 'c') && (parsedLine.length != 2)) {
							return false;
						}
						/*
						 * If the current line is a new class line, the grade value must be valid. Using
						 * a private method, getEnumValue(), the String is checked for a Grade
						 * representation and if none exists, it is not valid.
						 */
						if (currentLine.charAt(0) == 'c') {
							Grade classGrade = getEnumValue(parsedLine[1]);
							if (!classGrade.equals(Grade.UNKNOWN)) {

							} else {
								return false;
							}
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
				currentLine = bufferedReader.readLine();
			}
			// the reader is closed
			bufferedReader.close();
			fileReader.close();
			
		} catch (IOException e) {
		} finally {
		}
		return true;
	}

	/**
	 * Matches String representations of a class grade parsed from a new class line
	 * to their Grade counterpart.
	 * 
	 * @param toMatch
	 * @return
	 */
	private Grade getEnumValue(String toMatch) {

		switch (toMatch) {
		case "A+":
			return Grade.A_PLUS;
		case "A":
			return Grade.A;
		case "A-":
			return Grade.A_MINUS;
		case "B+":
			return Grade.B_PLUS;
		case "B":
			return Grade.B;
		case "B-":
			return Grade.B_MINUS;
		case "C+":
			return Grade.C_PLUS;
		case "C":
			return Grade.C;
		case "C-":
			return Grade.C_MINUS;
		case "D+":
			return Grade.D_PLUS;
		case "D":
			return Grade.D;
		case "D-":
			return Grade.D_MINUS;
		case "F":
			return Grade.F;
		default:
			return Grade.UNKNOWN;
		}
	}

}
