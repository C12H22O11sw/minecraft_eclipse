package minecraft;

import java.awt.Color;
import java.awt.Graphics;

public class Block {
	int x;
	int y;
	int type = 0;

	Block(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

	void update() {

	}

	void draw(Graphics graphics) {

		switch (type) {
		case 0:
			graphics.setColor(Color.GRAY.darker());
			break;
		case 1:
			graphics.setColor(Color.RED);
			break;
		case 2:
			graphics.setColor(Color.green);
			break;
		case 4:
			graphics.setColor(Color.ORANGE);
			break;

		}

		if (type == 3) {
			if (Player.time % 3600 < 1800)
				graphics.setColor(Color.white);
			else
				graphics.setColor(Color.black);
		}

		graphics.fillRect(((x + Actions.panX) * 16), GameWindow.height - ((y + Actions.panY) * 16), 16, 16);

	}
}
