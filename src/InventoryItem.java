import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class InventoryItem {
	int x;
	int y;
	int width;
	int height;
	String description;
	int num;
	String clue;
	boolean input=false;
	String answer= "15160514";
	
	public InventoryItem(String description, int x,int y, int width,int height, int num){
		this.description=description;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.num=num;
		 
		clue=description;
	}
	//InventoryItem liveItem= new InventoryItem(clue, x, 0, 0, 0, 0);
	
	public String toString() {
		return "inventory item "+description;
	}
	
	public boolean isCorrectAnswer(String guess) {
		return guess.equalsIgnoreCase(answer);
		
	}
	
	boolean isOnItem(int mouseX, int mouseY) {
		if (mouseX>=x && mouseX<=x+ width && mouseY>=y && mouseY<=y+ height) {
			return true;
		}else {
			return false;
		}
	}
}
