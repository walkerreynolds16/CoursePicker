package main;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Class.
 * 
 * A Class is an individual course with an unique CRN (Course Registration
 * number). Classes also have Course Acronyms, Sections, Course Title, Credit
 * Hours, Area of LLC, Class Type, Days, Time, Location, Instructor, Seats
 * Available, and Status.
 */
public class Class {

	/** The course acro. */
	private String courseAcro = "";

	/** The Section. */
	private int section = 0;

	/** The course title. */
	private String courseTitle = "";

	/** The credit hours. */
	private String creditHours = "";

	/** The llc. */
	private String LLC = "";

	/** The class type. */
	private String classType = "";

	/** The days. */
	private String days = "";

	/** The time. */
	private String time = "";

	/** The location. */
	private String location = "";

	/** The instructor. */
	private String instructor = "";

	/** The seats available. */
	private int seatsAvailable = 0;

	/** The status. */
	private String status = "";

	/** The crn. */
	private int crn = 0;

	/**
	 * Instantiates a new class.
	 *
	 * @param crn the crn
	 * @param courseAcro the course acro
	 * @param section the section
	 * @param courseTitle the course title
	 * @param creditHours the credit hours
	 * @param LLC the llc
	 * @param classType the class type
	 * @param days the days
	 * @param time the time
	 * @param location the location
	 * @param instructor the instructor
	 * @param seatsAvailable the seats available
	 * @param status the status
	 */
	public Class(int crn, String courseAcro, int section, String courseTitle, String creditHours, String LLC,
			String classType, String days, String time, String location, String instructor, int seatsAvailable,
			String status) {
		
		this.crn = crn;
		this.courseAcro = courseAcro;
		this.section = section;
		this.courseTitle = courseTitle;
		this.creditHours = creditHours;
		this.LLC = LLC;
		this.classType = classType;
		this.days = days;
		this.time = time;
		this.location = location;
		this.instructor = instructor;
		this.seatsAvailable = seatsAvailable;
		this.status = status;
		
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
	public void setCourseAcro(String courseAcro){
		this.courseAcro = courseAcro;
	}

	/**
	 * Gets the crn.
	 *
	 * @return the crn
	 */
	public int getCRN() {
		return crn;
	}

	/**
	 * Sets the crn.
	 *
	 * @param crn
	 *            the new crn
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}

	/**
	 * Gets the section.
	 *
	 * @return the section
	 */
	public int getSection() {
		return section;
	}

	/**
	 * Sets the section.
	 *
	 * @param section
	 *            the new section
	 */
	public void setSection(int section) {
		this.section = section;
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
	 * @param courseTitle
	 *            the new course title
	 */
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	/**
	 * Gets the credit hours.
	 *
	 * @return the credit hours
	 */
	public String getCreditHours() {
		return creditHours;
	}

	/**
	 * Sets the credit hours.
	 *
	 * @param creditHours
	 *            the new credit hours
	 */
	public void setCreditHours(String creditHours) {
		this.creditHours = creditHours;
	}

	/**
	 * Gets the llc.
	 *
	 * @return the llc
	 */
	public String getLLC() {
		return LLC;
	}

	/**
	 * Sets the llc.
	 *
	 * @param lLC
	 *            the new llc
	 */
	public void setLLC(String lLC) {
		LLC = lLC;
	}

	/**
	 * Gets the class type.
	 *
	 * @return the class type
	 */
	public String getClassType() {
		return classType;
	}

	/**
	 * Sets the class type.
	 *
	 * @param classType
	 *            the new class type
	 */
	public void setClassType(String classType) {
		this.classType = classType;
	}

	/**
	 * Gets the days.
	 *
	 * @return the days
	 */
	public String getDays() {
		return days;
	}

	/**
	 * Sets the days.
	 *
	 * @param days
	 *            the new days
	 */
	public void setDays(String days) {
		this.days = days;
	}

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * Sets the time.
	 *
	 * @param time
	 *            the new time
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location
	 *            the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the instructor.
	 *
	 * @return the instructor
	 */
	public String getInstructor() {
		return instructor;
	}

	/**
	 * Sets the instructor.
	 *
	 * @param instructor
	 *            the new instructor
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	/**
	 * Gets the seats available.
	 *
	 * @return the seats available
	 */
	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	/**
	 * Sets the seats available.
	 *
	 * @param seatsAvailable
	 *            the new seats available
	 */
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
	    return status;
	}
	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString(){
	    return "Arco : " + courseAcro + " Section : " +section;
	}
	
	public boolean hasTwoTimes(Class temp){
	    Scanner dayScan = new Scanner(temp.getDays());
	    dayScan.useDelimiter("   ");
	    Scanner timeScan = new Scanner(temp.getTime());
	    timeScan.useDelimiter("   ");
	    
	    String days = dayScan.next();
	    String times = timeScan.next();
	    
	    if(days.contains(";") || times.contains(";")){
	        return true;
	    }else {
	        return false;
	    }
	}
	

}
