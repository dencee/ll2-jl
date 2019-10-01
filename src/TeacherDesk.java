
public class TeacherDesk extends Room{
	
	TeacherDesk() {
		super("teacherDesk.jpg");
		
		//wednesday bin
		items.add(new InventoryItem ("Clue 2: Now, find a 3D version of a world map.",640,58,41,72,2));
		//trash
		items.add(new InventoryItem ("Clue 6: I have a monitor, screen, and keyboard. Find me!",59,463,187,685,6));
		/*
		 * //monday tuesday bin items.add(new InventoryItem
		 * ("mon, tue bin",567,60-24,72,72,)); //thursday friday bin items.add(new
		 * InventoryItem (681,58-24,90,72));
		 */
	}
}
