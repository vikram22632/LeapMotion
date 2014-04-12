package controller;

import com.leapmotion.leap.*;

import view.MainView;

public class ProjController extends Controller{
	/*
	 * @ Constructor of the class
	 */
	public ProjController(MainView view) {
		addListener(new LeapMotionListener(view));
		getBlocked();
	}
	
	private synchronized void getBlocked() {
		try {
			wait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
