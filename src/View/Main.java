package View;



import Controller.Controller;
import Model.DataBase;
import Tools.Constants;

public class Main {


	
	public static void main(String[] args)  { 
		int i=0;
		while(i++ < Constants.existingShows.length){
		ViewClient viewClient = new ViewClient("manger");
		viewClient.start();	
		
		}
		
	
	}
	
	
}
