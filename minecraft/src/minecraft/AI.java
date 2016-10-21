package minecraft;

public class AI {
	char command = ' ';
	int x;
	int y;
	boolean commandIsSending = true;

	void update() {
		if (Player.x < x) {
			if (command == 'g')
				command = 'A';
			else
				command = 'g';
		} else if (Player.x > x) {
			if (command == 'i')
				command = 'D';
			else
				command = 'i';
		} else {

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
