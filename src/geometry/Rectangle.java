package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	private Point upperLeftPoint;
	private int width;
	private int height;

	public Rectangle() {

	}

	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		this(upperLeftPoint, width, height);
		this.selected = selected;
	}

	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected, Color color) {
		this(upperLeftPoint, width, height, selected);
		setColor(color);
	}

	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected, Color color, Color innerColor) {
		this(upperLeftPoint, width, height, selected, color);
		setInnerColor(innerColor);
	}

	@Override
	public void fill(Graphics g) {
		if (getInnerColor() != null) {
			g.setColor(getInnerColor());
			g.fillRect(this.upperLeftPoint.getX(), this.upperLeftPoint.getY(), this.width, this.height);
		}
	}

	@Override
	public void draw(Graphics g) {
		// 1. Prvo unutrašnjost
		fill(g);

		// 2. Zatim se crta konturu (outline)
		if (getColor() != null) {
			g.setColor(getColor());
		} else {
			g.setColor(Color.BLACK);
		}
		g.drawRect(this.upperLeftPoint.getX(), this.upperLeftPoint.getY(), this.width, this.height);

		// 3. Crtanje tačaka selekcije
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getUpperLeftPoint().getX() - 3, getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(getUpperLeftPoint().getX() + getWidth() - 3, getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(getUpperLeftPoint().getX() - 3, getUpperLeftPoint().getY() + getHeight() - 3, 6, 6);
			g.drawRect(getUpperLeftPoint().getX() + getWidth() - 3, getUpperLeftPoint().getY() + getHeight() - 3, 6, 6);
		}
	}

	public String toString() {
		return "Upper left point: " + upperLeftPoint + ", width = " + width + ", height = " + height;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle pomocna = (Rectangle) obj;
			if (this.upperLeftPoint.equals(pomocna.upperLeftPoint) && width == pomocna.width && height == pomocna.height)
				return true;
			else
				return false;
		} else
			return false;
	}

	public boolean contains(int x, int y) {
		return (x >= upperLeftPoint.getX() && x <= upperLeftPoint.getX() + width && y >= upperLeftPoint.getY() && y <= upperLeftPoint.getY() + height);
	}

	public int area() {
		return width * height;
	}

	public int circumference() {
		return 2 * (height + width);
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void moveTo(int x, int y) {
		upperLeftPoint.moveTo(x, y);
	}

	@Override
	public void moveBy(int byX, int byY) {
		upperLeftPoint.moveBy(byX, byY);
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Rectangle)
			return (this.area() - ((Rectangle) o).area());
		return 0;
	}

	@Override
	public boolean contains(Point point) {
		return contains(point.getX(), point.getY());
	}
}