package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Drawing extends JFrame {
	
	private JPanel contentPane;
	private JPanel panel;
	private PnlDrawing pnlDrawing = new PnlDrawing(this);

	private JToggleButton tglbtnPoint = new JToggleButton("Point");
	private JToggleButton tglbtnCircle = new JToggleButton("Circle");
	private JToggleButton tglbtnLine = new JToggleButton("Line");
	private JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
	private JToggleButton tglbtnDonut = new JToggleButton("Donut");
	
	private JToggleButton tglbtnSelect = new JToggleButton("Select");
	private final JToolBar toolBar = new JToolBar();
	private final JToolBar toolBar_1 = new JToolBar();
	private final JLabel lbloblici = new JLabel("Oblici");
	private final JLabel lblNewActions = new JLabel("Akcije");
	
	
	
	public JToggleButton getTglbtnPoint() {
		return tglbtnPoint;
	}

	public void setTglbtnPoint(JToggleButton tglbtnPoint) {
		this.tglbtnPoint = tglbtnPoint;
	}

	public JToggleButton getTglbtnCircle() {
		return tglbtnCircle;
	}

	public void setTglbtnCircle(JToggleButton tglbtnCircle) {
		this.tglbtnCircle = tglbtnCircle;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drawing frame = new Drawing();
					frame.setTitle("Rade Petrovic IT 55/2025");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public Drawing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 590);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{757, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{444, 0, 56, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		GridBagConstraints gbc_tglbtnPoint = new GridBagConstraints();
		gbc_tglbtnPoint.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPoint.gridx = 0;
		gbc_tglbtnPoint.gridy = 0;
		//contentPane.add(tglbtnPoint, gbc_tglbtnPoint);
		
		
		GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnLine.gridx = 1;
		gbc_tglbtnLine.gridy = 0;
		//contentPane.add(tglbtnLine, gbc_tglbtnLine);
		
		
		GridBagConstraints gbc_tglbtnRectangle = new GridBagConstraints();
		gbc_tglbtnRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnRectangle.gridx = 2;
		gbc_tglbtnRectangle.gridy = 0;
		//contentPane.add(tglbtnRectangle, gbc_tglbtnRectangle);
		
		
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCircle.gridx = 3;
		gbc_tglbtnCircle.gridy = 0;
		
		
		GridBagConstraints gbc_tglbtnDonut = new GridBagConstraints();
		gbc_tglbtnDonut.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnDonut.gridx = 4;
		gbc_tglbtnDonut.gridy = 0;
		
		GridBagConstraints gbc_pnlDrawing = new GridBagConstraints();
		gbc_pnlDrawing.weighty = 1.0;
		gbc_pnlDrawing.weightx = 1.0;
		gbc_pnlDrawing.insets = new Insets(0, 0, 5, 5);
		gbc_pnlDrawing.fill = GridBagConstraints.BOTH;
		gbc_pnlDrawing.gridy = 0;
		gbc_pnlDrawing.gridx = 0;
		pnlDrawing.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlDrawing, gbc_pnlDrawing);
		
		
		JButton btnModify = new JButton("Modify");
		btnModify.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModify.setBackground(new Color(128, 255, 255));
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pnlDrawing.getSelectedShape() != null) {
					modify();
					pnlDrawing.getSelectedShape().setSelected(false);
				}else {
					JOptionPane.showMessageDialog(null, "Selektujete objekat", "Error", JOptionPane.ERROR_MESSAGE);
				}
				tglbtnSelect.setSelected(false);
			}
		});
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.insets = new Insets(0, 0, 5, 5);
		gbc_btnModify.gridx = 0;
		gbc_btnModify.gridy = 4;
		//contentPane.add(btnModify, gbc_btnModify);
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBounds(new java.awt.Rectangle(0, 0, 3, 3));
		btnDelete.setBackground(new Color(128, 255, 255));
		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				delete();
				tglbtnSelect.setSelected(false);
			}
		});
		
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 6;
		
		GridBagConstraints gbc_lblNewActions = new GridBagConstraints();
		gbc_lblNewActions.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewActions.gridx = 1;
		gbc_lblNewActions.gridy = 0;
		lblNewActions.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewActions.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(lblNewActions, gbc_lblNewActions);
		
		GridBagConstraints gbc_toolBar_1 = new GridBagConstraints();
		gbc_toolBar_1.insets = new Insets(0, 0, 5, 0);
		gbc_toolBar_1.gridx = 2;
		gbc_toolBar_1.gridy = 0;
		toolBar_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		toolBar_1.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(toolBar_1, gbc_toolBar_1);
		//contentPane.add(btnDelete, gbc_btnDelete);
		
		// Postavljanje jednake maksimalne širine za sva tri dugmeta
		btnDelete.setMaximumSize(new Dimension(100, 30));
		btnModify.setMaximumSize(new Dimension(100, 30));
		tglbtnSelect.setMaximumSize(new Dimension(100, 30));
		
		GridBagConstraints gbc_lbloblici = new GridBagConstraints();
		gbc_lbloblici.insets = new Insets(0, 0, 5, 5);
		gbc_lbloblici.gridx = 0;
		gbc_lbloblici.gridy = 1;
		lbloblici.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lbloblici.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lbloblici, gbc_lbloblici);
		
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.insets = new Insets(0, 0, 0, 5);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 2;
		toolBar.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(toolBar, gbc_toolBar);
		tglbtnPoint.setBackground(new Color(255, 255, 128));
		tglbtnPoint.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		toolBar.add(tglbtnPoint);
		tglbtnLine.setBackground(new Color(128, 255, 128));
		tglbtnLine.setFont(new Font("Tahoma", Font.BOLD, 15));
		toolBar.add(tglbtnLine);
		tglbtnCircle.setBackground(new Color(128, 255, 128));
		tglbtnCircle.setFont(new Font("Tahoma", Font.BOLD, 15));
		toolBar.add(tglbtnCircle);
		tglbtnDonut.setBackground(new Color(128, 255, 128));
		tglbtnDonut.setFont(new Font("Tahoma", Font.BOLD, 15));
		toolBar.add(tglbtnDonut);
		tglbtnRectangle.setBackground(new Color(255, 255, 128));
		tglbtnRectangle.setFont(new Font("Tahoma", Font.BOLD, 15));
		toolBar.add(tglbtnRectangle);
		toolBar_1.add(btnDelete);
		toolBar_1.add(btnModify);	
		tglbtnSelect.setFont(new Font("Tahoma", Font.BOLD, 15));
		tglbtnSelect.setBackground(new Color(128, 255, 255));
		toolBar_1.add(tglbtnSelect);
		ButtonGroup bg = new ButtonGroup();
		bg.add(tglbtnPoint);
		bg.add(tglbtnLine);
		bg.add(tglbtnCircle);
		bg.add(tglbtnDonut);
		bg.add(tglbtnRectangle);
		bg.add(tglbtnSelect);
		
	}
	
	public JToggleButton getTglbtnLine() {
		return tglbtnLine;
	}

	public void setTglbtnLine(JToggleButton tglbtnLine) {
		this.tglbtnLine = tglbtnLine;
	}

	public JToggleButton getTglbtnRectangle() {
		return tglbtnRectangle;
	}

	public void setTglbtnRectangle(JToggleButton tglbtnRectangle) {
		this.tglbtnRectangle = tglbtnRectangle;
	}

	public JToggleButton getTglbtnDonut() {
		return tglbtnDonut;
	}

	public void setTglbtnDonut(JToggleButton tglbtnDonut) {
		this.tglbtnDonut = tglbtnDonut;
	}

	protected void modify() {
		
		int index;
		
		Shape selectedShape = pnlDrawing.getSelectedShape();
		if (selectedShape != null) {
			if (selectedShape instanceof Point) {
				Point p = (Point) selectedShape;
				DlgPoint dialog = new DlgPoint();
				dialog.setModal(true);

				dialog.getTextFieldX().setText("" + Integer.toString(p.getX()));
				dialog.getTextFieldY().setText("" + Integer.toString(p.getY()));
				dialog.setVisible(true);
				

				if (dialog.isOk()) {
					index = pnlDrawing.getShapes().indexOf(selectedShape);
					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(index, dialog.getPoint());
				}
				p.setSelected(false);
				repaint();
			} else if (selectedShape instanceof Line) {
				Line l = (Line) selectedShape;
				DlgLine dialog = new DlgLine();
				dialog.setModal(true);

				dialog.getTextFieldX1().setText("" + Integer.toString(l.getStartPoint().getX()));
				dialog.getTextFieldY1().setText("" + Integer.toString(l.getStartPoint().getY()));

				dialog.getTextFieldX2().setText("" + Integer.toString(l.getEndPoint().getX()));
				dialog.getTextFieldY2().setText("" + Integer.toString(l.getEndPoint().getY()));
				dialog.setVisible(true);

				if (dialog.isOk()) {
					index = pnlDrawing.getShapes().indexOf(selectedShape);
					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(index, dialog.getLine());
				}
				l.setSelected(false);
				repaint();
			} else if (selectedShape instanceof Rectangle) {
				Rectangle r = (Rectangle) selectedShape;
				DlgRectangle dialog = new DlgRectangle();
				dialog.setModal(true);

				dialog.getTextFieldX().setText("" + Integer.toString(r.getUpperLeftPoint().getX()));
				dialog.getTextFieldY().setText("" + Integer.toString(r.getUpperLeftPoint().getY()));
				dialog.getTextFieldHeight().setText("" + Integer.toString(r.getHeight()));
				dialog.getTextFieldWidth().setText("" + Integer.toString(r.getWidth()));
				dialog.setVisible(true);

				if (dialog.isOk()) {
					index = pnlDrawing.getShapes().indexOf(selectedShape);
					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(index, dialog.getRect());
				}
				r.setSelected(false);
				repaint();
			} else if (selectedShape instanceof Circle && selectedShape instanceof Donut == false) {
				Circle c = (Circle) selectedShape;
				DlgCircle dialog = new DlgCircle();
				dialog.setModal(true);

				dialog.getTextFieldX().setText("" + Integer.toString(c.getCenter().getX()));
				dialog.getTextFieldY().setText("" + Integer.toString(c.getCenter().getY()));
				dialog.getTextFieldRadius().setText("" + Integer.toString(c.getRadius()));

				dialog.setVisible(true);

				if (dialog.isOk()) {
					c = dialog.getCircle();
					index = pnlDrawing.getShapes().indexOf(selectedShape);
					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(index, c);
				}
				c.setSelected(false);
				repaint();
			} else if (selectedShape instanceof Donut) {
				Donut d = (Donut) selectedShape;
				DlgDonut dialog = new DlgDonut();
				dialog.setModal(true);

				dialog.getTextFieldX().setText("" + Integer.toString(d.getCenter().getX()));
				dialog.getTextFieldY().setText("" + Integer.toString(d.getCenter().getY()));
				dialog.getTextFieldRadius().setText("" + Integer.toString(d.getRadius()));
				dialog.getTextFieldInnerRadius().setText("" + Integer.toString(d.getInnerRadius()));
				dialog.setVisible(true);
				if (dialog.isOk()) {
					d = dialog.getDonut();
					index = pnlDrawing.getShapes().indexOf(selectedShape);
					pnlDrawing.getShapes().remove(selectedShape);
					pnlDrawing.getShapes().add(index, d);
				}
				d.setSelected(false);
				repaint();
			}
		}

	}
	
	protected void delete() {
		Shape selectedShape = pnlDrawing.getSelectedShape();

		if (selectedShape != null) {
			int selectedOption = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?",
					"Warning message", JOptionPane.YES_NO_OPTION);
			if (selectedOption == JOptionPane.YES_OPTION) {
				pnlDrawing.getShapes().remove(selectedShape);
			}
		} else {
			JOptionPane.showMessageDialog(null, "You haven't selected any shape!", "Error",
					JOptionPane.WARNING_MESSAGE);
		}
		pnlDrawing.setSelectedShape(null);
		pnlDrawing.repaint();
	}

	public PnlDrawing getPnlDrawing() {
		return pnlDrawing;
	}

	public void setPnlDrawing(PnlDrawing pnlDrawing) {
		this.pnlDrawing = pnlDrawing;
	}

	public JToggleButton getTglbtnSelect() {
		return tglbtnSelect;
	}

	public void setTglbtnSelect(JToggleButton tglbtnSelect) {
		this.tglbtnSelect = tglbtnSelect;
	}

}
