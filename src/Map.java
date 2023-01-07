import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Map {
	int stenaON[] = new int[42];
	private ImageIcon stenaImg;
	private ImageIcon pevnaStenaImg;
	private int stenaXPos[] = {50,350,450,550,50,300,350,450,550,150,150,450,550,
						250,50,100,150,550,250,350,450,550,50,250,350,550,
						50,150,250,300,350,550,50,150,250,350,450,550,50,
						250,350,550};
	private int stenaYPos[] = {50,50,50,50,100,100,100,100,100,150,200,200,200,250,
						300,300,300,300,350,350,350,350,400,400,400,400,450,
						450,450,450,450,450,500,500,500,500,500,500,550,550,
						550,550};
	private int pevnaStenaXPos[] = {150,350,150,500,450,300,600,400,350,200,0,200,500};
	
	private int pevnaStenaYPos[] = {0,0,50,100,150,200,200,250,300,350,400,400,450};

	public Map() {
		stenaImg =new ImageIcon("pics/break_brick.jpg");
		pevnaStenaImg =new ImageIcon("pics/solid_brick.jpg");
		
		for(int i = 0; i< stenaON.length; i++) {
			stenaON[i] = 1;
		}
	}
	
	public void vykresli(Component c, Graphics g) {
		for(int i = 0; i< stenaON.length; i++) {
			if(stenaON[i]==1) {
				stenaImg.paintIcon(c, g, stenaXPos[i], stenaYPos[i]);
			}
		}
	}
	
	public void vykresliPevne(Component c, Graphics g) {
		for(int i = 0; i< pevnaStenaXPos.length; i++) {
			pevnaStenaImg.paintIcon(c, g, pevnaStenaXPos[i], pevnaStenaYPos[i]);
		}
	}
	
	public boolean kolizia(int x, int y) {
		boolean kolizia = false;
		for(int i = 0; i< stenaON.length; i++) {
			if(stenaON[i]==1) {
				if(new Rectangle(x, y, 10, 10).intersects(new Rectangle(stenaXPos[i], stenaYPos[i], 50, 50))) {
					stenaON[i] = 0;
					kolizia = true;
					break;
				}
			}
		}
		return kolizia;
	}
	
	public boolean koliziaPevna(int x, int y) {
		boolean kolizia = false;
		for(int i = 0; i< pevnaStenaXPos.length; i++) {
			if(new Rectangle(x, y, 10, 10).intersects(new Rectangle(pevnaStenaXPos[i], pevnaStenaYPos[i], 50, 50))) {
				kolizia = true;
				break;
			}			
		}
		return kolizia;
	}
}
