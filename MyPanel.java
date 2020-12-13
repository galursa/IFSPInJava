package fract;

import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	public MyPanel() {
		setPreferredSize(new Dimension(600, 600));
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		//Rysujemy ramkê
		Rectangle2D ramka = new Rectangle2D.Double(10, 10, 580, 580);
		g2D.setColor(Color.black);
		g2D.draw(ramka);
		//parametry do fraktala
		double[][] parametr ={{0.5, 0, 0, 0.5, 0, 0},
				 			  {0.5, 0, 0, 0.5, 0.5, 0},
				 			  {0.5, 0, 0, 0.5, 0, 0.5}};
		
		Random rand = new Random();
		//wspó³rzêdne pocz¹tkowe
		double x=100, y=100;
		//rysujemy wiele punktów
		for(int i =1; i<50000; i++)
		{
			//losujemy przekszta³cenie:
			int nr = rand.nextInt(3);
			//losujemy kolor			
			int red = rand.nextInt(255);
			int blue = rand.nextInt(255);
			int green = rand.nextInt(255);
			//obliczamy wspó³rzêdne
			x = parametr[nr][0]*x+parametr[nr][1]*y+parametr[nr][4];
			y = parametr[nr][2]*x+parametr[nr][3]*y+parametr[nr][5];
			//rysuje punkt
			Rectangle2D p1 = new Rectangle2D.Double(x*580+10, y*580+10, 1, 1);
			Color kolor = new Color(red, green, blue);
			g2D.setColor(kolor);
			g2D.draw(p1);
		}
	}
}
