package controller;

import view.MainView;

import com.leapmotion.leap.*;

public class LeapMotionListener extends Listener implements Runnable{
	 	
		public LeapMotionListener(MainView view) {
			cmdToCtrllr = 0;
			this.view = view;
			
			System.out.println("Starting the leap motion listener");
			animeThd = new Thread(this, "animation thread");
			animeThd.start();
		}
	
		public void onInit(Controller controller) {
	        System.out.println("Initialized");
	    }

	    public void onConnect(Controller controller) {
	        System.out.println("Connected");
	        //controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
	        controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
	    }

	    public void onDisconnect(Controller controller) {
	        //Note: not dispatched when running in a debugger.
	        System.out.println("Disconnected");
	    }
	    
	    public void onExit(Controller controller) {
	        System.out.println("Exited");
	    }
	    
	    public void onFrame(Controller controller) {
	    	 // Get the most recent frame and report some basic information
	        Frame frame = controller.frame();
	        System.out.println("Frame id: " + frame.id()
	                         + ", timestamp: " + frame.timestamp()
	                         + ", hands: " + frame.hands().count()
	                         + ", fingers: " + frame.fingers().count()
	                         + ", tools: " + frame.tools().count()
	                         + ", gestures " + frame.gestures().count());
	        
	        if (!frame.fingers().isEmpty()) {
	        	/* Checking for hand too, since gestures are not always coming for the fingers */
	        	FingerList fingers = frame.fingers();
	        	if(fingers.count() == 1) {
	        		command(PT_LEFT);
	        	} else if(fingers.count() == 2) {
	        		command(PT_MIDDLE);
	        	} else {
	        		command(PT_RIGHT);
	        	}
	        }

	        GestureList gestures = frame.gestures();
	        for (int i = 0; i < gestures.count(); i++) {
	            Gesture gesture = gestures.get(i);

	            switch (gesture.type()) {

	                case TYPE_KEY_TAP:
	                    KeyTapGesture keyTap = new KeyTapGesture(gesture);

	                    if(keyTap.position().getX() < -25){
	                    	System.out.println("Finger 1="+keyTap.position().getX());
	                    	command(PT_LEFT);
	                    }
	                    else if(keyTap.position().getX() >= -25  && keyTap.position().getX() < 20){
	                    	System.out.println("Finger 2="+keyTap.position().getX());
	                    	command(PT_MIDDLE);
	                    }
	                    else{
	                    	System.out.println("Finger 3 ="+keyTap.position().getX());
	                    	command(PT_RIGHT);
	                    }
	                    break;
	                default:
	                    //System.out.println("Unknown gesture type.");
	                    break;
	            }
	        }

	    }
	    
		/*
		 * @ Thread function, the controller runs as a separate thread controlling the GUI and 
		 * receiving commands from the leap listener
		 */
		public void run() {
			int cmd = 0;
			
			System.out.println("Thread starts working");
			
			while(true) {
				cmd = command(0);
				if(cmd == PT_LEFT) {
					/* Set the left button of the UI screen */
					view.showLeftBtnClick();
				}
				else if(cmd == PT_RIGHT) {
					/* Set the right button of the UI screen */
					view.showRightBtnClick();
				}
				else if(cmd == PT_MIDDLE) {
					/* Set the middle button of the UI screen */
					view.showMiddleBtnClick();
				}
			}
		}
		
		/*
		 * @ This function would be called by the leap listener for commanding the program controller
		 */
		private synchronized int command(int iCmd) {
			int cmd = 0;
			
			if(animeThd == Thread.currentThread()) {
				if(cmdToCtrllr == 0) {
					try {
						wait();
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				cmd = cmdToCtrllr;
				cmdToCtrllr = 0;
			}
			else {
				cmdToCtrllr = iCmd;
				notify();
			}
			
			return cmd;
		}
		
		private Thread animeThd;
		private int cmdToCtrllr;
		private MainView view;
	    
		public static final int PT_LEFT = 1;
		public static final int PT_MIDDLE = 2;
		public static final int PT_RIGHT = 3;

}
