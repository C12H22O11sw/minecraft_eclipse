package minecraft;

import javax.swing.JFrame;

public class GameWindow {
	int width;
	int height;
	JFrame frame;
	GamePanel gamepanel;
	public static void main(String[] args) {
		GameWindow window = new GameWindow(1080,800);
	}
	GameWindow(int width, int height){
		this.width = width;
		this.height = height;
		frame = new JFrame();
		gamepanel = new GamePanel();
		frame.add(gamepanel);
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	void update(){
	}

}
