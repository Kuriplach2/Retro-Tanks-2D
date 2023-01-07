import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;

public class Hra extends JPanel implements ActionListener {
	private Map map;
	private Timer casovac;
	private int delay = 8;
	private boolean play = true;

	private ImageIcon hrac1;
	private int hrac1X = 200;
	private int hrac1Y = 550;
	private boolean hrac1right = false;
	private boolean hrac1left = false;
	private boolean hrac1down = false;
	private boolean hra1up = true;
	private int hrac1life = 3;
	private boolean hrac1strela = false;
	private String strela1smer = "";
	
	private ImageIcon hrac2;
	private int hrac2X = 400;
	private int hrac2Y = 550;
	private boolean hrac2right = false;
	private boolean hrac2left = false;
	private boolean hrac2down = false;
	private boolean hrac2up = true;
	private int hrac2life = 3;
	private boolean hrac2strela = false;
	private String strela2smer = "";
	private Hrac1 hrac1manazer;
	private Hrac2 hrac2manazer;

	private Hrac1Strela strela1 = null;
	private Hrac2Strela strela2 = null;

	public Hra() {
		map = new Map();
		hrac1manazer = new Hrac1();
		hrac2manazer = new Hrac2();
		setFocusable(true);
		addKeyListener(hrac1manazer);
		addKeyListener(hrac2manazer);
		setFocusTraversalKeysEnabled(false);
        casovac = new Timer(delay,this);
		casovac.start();
	}
	private class Hrac1 implements KeyListener {
		public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()== KeyEvent.VK_SPACE && (hrac1life == 0)) {

				hrac1X = 200;
				hrac1Y = 550;
				hrac1right = false;
				hrac1left = false;
				hrac1down = false;
				hra1up = true;

				hrac1life = 3;
				play = true;
				repaint();
			}

			if(e.getKeyCode()== KeyEvent.VK_SPACE) {
				if(!hrac1strela) {
					if(hra1up) {
						strela1 = new Hrac1Strela(hrac1X + 20, hrac1Y);
					}
					if(hrac1down) {
						strela1 = new Hrac1Strela(hrac1X + 20, hrac1Y + 40);
					}
					if(hrac1right) {
						strela1 = new Hrac1Strela(hrac1X + 40, hrac1Y + 20);
					}
					if(hrac1left) {
						strela1 = new Hrac1Strela(hrac1X, hrac1Y + 20);
					}
					hrac1strela = true;
				}
			}

			if(e.getKeyCode()== KeyEvent.VK_W) {
				hrac1right = false;
				hrac1left = false;
				hrac1down = false;
				hra1up = true;

				if(!(hrac1Y < 10)) {
					hrac1Y -= 10;
				}
			}

			if(e.getKeyCode()== KeyEvent.VK_A) {
				hrac1right = false;
				hrac1left = true;
				hrac1down = false;
				hra1up = false;

				if(!(hrac1X < 10)) {
					hrac1X -= 10;
				}
			}

			if(e.getKeyCode()== KeyEvent.VK_S) {
				hrac1right = false;
				hrac1left = false;
				hrac1down = true;
				hra1up = false;

				if(!(hrac1Y > 540)) {
					hrac1Y += 10;
				}
			}

			if(e.getKeyCode()== KeyEvent.VK_D) {
				hrac1right = true;
				hrac1left = false;
				hrac1down = false;
				hra1up = false;

				if(!(hrac1X > 590)) {
					hrac1X += 10;
				}
			}
		}
	}

	private class Hrac2 implements KeyListener {

		public void keyTyped(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
		}

		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_M) {
				if (!hrac2strela) {
					if (hrac2up) {
						strela2 = new Hrac2Strela(hrac2X + 20, hrac2Y);
					}
					if (hrac2down) {
						strela2 = new Hrac2Strela(hrac2X + 20, hrac2Y + 40);
					}
					if (hrac2right) {
						strela2 = new Hrac2Strela(hrac2X + 40, hrac2Y + 20);
					}
					if (hrac2left) {
						strela2 = new Hrac2Strela(hrac2X, hrac2Y + 20);
					}
					hrac2strela = true;
				}
			}

			if (e.getKeyCode() == KeyEvent.VK_UP) {
				hrac2right = false;
				hrac2left = false;
				hrac2down = false;
				hrac2up = true;

				if (!(hrac2Y < 10))
					hrac2Y -= 10;

			}

			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				hrac2right = false;
				hrac2left = true;
				hrac2down = false;
				hrac2up = false;

				if (!(hrac2X < 10))
					hrac2X -= 10;
			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				hrac2right = false;
				hrac2left = false;
				hrac2down = true;
				hrac2up = false;

				if (!(hrac2Y > 540))
					hrac2Y += 10;
			}

			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				hrac2right = true;
				hrac2left = false;
				hrac2down = false;
				hrac2up = false;

				if (!(hrac2X > 590))
					hrac2X += 10;
			}
		}
	}

	public void paint(Graphics g) {
		// play background
		g.setColor(Color.white);
		g.fillRect(0, 0, 650, 600);

		// draw solid bricks
		map.vykresliPevne(this, g);

		// draw Breakable bricks
		map.vykresli(this, g);

		if(play) {
			// draw player 1
			if(hra1up) {
				hrac1 = new ImageIcon("pics/player1_tank_up.png");
			}
			if(hrac1down) {
				hrac1 = new ImageIcon("pics/player1_tank_down.png");
			}
			if(hrac1right) {
				hrac1 = new ImageIcon("pics/player1_tank_right.png");
			}
			if(hrac1left) {
				hrac1 = new ImageIcon("pics/player1_tank_left.png");
			}

			hrac1.paintIcon(this, g, hrac1X, hrac1Y);

			// draw player 2
			if(hrac2up) {
				hrac2 = new ImageIcon("pics/player2_tank_up.png");
			}
			if(hrac2down) {
				hrac2 = new ImageIcon("pics/player2_tank_down.png");
			}
			if(hrac2right) {
				hrac2 = new ImageIcon("pics/player2_tank_right.png");
			}
			if(hrac2left) {
				hrac2 = new ImageIcon("pics/player2_tank_left.png");
			}

			hrac2.paintIcon(this, g, hrac2X, hrac2Y);

			if(strela1 != null && hrac1strela) {
				if(strela1smer.equals("")) {
					if(hra1up) {
						strela1smer = "up";
					}
					if(hrac1down) {
						strela1smer = "down";
					}
					if(hrac1right) {
						strela1smer = "right";
					}
					if(hrac1left) {
						strela1smer = "left";
					}
				}
				else {
					strela1.pohyb(strela1smer);
					strela1.vykresli(g);
				}

				if(new Rectangle(strela1.getX(), strela1.getY(), 10, 10)
						.intersects(new Rectangle(hrac2X, hrac2Y, 50, 50))) {
					hrac2life -= 1;
					strela1 = null;
					hrac1strela = false;
					strela1smer = "";
				}

				if(map.kolizia(strela1.getX(), strela1.getY())
						|| map.koliziaPevna(strela1.getX(), strela1.getY())) {
					strela1 = null;
					hrac1strela = false;
					strela1smer = "";
				}

				if(strela1.getY() < 1
						|| strela1.getY() > 580
						|| strela1.getX() < 1
						|| strela1.getX() > 630) {
					strela1 = null;
					hrac1strela = false;
					strela1smer = "";
				}
			}

			if(strela2 != null && hrac2strela) {
				if(strela2smer.equals("")) {
					if(hrac2up) {
						strela2smer = "up";
					}
					if(hrac2down) {
						strela2smer = "down";
					}
					if(hrac2right) {
						strela2smer = "right";
					}
					if(hrac2left) {
						strela2smer = "left";
					}
				}
				else {
					strela2.pohyb(strela2smer);
					strela2.vykresli(g);
				}

				if(new Rectangle(strela2.getX(), strela2.getY(), 10, 10)
						.intersects(new Rectangle(hrac1X, hrac1Y, 50, 50))) {
					hrac1life -= 1;
					strela2 = null;
					hrac2strela = false;
					strela2smer = "";
				}

				if(map.kolizia(strela2.getX(), strela2.getY())
						|| map.koliziaPevna(strela2.getX(), strela2.getY())) {
					strela2 = null;
					hrac2strela = false;
					strela2smer = "";
				}

				if(strela2.getY() < 1
						|| strela2.getY() > 580
						|| strela2.getX() < 1
						|| strela2.getX() > 630) {
					strela2 = null;
					hrac2strela = false;
					strela2smer = "";
				}
			}
		}

		// the scores 		
		g.setColor(Color.white);
		g.setFont(new Font("Dialog",Font.BOLD, 25));
		g.drawString("Životy", 700,250);
		g.drawString("Hráč 1:  "+ hrac1life, 660,270);
		g.drawString("Hráč 2:  "+ hrac2life, 660,290);
		
		if(hrac1life == 0 || hrac2life == 0){
			g.setColor(Color.black);
			g.setFont(new Font("Dialog",Font.BOLD, 60));
			g.drawString("Game Over", 200,300);
			g.drawString("Hráč 2 vyhral", 180,380);
			play = false;
			g.setColor(Color.black);
			g.setFont(new Font("Dialog",Font.BOLD, 30));
			g.drawString("(Space to Restart)", 230,430);
		}
		else if(hrac2life == 0) {
			g.setColor(Color.black);
			g.setFont(new Font("Dialog",Font.BOLD, 60));
			g.drawString("Game Over", 200,300);
			g.drawString("Hráč 1 vyhral", 180,380);
			g.setColor(Color.black);
			g.setFont(new Font("Dialog",Font.BOLD, 30));
			g.drawString("(Space to Restart)", 230,430);
			play = false;
		}
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		casovac.start();
		repaint();
	}
}