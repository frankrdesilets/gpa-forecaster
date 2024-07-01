package app;

/**
 * An object of this class represents a class taken in a semester. Class
 * information encapsulated includes the class name, grade, and associated
 * semester.
 */
public class Class {

	private String name;
	private Grade letterGrade;
	private Semester semester;

	/**
	 * The only constructor for this class accepts a String name, Grade grade, and
	 * Semester semester as parameters and appropriately sets member variables.
	 * 
	 * @param name
	 * @param grade
	 * @param semester
	 */
	public Class(String name, Grade grade, Semester semester) {

		this.name = name;
		this.letterGrade = grade;
		this.semester = semester;

	}

	@Override
	public String toString() {
		return this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grade getLetterGrade() {
		return letterGrade;
	}

	public void setLetterGrade(Grade letterGrade) {
		this.letterGrade = letterGrade;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

}
