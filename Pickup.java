import java.awt.Color;
import java.awt.Graphics;


public class Pickup extends Segment{

	public Pickup(int s) {
		super(s);
		super.getPos().x = (int)(Math.random()*75)*10;
		super.getPos().y = (int)(Math.random()*75)*10;
	}
	
	public void draw(Graphics window){
		window.setColor(Color.BLACK);
		window.fillRect(super.getX(), super.getY(), super.getSize(), super.getSize());
	}
	
	public void move(){
		super.getPos().x = (int)(Math.random()*80)*10;
		super.getPos().y = (int)(Math.random()*80)*10;
	}
}
