package minecraft;

public class BigMobControler {
	char command = ' ';
	int x;
	int y = 50;
	boolean commandIsSending = true;
	boolean isAlive = true;
	boolean isHunting = false;

	void update() {
		if (GamePanel.blocks[x][y].type == 1) {
			isAlive = false;
			y = 50;
			Player.score += 9;
		}
		if (Math.abs(Player.x - x) < 50)
			isHunting = true;
		if (isAlive) {
			if (isHunting) {
				if (Player.x - x < -1) {
					if (command == 'g')
						command = 'A';
					else
						command = 'g';
				} else if (Player.x - x > 1) {
					if (command == 'i')
						command = 'D';
					else
						command = 'i';
				} else {
					if (Player.y == y) {
						Player.hurt(9);
						Player.score += 9;
						isAlive = false;
						for (int i = -5; i < 6; i++) {
							for (int j = -5; j < 6; j++) {
								GamePanel.blocks[x + i][y + j].type = 3;
							}
						}
					}
				}
			}
		}
	}

	char Command() {
		update();
		return command;
	}

	void setX(int x) {
		this.x = x;
	}

	void setY(int y) {
		this.y = y;
	}

	boolean commandIsSending() {
		return commandIsSending;

	}
}
