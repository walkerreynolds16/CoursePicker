package main;

import java.util.ArrayList;
import java.util.Scanner;

public class MethodTester {

    public static void main(String[] args) {

        boolean doIntersect = false;
        String one = "0800-1000";
        String two = "0930-1045";
        
        Scanner oneScan = new Scanner(one);
        Scanner twoScan = new Scanner(two);
        
        oneScan.useDelimiter("-");
        twoScan.useDelimiter("-");
        
        int oneStart = oneScan.nextInt();
        int oneEnd = oneScan.nextInt();
        
        int twoStart = twoScan.nextInt();
        int twoEnd = twoScan.nextInt();
        
        if(oneStart >= twoStart && oneStart <= twoEnd){
            doIntersect = true;
        }else if(twoStart >= oneStart && twoStart <= oneEnd){
            doIntersect = true;
        }else if(oneEnd >= twoStart && oneEnd <= twoEnd){
            doIntersect = true;
        }else if(twoEnd >= oneStart && twoEnd <= oneEnd){
            doIntersect = true;
        }
        
        System.out.println(doIntersect);

    }

    public static ArrayList<String> createCombinations(ArrayList<ArrayList<String>> chars) {
        
        int[] array = new int[chars.size()];
        
        ArrayList<String> combos = new ArrayList<String>();
        
        int itemCount = 0;
        
        boolean isDone = false;
        
        while(!isDone){
            itemCount++;
            
            String temp = "";
            for(int i = 0; i < chars.size(); i++){
                temp += chars.get(i).get(array[i]);
            }
            array[array.length-1]++;
            combos.add(temp);
            
            if(array[array.length-1] >= chars.get(array.length-1).size()){
                int count = array.length-1;
                boolean keepGoing = true;
                
                while(keepGoing){
                    if(count < 0){
                        System.out.println(itemCount);
                        return combos;
                    }else if(array[count] >= chars.get(count).size()-1){
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

}
