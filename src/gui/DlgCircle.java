package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldRadius;
	private Circle circle;
	private boolean isOk;
	private JButton btnInnerColor;
	private JButton btnOutlineColor;
	
	
	public JLabel getLblX() {
		return lblX;
	}

	public void setLblX(JLabel lblX) {
		this.lblX = lblX;
	}

	public JLabel getLblY() {
		return lblY;
	}

	public void setLblY(JLabel lblY) {
		this.lblY = lblY;
	}

	public JLabel getLblRadius() {
		return lblRadius;
	}

	public void setLblRadius(JLabel lblRadius) {
		this.lblRadius = lblRadius;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public boolean isOK() {
		return isOK;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}

	private boolean isOK;
	private JLabel lblX;
	private JLabel lblY;
	private JLabel lblRadius;
	
	
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Dialog Circle");
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblX = new JLabel("X coordinate");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 0;
			gbc_lblX.gridy = 1;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			textFieldX = new JTextField();
			GridBagConstraints gbc_textFieldX = new GridBagConstraints();
			gbc_textFieldX.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX.gridx = 1;
			gbc_textFieldX.gridy = 1;
			contentPanel.add(textFieldX, gbc_textFieldX);
			textFieldX.setColumns(10);
		}
		{
			lblY = new JLabel("Y coordinate");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 0;
			gbc_lblY.gridy = 3;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			textFieldY = new JTextField();
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 1;
			gbc_textFieldY.gridy = 3;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
		}
		{
			lblRadius = new JLabel("Radius");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 0;
			gbc_lblRadius.gridy = 5;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			textFieldRadius = new JTextField();
			GridBagConstraints gbc_textFieldRadius = new GridBagConstraints();
			gbc_textFieldRadius.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldRadius.gridx = 1;
			gbc_textFieldRadius.gridy = 5;
			contentPanel.add(textFieldRadius, gbc_textFieldRadius);
			textFieldRadius.setColumns(10);
		}
		{
		}
		{
			btnInnerColor = new JButton("Inner Color");
			btnInnerColor.setBackground(Color.WHITE);
			btnInnerColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Color innerColor = JColorChooser.showDialog(null, "Choose inner color", btnInnerColor.getBackground());
					
					if (innerColor != null)
						btnInnerColor.setBackground(innerColor);
				}
			});
			GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
			gbc_btnInnerColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnInnerColor.gridx = 0;
			gbc_btnInnerColor.gridy = 6;
			contentPanel.add(btnInnerColor, gbc_btnInnerColor);
		}
		btnOutlineColor = new JButton("Outline Color");
		btnOutlineColor.setForeground(new Color(0, 0, 0));
		btnOutlineColor.setBackground(new Color(255, 255, 255));
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Color outlineColor = JColorChooser.showDialog(null, "Choose outline color",
						btnOutlineColor.getBackground());
				
				if (outlineColor != null)
					btnOutlineColor.setBackground(outlineColor);
			}
		});
		GridBagConstraints gbc_btnOutlineColor = new GridBagConstraints();
		gbc_btnOutlineColor.insets = new Insets(0, 0, 0, 5);
		gbc_btnOutlineColor.gridx = 1;
		gbc_btnOutlineColor.gridy = 6;
		contentPanel.add(btnOutlineColor, gbc_btnOutlineColor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (textFieldX.getText().trim().isEmpty() || textFieldY.getText().trim().isEmpty()
								|| textFieldRadius.getText().trim().isEmpty()) {
							setOk(false);
							JOptionPane.showMessageDialog(null, "All fields are required!", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else {
							try {
								if (Integer.parseInt(textFieldRadius.getText().toString()) <= 0
										|| Integer.parseInt(textFieldX.getText().toString()) < 0
										|| Integer.parseInt(textFieldY.getText().toString()) < 0) {
									JOptionPane.showMessageDialog(null, "Enter positive number!", "ERROR",
											JOptionPane.ERROR_MESSAGE);
								} else {
									circle = new Circle(

											new Point(Integer.parseInt(textFieldX.getText().toString()),
													Integer.parseInt(textFieldY.getText().toString())),
													Integer.parseInt(textFieldRadius.getText().toString()), false, 
													btnOutlineColor.getBackground(), btnInnerColor.getBackground());

									setOk(true);
									setVisible(false);
								}
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "Enter numbers!", "Error",
										JOptionPane.ERROR_MESSAGE);
							}

						}

					}
				});
					
				//ok button event
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public void setBtnInnerColor(JButton btnInnerColor) {
		this.btnInnerColor = btnInnerColor;
	}

	public JButton getBtnOutlineColor() {
		return btnOutlineColor;
	}

	public void setBtnOutlineColor(JButton btnOutlineColor) {
		this.btnOutlineColor = btnOutlineColor;
	}

	public JTextField getTextFieldX() {
		return textFieldX;
	}

	public void setTextFieldX(JTextField textFieldX) {
		this.textFieldX = textFieldX;
	}

	public JTextField getTextFieldY() {
		return textFieldY;
	}

	public void setTextFieldY(JTextField textFieldY) {
		this.textFieldY = textFieldY;
	}

	public JTextField getTextFieldRadius() {
		return textFieldRadius;
	}

	public void setTextFieldRadius(JTextField textFieldRadius) {
		this.textFieldRadius = textFieldRadius;
	}
	

}
