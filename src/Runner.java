import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Runner {
	JFrame frame= new JFrame();
	Panel panel= new Panel();
	final int width= 1390;
	final int height= 666;
			
public static void main(String[] args) {
	Runner runner= new Runner();
	runner.setup();
}
void setup() {
	frame.setVisible(true);
	frame.getContentPane().setPreferredSize(new Dimension(width, height));
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.addMouseListener(panel);

	frame.add(panel);
	frame.pack();	
	
	 frame.addKeyListener(panel);
	//need to add more things like start game for anything to run
}
}
