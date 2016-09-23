package minecraft;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class Player {
	int x = 10;
	int y = 10;
	int type = 0;
		
	Player(){

	}
	void update(){
		if(Actions.keyIsPressed){
			if(Actions.keyPressed == 'A'){
				if(GamePanel.blocks[x+1][y+1].type == 3){
					if(GamePanel.blocks[x+1][y].type != 3){
						y++;
						JOptionPane.showMessageDialog(null,"auto-jump");
					}
					JOptionPane.showMessageDialog(null,"move");
					this.x--;
				}
			}
			else if(Actions.keyPressed == 'D'){
				if(GamePanel.blocks[x+1][y+1].type == 3){
					y++;
				}	
				this.x++;
			}
			else if(Actions.keyPressed == ' '){
				this.y++;
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

