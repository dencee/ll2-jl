import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public  class Room {

	
	boolean allItemsAdded=false;
	public BufferedImage image;
	ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
	
	Room(String imageName){
		
		try {
			image = ImageIO.read(this.getClass().getResourceAsStream(imageName));
		}
		catch (Exception e) {
			System.out.println("image error");
		}
		
	}
	void draw(Graphics g) {
		g.drawImage(image, 0, 0, 1000, 666, null);
		for(InventoryItem i: items) {
			//g.setColor(Color.red);
		//g.drawRect(i.x, i.y-24, i.width,i.height);

		}
	}
	InventoryItem clickedItem(int x, int y) {
	
		int i;
		for (i=0;i<items.size();i++) {
			if (items.get(i).isOnItem(x, y)){
				return items.remove(i);
			}
		}
		return null;
		
	}
	void addRemainingItems() {
		allItemsAdded=true;
	}
	
}
