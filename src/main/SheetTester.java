package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class SheetTester {

	public static void main(String[] args) {
		Sheet sheet = null;
		Workbook wb = null;
		String inputCourse = "ACCT 201";
		Scanner scan = new Scanner(System.in);
		ArrayList<String> courses = new ArrayList<String>();
		
		
		try {
			wb = Workbook.getWorkbook(new File("schedules.xls"));
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		
		sheet = wb.getSheet("2016spring");
		
		courses.add(inputCourse);
		
		boolean foundCourse = false;
		
		int row = 1;
		while(!foundCourse){
			Cell tempCell = sheet.getCell(1,row);
			
			if(tempCell.getContents().equalsIgnoreCase(inputCourse)){
				int crn = Integer.parseInt(sheet.getCell(0, row).getContents());
				System.out.println("CRN: " + crn);

				String courseAcro = sheet.getCell(1, row).getContents();
				System.out.println("CourseAcro: " + courseAcro);
				
				int section = Integer.parseInt(sheet.getCell(2, row).getContents());
				System.out.println("Section: " + section);
				
				String title = sheet.getCell(3, row).getContents();
				System.out.println("Title: " + title);
				
				String creditHours = sheet.getCell(4, row).getContents();
				System.out.println("CreditHours: " + creditHours);
				
				String LLC = sheet.getCell(5, row).getContents();
				System.out.println("LLC: " + LLC);	
				
				String classType = sheet.getCell(6, row).getContents();
				System.out.println("ClassType: " + classType);
				
				String days = sheet.getCell(7, row).getContents();
				System.out.println("Days: " + days);
				
				String time = sheet.getCell(8, row).getContents();
				System.out.println("Time: " + time);
				
				String location = sheet.getCell(9, row).getContents();
				System.out.println("Location: " + location);
				
				String instructor = sheet.getCell(10, row).getContents();
				System.out.println("Instructor: " + instructor);
				
				int seatsAvailable = Integer.parseInt(sheet.getCell(11, row).getContents());
				System.out.println("SeatsAvailable: " + seatsAvailable);
				
				String status = sheet.getCell(12, row).getContents();
				System.out.println("Status: " + status + "\n");
				
				System.out.println("********************************************************\n");
				//classes.add(new Class(crn, courseAcro, section, title, creditHours, LLC, classType, days, time, location, instructor, seatsAvailable, status));
			}
			
			row++;
		}
		
		
		
	}
	
	

}
