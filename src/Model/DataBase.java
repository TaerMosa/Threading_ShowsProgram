package Model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Tools.Constants;

/* This class represents data base model to 
 * be accessed via clients
 */
public class DataBase extends Thread {

	// Scheduled shows
	private List<Show> shows;
	// Rejected shows
	private List<Show> rejectedShows;
	// TODO - Complete this variable: Can be changed
	private volatile int  numberOfShowsToSchedule;
	// Singleton
	private static DataBase _db;

	// Singleton method
	public static DataBase getDatabase() {

		if (_db == null)
			_db = new DataBase();
		return _db;
	}

	// Class constructor
	private DataBase() {

	

		this.shows = new ArrayList<Show>();
		this.rejectedShows = new ArrayList<Show>();
		this.numberOfShowsToSchedule = Constants.maxNumberOfShows;

			
	}

	/**
	 * Done
	 * 
	 * @param show
	 * @return true /false
	 * @throws InterruptedException
	 * @throws Exception
	 */

	// Add show
	public boolean addShow(Show show) throws InterruptedException {
synchronized (shows) {
	
			for (int i = 0; i < this.shows.size(); i++) {
				
				if (shows.get(i).compareTo(show)==0||shows.get(i).getName()==show.getName()) {
					return false;
				}
			}
			//give him some time about 1 sec to update numberofshowstoschedule and for the output
			
				this.numberOfShowsToSchedule--;
				shows.wait(1000);
				this.shows.add(show);
				return true;
	}
		


	}

	/**
	 * Done
	 * 
	 * @param show
	 * @return true / false
	 * @throws InterruptedException 
	 */
	// Add rejected show
	public boolean addRejectedShow(Show show)  {
	synchronized (rejectedShows) {

			if (show != null) {
				this.rejectedShows.add(show);
				
				return true;
			}
		}
		return false;

	}

	// Get the number of shows to schedule
	public  int getNumberOfShowsToSchedule() {
		return numberOfShowsToSchedule;
	}
	
	

	/**
	 * print shows list
	 */
	public void printShows(){
		System.out.println("---------------------------------");
		System.out.println("Shows Schedule:");
		System.out.println("---------------------------------");
		Collections.sort(shows);
		for(int i=1;i<=shows.size();i++){
			System.out.println(i+")"+shows.get(i).toString());
		}
	}
	
	public void printrejectedshows(){
		System.out.println("---------------------------------");
		System.out.println("rejected shows Schedule:");
		System.out.println("---------------------------------");
		for(int i=1;i<=rejectedShows.size();i++){
			System.out.println(i+")"+rejectedShows.get(i).toString());
		}
	}
	
}
