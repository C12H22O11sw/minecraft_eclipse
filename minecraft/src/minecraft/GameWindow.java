package minecraft;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class GameWindow{
	static int width;
	static int height;
	
	JFrame frame;	GamePanel gamepanel;	Actions actions = new Actions();
	
	public static void main(String[] args) {
		GameWindow window = new GameWindow(1920,800);
	}
	GameWindow(int width, int height){
		this.width = width;
		this.height = height;
		frame = new JFrame();
		gamepanel = new GamePanel();
		frame.addKeyListener(actions);
		frame.add(gamepanel);
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	void update(){
		
	}

}
