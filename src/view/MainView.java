package view;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfugue.Pattern;
import org.jfugue.Player;

public class MainView extends JFrame{
	
	public MainView() {
		JPanel panel = new JPanel(null);
		leftLane = new JLabel();
		midLane = new JLabel();
		rightLane = new JLabel();
		
		try {
			leftLane.setIcon(new ImageIcon(ImageIO.read(new File(IMG_PATH + RED_BTN_UP))));
			leftLane.setBounds(0, 0, 350, 350);
			
			midLane.setIcon(new ImageIcon(ImageIO.read(new File(IMG_PATH + GREEN_BTN_UP))));
			midLane.setBounds(350, 0, 350, 350);
			
			rightLane.setIcon(new ImageIcon(ImageIO.read(new File(IMG_PATH + BLUE_BTN_UP))));
			rightLane.setBounds(700, 0, 350, 350);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		/* Add the images */
		panel.add(leftLane, BorderLayout.PAGE_START);
		panel.add(midLane, BorderLayout.CENTER);
		panel.add(rightLane, BorderLayout.PAGE_END);
		
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1050, 380);
		setVisible(true);
		setResizable(false);
		
		soundPlayer = new Player();
		leftBtnSound = new Pattern("A");
		middleBtnSound = new Pattern("E");
		rightBtnSound = new Pattern("C7h");
	}
	
	public void showLeftBtnClick() {
		try {
			leftLane.setIcon(new ImageIcon(ImageIO.read(new File(IMG_PATH + RED_BTN_DOWN))));
			soundPlayer.play(leftBtnSound);
			//Thread.sleep(10);
			leftLane.setIcon(new ImageIcon(ImageIO.read(new File(IMG_PATH + RED_BTN_UP))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showMiddleBtnClick() {
		try {
			midLane.setIcon(new ImageIcon(ImageIO.read(new File(IMG_PATH + GREEN_BTN_DOWN))));
			soundPlayer.play(middleBtnSound);
			//Thread.sleep(10);
			midLane.setIcon(new ImageIcon(ImageIO.read(new File(IMG_PATH + GREEN_BTN_UP))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showRightBtnClick() {
		try {
			rightLane.setIcon(new ImageIcon(ImageIO.read(new File(IMG_PATH + BLUE_BTN_DOWN))));
			soundPlayer.play(rightBtnSound);
			//Thread.sleep(10);
			rightLane.setIcon(new ImageIcon(ImageIO.read(new File(IMG_PATH + BLUE_BTN_UP))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private JLabel leftLane;
	private JLabel midLane;
	private JLabel rightLane;
	private Player soundPlayer;
	private Pattern leftBtnSound;
	private Pattern middleBtnSound;
	private Pattern rightBtnSound;
	
	private static final String BLUE_BTN_DOWN = "BLUE_DOWN.jpg";
	private static final String BLUE_BTN_UP = "BLUE_UP.jpg";
	
	private static final String GREEN_BTN_DOWN = "GREEN_DOWN.jpg";
	private static final String GREEN_BTN_UP = "GREEN_UP.jpg";
	
	private static final String RED_BTN_DOWN = "RED_DOWN.jpg";
	private static final String RED_BTN_UP = "RED_UP.jpg";
	private static final String IMG_PATH = "images/";
}