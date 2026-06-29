package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	private int innerRadius;

	public Donut() {

	}

	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		super.setSelected(selected);
	}

	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}

	public double circumference() {
		return super.circumference() + 2 * innerRadius * Math.PI;
	}

	public String toString() {
		return super.toString() + ", inner radius = " + innerRadius;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut secondDonut = (Donut) obj;
			if (super.getCenter().equals(secondDonut.getCenter()) && super.getRadius() == secondDonut.getRadius()
					&& this.innerRadius == secondDonut.innerRadius)
				return true;
			else
				return false;
		} else
			return false;
	}

	public boolean contains(int x, int y) {
		return super.contains(x, y) && super.getCenter().distance(x, y) >= innerRadius;
	}

	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}

	@Override
	public void draw(Graphics g) {
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() + innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - innerRadius - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() + innerRadius - 2, 4, 4);
			g.setColor(Color.black);
		}

		super.draw(g);
		g.drawOval(super.getCenter().getX() - innerRadius, super.getCenter().getY() - innerRadius, 2 * innerRadius,
				2 * innerRadius);
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Donut) {
			return (int) (this.area() - ((Donut) o).area());
		}
		return 0;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
}
