package minecraft;

public class MobControler {
	char command = ' ';
	int x;
	int y = 50;
	boolean commandIsSending = true;
	boolean isAlive = true;

	void update() {
		if(y<1){
			isAlive = false;
			y=50;
		}
		if (isAlive) {
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
					Player.hurt(5);
					isAlive = false;
					for (int i = -1; i < 2; i++) {
						for (int j = -1; j < 2; j++) {
							GamePanel.blocks[x+i][y+j].type = 3;
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
