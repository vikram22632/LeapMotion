package view;

<<<<<<< HEAD

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MainView extends JFrame{
	
	private static final String BLUE_BTN_DOWN = "../../images/BLUE_DOWN.png";
	private static final String GREEN_BTN_DOWN = "../../images/GREEN_DOWN.png";
	private static final String RED_BTN_DOWN = "../../images/RED_DOWN.png";
	private static final String BLUE_BTN_UP = "../../images/BLUE_UP.png";
	private static final String GREEN_BTN_UP = "../../images/GREEN_UP.png";
	private static final String RED_BTN_UP = "../../images/RED_UP.png";
	
	private JFrame mainFrame;
	private JLabel leftLane;
	private JLabel midLane;
	private JLabel rightLane;
	
	public MainView() {
		try {
			leftLane.setIcon(new ImageIcon(ImageIO.read(new File(BLUE_BTN_UP))));
			midLane.setIcon(new ImageIcon(ImageIO.read(new File(GREEN_BTN_UP))));
			rightLane.setIcon(new ImageIcon(ImageIO.read(new File(RED_BTN_UP))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
=======
import javax.swing.JFrame;

public class MainView extends JFrame{
	
	public MainView() {
		
	}
}
>>>>>>> 9b0ebcc35055640bbec6c6dd413b879c4e8c5657
