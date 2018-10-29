package Controller;


import Model.DataBase;
import Model.Show;

public class Controller extends Thread  {

	private static Controller controller;
	
	
	public static Controller getController(){
		
		if(controller == null)
			controller = new Controller();
		
		
		return controller;
	}
    
	
	public  synchronized boolean addShow(Show show) throws Exception{
		
		return DataBase.getDatabase().addShow(show);
	}
	
	public synchronized  boolean addRejectedShow(Show show) throws InterruptedException{
		
		return DataBase.getDatabase().addRejectedShow(show);
	}
	
	public  synchronized int getNumberOfShowsToSchedule() throws InterruptedException{
		
		return DataBase.getDatabase().getNumberOfShowsToSchedule();
	}
	
}
