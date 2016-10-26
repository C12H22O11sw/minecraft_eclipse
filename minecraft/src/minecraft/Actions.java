package minecraft;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Actions implements KeyListener, MouseListener {
	static char keyPressed;
	static boolean keyIsPressed;
	static boolean mousePressed;
	static int mouseX;
	static int mouseY;
	static long time;
	static int panX;
	static int panY;
	static boolean[][][] text = new boolean[10][3][5];

	{

		text[0][0][0] = true;
		text[0][1][0] = true;
		text[0][2][0] = true;
		text[0][0][1] = true;
		text[0][1][1] = false;
		text[0][2][1] = true;
		text[0][0][2] = true;
		text[0][1][2] = false;
		text[0][2][2] = true;
		text[0][0][3] = true;
		text[0][1][3] = false;
		text[0][2][3] = true;
		text[0][0][4] = true;
		text[0][1][4] = true;
		text[0][2][4] = true;

		text[1][0][0] = false;
		text[1][1][0] = true;
		text[1][2][0] = false;
		text[1][0][1] = true;
		text[1][1][1] = true;
		text[1][2][1] = false;
		text[1][0][2] = false;
		text[1][1][2] = true;
		text[1][2][2] = false;
		text[1][0][3] = false;
		text[1][1][3] = true;
		text[1][2][3] = false;
		text[1][0][4] = true;
		text[1][1][4] = true;
		text[1][2][4] = true;

		text[2][0][0] = true;
		text[2][1][0] = true;
		text[2][2][0] = true;
		text[2][0][1] = false;
		text[2][1][1] = false;
		text[2][2][1] = true;
		text[2][0][2] = true;
		text[2][1][2] = true;
		text[2][2][2] = true;
		text[2][0][3] = true;
		text[2][1][3] = false;
		text[2][2][3] = false;
		text[2][0][4] = true;
		text[2][1][4] = true;
		text[2][2][4] = true;

		text[3][0][0] = true;
		text[3][1][0] = true;
		text[3][2][0] = true;
		text[3][0][1] = false;
		text[3][1][1] = false;
		text[3][2][1] = true;
		text[3][0][2] = true;
		text[3][1][2] = true;
		text[3][2][2] = true;
		text[3][0][3] = false;
		text[3][1][3] = false;
		text[3][2][3] = true;
		text[3][0][4] = true;
		text[3][1][4] = true;
		text[3][2][4] = true;

		text[4][0][0] = false;
		text[4][1][0] = false;
		text[4][2][0] = true;
		text[4][0][1] = false;
		text[4][1][1] = true;
		text[4][2][1] = true;
		text[4][0][2] = true;
		text[4][1][2] = false;
		text[4][2][2] = true;
		text[4][0][3] = true;
		text[4][0][3] = true;
		text[4][2][3] = true;
		text[4][0][4] = false;
		text[4][1][4] = false;
		text[4][2][4] = true;

		text[5][0][0] = true;
		text[5][1][0] = true;
		text[5][2][0] = true;
		text[5][0][1] = true;
		text[5][1][1] = false;
		text[5][2][1] = false;
		text[5][0][2] = true;
		text[5][1][2] = true;
		text[5][2][2] = true;
		text[5][0][3] = false;
		text[5][1][3] = false;
		text[5][2][3] = true;
		text[5][0][4] = true;
		text[5][1][4] = true;
		text[5][2][4] = true;

		text[6][0][0] = true;
		text[6][1][0] = true;
		text[6][2][0] = true;
		text[6][0][1] = true;
		text[6][1][1] = false;
		text[6][2][1] = false;
		text[6][0][2] = true;
		text[6][1][2] = true;
		text[6][2][2] = true;
		text[6][0][3] = true;
		text[6][1][3] = false;
		text[6][2][3] = true;
		text[6][0][4] = true;
		text[6][1][4] = true;
		text[6][2][4] = true;

		text[7][0][0] = true;
		text[7][1][0] = true;
		text[7][2][0] = true;
		text[7][0][1] = false;
		text[7][1][1] = false;
		text[7][2][1] = true;
		text[7][0][2] = false;
		text[7][1][2] = false;
		text[7][2][2] = true;
		text[7][0][3] = false;
		text[7][1][3] = false;
		text[7][2][3] = true;
		text[7][0][4] = false;
		text[7][1][4] = false;
		text[7][2][4] = true;

		text[8][0][0] = true;
		text[8][1][0] = true;
		text[8][2][0] = true;
		text[8][0][1] = true;
		text[8][1][1] = false;
		text[8][2][1] = true;
		text[8][0][2] = true;
		text[8][1][2] = true;
		text[8][2][2] = true;
		text[8][0][3] = true;
		text[8][1][3] = false;
		text[8][2][3] = true;
		text[8][0][4] = true;
		text[8][1][4] = true;
		text[8][2][4] = true;

		text[9][0][0] = true;
		text[9][1][0] = true;
		text[9][2][0] = true;
		text[9][0][1] = true;
		text[9][1][1] = false;
		text[9][2][1] = true;
		text[9][0][2] = true;
		text[9][1][2] = true;
		text[9][2][2] = true;
		text[9][0][3] = false;
		text[9][1][3] = false;
		text[9][2][3] = true;
		text[9][0][4] = false;
		text[9][1][4] = false;
		text[9][2][4] = true;

	}

	Actions() {

	}

	static void drawInt(Graphics graphics, int x, int y, String display) {
		int digitValue = 0;
		graphics.setColor(Color.lightGray);
		for (int i = 0; i < display.length(); i++) {
			switch (display.charAt(i)) {
			case '0':
				digitValue = 0;
				break;
			case '1':
				digitValue = 1;
				break;
			case '2':
				digitValue = 2;
				break;
			case '3':
				digitValue = 3;
				break;
			case '4':
				digitValue = 4;
				break;
			case '5':
				digitValue = 5;
				break;
			case '6':
				digitValue = 6;
				break;
			case '7':
				digitValue = 7;
				break;
			case '8':
				digitValue = 8;
				break;
			case '9':
				digitValue = 9;
				break;
			}
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 5; k++) {
					if (text[digitValue][j][k])
						graphics.fillRect(j * 3 + x + (i * 12), k * 3 + y, 3, 3);
				}
			}
		}
	}
	static void displayGameOver(Graphics graphics){
//		graphics.setColor(Color.RED);
//		graphics.fillRect((1920-28*32)/2, (800-18*32)/2, 28*32, 18*32);
//		graphics.setColor(Color.WHITE);
//		graphics.fillRect((1920-26*32)/2, (800-16*32)/2, 26*32, 16*32);
		graphics.setColor(Color.RED.darker());
		graphics.fillRect((1920-24*32)/2, (800-12*32)/2, 1*32, 4*32);
		graphics.fillRect((1920-22*32)/2, (800-14*32)/2, 4*32, 1*32);
		graphics.fillRect((1920-22*32)/2, (800-4*32)/2, 4*32, 1*32);
		graphics.fillRect((1920-16*32)/2, (800-8*32)/2, 1*32, 2*32);
		graphics.fillRect((1920-18*32)/2, (800-8*32)/2, 1*32, 1*32);
		graphics.fillRect((1920-12*32)/2, (800-12*32)/2, 1*32, 5*32);
		graphics.fillRect((1920-4*32)/2, (800-12*32)/2, 1*32, 5*32);
		graphics.fillRect((1920-10*32)/2, (800-14*32)/2, 3*32, 1*32);
		graphics.fillRect((1920-10*32)/2, (800-8*32)/2, 3*32, 1*32);
		graphics.fillRect((1920)/2, (800-14*32)/2, 1*32, 6*32);
		graphics.fillRect((1920+8*32)/2, (800-14*32)/2, 1*32, 6*32);
		graphics.fillRect((1920+6*32)/2, (800-12*32)/2, 1*32, 1*32);
		graphics.fillRect((1920+4*32)/2, (800-10*32)/2, 1*32, 1*32);
		graphics.fillRect((1920+2*32)/2, (800-12*32)/2, 1*32, 1*32);
		graphics.fillRect((1920+12*32)/2, (800-14*32)/2, 1*32, 6*32);
		graphics.fillRect((1920+12*32)/2, (800-14*32)/2, 5*32, 1*32);
		graphics.fillRect((1920+12*32)/2, (800-10*32)/2, 5*32, 1*32);
		graphics.fillRect((1920+12*32)/2, (800-4*32)/2, 5*32, 1*32);
		graphics.fillRect((1920-20*32)/2, (800)/2, 3*32, 1*32);
		graphics.fillRect((1920-20*32)/2, (800+10*32)/2, 3*32, 1*32);
		graphics.fillRect((1920-22*32)/2, (800+2*32)/2, 1*32, 4*32);
		graphics.fillRect((1920-14*32)/2, (800+2*32)/2, 1*32, 4*32);
		graphics.fillRect((1920-20*32)/2, (800+10*32)/2, 3*32, 1*32);
		graphics.fillRect((1920-10*32)/2, (800)/2, 1*32, 3*32);
		graphics.fillRect((1920-8*32)/2, (800+6*32)/2, 1*32, 3*32);
		graphics.fillRect((1920-2*32)/2, (800)/2, 1*32, 3*32);
		graphics.fillRect((1920-4*32)/2, (800+6*32)/2, 1*32, 3*32);
		graphics.fillRect((1920-6*32)/2, (800+10*32)/2, 1*32, 1*32);
		graphics.fillRect((1920+2*32)/2, (800)/2, 1*32, 6*32);
		graphics.fillRect((1920+2*32)/2, (800)/2, 5*32, 1*32);
		graphics.fillRect((1920+2*32)/2, (800+4*32)/2, 5*32, 1*32);
		graphics.fillRect((1920+2*32)/2, (800+10*32)/2, 5*32, 1*32);
		graphics.fillRect((1920+14*32)/2, (800)/2, 1*32, 6*32);
		graphics.fillRect((1920+14*32)/2, (800)/2, 4*32, 1*32);
		graphics.fillRect((1920+22*32)/2, (800+2*32)/2, 1*32, 2*32);
		graphics.fillRect((1920+14*32)/2, (800+6*32)/2, 4*32, 1*32);
		graphics.fillRect((1920+18*32)/2, (800+8*32)/2, 1*32, 1*32);
		graphics.fillRect((1920+20*32)/2, (800+10*32)/2, 1*32, 1*32);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keyPressed = (char) e.getKeyCode();
		keyIsPressed = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mousePressed = true;
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}
