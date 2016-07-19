package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import jxl.write.WriteException;

public class MethodTester {
	
	

	public static void main(String[] args) throws IOException, WriteException {
		
		Class classOne = new Class(	0, "CPSC 270", 1, null, null, null, null, "MW", "1600-1715", null, null, 0, null);
		Class classTwo = new Class(	0, "CPSC 270", 2, null, null, null, null, "TR", "1330-1445", null, null, 0, null);
		
		Class classThree = new Class(0, "ENGR 213", 1, null, null, null, null, "TR", "1630-1745", null, null, 0, null);
		Class classFour = new Class(0, "ENGR 213", 2, null, null, null, null, "TR", "1800-1915", null, null, 0, null);
		
//		System.out.println(doTimesIntersect(classOne, classThree));
//		System.out.println(doTimesIntersect(classOne, classFour));
//		System.out.println(doTimesIntersect(classTwo, classThree));
//		System.out.println(doTimesIntersect(classTwo, classFour));
		
		ArrayList<Class> one = new ArrayList<Class>();
		one.add(classOne);
		one.add(classTwo);
		Schedule s1 = new Schedule(one);
		
		ArrayList<Class> two = new ArrayList<Class>();
		two.add(classOne);
		two.add(classTwo);
		Schedule s2 = new Schedule(two);
		
		System.out.println(s1.equals(s2));
	}
	
	public static int factorial(int n){
		int sum = 1;
		
		for(int i = n; i > 0; i--){
			sum *= i;
		}
		
		return sum;
		
	}

	public static ArrayList<String> createCombinations(ArrayList<ArrayList<String>> chars) {

		int[] array = new int[chars.size()];

		ArrayList<String> combos = new ArrayList<String>();

		int itemCount = 0;

		boolean isDone = false;

		while (!isDone) {
			itemCount++;

			String temp = "";
			for (int i = 0; i < chars.size(); i++) {
				temp += chars.get(i).get(array[i]);
			}
			array[array.length - 1]++;
			combos.add(temp);

			if (array[array.length - 1] >= chars.get(array.length - 1).size()) {
				int count = array.length - 1;
				boolean keepGoing = true;

				while (keepGoing) {
					if (count < 0) {
						System.out.println(itemCount);
						return combos;
					} else if (array[count] >= chars.get(count).size() - 1) {
						array[count] = 0;
						count--;
					} else {
						array[count]++;
						keepGoing = false;
					}
				}

			}

		}

		return null;

	}

	public static String superTrim(String string) {
		String str = string;

		for (int i = 1; i < str.length(); i++) {
			if (str.substring(i - 1, i).equals(" ")) {
				str = str.substring(i);
				i--;
			} else if (Character.isLetter(str.charAt(i))) {
				return str;
			}
		}

		return str;
	}

	public static void removeWhiteSpace(ArrayList<String> string) {
		for (int i = 0; i < string.size(); i++) {
			if (string.get(i).equals(" ")) {
				string.remove(i);
				--i;
			}
		}

	}

	public static void removeWhiteSpace(String str) {
		str.replaceAll("\\s+", "");
	}

	public static void makeCombs(ArrayList<String> perms, ArrayList<String> classes, int k, int count){
    	for(int i = k; i < classes.size(); i++){
            java.util.Collections.swap(classes, i, k);
            makeCombs(perms, classes, k+1, count++);
            java.util.Collections.swap(classes, k, i);
        }
        if (k == classes.size() -1){
        	String temp = Arrays.toString(classes.toArray());
        	temp = temp.substring(1, temp.length()-1);
            perms.add(temp);
            
        }
    	
    	
    }
	
	public static boolean doTimesIntersect(Class one, Class two) {
       
        
        if(one.hasTwoTimes() || two.hasTwoTimes()){
            return doTimesIntersectSpecial(one, two);
        }
        
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

	public static boolean doTimesIntersectSpecial(Class one, Class two){
    
    boolean dontCreate = false;
    
    if(one.hasTwoTimes() && two.hasTwoTimes()){
        
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
        
        oneScan.useDelimiter(";");
        twoScan.useDelimiter(";");
        
        String oneFirstTimeTemp = oneScan.next();
        String oneSecondTimeTemp = oneScan.next(); 
        String oneFirstTime = oneFirstTimeTemp.replaceAll("\\s","");
        String oneSecondTime = oneSecondTimeTemp.replaceAll("\\s","");
        oneFirstTimeTemp = "";
        oneSecondTimeTemp = "";
        
        String twoFirstTimeTemp = twoScan.next();
        String twoSecondTimeTemp = twoScan.next();
        String twoFirstTime = twoFirstTimeTemp.replaceAll("\\s","");
        String twoSecondTime = twoSecondTimeTemp.replaceAll("\\s","");
        twoFirstTimeTemp = "";
        twoSecondTimeTemp = "";
        
        classOneTime = "";
        classTwoTime = "";
        
        Scanner oneFirstScan = new Scanner(oneFirstTime);
        Scanner oneSecondScan = new Scanner(oneSecondTime);
        Scanner twoFirstScan = new Scanner(twoFirstTime);
        Scanner twoSecondScan = new Scanner(twoSecondTime);
        oneFirstScan.useDelimiter("-"); oneSecondScan.useDelimiter("-"); twoFirstScan.useDelimiter("-"); twoSecondScan.useDelimiter("-");
        
        
        int oneFirstStart = Integer.parseInt(oneFirstScan.next()); 
        int oneFirstEnd = Integer.parseInt(oneFirstScan.next()); 
        int oneSecondStart = Integer.parseInt(oneSecondScan.next()); 
        int oneSecondEnd = Integer.parseInt(oneSecondScan.next());
        int twoFirstStart = Integer.parseInt(twoFirstScan.next()); 
        int twoFirstEnd = Integer.parseInt(twoFirstScan.next()); 
        int twoSecondStart = Integer.parseInt(twoSecondScan.next()); 
        int twoSecondEnd = Integer.parseInt(twoSecondScan.next());
        
        oneFirstScan.close(); oneSecondScan.close(); twoSecondScan.close(); twoFirstScan.close();
        
        
        if(oneFirstStart >= twoFirstStart && oneFirstStart <= twoFirstEnd){
            doTimesIntersect = true;
        }else if(twoFirstStart >= oneFirstStart && twoFirstStart <= oneFirstEnd){
            doTimesIntersect = true;
        }else if(oneFirstEnd >= twoFirstStart && oneFirstEnd <= twoFirstEnd){
            doTimesIntersect = true;
        }else if(twoFirstEnd >= oneFirstStart && twoFirstEnd <= oneFirstEnd){
            doTimesIntersect = true;
        }else if(oneSecondStart >= twoSecondStart && oneSecondStart <= twoSecondEnd){
            doTimesIntersect = true;
        }else if(twoSecondStart >= oneSecondStart && twoSecondStart <= oneSecondEnd){
            doTimesIntersect = true;
        }else if(oneSecondEnd >= twoSecondStart && oneSecondEnd <= twoSecondEnd){
            doTimesIntersect = true;
        }else if(twoSecondEnd >= oneSecondStart && twoSecondEnd <= oneSecondEnd){
            doTimesIntersect = true;
        }
        
        
        ArrayList<String> oneDaysArray = new ArrayList<String>(Arrays.asList(classOneDays.split("")));
        ArrayList<String> twoDaysArray = new ArrayList<String>(Arrays.asList(classTwoDays.split("")));
        removeWhiteSpace(oneDaysArray);removeWhiteSpace(twoDaysArray);
        
        if(doTimesIntersect){
            dontCreate = true;
        }
        
    }else if(one.hasTwoTimes()){
        
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
        
        oneScan.useDelimiter(";");
        
        
        String oneFirstTimeTemp = oneScan.next();
        String oneSecondTimeTemp = oneScan.next(); 
        String oneFirstTime = oneFirstTimeTemp.replaceAll("\\s","");
        String oneSecondTime = oneSecondTimeTemp.replaceAll("\\s","");
        oneFirstTimeTemp = "";
        oneSecondTimeTemp = "";
        
        classOneTime = "";
        
        Scanner oneFirstScan = new Scanner(oneFirstTime);
        Scanner oneSecondScan = new Scanner(oneSecondTime);
        
        oneFirstScan.useDelimiter("-"); oneSecondScan.useDelimiter("-"); 
        twoScan.useDelimiter("-");
        
        
        int oneFirstStart = Integer.parseInt(oneFirstScan.next()); 
        int oneFirstEnd = Integer.parseInt(oneFirstScan.next()); 
        int oneSecondStart = Integer.parseInt(oneSecondScan.next()); 
        int oneSecondEnd = Integer.parseInt(oneSecondScan.next());
        int twoFirstStart = Integer.parseInt(twoScan.next()); 
        int twoFirstEnd = Integer.parseInt(twoScan.next()); 
        
        
        oneFirstScan.close(); oneSecondScan.close(); twoScan.close(); 
        
        if(oneFirstStart >= twoFirstStart && oneFirstStart <= twoFirstEnd){
            doTimesIntersect = true;
        }else if(twoFirstStart >= oneFirstStart && twoFirstStart <= oneFirstEnd){
            doTimesIntersect = true;
        }else if(oneFirstEnd >= twoFirstStart && oneFirstEnd <= twoFirstEnd){
            doTimesIntersect = true;
        }else if(twoFirstEnd >= oneFirstStart && twoFirstEnd <= oneFirstEnd){
            doTimesIntersect = true;
        }else if(oneSecondStart >= twoFirstStart && oneSecondStart <= twoFirstEnd){
            doTimesIntersect = true;
        }else if(oneSecondEnd >= twoFirstStart && oneSecondEnd <= twoFirstEnd){
            doTimesIntersect = true;
        }
        
        
        ArrayList<String> oneDaysArray = new ArrayList<String>(Arrays.asList(classOneDays.split("")));
        ArrayList<String> twoDaysArray = new ArrayList<String>(Arrays.asList(classTwoDays.split("")));
        removeWhiteSpace(oneDaysArray);removeWhiteSpace(twoDaysArray);
        
        for(int i = 0; i < twoDaysArray.size(); i++){
            for(int k = 0; k < oneDaysArray.size(); k++){
                
                if(oneDaysArray.get(k).equalsIgnoreCase(twoDaysArray.get(i))){
                    doDaysIntersect = true;
                }
            }
        }
        
        
        if(doTimesIntersect && doDaysIntersect){
            dontCreate = true;
        }
        
        
        
    }else {//if two has two times
        
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
        
        twoScan.useDelimiter(";");
        
        
        String twoFirstTimeTemp = twoScan.next();
        String twoSecondTimeTemp = twoScan.next(); 
        String twoFirstTime = twoFirstTimeTemp.replaceAll("\\s","");
        String twoSecondTime = twoSecondTimeTemp.replaceAll("\\s","");
        twoFirstTimeTemp = "";
        twoSecondTimeTemp = "";
        
        classTwoTime = "";
        
        Scanner twoFirstScan = new Scanner(twoFirstTime);
        Scanner twoSecondScan = new Scanner(twoSecondTime);
        
        twoFirstScan.useDelimiter("-"); twoSecondScan.useDelimiter("-"); 
        oneScan.useDelimiter("-");
        
        
        int twoFirstStart = Integer.parseInt(twoFirstScan.next()); 
        int twoFirstEnd = Integer.parseInt(twoFirstScan.next()); 
        int twoSecondStart = Integer.parseInt(twoSecondScan.next()); 
        int twoSecondEnd = Integer.parseInt(twoSecondScan.next());
        int oneFirstStart = Integer.parseInt(oneScan.next()); 
        int oneFirstEnd = Integer.parseInt(oneScan.next()); 
        
        
        twoFirstScan.close(); twoSecondScan.close(); oneScan.close(); 
        
        if(oneFirstStart >= twoFirstStart && oneFirstStart <= twoFirstEnd){
            doTimesIntersect = true;
        }else if(twoFirstStart >= oneFirstStart && twoFirstStart <= oneFirstEnd){
            doTimesIntersect = true;
        }else if(oneFirstEnd >= twoFirstStart && oneFirstEnd <= twoFirstEnd){
            doTimesIntersect = true;
        }else if(twoFirstEnd >= oneFirstStart && twoFirstEnd <= oneFirstEnd){
            doTimesIntersect = true;
        }else if(twoSecondStart >= oneFirstStart && twoSecondStart <= oneFirstEnd){
            doTimesIntersect = true;
        }else if(twoSecondEnd >= oneFirstStart && twoSecondEnd <= oneFirstEnd){
            doTimesIntersect = true;
        }
        
        
        ArrayList<String> oneDaysArray = new ArrayList<String>(Arrays.asList(classOneDays.split("")));
        ArrayList<String> twoDaysArray = new ArrayList<String>(Arrays.asList(classTwoDays.split("")));
        removeWhiteSpace(oneDaysArray);removeWhiteSpace(twoDaysArray);
        
        for(int i = 0; i < oneDaysArray.size(); i++){
            for(int k = 0; k < twoDaysArray.size(); k++){
                
                if(oneDaysArray.get(i).equalsIgnoreCase(twoDaysArray.get(k))){
                    doDaysIntersect = true;
                }
            }
        }
        
        
        if(doTimesIntersect && doDaysIntersect){
            dontCreate = true;
        }
    }
    
  return dontCreate;
    
}

}
