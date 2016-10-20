package minecraft;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player {
	static int x = 10;
	static int y = 10;
	int placeBlockType;
	int[] inventory = new int[10];
	
	Player() {

	}

	/*
	 * instuctions
	 * 
	 * press a to move to the left and d for the right. use the number pad to
	 * place/destroy blocks press 3 to destroy blocks and 2 or 1 to place them.
	 * 
	 */
	void placeBlock(int x, int y, int type) {
		if (inventory[type] > 0 || type == 3) {
			if (type == 3)
				inventory[GamePanel.blocks[this.x + x][this.y + y].type]++;

			GamePanel.blocks[this.x + x][this.y + y].type = type;// 1
			System.out.println("0:" + inventory[0] + "; 1:" + inventory[1] + "; 2:" + inventory[2]);
			inventory[type]--;
		}
	}

	void update() {
		Actions.time++;
		if (Actions.keyIsPressed) {
			if (Actions.keyPressed == 'A' && GamePanel.blocks[x - 1][y].type == 3) {
				this.x--;
			} else if (Actions.keyPressed == 'D' && GamePanel.blocks[x + 1][y].type == 3) {
				this.x++;
			} else if (Actions.keyPressed == 'A' && GamePanel.blocks[x - 1][y + 1].type == 3) {
				this.x--;
				this.y++;
			} else if (Actions.keyPressed == 'D' && GamePanel.blocks[x + 1][y + 1].type == 3) {
				this.x++;
				this.y++;
			} else if (Actions.keyPressed == ' ') {
				this.y++; 
			}

			switch (Actions.keyPressed) {

			// block switching controls
			case '0':
				placeBlockType = 0;
				break;
			case '1':
				placeBlockType = 1;
				break;
			case '2':
				placeBlockType = 2;
				break;
			case '3':
				placeBlockType = 3;
				break;

			// block placing controls
			case 'a':
				placeBlock(-1, -1, placeBlockType);
				break;
			case '#':
				placeBlock(-1, -1, placeBlockType);
				break;
			case 'b':
				placeBlock(0, -1, placeBlockType);
				break;			
			case '(':
				placeBlock(0, -1, placeBlockType);
				break;
			case 'c':
				placeBlock(1, -1, placeBlockType);
				break;
			case '"':
				placeBlock(1, -1, placeBlockType);
				break;
			case 'd':
				placeBlock(-1, 0, placeBlockType);
				break;
			case '%':
				placeBlock(-1, 0, placeBlockType);
				break;
			case 'f':
				placeBlock(1, 0, placeBlockType);
				break;
			case (char)39:
				placeBlock(1, 0, placeBlockType);
				break;
			case 'g':
				placeBlock(-1, 1, placeBlockType);
				break;
			case '$':
				placeBlock(-1, 1, placeBlockType);
				break;
			case 'h':
				placeBlock(0, 1, placeBlockType);
				break;
			case '&':
				placeBlock(0, 1, placeBlockType);
				break;
			case 'i':
				placeBlock(1, 1, placeBlockType);
				break;
			case '!':
				placeBlock(1, 1, placeBlockType);
				break;

			}

			Actions.keyIsPressed = false;
		}

		if (GamePanel.blocks[x][y - 1].type == 3 || GamePanel.blocks[x][y - 1].type == 1) {
			y--;
		}
	}
	double eyebrowY;
	void draw(Graphics graphics) {
		eyebrowY=Math.sin(Actions.time/50)*3;
		update();
		graphics.setColor(Color.cyan);
		graphics.fillRect(x * 16, (GameWindow.height - (y * 16)), 16, 16);
		if(Actions.time*Actions.time/2%200>10)
			graphics.setColor(Color.BLACK);
		graphics.fillRect(x * 16+3, GameWindow.height - (y * 16)+5, 3, 3);
		graphics.fillRect(x * 16+10, GameWindow.height - (y * 16)+5, 3, 3);

		graphics.setColor(Color.GRAY.darker());
		graphics.fillRect((GameWindow.width-500)/2,GameWindow.height - 100, 500, 50);
		graphics.setColor(Color.gray);
		graphics.fillRect((GameWindow.width-500)/2 - 1, GameWindow.height - 101, 498, 48);

		
		graphics.setColor(Color.black);
		graphics.fillRect((GameWindow.width/2) - 241, GameWindow.height-91, 32, 32);
		graphics.setColor(Color.GRAY.darker());
		graphics.fillRect((GameWindow.width/2) - 242, GameWindow.height-92, 30, 30);
		Actions.drawInt(graphics, (GameWindow.width/2) - 232, GameWindow.height-82,inventory[0]+"");
		
		graphics.setColor(Color.red.darker());
		graphics.fillRect((GameWindow.width/2) - 191, GameWindow.height-91, 32, 32);
		graphics.setColor(Color.red);
		graphics.fillRect((GameWindow.width/2) - 192, GameWindow.height-92, 30, 30);
		Actions.drawInt(graphics, (GameWindow.width/2) - 182, GameWindow.height-82,inventory[1]+"");		
		
		graphics.setColor(Color.green.darker());
		graphics.fillRect((GameWindow.width/2) - 141, GameWindow.height-91, 32, 32);
		graphics.setColor(Color.green);
		graphics.fillRect((GameWindow.width/2) - 142, GameWindow.height-92, 30, 30);
		Actions.drawInt(graphics, (GameWindow.width/2) - 132, GameWindow.height-82,inventory[2]+"");	}
}
