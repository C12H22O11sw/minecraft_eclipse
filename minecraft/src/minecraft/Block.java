package minecraft;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class Block {
	int x;
	int y;
	int type = 0;
		
	Block(int x, int y,int type){
		this.x = x;
		this.y = y;
		this.type = type;
	}
	void update(){
	
	}
	void draw(Graphics graphics){

		switch(type){
		case 0:graphics.setColor(Color.BLACK); break;
		case 1:graphics.setColor(Color.RED.darker()); break;
		case 2:graphics.setColor(Color.green.darker()); break;
		case 3:graphics.setColor(Color.BLUE); break;	
		case 4:graphics.setColor(Color.ORANGE.darker()); break;
		}	
		graphics.fillRect(((x+Actions.panX)*16), GameWindow.height - ((y+Actions.panY)*16), 16, 16);
		switch(type){
		case 0:graphics.setColor(Color.GRAY.darker()); break;
		case 1:graphics.setColor(Color.RED); break;
		case 2:graphics.setColor(Color.green); break;
		case 3:graphics.setColor(Color.BLUE); break;
		case 4:graphics.setColor(Color.ORANGE); break;
		}	
		graphics.fillRect(((x+Actions.panX)*16)+1, GameWindow.height- 1 - ((y+Actions.panY)*16), 14, 14);

	}
}

