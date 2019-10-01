import java.awt.Color;
import java.awt.Graphics;

public class Classroom extends Room{

	Classroom() {
		super("Classroom.jpg");
		// white board
		items.add(new InventoryItem("Clue 1: Dear class, today is WEDNESDAY. Turn in the homework in the pink bin.", 102, 179,205, 143, 1));
		// globe
		items.add(new InventoryItem("Clue 3: Math begins at 11:05.", 770, 265, 23, 29, 3));
		// clock:
		items.add(new InventoryItem("Clue 4: A(n) ______ doesn't fall far from the tree", 345, 151, 27, 23, 4));
		// computer:
		items.add(new InventoryItem("Clue 7: Don't forget the read aloud after lunch! Read the blue/grey book on the desk.", 313, 277, 49, 26,7));
	}
	
/* * void addRemainingItems() { super.addRemainingItems(); //clock: items.add(new
 * InventoryItem ("It doesn't fall from the tree",345,151,27,23,4)); //computer:
 * items.add(new InventoryItem
 * ("Don't forget the read aloud after lunch! Read the blue book...",313,277,49,
 * 26,7));*}*/
}