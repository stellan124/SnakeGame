import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Segment {
	private int size;
	private Point position = new Point();

	public Segment(int s) {
		size = s;
	}

	public Segment(int s, int x, int y) {
		size = s;
		position.x = x;
		position.y = y;
	}

	public void move(String d){
		if(d.equals("N")){
			position.y -= size;
		}else if(d.equals("E")){
			position.x += size;
		}else if(d.equals("S")){
			position.y += size;
		}else if(d.equals("W")){
			position.x -= size;
		}
	}
	
	public boolean collide(Segment obj){
		if(this.getRect().intersects(obj.getRect())){
			return true;
		}
		return false;
	}

	public void draw(Graphics window) {
		window.setColor(Color.red);
		window.fillRect(position.x, position.y, size, size);
	}

	// getters and setters
	public Rectangle getRect() {
		return new Rectangle(position.x, position.y, size, size);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getX() {
		return position.x;
	}

	public int getY() {
		return position.y;
	}
	
	public Point getPos(){
		return position;
	}

	public void setX(int x) {
		position.x = x;
	}

	public void setY(int y) {
		position.y = y;
	}
	
	public void setPos(Point p){
		position = p;
	}
	
	public void setPos(int x, int y){
		setX(x);
		setY(y);
	}
	
	//duplication
	public static Segment duplicate(Segment obj){
		return new Segment(obj.getSize(),obj.getX(),obj.getY());
	}

}
