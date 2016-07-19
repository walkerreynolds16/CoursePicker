package main;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;



public class Writer {

    private File path;
    private ArrayList<Schedule> schedules;
    
    private static Colour[] cols = {Colour.AQUA, Colour.GREEN, Colour.LAVENDER, Colour.LIGHT_ORANGE, Colour.IVORY, Colour.OCEAN_BLUE, Colour.RED, Colour.PINK, Colour.YELLOW, Colour.BLUE_GREY};
    

    public Writer(File file, ArrayList<Schedule> schedules) throws IOException, RowsExceededException, WriteException{
        this.setPath(file);
        this.schedules = schedules;
        createWorkbook();
        //createWorkbookTester();
        
    }
    
    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }
    
    
    public void createWorkbook() throws IOException, RowsExceededException, WriteException{
        WritableWorkbook book = Workbook.createWorkbook(path);
        
        for(int i = 0; i < schedules.size(); i++){
            WritableSheet sheet = book.createSheet("Sheet " + i, i);
            
            for(int k = 0; k < schedules.get(i).getClasses().size(); k++){
                Label lTemp = new Label(k, 1, schedules.get(i).getClasses().get(k).toString());
                sheet.addCell(lTemp);
            }
            
        }
        
        book.write();
        book.close();
        
        
    }
    
    public void createWorkbookTester() throws IOException, RowsExceededException, WriteException{
        WritableWorkbook book = Workbook.createWorkbook(path);
        
        for(int i = 0; i < 10; i++){
            WritableSheet sheet = book.createSheet("Sheet " + i, i);
            WritableCellFormat cellFormat = new WritableCellFormat();
            cellFormat.setBackground(cols[i]);
            
            Label l = new Label(i, 1, i +"" ,cellFormat);
            sheet.addCell(l);
        }
        
        book.write();
        book.close();
    }


    

}
