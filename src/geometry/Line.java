package geometry;
import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
	
	private Point startPoint;
	private Point endPoint;
	
	public Line() {
		
	}
	public Line (Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	public Line (Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}
	public Line(Point startPoint, Point endPoint, boolean selected, Color color) {
		this(startPoint, endPoint, selected);
		setColor(color);
	}
	
	public String toString() {
		return startPoint + "-->" + endPoint; //(x, y) --> (xE, yE)
	}
	
	public boolean equals (Object obj) {
		if(obj instanceof Line) {
			Line pomocna = (Line)obj;
			if(startPoint.equals(pomocna.startPoint) && endPoint.equals(pomocna.endPoint))
				return true;
			else
				return false;
		}else 
			return false;
	}
	
	public boolean contains(int x, int y) {
		return this.startPoint.distance(x, y) + this.endPoint.distance(x, y) - length()<= 2;
	}
	
	//duzina linije
	
	public double length () { 
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	//metode pristupa koje ce biti javne
	
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	public Point getEndPoint() {
		return endPoint;
	}
	public void setEndPoint (Point endPoint) {
		this.endPoint = endPoint;
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(this.startPoint.getX(), this.startPoint.getY(), this.endPoint.getX(), this.endPoint.getY());
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.startPoint.getX() - 3, this.startPoint.getY() - 3, 6, 6);
			g.drawRect(this.endPoint.getX() - 3, this.endPoint.getY() - 3, 6, 6);
		}
		
	}
	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		this.startPoint.moveBy(byX, byY);
		this.endPoint.moveBy(byX, byY);
	}
	@Override
	public int compareTo(Object o) {
		if (o instanceof Line)
			return (int)(this.length() - ((Line)o).length());
		return 0;
	}
	@Override
	public boolean contains(Point point) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
