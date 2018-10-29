package Model;

import java.util.ArrayList;
import java.util.Random;

import Tools.Constants;

public class Show  implements Comparable<Show>  {
	
	private int startTime;
	
	private String name;
	
	private int showindex;
	
	
	public Show(int startTime, String name) {
		this.startTime = startTime;
		this.name = name;
		
	}
	/**
	 * another constructor returns random show object
	 */
	public  Show(){
		this.randomShow();
	}
	


	public int getStartTime() {
		return startTime;
	}


	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return show index in the existing show array 
	 */
	public int getindexshow(){
		return showindex;
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Show other = (Show) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	public int compareTo(Show arg0) {
		
		return this.startTime - arg0.startTime;
	}
	/**
	 * 
	 * @return random show with random start time and index for name 
	 */
	
	public   Show randomShow() {
		
		Random rand= new Random();
		int showTime=rand.nextInt(Constants.maxHour)+8;
		int showName=rand.nextInt(16);
		this.showindex=showName;
		this.startTime=showTime;
		this.name=Constants.existingShows[this.showindex];
		return new Show(this.startTime,this.name);
	
	}

	@Override
	/**
	 * show to string 
	 */
	public String toString() {
		int endTime=this.startTime+1;
		return "Show [startTime=" + startTime +":00"+" ,End Time="+endTime+":00"+" ,name=" + name + "]";
	}
	
	
}
