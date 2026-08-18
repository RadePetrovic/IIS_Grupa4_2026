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

import geometry.Donut;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import geometry.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private boolean isOk;
	private Donut donut;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldRadius;
	private JTextField textFieldInnerRadius;
	public JButton btnInnerColor;
	public JButton btnOutlineColor;
	private JLabel lblX;
	private JLabel lblY;
	private JLabel lblRadius;
	private JLabel lblInnerRadius;
	
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("Rade Petrovic IT55/2025");
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgDonut() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{118, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			gbc_textFieldX.insets = new Insets(0, 0, 5, 0);
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
			gbc_textFieldY.insets = new Insets(0, 0, 5, 0);
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
			gbc_textFieldRadius.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldRadius.gridx = 1;
			gbc_textFieldRadius.gridy = 5;
			contentPanel.add(textFieldRadius, gbc_textFieldRadius);
			textFieldRadius.setColumns(10);
		}
		{
			lblInnerRadius = new JLabel("Inner Radius");
			GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
			gbc_lblInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerRadius.gridx = 0;
			gbc_lblInnerRadius.gridy = 7;
			contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
		}
		{
			textFieldInnerRadius = new JTextField();
			GridBagConstraints gbc_textFieldInnerRadius = new GridBagConstraints();
			gbc_textFieldInnerRadius.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldInnerRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldInnerRadius.gridx = 1;
			gbc_textFieldInnerRadius.gridy = 7;
			contentPanel.add(textFieldInnerRadius, gbc_textFieldInnerRadius);
			textFieldInnerRadius.setColumns(10);
		}
		{
			{
				btnInnerColor = new JButton("Inner Color");
				btnInnerColor.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnInnerColor.setBackground(new Color(255, 255, 255));
				btnInnerColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Color innerColor = JColorChooser.showDialog(null, "Choose inner color", btnInnerColor.getBackground());
						if (innerColor != null)
							btnInnerColor.setBackground(innerColor);
					}
				});
				GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
				gbc_btnInnerColor.insets = new Insets(0, 0, 5, 5);
				gbc_btnInnerColor.gridx = 0;
				gbc_btnInnerColor.gridy = 9;
				contentPanel.add(btnInnerColor, gbc_btnInnerColor);
			}
		}
		btnOutlineColor = new JButton("Outline Color");
		btnOutlineColor.setToolTipText("");
		btnOutlineColor.setFont(new Font("Tahoma", Font.BOLD, 11));
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
		gbc_btnOutlineColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnOutlineColor.gridx = 1;
		gbc_btnOutlineColor.gridy = 9;
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
								|| textFieldRadius.getText().trim().isEmpty()
								|| textFieldInnerRadius.getText().trim().isEmpty()) {
							
							setOk(false);
							JOptionPane.showMessageDialog(null, "All fields are required!", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else {
							try {
								int x = Integer.parseInt(textFieldX.getText().trim());
								int y = Integer.parseInt(textFieldY.getText().trim());
								int radius = Integer.parseInt(textFieldRadius.getText().trim());
								int innerRadius = Integer.parseInt(textFieldInnerRadius.getText().trim());

								if (x < 0 || y < 0 || radius <= 0 || innerRadius <= 0) {
									JOptionPane.showMessageDialog(null, "Values must be positive!", "ERROR",
											JOptionPane.ERROR_MESSAGE);
								} 
								else if (innerRadius >= radius) {
									JOptionPane.showMessageDialog(null, "Outer radius must be greater than inner radius!", "ERROR",
											JOptionPane.ERROR_MESSAGE);
								} 
								else {
									Donut d = new Donut(new Point(x, y), radius, innerRadius);
									d.setSelected(false);
									d.setColor(btnOutlineColor.getBackground());
									d.setInnerColor(btnInnerColor.getBackground());

									donut = d;
									setOk(true);
									setVisible(false);
								}
							} catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog(null, "Enter numbers!", "Error",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setOk(false);
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public Donut getDonut() {
		return donut;
	}

	public void setDonut(Donut donut) {
		this.donut = donut;
		if (donut != null) {
			textFieldX.setText(String.valueOf(donut.getCenter().getX()));
			textFieldY.setText(String.valueOf(donut.getCenter().getY()));
			textFieldRadius.setText(String.valueOf(donut.getRadius()));
			textFieldInnerRadius.setText(String.valueOf(donut.getInnerRadius()));

			textFieldX.setEditable(false);
			textFieldY.setEditable(false);
			textFieldRadius.setEditable(false);
			textFieldInnerRadius.setEditable(false);

			if (donut.getInnerColor() != null) {
				btnInnerColor.setBackground(donut.getInnerColor());
			}
			if (donut.getColor() != null) {
				btnOutlineColor.setBackground(donut.getColor());
			}

			btnInnerColor.setEnabled(false);
			btnOutlineColor.setEnabled(false);
		}
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

	public JTextField getTextFieldInnerRadius() {
		return textFieldInnerRadius;
	}

	public void setTextFieldInnerRadius(JTextField textFieldInnerRadius) {
		this.textFieldInnerRadius = textFieldInnerRadius;
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
}