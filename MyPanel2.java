package fract;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JPanel;

public class MyPanel2 extends JPanel {
	public MyPanel2() {
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
		double[][] parametr ={{0.849, 0.037, -0.037, 0.849, 0.075, 0.1830},
				{0.197, -0.226, 0.226, 0.197, 0.4, 0.0490},
				{-0.150, 0.283, 0.260, 0.237, 0.575, -0.084},
				{0,0,0,0.16, 0.5, 0}
		};
		Random rand = new Random();
		//wspó³rzêdne pocz¹tkowe
		double x=100, y=100;
		//rysujemy wiele punktów
		for(int i =1; i<50000; i++)
		{
			//losujemy przekszta³cenie:
			int nr = rand.nextInt(4);

			//obliczamy wspó³rzêdne
			x = parametr[nr][0]*x+parametr[nr][1]*y+parametr[nr][4];
			y = parametr[nr][2]*x+parametr[nr][3]*y+parametr[nr][5];
			//rysuje punkt
			Rectangle2D p1 = new Rectangle2D.Double(x*400+100, y*400+100, 1, 1);		
			//losujemy kolor			
			int red = rand.nextInt(255);
			int blue = rand.nextInt(255);
			int green = rand.nextInt(255);
			Color kolor = new Color(red,green,blue);
			g2D.setColor(kolor);
			g2D.draw(p1);
		}
	}
}
