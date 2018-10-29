package View;


import Controller.Controller;
import Model.DataBase;
import Model.Show;

public class ViewClient extends Thread {
	private String manager;

	public ViewClient(String manger) {
		this.manager = manger;

	}
	
	/**
	 * rum method
	 */

	public void run() {

		Show show = new Show();
		boolean chekAdd = false;
		try {
			if (Controller.getController().getNumberOfShowsToSchedule() == 0) {     // if the shows is full 
				sleep(3000);
				Controller.getController().addRejectedShow(show);
				System.out
						.println("Sorry your show is added to the rejected shows program:\n "
								+ show.toString());

			} else {

				if (Controller.getController().addShow(show) == false) {   //if the show is exist 
					while (chekAdd == false
			
							
							&& Controller.getController()
									.getNumberOfShowsToSchedule() > 0) {
						sleep(2000);
						show = new Show();
						
						chekAdd = Controller.getController().addShow(show);
						if (chekAdd == true) {     //new show after sleep
							System.out
									.println("Your show is added after sleep to Shows Program:\n"
											+ show.toString()+"\n");

						}
						if (Controller.getController()
								.getNumberOfShowsToSchedule() == 0) {   // add rejected show
							sleep(3000);
							Controller.getController().addRejectedShow(show);
							System.out
									.println("Sorry your show is added to the rejected shows program:\n "
											+ show.toString()+"\n");

						}

						else {
							System.out
									.println("your show is in the program go to sleep for 2 sec and try later!!\n");

						}
					}
				} else {    //add normal show s
					System.out
							.println("nice your show is added to Shows program:\n "
									+ show.toString()+"\n");

				}
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		

	}

}
