package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class PnlDrawing extends JPanel {
	private Drawing frame;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Shape selectedShape;
	private Point startPoint;
	
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public PnlDrawing() {
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setBackground(new Color(255, 255, 255));
	}
	public PnlDrawing(Drawing frame) {
		this.frame = frame;
		setPreferredSize(new Dimension(1000, 1000));
		setBackground(Color.WHITE);
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				thisMouseClicked(me);
			}
		});
	}
	
	protected void thisMouseClicked(MouseEvent me) {
		Shape newShape = null;
		Point click = new Point(me.getX(), me.getY());

		if (frame.getTglbtnSelect().isSelected()) {
			selectedShape = null;
			Iterator<Shape> iterator = shapes.iterator();
			while (iterator.hasNext()) {
				Shape shape = iterator.next();
				shape.setSelected(false);
				if (shape.contains(click.getX(), click.getY()))
					selectedShape = shape;
			}

			if (selectedShape != null)
				selectedShape.setSelected(true);

		} else if (frame.getTglbtnPoint().isSelected()) {
			DlgPoint dialog = new DlgPoint();
			dialog.setModal(true);

			dialog.getTextFieldX().setText(Integer.toString(click.getX()));
			dialog.getTextFieldX().setEditable(false);
			dialog.getTextFieldY().setText(Integer.toString(click.getY()));
			dialog.getTextFieldY().setEditable(false);

			dialog.setVisible(true);
			if (dialog.isOk()) {
				newShape = dialog.getPoint();
			}
		} else if (frame.getTglbtnLine().isSelected()) {
			if (startPoint == null) {
				startPoint = click;
			} else {
				DlgLine dialog = new DlgLine();
				dialog.setModal(true);

				dialog.getTextFieldX1().setText(Integer.toString(startPoint.getX()));
				dialog.getTextFieldX1().setEditable(false);
				dialog.getTextFieldY1().setText(Integer.toString(startPoint.getY()));
				dialog.getTextFieldY1().setEditable(false);
				dialog.getTextFieldX2().setText(Integer.toString(click.getX()));
				dialog.getTextFieldX2().setEditable(false);
				dialog.getTextFieldY2().setText(Integer.toString(click.getY()));
				dialog.getTextFieldY2().setEditable(false);

				dialog.setVisible(true);
				if (dialog.isOk()) {
					newShape = dialog.getLine();
				}
				startPoint = null;
			}
		} else if (frame.getTglbtnRectangle().isSelected()) {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setModal(true);
			dialog.getTextFieldX().setText(Integer.toString(me.getX()));
			dialog.getTextFieldX().setEditable(false);
			dialog.getTextFieldY().setText(Integer.toString(me.getY()));
			dialog.getTextFieldY().setEditable(false);
			dialog.setVisible(true);

			if (dialog.isOk()) {
				newShape = dialog.getRect();
			}
		} else if (frame.getTglbtnCircle().isSelected()) {
			DlgCircle dialog = new DlgCircle();
			dialog.setModal(true);

			dialog.getTextFieldX().setText(Integer.toString(click.getX()));
			dialog.getTextFieldX().setEditable(false);
			dialog.getTextFieldY().setText(Integer.toString(click.getY()));
			dialog.getTextFieldY().setEditable(false);
			dialog.setVisible(true);

			if (dialog.isOk()) {
				newShape = dialog.getCircle();
			}
		} else if (frame.getTglbtnDonut().isSelected()) {
			DlgDonut dialog = new DlgDonut();
			dialog.setModal(true);
			dialog.getTextFieldX().setText(Integer.toString(click.getX()));
			dialog.getTextFieldX().setEditable(false);
			dialog.getTextFieldY().setText(Integer.toString(click.getY()));
			dialog.getTextFieldY().setEditable(false);
			dialog.setVisible(true);

			if (dialog.isOk()) {
				newShape = dialog.getDonut();
			}
		}

		if (newShape != null)
			shapes.add(newShape);

		repaint();
	}

	public void modify() {
		if (selectedShape != null) {
			if (selectedShape instanceof Point) {
				Point point = (Point) selectedShape;
				DlgPoint dialog = new DlgPoint();

				dialog.getTextFieldX().setText(Integer.toString(point.getX()));
				dialog.getTextFieldY().setText(Integer.toString(point.getY()));
				dialog.setBtnColor(point.getColor());

				dialog.setVisible(true);

				if (dialog.isOk()) {
					shapes.remove(selectedShape);
					shapes.add(dialog.getPoint());

					repaint();
				}
			} else if (selectedShape instanceof Line) {
				Line line = (Line) selectedShape;
				DlgLine dialog = new DlgLine();

				dialog.getTextFieldX1().setText(Integer.toString(line.getStartPoint().getX()));
				dialog.getTextFieldY1().setText(Integer.toString(line.getStartPoint().getY()));
				dialog.getTextFieldX2().setText(Integer.toString(line.getEndPoint().getX()));
				dialog.getTextFieldY2().setText(Integer.toString(line.getEndPoint().getY()));
				dialog.setBtnColor(line.getColor());

				dialog.setVisible(true);

				if (dialog.isOk()) {
					shapes.remove(selectedShape);
					shapes.add(dialog.getLine());

					repaint();
				}
			} else if (selectedShape instanceof Rectangle) {
				Rectangle rect = (Rectangle) selectedShape;
				DlgRectangle dialog = new DlgRectangle();

				dialog.getTextFieldX().setText(Integer.toString(rect.getUpperLeftPoint().getX()));
				dialog.getTextFieldY().setText(Integer.toString(rect.getUpperLeftPoint().getY()));
				dialog.getTxtWidth().setText(Integer.toString(rect.getWidth()));
				dialog.getTxtHeight().setText(Integer.toString(rect.getHeight()));
				dialog.setBtnInnerColor(rect.getInnerColor());
				dialog.setBtnBorderColor(rect.getColor());

				dialog.setVisible(true);

				if (dialog.isOk()) {
					shapes.remove(selectedShape);
					shapes.add(dialog.getRect());

					repaint();
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Morate selektovati oblik!", "Upozorenje",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> iterator = shapes.iterator();
		while (iterator.hasNext())
			iterator.next().draw(g);
	}
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	public Shape getSelectedShape() {
		return selectedShape;
	}
	public void setSelectedShape(Shape selectedShape) {
		this.selectedShape = selectedShape;
	}
}