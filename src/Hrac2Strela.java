import java.awt.*;

public class Hrac2Strela {

	//X a Y suradnice strely hraca2
	private double x;
	private double y;
	private String tvar;

	public Hrac2Strela(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void pohyb(String tvar) {
		this.tvar = tvar;
		if(tvar.equals("right")) {
			x += 5;
		}
		if(tvar.equals("left")) {
			x -= 5;
		}
		if(tvar.equals("up")) {
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
