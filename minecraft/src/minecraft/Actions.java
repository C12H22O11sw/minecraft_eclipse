package minecraft;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Actions implements KeyListener {
	static char keyPressed;
	static boolean keyIsPressed;
	Actions(){
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keyPressed = (char)e.getKeyCode();
		System.out.println(keyPressed);
		keyIsPressed = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
