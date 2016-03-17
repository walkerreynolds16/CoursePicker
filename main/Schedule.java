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
    
    
}
