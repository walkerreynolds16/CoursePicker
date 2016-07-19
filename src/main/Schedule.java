package main;

import java.util.ArrayList;

public class Schedule {

    private ArrayList<Class> classes;
    
    
    public Schedule(ArrayList<Class> classes){
        this.setClasses(classes);
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }
    
    public boolean equals(Object s2){
    	if(s2 instanceof Schedule){
    		if(((Schedule) s2).getClasses().equals(this.getClasses())){
    			return true;
    		}
    	}
    	
    	return false;
    }
}
