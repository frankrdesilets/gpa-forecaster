package app;

import java.util.ArrayList;

/**
 * An object of this class holds information pertaining to a semester of school,
 * including the semester name, classes, and semester GPA.
 */
public class Semester {

	private String semesterName; // the semester name
	private ArrayList<Class> classList; // a list of all classes taken in a semester
	private int classCount; // the number of classes taken in a semester
	private double semesterPoints; // the semester GPA (updated in real time)

	/*
	 * These values represent the point value for each possible letter grade.
	 */
	private final double A_PLUS_POINTVALUE = 4.0;
	private final double A_POINTVALUE = 4.0;
	private final double A_MINUS_POINTVALUE = 3.667;
	private final double B_PLUS_POINTVALUE = 3.333;
	private final double B_POINTVALUE = 3.0;
	private final double B_MINUS_POINTVALUE = 2.667;
	private final double C_PLUS_POINTVALUE = 2.333;
	private final double C_POINTVALUE = 2.0;
	private final double C_MINUS_POINTVALUE = 1.667;
	private final double D_PLUS_POINTVALUE = 1.333;
	private final double D_POINTVALUE = 1.0;
	private final double D_MINUS_POINTVALUE = 0.667;
	private final double F_POINTVALUE = 0.0;

	/**
	 * The only constructor for this class accepts a String semesterName as a
	 * parameter and appropriately sets member variables.
	 * 
	 * @param semesterName
	 */
	public Semester(String semesterName) {

		this.semesterName = semesterName;
		this.classList = new ArrayList<>();
		this.classCount = 0;
		this.semesterPoints = 0;

	}

	/**
	 * Adds a class to the semester. After every insertion, the total class count
	 * and semester GPA are updated.
	 * 
	 * @param classToAdd
	 */
	public void addClass(Class classToAdd) {

		classList.add(classToAdd); // the class is added to the class list
		classCount++; // the number of classes in the semester is incremented
		updateSemesterGPA(); // the semester GPA for the semester is updated

	}

	/**
	 * Updates the semester GPA.
	 * 
	 * @param classToAdd
	 */
	private void updateSemesterGPA() {

		double runningPointTotal = 0;
		/*
		 * The semester GPA is calculated by adding the grade point values of each class
		 * and dividing by the total number of classes.
		 */
		for (int i = 0; i < classList.size(); i++) {
			runningPointTotal += letterGradeToPointValue(classList.get(i).getLetterGrade());
		}
		this.semesterPoints = runningPointTotal;

	}

	/**
	 * Returns the grade point value in the form of a double for a Grade. For
	 * example, Grade.A would yield a point value of 4.0;
	 * 
	 * @param grade
	 * @return
	 */
	private double letterGradeToPointValue(Grade grade) {
		switch (grade) {
		case A_PLUS:
			return this.A_PLUS_POINTVALUE;
		case A:
			return this.A_POINTVALUE;
		case A_MINUS:
			return this.A_MINUS_POINTVALUE;
		case B_PLUS:
			return this.B_PLUS_POINTVALUE;
		case B:
			return this.B_POINTVALUE;
		case B_MINUS:
			return this.B_MINUS_POINTVALUE;
		case C_PLUS:
			return this.C_PLUS_POINTVALUE;
		case C:
			return this.C_POINTVALUE;
		case C_MINUS:
			return this.C_MINUS_POINTVALUE;
		case D_PLUS:
			return this.D_PLUS_POINTVALUE;
		case D:
			return this.D_POINTVALUE;
		case D_MINUS:
			return this.D_MINUS_POINTVALUE;
		case F:
			return this.F_POINTVALUE;
		default:
			return -1;
		}
	}

	@Override
	public String toString() {
		return this.semesterName;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String name) {
		this.semesterName = name;
	}

	public ArrayList<Class> getClasses() {
		return classList;
	}

	public int getClassCount() {
		return classCount;
	}

	public double getSemesterPoints() {
		return semesterPoints;
	}

}
