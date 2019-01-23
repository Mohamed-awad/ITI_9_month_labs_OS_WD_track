package inc_dec;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inc_dec extends Applet {

	public int x = 0;
	Button b_inc, b_dec;
	public Inc_dec() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		setSize(400, 400);
		b_inc = new Button("increase");
		b_dec = new Button("decrease");
		b_inc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(x < 10)
					x++;
				repaint();
			}
		});
		b_dec.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(x > 0)
					x--;
				repaint();
			}
		});
		
		add(b_inc);
		add(b_dec);
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawString("x = " + x, 100, 100);
	}
}
