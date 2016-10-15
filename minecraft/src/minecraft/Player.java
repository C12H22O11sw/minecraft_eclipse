package minecraft;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	int x = 10;
	int y = 10;
	int type = 0;
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

		if (GamePanel.blocks[x][y - 1].type == 3) {
			y--;
		}
	}

	void draw(Graphics graphics) {
		update();
		graphics.setColor(Color.gray);
		graphics.fillRect(x * 16, 800 - (y * 16), 16, 16);

		graphics.setColor(Color.GRAY.darker());
		graphics.fillRect(290, 700, 500, 50);
		graphics.setColor(Color.gray);
		graphics.fillRect(290 - 1, 700 - 1, 498, 48);

		

		graphics.fillRect(299, 709, 32, 32);
		graphics.setColor(Color.GRAY.darker());
		graphics.fillRect(298, 708, 30, 30);
		Actions.drawInt(graphics, 303, 726,inventory[0]+"");
		
		graphics.setColor(Color.red.darker());
		graphics.fillRect(349, 709, 32, 32);
		graphics.setColor(Color.red);
		graphics.fillRect(348, 708, 30, 30);
		Actions.drawInt(graphics, 353, 726,inventory[1]+"");
		
		graphics.setColor(Color.green.darker());
		graphics.fillRect(399, 709, 32, 32);
		graphics.setColor(Color.green);
		graphics.fillRect(398, 708, 30, 30);
		Actions.drawInt(graphics, 403, 726,inventory[2]+"");
	}
}
