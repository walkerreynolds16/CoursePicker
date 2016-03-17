package main;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Course.
 */
public class Course {

	/** The classes. */
	private ArrayList<Class> classes;
	
	/** The course title. */
	private String courseTitle;
	
	/** The course acro. */
	private String courseAcro;
	
	private int amountOfClasses;
	
	
	/**
	 * Instantiates a new course.
	 *
	 * @param classes the classes
	 */
	public Course(ArrayList<Class> classes){
		this.setClasses(classes);
		
		courseTitle = classes.get(0).getCourseTitle();
		courseAcro = classes.get(0).getCourseAcro();
		amountOfClasses = classes.size();
		
	}


	/**
	 * Gets the course title.
	 *
	 * @return the course title
	 */
	public String getCourseTitle() {
		return courseTitle;
	}


	/**
	 * Sets the course title.
	 *
	 * @param courseTitle the new course title
	 */
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}


	/**
	 * Gets the course acro.
	 *
	 * @return the course acro
	 */
	public String getCourseAcro() {
		return courseAcro;
	}


	/**
	 * Sets the course acro.
	 *
	 * @param courseAcro the new course acro
	 */
	public void setCourseAcro(String courseAcro) {
		this.courseAcro = courseAcro;
	}


	/**
	 * Gets the classes.
	 *
	 * @return the classes
	 */
	public ArrayList<Class> getClasses() {
		return classes;
	}


	/**
	 * Sets the classes.
	 *
	 * @param classes the new classes
	 */
	public void setClasses(ArrayList<Class> classes) {
		this.classes = classes;
	}


	public int getAmountOfClasses() {
		return amountOfClasses;
	}


	public void setAmountOfClasses(int amountOfClasses) {
		this.amountOfClasses = amountOfClasses;
	}
	
	
}
