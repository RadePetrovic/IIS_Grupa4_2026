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
}