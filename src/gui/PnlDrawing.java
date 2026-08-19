package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import geometry.Point;
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

		if (frame.getTglbtnPoint().isSelected()) {
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
		}

		if (newShape != null)
			shapes.add(newShape);

		repaint();
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