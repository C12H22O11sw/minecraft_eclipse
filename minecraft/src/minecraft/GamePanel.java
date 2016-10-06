package minecraft;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
	
	//Terrain variables
		int height = 20;
		int heightTrend = 0;
		int random;
		static int worldWidth = 100;
		static int worldHeight = 100;
		int blockSize = 16;
		
		
		
		boolean worldHasBeenGenerated = false;

	Timer timer;
	static Block[][] blocks = new Block[worldWidth][worldHeight];	Player player = new Player();
	GamePanel(){
		timer = new Timer(50,this);
		timer.start();
	}
	void getHeight(int method){
		if(method == 1){
			if(random > 99)
				heightTrend = 5;
	          else if(random < 1)
	        	  heightTrend = -5;
	          else if(random > 98)
	        	  heightTrend = 4;
	          else if(random < 2)
	        	  heightTrend = -4;
	          else if(random > 96)
	        	  heightTrend = 3;
	          else if(random < 4)
	        	  heightTrend = -3;
	          else if(random > 90)
	        	  heightTrend = 2;
	          else if(random < 10)
	        	  heightTrend = -2;
	          else if(random > 80)
	        	  heightTrend = 1;
	          else if(random < 20)
	        	  heightTrend = -1;  
	          else
	        	  heightTrend = 0;	
		}else{
			if(heightTrend == 0){
				if(random < 10)
					heightTrend = 1;
				if(random > 90)
					heightTrend = -1;
			}else if(heightTrend == 1){
				if(random < 40)
					heightTrend = 0;
				if(random > 90)
					heightTrend = -1;
			}else if(heightTrend == -1){
				if(random < 40)
					heightTrend = 0;
				if(random > 90)
					heightTrend = 1;
			}	
		}
	}
	void generateWorld(){
		height = 20;
		heightTrend = 0;
		for(int x = 0; x< worldWidth; x++){
			random = new Random().nextInt(100);
			getHeight(0);
			//heightTrend = 0;
			height+=heightTrend;
		
			for(int y = 0; y< worldHeight; y++){
				if(y<height)
					blocks[x][y] = new Block(x,y,2);
				else
					blocks[x][y] = new Block(x,y,3);
			}
		}
	}
	void renderWorld(Graphics graphics){
		for(int x = 0; x< worldWidth; x++){
			for(int y = 0; y< worldHeight; y++){
				blocks[x][y].draw(graphics);
			}
		}
	}
	
	
	@Override 
	public void paintComponent(Graphics graphics){
		if(!worldHasBeenGenerated){
			generateWorld();
			
			worldHasBeenGenerated = true;
		}
		renderWorld(graphics);
		player.draw(graphics);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();	
	}
}
