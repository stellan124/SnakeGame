import java.awt.Component;

import javax.swing.JFrame;


public class SnakeRunner extends JFrame{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;
	
	public SnakeRunner(){
		super("Snake");
		setSize(WIDTH,HEIGHT);
		
		SnakeLoop game = new SnakeLoop(WIDTH,HEIGHT);
		((Component)game).setFocusable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(game);
		this.pack();
		setVisible(true);
		
	}
	
	public static void main(String[] args){
		SnakeRunner run = new SnakeRunner();
	}
}
