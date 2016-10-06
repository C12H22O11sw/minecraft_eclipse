package minecraft;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

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
		if (type == 3)
			inventory[GamePanel.blocks[this.x + x][this.y + y].type]++;
		GamePanel.blocks[this.x + x][this.y + y].type = type;// 1
		System.out.println("0:"+inventory[0]+"; 1:"+inventory[1]+"; 2:"+inventory[2]);

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
			if (Actions.keyPressed == '1') {
				placeBlockType = 1;
			}else if (Actions.keyPressed == '2') {
				placeBlockType = 2;
			}else if (Actions.keyPressed == '3') {
				placeBlockType = 3;
			}else if (Actions.keyPressed == '0') {
				placeBlockType = 3;
			}

			if (Actions.keyPressed == 'a') {
				placeBlock(-1, -1, placeBlockType);// 1
			} else if (Actions.keyPressed == 'b') {
				GamePanel.blocks[x][y - 1].type = placeBlockType;// 2
			} else if (Actions.keyPressed == 'c') {
				GamePanel.blocks[x + 1][y - 1].type = placeBlockType;// 3
			} else if (Actions.keyPressed == 'd') {
				GamePanel.blocks[x - 1][y].type = placeBlockType;// 4
			} else if (Actions.keyPressed == 'f') {
				GamePanel.blocks[x + 1][y].type = placeBlockType;// 6
			} else if (Actions.keyPressed == 'g') {
				GamePanel.blocks[x - 1][y + 1].type = placeBlockType;// 7
			} else if (Actions.keyPressed == 'h') {
				GamePanel.blocks[x][y + 1].type = placeBlockType;// 8
			} else if (Actions.keyPressed == 'i') {
				GamePanel.blocks[x + 1][y + 1].type = placeBlockType;// 9
			}
			Actions.keyIsPressed = false;
		}

		if (GamePanel.blocks[x][y - 1].type == 3) {
			y--;
		}
		Actions.keyPressed = '?';
	}

	void draw(Graphics graphics) {
		update();
		graphics.setColor(Color.gray);
		graphics.fillRect(x * 16, 800 - (y * 16), 16, 16);
		
		graphics.setColor(Color.DARK_GRAY);
		graphics.fillRect(290, 700, 500, 50);
		graphics.setColor(Color.gray);
		graphics.fillRect(290-1, 700-1, 498, 48);

		graphics.setColor(Color.black);
		graphics.fillRect(299, 709, 32, 32);
		graphics.setColor(Color.GRAY.darker());
		graphics.fillRect(298, 708, 30, 30);
		
		graphics.setColor(Color.red.darker());
		graphics.fillRect(349, 709, 32, 32);
		graphics.setColor(Color.red);
		graphics.fillRect(348, 708, 30, 30);
		
		graphics.setColor(Color.green.darker());
		graphics.fillRect(399, 709, 32, 32);
		graphics.setColor(Color.green);
		graphics.fillRect(398, 708, 30, 30);


	}
}
