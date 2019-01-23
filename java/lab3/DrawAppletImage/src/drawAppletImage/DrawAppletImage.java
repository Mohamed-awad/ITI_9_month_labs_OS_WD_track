package drawAppletImage;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;

public class DrawAppletImage extends Applet {

	public DrawAppletImage() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}
	
	private Image image;
	
	@Override
	 public void init() {
	  setSize(400, 400);
	  System.out.println(getCodeBase());
	  image = getImage(getCodeBase(), "drawAppletImage/back.jpg");
	 }
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub		
		g.drawImage(image, 10, 10,this.getWidth(), this.getHeight(), this);
	}

}
