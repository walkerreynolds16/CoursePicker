package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Main {

    public static Workbook schedule;

    public static Scanner inputScan = new Scanner(System.in);
    public static ArrayList<Course> courses = new ArrayList<Course>();
    public static ArrayList<String> inputedCourseAcros = new ArrayList<String>();
    public static ArrayList<Schedule> schedules = new ArrayList<Schedule>();

    public static void main(String[] args) {

        Sheet sheet = null;

        // Try catch statement to get the Workbook (Schedule Excel File) from
        // the directory
        try {
            schedule = Workbook.getWorkbook(new File("schedules.xls"));
        }
        catch (BiffException | IOException e) {
            e.printStackTrace();
        }

        // The year that the user inputs
        int year = getYear();

        // The semester that the user inputs
        String semester = getSemester();

        // Uses the getSheets method that finds the right sheet for the inputed
        // year and semester
        sheet = getSheet(semester, year);

        System.out.println("\nType all Course Acronym (Ex: Math 140), serperated by commas then press enter.");

        // this is a nextLine to make a new line, its weird, idk
        inputScan.nextLine();

        findAndAddCourses(sheet);

        sortCourses();
        
        schedules = createSchedules();
        
        checkTimes(schedules);
        
        for(int i = 0; i < schedules.size(); i++){
            ArrayList<Class> tempClasses = schedules.get(i).getClasses();
            System.out.println(tempClasses.toString());
        }
        System.out.println(schedules.size());
    }

    public static int getYear() {

        boolean hasYear = false;
        int year = 0;

        System.out.println("What year?");

        while (!hasYear) {

            try {
                year = inputScan.nextInt();

                if (year < 2015 || year > 2016) {
                    System.out.println(
                            "We do not have this year on record, please choose another.");
                }
                else {
                    hasYear = true;
                }

            }
            catch (InputMismatchException e) {
                System.out.println(
                        "You did not put in an applicable year, please put your year in the right way (i.e. 2016)");
                inputScan.nextLine();
                continue;
            }

        }

        return year;
    }

    public static String getSemester() {
        boolean hasSemester = false;
        String semester = "";

        System.out.println("What Semester?");

        while (!hasSemester) {

            semester = inputScan.next();

            if (!semester.equalsIgnoreCase("fall")
                    && !semester.equalsIgnoreCase("spring")) {
                System.out.println(
                        "We do not have that semester on record or you didn't type it in right, please try again.\n");
            }
            else {
                hasSemester = true;
            }

        }

        return semester;
    }

    public static Sheet getSheet(String semester, int year) {
        if (semester.equalsIgnoreCase("spring") && year == 2016) {
            return schedule.getSheet("2016spring");

            // System.out.println("Found 2016spring");
        }
        else if (semester.equalsIgnoreCase("fall") && year == 2015) {
            return schedule.getSheet("2015fall");

            // System.out.println("Found 2015fall");
        }
        else {
            return null;
        }
    }

    public static String superTrim(String string) {
        String str = string;

        for (int i = 1; i < str.length(); i++) {
            if (str.substring(i - 1, i).equals(" ")) {
                str = str.substring(i);
                i--;
            }
            else if (Character.isLetter(str.charAt(i))) {
                return str;
            }
        }

        return str;
    }
    
    public static void removeWhiteSpace(ArrayList<String> string){
        for(int i = 0; i < string.size(); i++){
            if(string.get(i).equals(" ")){
                string.remove(i);
                --i;
            }
        }
        
    }

    public static void findAndAddCourses(Sheet sheet) {
        String inputedCourses = inputScan.nextLine();

        Scanner coursesScan = new Scanner(inputedCourses);
        coursesScan.useDelimiter(",");

        while (coursesScan.hasNext()) {
            String temp = coursesScan.next();
            temp = superTrim(temp);
            inputedCourseAcros.add(temp);
        }
        coursesScan.close();

        boolean foundCourse = false;
        boolean noMoreCourses = false;

        for (int i = 0; i < inputedCourseAcros.size(); i++) {

            String inputCourse = inputedCourseAcros.get(i);
            foundCourse = false;
            noMoreCourses = false;
            int row = 1;
            ArrayList<Class> classes = new ArrayList<Class>();
            while (!foundCourse || !noMoreCourses) {

                try {
                    Cell tempCell = sheet.getCell(1, row);

                    if (tempCell.getContents().equalsIgnoreCase(inputCourse)) {
                        foundCourse = true;

                        int crn = Integer
                                .parseInt(sheet.getCell(0, row).getContents());
                        //System.out.println("CRN: " + crn);

                        String courseAcro = sheet.getCell(1, row)
                                .getContents();
                        //System.out.println("CourseAcro: " + courseAcro);

                        int section = Integer
                                .parseInt(sheet.getCell(2, row).getContents());
                        //System.out.println("Section: " + section);

                        String title = sheet.getCell(3, row).getContents();
                        //System.out.println("Title: " + title);

                        String creditHours = sheet.getCell(4, row)
                                .getContents();
                        //System.out.println("CreditHours: " + creditHours);

                        String LLC = sheet.getCell(5, row).getContents();
                        //System.out.println("LLC: " + LLC);

                        String classType = sheet.getCell(6, row).getContents();
                        //System.out.println("ClassType: " + classType);

                        String days = sheet.getCell(7, row).getContents();
                        //System.out.println("Days: " + days);

                        String time = sheet.getCell(8, row).getContents();
                        //System.out.println("Time: " + time);

                        String location = sheet.getCell(9, row).getContents();
                        //System.out.println("Location: " + location);

                        String instructor = sheet.getCell(10, row)
                                .getContents();
                        //System.out.println("Instructor: " + instructor);

                        int seatsAvailable = Integer.parseInt(
                                sheet.getCell(11, row).getContents());
                        //System.out.println("SeatsAvailable: " + seatsAvailable);

                        String status = sheet.getCell(12, row).getContents();
                        //System.out.println("Status: " + status + "\n");

                        //System.out.println("********************************************************\n");
                        classes.add(new Class(crn, courseAcro, section, title,
                                creditHours, LLC, classType, days, time,
                                location, instructor, seatsAvailable, status));

                    }
                    else if (foundCourse) {
                        noMoreCourses = true;
                        Course course = new Course(classes);
                        courses.add(course);
                    }
                    else {
                        foundCourse = false;
                    }

                    row++;
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Could not Find " + inputCourse
                            + ". Moving onto the next course.");
                    break;
                }
            }
        }

    }

    public static ArrayList<Schedule> createSchedules() {

        int[] array = new int[courses.size()];
        
        ArrayList<Schedule> combos = new ArrayList<Schedule>();
        
        
        int itemCount = 0;
        
        boolean isDone = false;
        
        while(!isDone){
            itemCount++;
            
            Class temp = null;
            ArrayList<Class> tempClasses = new ArrayList<Class>();
            for(int i = 0; i < courses.size(); i++){
                temp = courses.get(i).getClasses().get(array[i]);
                tempClasses.add(temp);
            }
            array[array.length-1]++;
            
            combos.add(new Schedule(tempClasses));
            
            if(array[array.length-1] >= courses.get(array.length-1).getClasses().size()){
                int count = array.length-1;
                boolean keepGoing = true;
                
                while(keepGoing){
                    if(count < 0){
                        System.out.println(itemCount);
                        return combos;
                    }else if(array[count] >= courses.get(count).getClasses().size()-1){
                        array[count] = 0;
                        count--;
                    }else{
                        array[count]++;
                        keepGoing = false;
                    }
                }
                
            }
            
        }
        
        
        
        return null;
     

    }

    public static boolean doTimesIntersect(Class one, Class two) {
       
        boolean doTimesIntersect = false;
        boolean doDaysIntersect = false;
        
        String classOneTime = one.getTime();
        String classOneDays = one.getDays();
        String classTwoTime = two.getTime();
        String classTwoDays = two.getDays();
        
        if(classOneTime.length() == 0 || classOneDays.length() == 0 || classTwoTime.length() == 0 || classTwoDays.length() == 0){
            return false;
        }
        
        Scanner oneScan = new Scanner(classOneTime);
        Scanner twoScan = new Scanner(classTwoTime);
        
        oneScan.useDelimiter("-");
        twoScan.useDelimiter("-");
        
        int oneStart = oneScan.nextInt();
        int oneEnd = oneScan.nextInt();
        
        int twoStart = twoScan.nextInt();
        int twoEnd = twoScan.nextInt();
        
        oneScan.close();
        twoScan.close();
        
        if(oneStart >= twoStart && oneStart <= twoEnd){
            doTimesIntersect = true;
        }else if(twoStart >= oneStart && twoStart <= oneEnd){
            doTimesIntersect = true;
        }else if(oneEnd >= twoStart && oneEnd <= twoEnd){
            doTimesIntersect = true;
        }else if(twoEnd >= oneStart && twoEnd <= oneEnd){
            doTimesIntersect = true;
        }else {
            return false;
        }
        
        
        
        ArrayList<String> oneDaysArray = new ArrayList<String>(Arrays.asList(classOneDays.split("")));
        ArrayList<String> twoDaysArray = new ArrayList<String>(Arrays.asList(classTwoDays.split("")));
        removeWhiteSpace(oneDaysArray);removeWhiteSpace(twoDaysArray);
        
        
        for(int i = 0; i < oneDaysArray.size(); i++){
           if(twoDaysArray.contains(oneDaysArray.get(i))){
               doDaysIntersect = true;
               break;
           }
        }
        
        if(doDaysIntersect && doTimesIntersect){
            return true;
        }else {
            return false;
        }
        
    }

    public static void sortCourses() {

        for (int i = 0; i < courses.size(); i++) {
            for (int k = 1; k < courses.size() - 1; k++) {
                if (courses.get(k).getAmountOfClasses() < courses.get(k - 1)
                        .getAmountOfClasses()) {
                    Course temp = courses.get(k);
                    courses.set(k, courses.get(k - 1));
                    courses.set(k - 1, temp);
                }
            }
        }

    }
    
    public static void checkTimes(ArrayList<Schedule> schedules){
        boolean keepGoing = true;
        
        for(int i = schedules.size()-1; i > 0 ; i--){
            
            for(int x = 0; x < schedules.get(i).getClasses().size(); x++){
                
                for(int y = x + 1; y < schedules.get(i).getClasses().size(); y++){
                    Class one = schedules.get(i).getClasses().get(x);
                    Class two = schedules.get(i).getClasses().get(y);
                    
                    if(doTimesIntersect(one, two)){
                        schedules.remove(i);
                        keepGoing = false;
                        break;
                    }
                }
                
                if(!keepGoing) break;
            }
            
        }

    }
}
