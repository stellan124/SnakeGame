import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


public class SnakeLoop extends JPanel implements Runnable, KeyListener{
	private Player snake = new Player(10);
	private boolean[] keys;
	private Pickup point;
	public SnakeLoop(int width, int height){
		setBackground(Color.white);
		this.setPreferredSize(new Dimension(width, height));
		new Thread(this).start();
		setVisible(true);
		addKeyListener(this);
		point = new Pickup(10);
		keys = new boolean[5];
	}
	public void update(Graphics window) {
		paint(window);
	}
	
	public void paint(Graphics window){
		window.setColor(Color.white);
		window.fillRect(0, 0, 800, 800);
		drawGrid(window);
		drawScore(window);
		snake.changeDirection(keys);
		if(keys[4]){
			snake.addSegment();
		}
		snake.moveBody();
		snake.pointCollide(point);
		snake.draw(window);
		point.draw(window);
		
		keys = new boolean[5];
	}
	public void drawGrid(Graphics window){
		window.setColor(Color.gray);
		for(int i = 0;i <= 800;i+=10){
			window.drawLine(i, 0, i, 800);
		}
		for(int i = 0;i <= 800;i+= 10){
			window.drawLine(0, i, 800, i);
		}
	}
	public void drawScore(Graphics window){
		window.setColor(Color.black);
		window.drawString("Length: "+snake.getSize(), 10, 20);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(true){
				Thread.currentThread().sleep(50);
				repaint();
			}
		} catch (Exception e){
			System.out.println("Loop died");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP){
			keys[0] = true;
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			keys[1] = true;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			keys[2] = true;
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			keys[3] = true;
		}else{
			keys[4] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
