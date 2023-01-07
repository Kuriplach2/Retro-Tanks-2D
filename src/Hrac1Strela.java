import java.awt.*;

public class Hrac1Strela {

	//X a Y suradnice strely hraca1
	private double x;
	private double y;
	private String smer;

	public Hrac1Strela(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void pohyb(String smer) {
		this.smer = smer;
		if(smer.equals("right")) {
			x += 5;
		}
		if(smer.equals("left")) {
			x -= 5;
		}
		if(smer.equals("up")) {
			y -= 5;
		}
		else {
			y += 5;
		}
	}
	
	public void vykresli(Graphics g) {
		g.setColor(Color.red);
		g.fillOval((int) x, (int) y, 8, 8);
	}
	
	public int getX() {
		return (int)this.x;
	}
	
	public int getY() {
		return (int)this.y;
	}
}
