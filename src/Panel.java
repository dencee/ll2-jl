import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.Graphics;

public class Panel extends JPanel implements ActionListener, KeyListener, MouseListener {

	public static BufferedImage classroom;
	public static BufferedImage door;
	public static BufferedImage teacherDesk;
	public static BufferedImage doorknobLock;
	public static BufferedImage hallway;
	Room currentRoom;
	int clickerCount=20;
	int infoPanel=1000;
	Timer minuteTimer;
	int timeLimit=300;
	
	Classroom classRoom= new Classroom();
	TeacherDesk deskRoom= new TeacherDesk();
	 Room hallwayRoom= new Room ("hallway.jpg");
	Room doorRoom= new Room("door.jpg");

	public static boolean needImage = true;
	public static boolean gotImage = false;
	Font titleFont;
	Font pressEnterToStartFont;
	Font iForInstructionsFont;
	Font gameOver;
	Font restartFont;
	
	Graphics g;

	final int TITLE_SCREEN = 0;
	final int CLASSROOM = 1;
	final int TEACHER_DESK = 2;
	final int MATH_WORKSHEET = 3;
	final int DOOR = 4;
	final int SUCCESS_SCREEN = 5;
	final int FAIL_SCREEN = 6;
	int currentState = TITLE_SCREEN;

	Panel() {
		
		currentRoom=new Classroom();	
		titleFont = new Font("Courier", Font.PLAIN, 48);
		pressEnterToStartFont = new Font("Courier", Font.PLAIN, 30);
		iForInstructionsFont = new Font("Courier", Font.PLAIN, 20);
		gameOver = new Font("Courier", Font.BOLD, 48);
		restartFont = new Font("Courier", Font.PLAIN, 44);
		//loadImages();
		minuteTimer = new Timer(1000,this);
		
	}

	/*
	 * void loadImages() {
	 * 
	 * try { classroom =
	 * ImageIO.read(this.getClass().getResourceAsStream("Classroom.jpg"));
	 * teacherDesk =
	 * ImageIO.read(this.getClass().getResourceAsStream("teacherDesk.jpg")); door =
	 * ImageIO.read(this.getClass().getResourceAsStream("door.jpg")); doorknobLock =
	 * ImageIO.read(this.getClass().getResourceAsStream("doorknobLockjpg.jpg"));
	 * math = ImageIO.read(this.getClass().getResourceAsStream("math.jpg")); }
	 * 
	 * catch (Exception e) { System.out.println("image error"); }
	 * 
	 * 
	 * }
	 */

	public void paintComponent(Graphics g) {

		if (currentState == TITLE_SCREEN) {
			drawInfoPanel(g);

			drawTitleScreen(g);
		
		} else if (currentState == SUCCESS_SCREEN) {
			
			drawSuccessScreen(g);
		
		}else if(currentState == FAIL_SCREEN) {
			drawFailScreen(g);
		}
		else {
			currentRoom.draw(g);
			drawInfoPanel(g);
		}
		
		
	}

	void drawTitleScreen(Graphics g) {

		g.setColor(Color.YELLOW);

		g.fillRect(0, 0, 1000, 666);

		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("CLASSROOM ESCAPE", 250, 100);
		

		g.setColor(Color.BLACK);
		g.setFont(pressEnterToStartFont);
		g.drawString("Press ENTER to start", 310, 175);
		
		g.setColor(Color.BLACK);
		g.setFont(iForInstructionsFont);
		g.drawString("Description: You are the substitute teacher of a first grade class and you ", 30, 250);
		g.drawString("happen to accidentally lock yourself in the classroom. On the door is an ", 30, 280);
		g.drawString("8 NUMBER combination lock. Unfortunately, class starts in 5 minutes, so in ", 30, 310);
		g.drawString("order to open the door before class starts, you have to go through a set of", 30, 340);
		g.drawString("clues and riddles to find the password to the door. There are 3 rooms you can", 30, 370);
		g.drawString("investigate. Good luck!", 30, 400);
		
		g.drawString("Instructions:", 30, 460);
		g.drawString("- Use the ARROW keys to change rooms", 30, 490);
		g.drawString("- Click on items you would like to investigate", 30, 520);
		g.drawString("- Keep in mind of your clue number in case you need a hint", 30, 550);

	}

	void drawClassroomScreen(Graphics g) {
		g.drawImage(classRoom.image, 0, 0, 1000, 666, null);
		System.out.println("projector");
	}

	void drawTeacherScreen(Graphics g) {
		g.drawImage(deskRoom.image, 0, 0, 1000, 666, null);
	}

	void drawDoorScreen(Graphics g) {
		g.drawImage(doorRoom.image, 0, 0, 1000, 666, null);
		
	}
void drawInfoPanel(Graphics g) {
	g.setColor(Color.BLACK);
	g.setFont(titleFont);
	g.drawString("Key", infoPanel+150, 100);
	g.drawString("___", infoPanel+150, 95);
	
	g.setColor(Color.BLACK);
	g.setFont(iForInstructionsFont);
	g.drawString(String.valueOf(timeLimit),infoPanel+50, 170);
	g.drawString("seconds left",infoPanel+95, 170);
	g.drawString("Clicker Count: "+clickerCount, infoPanel+50, 210);
	g.drawString("Click D for description", infoPanel+50, 250);
	g.drawString("Click I for instructions", infoPanel+50, 290);
	g.drawString("Click H for a hint", infoPanel+50, 330);
	
	if(timeLimit<=0) {
		changeState(6);
	}
	
	repaint();
}
	
	void drawSuccessScreen(Graphics g) {
		g.drawImage(hallwayRoom.image, 0, 0, 1000, 666, null);
		
		g.setColor(Color.BLACK);
		g.setFont(gameOver);
		g.drawString("You succeeded!", 250, 100);
		/*
		 * g.setColor(Color.BLACK); g.setFont(restartFont);
		 * g.drawString("Press ENTER to restart", 230, 450);
		 */
	}

	 void drawFailScreen(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, 1000, 666);
		g.setColor(Color.BLACK);
		g.setFont(gameOver);
		g.drawString("You failed", 270, 100);
		// need to finish the states of the game

		g.setColor(Color.BLACK);
		g.setFont(restartFont);
		g.drawString("Press ENTER to restart", 200, 450);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == TITLE_SCREEN) {
				currentState = CLASSROOM;
				
				
				minuteTimer.start();
				JOptionPane.showMessageDialog(null, "Click the whiteboard to start!");
			}
			else if (currentState == FAIL_SCREEN) {
						currentState = TITLE_SCREEN;
						clickerCount= 20;
						timeLimit=300;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			 if (currentState == CLASSROOM) {
				currentState = TEACHER_DESK;
				currentRoom=new TeacherDesk();
			} else if (currentState == TEACHER_DESK) {
				currentState = DOOR;
				currentRoom=new Door();
			} 
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			 if (currentState == DOOR) {
				currentState = TEACHER_DESK;
				currentRoom=new TeacherDesk();
			} else if (currentState == TEACHER_DESK) {
				currentState = CLASSROOM;
				currentRoom=new Classroom();
			} 
		}
		if (e.getKeyCode() == KeyEvent.VK_0) {
			if (currentState == DOOR) {
				currentState = SUCCESS_SCREEN;
					}
			
		
		}if (e.getKeyCode() == KeyEvent.VK_I) {
			JOptionPane.showMessageDialog(null, "Instructions-Use the arrow keys to change rooms\n- Click on items you would like to investigate\n-Reference the game panel on the right hand side to find a key\n- Keep in mind of your clue number in case you need a hint/n-You can click i at any time during the game\n-You only have 5 minutes, and 20 clicks to crack the code!");
		}else if (e.getKeyCode() == KeyEvent.VK_D) {
			JOptionPane.showMessageDialog(null, "Description: You are the substitute teacher of a first grade class \nand you happen to accidentally lock yourself in the classroom. On \nthe door is an 8 number combination lock. Unfortunately, class starts \nin 5 minutes, so in order to open the door before class starts, you \nhave to go through a set of clues and riddles to find the password to the door.\nGood luck!");
		}else if (e.getKeyCode() == KeyEvent.VK_C) {
			JOptionPane.showMessageDialog(null, "Clicker Count: "+clickerCount);
		}else if (e.getKeyCode() == KeyEvent.VK_H) {
			String clueNumber=JOptionPane.showInputDialog(null, "HINT: Which clue number do you need help on?");
			
			if(clueNumber.equals("1")) {
				JOptionPane.showMessageDialog(null, "Look for a bin that has a W on it.");
			}else if(clueNumber.equals("2")) {
				JOptionPane.showMessageDialog(null, "Look for a globe.");
			}else if(clueNumber.equals("3")) {
				JOptionPane.showMessageDialog(null, "Look for something that tells the time.");
			}else if(clueNumber.equals("4")) {
				JOptionPane.showMessageDialog(null, "Look for something that a steriotypical teacher might eat.");
			}else if(clueNumber.equals("5")) {
				JOptionPane.showMessageDialog(null, "Where do you throw trash away?");
			}else if(clueNumber.equals("6")) {
				JOptionPane.showMessageDialog(null, "The riddle has something to do with an electronic device in the first room.");
			}else if(clueNumber.equals("7")) {
				JOptionPane.showMessageDialog(null, "Look for a stack of books.");
			}else if(clueNumber.equals("8")) {
				JOptionPane.showMessageDialog(null, "Correspond each individual letter to a number (eg. a=1, b=2, c=3...).");
			}
		}
		repaint();
		}
	void changeState(int stateNum) {
		currentState= stateNum;
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timeLimit=timeLimit-1;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	//	System.out.println(e.getX()+", "+e.getY());
		InventoryItem item= currentRoom.clickedItem(e.getX(), e.getY());

		if (item != null) {
			if (!item.input) {
				JOptionPane.showMessageDialog(null, item.clue);
				currentRoom.addRemainingItems();
			} else {
				String guess = JOptionPane.showInputDialog(null, item.clue);

				if (item.isCorrectAnswer(guess)) {
					currentState = SUCCESS_SCREEN;
					repaint();
				} else {
					JOptionPane.showMessageDialog(null, "INCORRECT!");
				}
			}
		}
	clickerCount=clickerCount-1;
	if(clickerCount<=0) {
		changeState(6);
	}
	}

	private InventoryItem currentRoom(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
