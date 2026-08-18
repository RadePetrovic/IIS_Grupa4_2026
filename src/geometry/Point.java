package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape{
	
	private int x;
	private int y;
	
	public Point() {
		
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Point (int x, int y, boolean selected) {
		this(x, y);
		this.selected = selected;
	}
	public Point(int x, int y, boolean selected, Color color) {
		this(x, y, selected);
		setColor(color);
	}
	
	public String toString() {
		return "(" + x + "," + y + ")"; //(x, y)
	}
	
	public double distance(int x2, int y2) {
		int dx = x2 - x;
		int dy = y2 - y;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point pomocna = (Point) obj;
			
			if(this.x  == pomocna.x && this.y == pomocna.y) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}
	
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;
	}
	
	//Metode pristupa (GET i SET)
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	
	public void setX(int novoX) throws Exception {
		if (novoX < 0)
			throw new Exception("Coordinates can not be negative value.");
		x = novoX;
	}
	public void setY(int novoY) throws Exception {
		if (novoY < 0)
			throw new Exception("Coordinates can not be negative value.");
		y = novoY;
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(this.x - 2, this.y, this.x + 2, this.y);
		g.drawLine(this.x, this.y - 2, this.x, this.y + 2);
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.x - 3, this.y - 3, 6, 6);
		}
		
	}
		
	
	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public void moveBy(int byX, int byY) {
		this.x += x;
		this.y += y;
		
	}
	@Override
	public int compareTo(Object o) {
		if (o instanceof Point)
			return (int)(this.distance(0, 0) - ((Point)o).distance(0, 0));
		return 0;
	}
	@Override
	public boolean contains(Point point) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
