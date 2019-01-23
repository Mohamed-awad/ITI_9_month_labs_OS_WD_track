package drawApplet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.GraphicsEnvironment;

public class DrawApplet extends Applet {

	public DrawApplet() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	 public void init() {
	  setSize(400, 800);
	 }
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		
		String[] s = Toolkit.getDefaultToolkit().getFontList();
		Font f;
		int last_y = 0;
		for (int i = 0; i < s.length; i++)
		{
			f = new Font(s[i], Font.ITALIC, 20);
			g.setFont(f);
			last_y = (i+1)*25 + 25;
			g.drawString("awad using " + s[i], 20, 10 + (i+1)*25);
		}
		g.drawString("--------------------------------------------", 1, last_y);
		last_y += 25;
		GraphicsEnvironment graphicsEnvironment = 
				GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		String[] s1 = graphicsEnvironment.getAvailableFontFamilyNames();
		System.out.println(s1.length);
		for (int i = 0; i < 20; i++)
		{
			f = new Font(s1[i], Font.ITALIC, 20);
			g.setFont(f);
			g.drawString("awad using " + s1[i], 20, last_y+(i+1)*25);
		}
	}

}
