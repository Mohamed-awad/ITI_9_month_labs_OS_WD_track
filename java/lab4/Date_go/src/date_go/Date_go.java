package date_go;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;

public class Date_go extends Applet{

	Thread th;
	int xx = 0, xx1=0;
	runable nn;
	public Date_go() {
		nn = new runable(this);
	}
	public void init()
	{
		setSize(400, 400);
	}
	public void us()
	{
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		Date d = new Date();
		int x =0, x1=0, i = 0;
		String s = d.toString();
		for (i = 0; i < s.length(); i++)
		{
			String temp = String.valueOf(s.charAt(i));
			g.drawString(temp, xx+x, 100);
			x+=7;
			if(xx+x > this.getWidth())
				break;
		}
		for (; i < s.length(); i++)
		{
			String temp = String.valueOf(s.charAt(i));
			g.drawString(temp, x1, 100);
			x1+=7;
		}
		xx += 7;
		if(xx> this.getWidth())
			xx = 0;
	}
	public static void main(String [] args) {
		
	}
}


