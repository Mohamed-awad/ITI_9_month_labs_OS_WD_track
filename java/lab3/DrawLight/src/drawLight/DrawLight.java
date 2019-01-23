package drawLight;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;

public class DrawLight extends Applet implements Runnable{

	Thread th;
	public static boolean f = true;
	public DrawLight() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		setSize(400, 400);
		th = new Thread(this);
		th.start();
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawOval(100, 50, 120, 50);
		if(f)
			g.setColor(Color.ORANGE);
		else
			g.setColor(Color.GRAY);
		
		g.fillOval(101, 51, 119, 48);
		
		g.setColor(Color.BLACK);
		
		g.drawLine(100, 70, 70, 150);
		g.drawLine(220, 70, 250, 150);
		g.drawArc(70, 125, 180, 50, 180, 180);
		
		g.drawOval(100, 105, 20, 50);
		g.drawOval(140, 105, 30, 60);
		g.drawOval(190, 105, 20, 50);
		
		
		if(f)
			g.setColor(Color.ORANGE);
		else
			g.setColor(Color.GRAY);
		
		g.fillOval(101, 106, 19, 48);
		g.fillOval(141, 106, 29, 58);
		g.fillOval(191, 106, 19, 48);

		g.setColor(Color.BLACK);

		g.drawLine(140, 175, 110, 250);
		g.drawLine(160, 175, 180, 250);
		
		g.drawRect(70, 250, 170, 20);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true)
		{
			repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(f)
				f = false;
			else
				f = true;
		}
	}

}
