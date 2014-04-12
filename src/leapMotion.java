import javax.swing.UIManager;

import view.MainView;

/*
 * @ Project class is just the beginning of the project, it handles the task of initialising
 * the other relevant classes and get the work going.
 */
public class leapMotion {
	/*
	 * @ Main: Starting point of the project
	 */
	public static void main(String[] args) {
		try {
			  UIManager.setLookAndFeel(
			    UIManager.getSystemLookAndFeelClassName());
			} 
		catch (Exception e) {
			System.out.println("Unable to set the system look and feel");
		}
		
		new MainView();
	}
}
