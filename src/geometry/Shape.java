package geometry;
import java.awt.Graphics;
import java.awt.Color;



public abstract class Shape implements Moveable, Comparable{
	
	protected boolean selected;
	protected Color color;
	protected Color innerColor;
	//deklaracija apstraktnih metoda
	public abstract boolean contains(Point point);
	public abstract boolean contains(int x, int y);
	public abstract void draw(Graphics g);
	
	
	public Shape() {
		
	}
	
	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Color getInnerColor() {
		return innerColor;
	}
	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public void fill(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}
