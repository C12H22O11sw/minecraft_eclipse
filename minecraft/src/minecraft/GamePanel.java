package minecraft;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {

	// Terrain variables
	int height = 20;
	int heightTrend = 0;
	int random;
	static int worldWidth = 1200;
	static int worldHeight = 100;
	int blockSize = 16;

	boolean worldHasBeenGenerated = false;

	Timer timer;
	static Block[][] blocks = new Block[worldWidth][worldHeight];
	Player player = new Player();
	Mob mob = new Mob();

	GamePanel() {
		timer = new Timer(50, this);
		timer.start();
	}

	void makeTree(int x, int y) {
		blocks[x][y].type = 0;
	}

	void getHeight(int method) {
		if (heightTrend == 0) {
			if (random < 10)
				heightTrend = 1;
			if (random > 90)
				heightTrend = -1;
		} else if (heightTrend == 1) {
			if (random < 40)
				heightTrend = 0;
			if (random > 90)
				heightTrend = -1;
		} else if (heightTrend == -1) {
			if (random < 40)
				heightTrend = 0;
			if (random > 90)
				heightTrend = 1;
		}
	}

	void generateWorld() {
		height = 20;
		heightTrend = 0;
		for (int x = 0; x < worldWidth; x++) {
			random = new Random().nextInt(100);
			getHeight(0);
			// heightTrend = 0;
			if (height > 10)
				height += heightTrend;
			else
				height++;
			for (int y = 0; y < worldHeight; y++) {
				if (y < height)
					if (y < 7)
						blocks[x][y] = new Block(x, y, 1);
					else if (y < 8 + x % 2)
						blocks[x][y] = new Block(x, y, 3);
					else if (y < height - 4)
						blocks[x][y] = new Block(x, y, 0);
					else if (y < height - 1)
						blocks[x][y] = new Block(x, y, 4);
					else
						blocks[x][y] = new Block(x, y, 2);
				else
					blocks[x][y] = new Block(x, y, 3);
			}

		}
	}

	void renderWorld(Graphics graphics) {
		for (int x = 0; x < worldWidth; x++) {
			for (int y = 0; y < worldHeight; y++) {
				blocks[x][y].draw(graphics);
			}
		}
	}

	@Override
	public void paintComponent(Graphics graphics) {
		if (!worldHasBeenGenerated) {
			generateWorld();

			worldHasBeenGenerated = true;
		}
		renderWorld(graphics);
		player.draw(graphics);
		// mob.draw(graphics);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
}
