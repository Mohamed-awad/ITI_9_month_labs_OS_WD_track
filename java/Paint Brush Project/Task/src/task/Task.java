package task;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

public class Task extends Applet {
	// data structures for shapes
	Vector<Shape> shapes = new Vector<>();
	boolean event_drag_work = false;
	Point st = new Point(-30, -30);
	Point en = new Point(-30,-30);
	Vector<Point> free_hand_points = new Vector<>();
	int w = 0, h = 0;
	int shape_index=0, color_index=0, temp_shape_index=0;
	boolean filled = false;
    Choice color_list;
    Choice shape_list;
	Button erase;
	Button erase_all;
	Button free_hand;
	Button undo;
	Checkbox fill;
	
	public abstract class Shape{
		public Point st;
		public Color color;
		public int index_shape;
		
		public abstract Point get_en();
		public abstract Boolean get_filled();
		public abstract int get_w();
		public abstract int get_h();
	}
	
	public class Myline extends Shape{
		public Point en;
		
		public Myline(Point p1, Point p2, Color c, int shape_type) {
			this.st = p1;
			this.en = p2;
			this.color = c;
			this.index_shape = shape_type;
		}

		@Override
		public Point get_en() {return en;}
		@Override
		public Boolean get_filled() {return true;}
		@Override
		public int get_w() {return 0;}
		@Override
		public int get_h() {return 0;}
	}
	
	public class Myrect extends Shape{
		public Point en;
		public Boolean filled;
		public int w;
		public int h;
		
		public Myrect(Point p1, Point p2, Color c, Boolean f, int w, int h, int shape_type) {
			this.st = p1;
			this.en = p2;
			this.color = c;
			this.filled = f;
			this.w = w;
			this.h = h;
			this.index_shape = shape_type;
		}

		@Override
		public Point get_en() {return en;}
		@Override
		public Boolean get_filled() {return filled;}
		@Override
		public int get_w() {return w;}
		@Override
		public int get_h() {return h;}
	}
	
	public class Myoval extends Shape{
		public Point en;
		public Boolean filled;
		public int w;
		public int h;
		
		public Myoval(Point p1, Point p2, Color c, Boolean f, int w, int h, int shape_type) {
			this.st = p1;
			this.en = p2;
			this.color = c;
			this.filled = f;
			this.w = w;
			this.h = h;
			this.index_shape = shape_type;
		}

		@Override
		public Point get_en() {return en;}
		@Override
		public Boolean get_filled() {return filled;}
		@Override
		public int get_w() {return w;}
		@Override
		public int get_h() {return h;}
	}
	@Override
	public void init() {
		// set size of window 
		this.setSize(1000, 800);
		this.setBackground(Color.white);
		// init my components
		color_list = new Choice();
		color_list.add("Red");
		color_list.add("Green");
		color_list.add("Blue");
		shape_list = new Choice();
		shape_list.add("Line");
		shape_list.add("Rectangle");
		shape_list.add("Oval");
		erase = new Button("erase");
		erase_all = new Button("erase all");
		free_hand = new Button("free hand");
		fill = new Checkbox("fill");
		undo = new Button("Un do");
		// set attribute for our components
		color_list.setPreferredSize(new Dimension(100, 35));
		color_list.setBackground(Color.ORANGE);
		color_list.setFont(new Font(getName(), Font.ITALIC, 20));
		
		shape_list.setPreferredSize(new Dimension(150, 35));
		shape_list.setBackground(Color.ORANGE);
		shape_list.setFont(new Font(getName(), Font.ITALIC, 20));
		
		erase.setPreferredSize(new Dimension(100, 35));
		erase.setBackground(Color.ORANGE);
		erase.setFont(new Font(getName(), Font.ITALIC, 20));
		
		erase_all.setPreferredSize(new Dimension(120, 35));
		erase_all.setBackground(Color.ORANGE);
		erase_all.setFont(new Font(getName(), Font.ITALIC, 20));
		
		free_hand.setPreferredSize(new Dimension(130, 35));
		free_hand.setBackground(Color.ORANGE);
		free_hand.setFont(new Font(getName(), Font.ITALIC, 20));
		
		undo.setPreferredSize(new Dimension(130, 35));
		undo.setBackground(Color.ORANGE);
		undo.setFont(new Font(getName(), Font.ITALIC, 20));
		
		fill.setPreferredSize(new Dimension(100, 35));
		fill.setBackground(Color.ORANGE);
		fill.setFont(new Font(getName(), Font.ITALIC, 20));
		
		// add my components to window
		add(color_list);
		add(shape_list);
		add(erase);
		add(erase_all);
		add(free_hand);
		add(fill);
		add(undo);
		
		//add events to our components
		// mouse events
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				event_drag_work = false;
				en.x = e.getX();
				en.y = e.getY();
				w = en.x-st.x;
				h = en.y-st.y;
				
				Color store_color = select_color();
				
				switch (shape_index) {
				// draw line
				case 0:
					shapes.add(new Myline(new Point(st.x, st.y), new Point(en.x, en.y), store_color, 0));
					break;
				// draw rectangle
				case 1:
					shapes.add(new Myrect(new Point(st.x, st.y), new Point(en.x, en.y),
							store_color, filled, w, h, 1));
					break;
				// draw oval
				case 2:
					shapes.add(new Myoval(new Point(st.x, st.y), new Point(en.x, en.y),
							store_color, filled, w, h, 2));
					break;
				// erase
				case 3:
					shapes.add(new Myoval(new Point(st.x, st.y), new Point(en.x, en.y),
							Color.WHITE, filled, 30, 30, 3));
					break;
				}
				repaint();
			}			
			@Override
			public void mousePressed(MouseEvent e) {
				event_drag_work = false;
				st.x = e.getX();
				st.y = e.getY();
				en.x = e.getX();
				en.y = e.getY();
				w = 0;
				h = 0;
				free_hand_points.clear();
				if(shape_index == 3)
					shapes.add(new Myoval(new Point(st.x, st.y), new Point(en.x, en.y),
						Color.WHITE, true, 30, 30, 3));
				repaint();
			}	
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		this.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {}
			@Override
			public void mouseDragged(MouseEvent e) {
				event_drag_work = true;
				en.x = e.getX();
				en.y = e.getY();
				w = en.x-st.x;
				h = en.y-st.y;
				if(shape_index == 3)
					shapes.add(new Myoval(new Point(en.x, en.y), new Point(en.x, en.y),
						Color.WHITE, true, 30, 30, 3));
				repaint();
			}
		});
		// choices events
		color_list.addItemListener(new ItemListener() {	
			@Override
			public void itemStateChanged(ItemEvent e) {
				event_drag_work = false;
				if(e.getItem() == "Red")
					color_index = 0;
				else if (e.getItem() == "Green")
					color_index = 1;
				if(e.getItem() == "Blue")
					color_index = 2;
			}
		});
		
		shape_list.addItemListener(new ItemListener() {	
			@Override
			public void itemStateChanged(ItemEvent e) {
				event_drag_work = false;
				if(e.getItem() == "Line")
					shape_index = 0;
				else if (e.getItem() == "Rectangle")
					shape_index = 1;
				if(e.getItem() == "Oval")
					shape_index = 2;
			}
		});
		// buttons events
		erase.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				event_drag_work = false;
				shape_index = 3;
			}
		});
		erase_all.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				event_drag_work = false;
				temp_shape_index = shape_index;
				shape_index = 5;
				shapes.add(new Myrect(new Point(0, 0), new Point(1500, 2000),
						getBackground(), true, 1500, 2000, 1));
				repaint();
			}
		});
		free_hand.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				event_drag_work = false;
				shape_index = 4;
			}
		});
		fill.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				event_drag_work = false;
				if(e.getStateChange() == 1)
					filled = true;
				else
					filled = false;			
			}
		});
		
		undo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				event_drag_work = false;
				if(!shapes.isEmpty()) {
					if(shapes.get(shapes.size()-1).index_shape != 3 &&
					   shapes.get(shapes.size()-1).index_shape != 4)
					{
						shapes.remove(shapes.size()-1);
					}
					else if (shapes.get(shapes.size()-1).index_shape == 3){
						shapes.remove(shapes.size()-1);
						while(!shapes.isEmpty())
						{
							if(shapes.get(shapes.size()-1).index_shape != 3)
								break;
							shapes.remove(shapes.size()-1);
						}
					}
					else {
						shapes.remove(shapes.size()-1);
						while(!shapes.isEmpty())
						{
							if(shapes.get(shapes.size()-1).index_shape != 4)
								break;
							shapes.remove(shapes.size()-1);
						}
					}
				}
				repaint();
			}
		});
	}
	
	// determine color
	Color select_color() {
		if(color_index == 0)
			return Color.RED;
		else if(color_index == 1)
			return Color.GREEN;
		else
			return Color.BLUE;
	}
	
	@Override
	public void paint(Graphics g) {
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		// draw stored shapes		
		// draw shapes
		for (int i = 0; i < shapes.size(); i++) {
			g.setColor(shapes.get(i).color);
			int xx = shapes.get(i).st.x;
			int yy = shapes.get(i).st.y;
			int ww = shapes.get(i).get_w();
			int hh = shapes.get(i).get_h();
			if(shapes.get(i) instanceof Myline)
				g.drawLine(shapes.get(i).st.x, shapes.get(i).st.y,
					   shapes.get(i).get_en().x, shapes.get(i).get_en().y);
			else if(shapes.get(i) instanceof Myrect)
			{
				if(ww < 0){
					ww = ww * -1;
					xx = shapes.get(i).get_en().x;
				}
				if(hh < 0){
					hh = hh * -1;
					yy = shapes.get(i).get_en().y;
				}
				if(!shapes.get(i).get_filled())
					g.drawRect(xx, yy, ww, hh);
				else
					g.fillRect(xx, yy, ww, hh);
			}
			else if(shapes.get(i) instanceof Myoval)
			{
				if(ww < 0){
					ww = ww * -1;
					xx = shapes.get(i).get_en().x;
				}
				if(hh < 0){
					hh = hh * -1;
					yy = shapes.get(i).get_en().y;
				}
				if(!shapes.get(i).get_filled())
					g.drawOval(xx, yy, ww, hh);
				else
					g.fillOval(xx, yy, ww, hh);
			}
		}
		if(event_drag_work) {
		// determine color choose
		Color st_color = select_color();
		g.setColor(st_color);
		
		int xx = 0, yy = 0;
		// determine shape choose
		switch (shape_index) {
			// draw line
			case 0:
				g.drawLine(st.x, st.y, en.x, en.y);
				break;
			// draw rectangle
			case 1:
				 xx = st.x;
				 yy = st.y;
				if(w < 0){
					w = w * -1;
					xx = en.x;
				}
				if(h < 0){
					h = h * -1;
					yy = en.y;
				}
				if(!filled)
					g.drawRect(xx, yy, w, h);
				else
					g.fillRect(xx, yy, w, h);
				break;
			// draw oval
			case 2:
				xx = st.x;
				yy = st.y;
				if(w < 0){
					w = w * -1;
					xx = en.x;
				}
				if(h < 0){
					h = h * -1;
					yy = en.y;
				}
				if(!filled)
					g.drawOval(xx, yy, w, h);
				else
					g.fillOval(xx, yy, w, h);
				break;
			// erase
			case 3:
				xx = en.x;
				yy = en.y;
				g.setColor(Color.white);
				g.fillOval(xx, yy, 30, 30);
				break;
			// free hand
			case 4:
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				if(en.x != -30)
					free_hand_points.add(new Point(en.x, en.y));
				for (int i = 0; i < free_hand_points.size()-1; i++) {
					shapes.add(new Myline(new Point(free_hand_points.get(i)), 
							  new Point(free_hand_points.get(i+1)), st_color, 4));
					g.drawLine(free_hand_points.get(i).x, free_hand_points.get(i).y, 
							free_hand_points.get(i+1).x, free_hand_points.get(i+1).y);
				}
				break;
			case 5:
				shape_index = temp_shape_index;
			}
		}
	}
}
