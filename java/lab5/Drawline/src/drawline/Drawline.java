package drawline;

import java.applet.Applet;

import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
import java.awt.Font;
import java.awt.Graphics;

public class Drawline extends Applet {

	public int x = 100, y = 100;
	Vector<Integer> vx = new Vector<>();
	Vector<Integer> vy = new Vector<>();
	
	public Drawline() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init() {
		setSize(400, 400);
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				vx.add(x);
				vy.add(y);
				repaint();
			}
		});
	}
	
	public void paint(Graphics g) {
		for (int i = 0; i < vx.size(); i++) {
			g.fillOval(vx.get(i), vy.get(i), 10, 10);
		}
	};

}
