package minecraft;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class Player {
	int x = 10;
	int y = 10;
	int type = 0;
	int placeBlock;
	int[] inventory = new int[10];
	Player(){

	}
	void update(){
		if(Actions.keyIsPressed){
			if(Actions.keyPressed == 'A' &&  GamePanel.blocks[x-1][y].type == 3){
				this.x--;	
			}else if(Actions.keyPressed == 'D' &&  GamePanel.blocks[x+1][y].type == 3){
				this.x++;
			}else if(Actions.keyPressed == 'A' &&  GamePanel.blocks[x-1][y+1].type == 3){
				this.x--;this.y++;
			}else if(Actions.keyPressed == 'D' &&  GamePanel.blocks[x+1][y+1].type == 3){
				this.x++;this.y++;
			}
			else if(Actions.keyPressed == ' '){
				this.y++;
			}
			if(Actions.mousePressed == true){
				GamePanel.blocks[Actions.mouseX/16][Actions.mouseY/16].type = 3;
				Actions.mousePressed = false;
				JOptionPane.showMessageDialog(null, "");
			}
			if(Actions.keyPressed == '1'){
				placeBlock = 1;
			}if(Actions.keyPressed == '2'){
				placeBlock = 2;
			}if(Actions.keyPressed == '3'){
				placeBlock = 3;
			}
			if(Actions.keyPressed == 'a'){
				GamePanel.blocks[x-1][y-1].type = placeBlock;//1	
			}else if(Actions.keyPressed == 'b'){
				GamePanel.blocks[x][y-1].type = placeBlock;//2		
			}else if(Actions.keyPressed == 'c'){
				GamePanel.blocks[x+1][y-1].type = placeBlock;//3	
			}else if(Actions.keyPressed == 'd'){
				GamePanel.blocks[x-1][y].type = placeBlock;//4	
			}else if(Actions.keyPressed == 'f'){
				GamePanel.blocks[x+1][y].type = placeBlock;//6	
			}else if(Actions.keyPressed == 'g'){
				GamePanel.blocks[x-1][y+1].type = placeBlock;//7		
			}else if(Actions.keyPressed == 'h'){
				GamePanel.blocks[x][y+1].type = placeBlock;//8		
			}else if(Actions.keyPressed == 'i'){
				GamePanel.blocks[x+1][y+1].type = placeBlock;//9		
			}

			Actions.keyIsPressed = false;
		}
		if(GamePanel.blocks[x][y-1].type == 3){
			y--;
		}
	}

	void draw(Graphics graphics){
		update();
		graphics.setColor(Color.gray);
		graphics.fillRect(x*16, 800 - (y*16), 16, 16);
		
	}
}

