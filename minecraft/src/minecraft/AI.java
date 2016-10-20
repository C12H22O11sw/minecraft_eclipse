package minecraft;

public class AI {
	char command = ' ';
	int x;
	int y;
	boolean commandIsSending = true;
	void update(){
		if(Player.x < x)
			command = 'd';
		else if(Player.x > x)
			command = 'f';
		else
			command = ' ';
		
		
	}
	char Command(){
		update();
		return command;
	}
	void setX(int x){
		this.x = x;
	}
	void setY(int y){
		this.y = y;
	}
	boolean commandIsSending(){
		return commandIsSending;
	}
}
