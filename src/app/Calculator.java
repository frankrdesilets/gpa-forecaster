package app;

import java.util.ArrayList;

/**
 * An object of this class calculates the cumulative GPA for a list of semesters
 * (one input file).
 */
public class Calculator {

	private ArrayList<Semester> semesterList; // the semester list used to calculate cumulative GPA
	private double cumulativeGPA; // cumulative GPA

	/**
	 * The only constructor for this class accepts an ArrayList<Semester>
	 * semesterList as a parameter. It sets the cumulativeGPA member variable to the
	 * cumulative GPA value for every semester in the list.
	 * 
	 * @param semesterList
	 */
	public Calculator(ArrayList<Semester> semesterList) {
		this.semesterList = semesterList;
		this.cumulativeGPA = calculateGPA();
	}

	/**
	 * Calculates and returns the cumulative GPA value for all semesters in the
	 * list.
	 * 
	 * @return
	 */
	private double calculateGPA() {
		double runningPointTotal = 0;
		int classCount = 0;
		/*
		 * Because a Semester object keeps track of its current GPA, the cumulative GPA
		 * is calculated by adding the semester GPA of each Semester in the list and
		 * divided by the total number of semesters.
		 */
		for (int i = 0; i < semesterList.size(); i++) {
			Semester currentSemester = semesterList.get(i);
			runningPointTotal += currentSemester.getSemesterPoints();
			classCount += semesterList.get(i).getClassCount();
		}

		return runningPointTotal / classCount;
	}

	public double getGPA() {
		return cumulativeGPA;
	}

}
