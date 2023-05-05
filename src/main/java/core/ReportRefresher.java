package core;

import java.io.FileNotFoundException;

import javax.annotation.processing.FilerException;

public class ReportRefresher{
    private Tracker tracker;
    private String path;
    private Report report;
    public ReportRefresher(String path, Report reportObservable){
        this.path = path;
        this.report = reportObservable;
    }
    public void refreshReport()  {
    	
    	ReportResult report;
        try {
    	report = this.tracker.find(this.path);
    	this.report.set(report);
    	}
        catch(FileNotFoundException e) {
        	System.out.println(e.getMessage());
        	System.out.println(e.getStackTrace());
        }
        catch(FilerException e) {
        	System.out.println(e.getMessage());
        	System.out.println(e.getStackTrace());
        }
       
       
    	
    }
    
    public void setTracker(Tracker tracker) {
    	this.tracker = tracker;
    }
}
