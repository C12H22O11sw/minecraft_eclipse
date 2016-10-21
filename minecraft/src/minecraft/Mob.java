package minecraft;

import java.awt.Color;
import java.awt.Graphics;

public class Mob {
	int x = 55;
	int y = 10;

	int placeBlockType = 3;
	int[] inventory = new int[10];
	char control = '?';
	int lives;
	AI ai = new AI();

	Mob() {

	}

	void placeBlock(int x, int y, int type) {
		if (true || inventory[type] > 0 || type == 3) {
			if (type == 3)
				inventory[GamePanel.blocks[this.x + x][this.y + y].type]++;

			GamePanel.blocks[this.x + x][this.y + y].type = type;// 1
			inventory[type]--;
		}
	}

	void update() {
		char control = ai.Command();
		ai.setX(x);
		ai.setY(y);
		if (ai.commandIsSending()) {
			if (control == 'A' && GamePanel.blocks[x - 1][y].type == 3) {
				this.x--;
			} else if (control == 'D' && GamePanel.blocks[x + 1][y].type == 3) {
				this.x++;
			} else if (control == 'A' && GamePanel.blocks[x - 1][y + 1].type == 3) {
				this.x--;
				this.y++;
			} else if (control == 'D' && GamePanel.blocks[x + 1][y + 1].type == 3) {
				this.x++;
				this.y++;
			} else if (control == ' ') {
				this.y++;
			}

			switch (control) {

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
			case 'b':
				placeBlock(0, -1, placeBlockType);
				break;
			case 'c':
				placeBlock(1, -1, placeBlockType);
				break;
			case 'd':
				placeBlock(-1, 0, placeBlockType);
				break;
			case 'f':
				placeBlock(1, 0, placeBlockType);
				break;
			case 'g':
				placeBlock(-1, 1, placeBlockType);
				break;
			case 'h':
				placeBlock(0, 1, placeBlockType);
				break;
			case 'i':
				placeBlock(1, 1, placeBlockType);
			}
		}
		if (GamePanel.blocks[x][y - 1].type == 3 || GamePanel.blocks[x][y - 1].type == 1) {
			y--;
		}

	}

	void draw(Graphics graphics) {
		update();

		graphics.setColor(Color.red.darker());
		graphics.fillRect((x + Actions.panX) * 16, GameWindow.height - (y * 16), 16, 16);
		graphics.setColor(Color.BLACK);
		graphics.fillRect((x + Actions.panX) * 16 + 3, GameWindow.height - (y * 16) + 5, 4, 2);
		graphics.fillRect((x + Actions.panX) * 16 + 10, GameWindow.height - (y * 16) + 5, 4, 2);

	}
}
