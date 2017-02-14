import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player {
	private ArrayList<Segment> body = new ArrayList<Segment>();
	private Segment previousLast;
	private String direction = "E";
	private int size = 10;

	public Player(int s) {
		size = s;
		body.add(new Segment(size, 400, 400));
	}

	public void addSegment() {
		body.add(Segment.duplicate(previousLast));
		System.out.println(body.size());
	}

	public void getPreviousLast() {
		previousLast = Segment.duplicate(body.get(body.size() - 1));
	}

	public void moveBody() {
		getPreviousLast();
		if (body.size() <= 1) {
			body.get(0).move(direction);
		} else {
			body.add(0, Segment.duplicate(body.get(0)));
			body.remove(body.size() - 1);
			body.get(0).move(direction);
		}
		leadCollide();
	}

	public void leadCollide() {
		if (body.size() > 1) {
			for (int i = 1; i < body.size(); i++) {
				if(body.get(0).collide(body.get(i))){
					reset();
				}
			}
		}
		if(body.get(0).getX() < 0 || body.get(0).getX() > 800){
			reset();
		} else if(body.get(0).getY() < 0 || body.get(0).getY() > 800){
			reset();
		}
	}

	public void reset() {
		size = 10;
		body = new ArrayList<Segment>();
		direction = "E";
		previousLast = null;
		body.add(new Segment(size, 400, 400));
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String d) {
		direction = d;
	}
	
	public int getSize(){
		return body.size();
	}

	public void pointCollide(Pickup p){
		if(body.get(0).collide(p)){
			addSegment();
			p.move();
		}
	}
	
	public void changeDirection(boolean[] b) {
		if (b[0] && !getDirection().equals("S")) {
			setDirection("N");
		} else if (b[1] && !getDirection().equals("W")) {
			setDirection("E");
		} else if (b[2] && !getDirection().equals("N")) {
			setDirection("S");
		} else if (b[3] && !getDirection().equals("E")) {
			setDirection("W");
		}
	}

	public void draw(Graphics window) {
		for (int i = 0; i < body.size(); i++) {
			body.get(i).draw(window);
		}
	}
}
