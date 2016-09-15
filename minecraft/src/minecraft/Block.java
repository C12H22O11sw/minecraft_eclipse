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
		case 0:graphics.setColor(Color.red); break;
		case 2:graphics.setColor(Color.green); break;
		case 3:graphics.setColor(Color.blue); break;		
		}	
		graphics.fillRect(x, 800 - y, 16, 16);
		graphics.setColor(Color.black);
		graphics.drawRect(x, 800-y, 16, 16);
	}
}

